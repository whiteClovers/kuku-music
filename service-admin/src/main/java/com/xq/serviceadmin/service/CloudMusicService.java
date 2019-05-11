package com.xq.serviceadmin.service;

import com.xq.serviceadmin.entity.Music;
import com.xq.serviceadmin.entity.MusicList;
import com.xq.serviceadmin.entity.cloudmusic.MusicRootBean;
import com.xq.serviceadmin.entity.comment.CommentReturn;
import com.xq.serviceadmin.entity.dto.AddMusicDTO;

import java.util.List;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-09 11:22
 **/
public interface CloudMusicService {
    MusicRootBean musicSearch(String s, String pageNum, String pageSize, String type) throws Exception;

    Integer addMusic(AddMusicDTO addMusicDTO) throws Exception;

    CommentReturn getMusicCommentById(String id, String pageSize, String pageNum);

    List<MusicList> getLoginUserMusicList();

    List<Music> getLoginUserMusicListSongs(Integer musicListId);

    MusicList getLoginUserMusicList(Integer listId);

    List<Music> getAllMusic(Integer userId);
}
