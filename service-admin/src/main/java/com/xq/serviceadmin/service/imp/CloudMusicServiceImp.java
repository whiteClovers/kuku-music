package com.xq.serviceadmin.service.imp;

import com.xq.serviceadmin.dao.MusicListMapper;
import com.xq.serviceadmin.dao.MusicMapper;
import com.xq.serviceadmin.entity.Music;
import com.xq.serviceadmin.entity.MusicList;
import com.xq.serviceadmin.entity.User;
import com.xq.serviceadmin.entity.cloudmusic.LyricReturn;
import com.xq.serviceadmin.entity.cloudmusic.MusicDetailReturn;
import com.xq.serviceadmin.entity.cloudmusic.MusicRootBean;
import com.xq.serviceadmin.entity.cloudmusic.Songs;
import com.xq.serviceadmin.entity.comment.CommentReturn;
import com.xq.serviceadmin.entity.dto.AddMusicDTO;
import com.xq.serviceadmin.service.CloudMusicService;
import com.xq.serviceadmin.utils.SessionUtils;
import com.xq.utils.HttpUtils;
import com.xq.utils.JacksonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class CloudMusicServiceImp implements CloudMusicService {

    private static final String CLOUD_MUSIC_API = "http://music.163.com/api/search/pc";
    private static final String DEFAULT_LRC = "[00:00.000] Default Lyric From kuku \\n [00:03.000] 无歌词，请您欣赏";
    private static final Integer ZERO = 0;
    private static final Integer MUSIC_INSERT_SUCCESS = 1;
    private static final Integer MUSIC_INSERT_Fail = 2;
    private static final Integer MUSIC_IS_EXIST = 3;


    @Autowired
    private MusicMapper musicMapper;
    @Autowired
    private MusicListMapper musicListMapper;

    @Override
    public MusicRootBean musicSearch(String s, String pageNum, String pageSize, String type) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("s", s);
        map.put("offset", pageNum);
        map.put("limit", pageSize);
        map.put("type", type);
        MusicRootBean result = JacksonUtils.json2pojo(HttpUtils.postMap(CLOUD_MUSIC_API, map), MusicRootBean.class);
        return result;
    }

    @Override
    public Integer addMusic(AddMusicDTO addMusicDTO) throws Exception {
        //判断音乐和用户id是否存在，不存在则返回true 可以插入
        Music m = new Music();
        User loginUser = SessionUtils.getUserFromSession();
        m.setUserId(null == loginUser ? 0 : loginUser.getUserId());
        Integer id = addMusicDTO.getMusicId();
        m.setMusicId(id);
        if (musicMapper.select(m).size() != 0) {
            return MUSIC_IS_EXIST;
        }

        //传过来网易云的音乐id，拼接成：http://music.163.com/song/media/outer/url?id=1313354324.mp3
        String musicUrl = "http://music.163.com/song/media/outer/url?id=" + id + ".mp3";

        CompletableFuture<Music> musicDO = CompletableFuture.supplyAsync(() -> {
            String json = HttpUtils.get("http://music.163.com/api/song/detail/?id=" + id + "&ids=%5B" + id + "%5D");
            MusicDetailReturn musicDetailReturn = null;
            try {
                musicDetailReturn = JacksonUtils.json2pojo(json, MusicDetailReturn.class);
            } catch (Exception e) {
                System.out.println("歌曲id:{},获取歌曲详情jackson转换出错：" + e);
            }
            Songs song = musicDetailReturn.getSongs().get(0);
            Music music = new Music();
            music.setMusicId(id);
            music.setName(song.getName());
            music.setArtist(song.getArtists().get(0).getName());
            music.setCover(song.getAlbum().getPicUrl());
            music.setCommentId(song.getCommentThreadId());
            return music;
        });

        CompletableFuture<String> musicLyric = CompletableFuture.supplyAsync(() -> {
            String json = HttpUtils.get("http://music.163.com/api/song/media?id=" + id);
            LyricReturn lyricReturn = null;
            try {
                lyricReturn = JacksonUtils.json2pojo(json, LyricReturn.class);
            } catch (Exception e) {
                System.out.println(e);
            }

            return StringUtils.isEmpty(lyricReturn.getLyric()) ? DEFAULT_LRC : lyricReturn.getLyric();
        });
        Music music = musicDO.get();
        music.setLrc(musicLyric.get());
        music.setUrl(musicUrl);
        music.setMusicListId(addMusicDTO.getMusicListId());
        User user = SessionUtils.getUserFromSession();
        music.setUserId(null == user ? ZERO : user.getUserId());
        //插入数据库
        return musicMapper.insertSelective(music) == 1 ? MUSIC_INSERT_SUCCESS : MUSIC_INSERT_Fail;
    }

    @Override
    public CommentReturn getMusicCommentById(String id, String pageSize, String pageNum) {
        String s = HttpUtils.get("http://music.163.com/api/v1/resource/comments/" + id + "?limit=" + pageSize + "&offset=" + pageNum);
        CommentReturn commentReturn = null;
        try {
            commentReturn = JacksonUtils.json2pojo(s, CommentReturn.class);
        } catch (Exception e) {
//            log.warn("当前链接:{},获取歌曲评论出错：{}", "http://music.163.com/api/v1/resource/comments/" + id + "?limit=" + pageSize + "&offset=" + pageNum, e.getMessage());
        }
        return commentReturn;
    }

    @Override
    public List<MusicList> getLoginUserMusicList() {
        User user = SessionUtils.getUserFromSession();
        return user == null ? null : musicListMapper.selectAllByUserId(user.getUserId());
    }

    @Override
    public List<Music> getLoginUserMusicListSongs(Integer musicListId) {
        User user = SessionUtils.getUserFromSession();
        return user == null ? null : musicMapper.selectAllByUserIdAndMusicListId(user.getUserId(), musicListId);
    }

    @Override
    public MusicList getLoginUserMusicList(Integer listId) {
        User user = SessionUtils.getUserFromSession();
        return user == null ? null : musicListMapper.selectOneByListIdAndUserId(listId,user.getUserId());
    }

    //    @Override
//    public void delMusic(String id) {
////        MusicVO music = new MusicVO();
////        music.setMusicId(id);
////        musicMapper.delete(music);
//    }
    @Deprecated
    @Override
    public List<Music> getAllMusic(Integer userId) {
        List<Music> musics = musicMapper.selectByUserId(userId);
        return musics;
    }
}
