package com.xq.serviceadmin.controller;

import com.xq.serviceadmin.entity.Music;
import com.xq.serviceadmin.entity.MusicList;
import com.xq.serviceadmin.entity.cloudmusic.MusicRootBean;
import com.xq.serviceadmin.entity.comment.CommentReturn;
import com.xq.serviceadmin.entity.dto.AddMusicDTO;
import com.xq.serviceadmin.entity.dto.BaseResult;
import com.xq.serviceadmin.service.CloudMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-06 16:08
 **/
@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    CloudMusicService cloudMusicService;

    /* 
    * @Description: 音乐搜索 
    * @Param: [s, pageNum, pageSize, type] 
    * @return: com.xq.serviceadmin.entity.dto.BaseResult 
    * @Author: Mr.Fu 
    * @Date: 2019/5/18 
    */ 
    @GetMapping("/search")
    public BaseResult musicSearch(String s, String pageNum, String pageSize, String type) throws Exception {
        MusicRootBean musicRootBean = cloudMusicService.musicSearch(s, pageNum, pageSize, type);
        return BaseResult.ok(musicRootBean);
    }

    /**
     * 网易云音乐搜索
     *
     * @param s        搜索的内容
     * @param pageNum  当前页码
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping("/hotMusicPlay")
    public BaseResult hotMusicPlay(String s, String pageNum, String pageSize, String type) throws Exception {
        MusicRootBean musicRootBean = cloudMusicService.musicSearch(s, pageNum, pageSize, type);
        return BaseResult.ok(musicRootBean);
    }

    /* 
    * @Description: 从数据库随机选取9条music数据作为展示 
    * @Param: [] 
    * @return: com.xq.serviceadmin.entity.dto.BaseResult 
    * @Author: Mr.Fu 
    * @Date: 2019/5/18 
    */ 
    @GetMapping("/hotMusic")
    public BaseResult getHotMusic() {
        List<Music> musics= cloudMusicService.getHotMusic();
        return BaseResult.ok(musics);
    }

    /**
     * 获得当前登录用户的所有歌单
     *
     * @return
     */
    @GetMapping("/musicList")
    public BaseResult getMusicList() {
        List<MusicList> list = cloudMusicService.getLoginUserMusicList();
        return list == null ? BaseResult.notOk("null") : BaseResult.ok(list);
    }

    /**
     * 根据 id 获得当前登录用户的歌单
     *
     * @return
     */
    @GetMapping("/musicList/{id}")
    public BaseResult getMusicListById(@PathVariable("id") Integer id) {
        MusicList musicList = cloudMusicService.getLoginUserMusicList(id);
        return musicList == null ? BaseResult.notOk("null") : BaseResult.ok(musicList);
    }

    /**
     * 获得歌单的哥
     *
     * @return
     */
    @GetMapping("/musicList/songs/{id}")
    public BaseResult getMusicList(@PathVariable("id") Integer musicListId) {
        List<Music> songs = cloudMusicService.getLoginUserMusicListSongs(musicListId);
        return songs == null ? BaseResult.notOk("null") : BaseResult.ok(songs);
    }


    /**
     * 通过网易云音乐ID添加音乐到DB
     *
     * @param addMusicDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/addmusic")
    public BaseResult addMusic(AddMusicDTO addMusicDTO) throws Exception {
        Integer result = cloudMusicService.addMusic(addMusicDTO);
        return BaseResult.ok(result == 3 ? "歌曲已存在" : (result == 1 ? "添加成功" : "添加失败"));
    }

    /**
     * 通过id获得评论内容
     *
     * @param id       网易云评论id 格式类似：R_SO_4_516997458   其中516997458为歌曲id
     * @param pageSize 每页数量
     * @param pageNum  当前页
     * @return
     * @throws Exception
     */
    @GetMapping("/comment")
    public BaseResult getMusicCompentById(String id, String pageSize, String pageNum) {
        CommentReturn comment = cloudMusicService.getMusicCommentById(id, pageSize, pageNum);
        return BaseResult.ok(comment);
    }

    /** 
    * @Description: 获取当前用户歌单列表 
    * @Param: [model, request] 
    * @return: java.lang.String 
    * @Author: Mr.Fu 
    * @Date: 2019/5/18 
    */ 
    @Deprecated
    @GetMapping("/list")
    public String getAllMusicByUserId(Model model, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        List<Music> allMusic = cloudMusicService.getAllMusic(userId);
        model.addAttribute("musics", allMusic);
        return "/user/myPage";
    }


}
