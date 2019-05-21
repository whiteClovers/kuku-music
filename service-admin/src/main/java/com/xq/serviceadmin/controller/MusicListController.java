package com.xq.serviceadmin.controller;

import com.netflix.discovery.converters.Auto;
import com.xq.serviceadmin.dao.MusicListMapper;
import com.xq.serviceadmin.entity.Music;
import com.xq.serviceadmin.entity.MusicList;
import com.xq.serviceadmin.entity.User;
import com.xq.serviceadmin.entity.dto.BaseResult;
import com.xq.serviceadmin.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-06 16:08
 **/
@RestController
@RequestMapping("/musicList")
public class MusicListController {

    @Autowired
    MusicListService musicListService;

    @Autowired
    MusicListMapper musicListMapper;


    @GetMapping("/list")
    public BaseResult list(HttpSession session){
        User user = (User)session.getAttribute("user");
        List<MusicList> musicLists = musicListMapper.selectAllByUserId(user.getUserId());

        return BaseResult.ok(musicLists);
    }

    @GetMapping("/list/{id}")
    public BaseResult listById(HttpSession session, @PathVariable("id") Integer id){
        User user = (User)session.getAttribute("user");
        MusicList musicList = musicListMapper.selectOneByListIdAndUserId(id, user.getUserId());

        return BaseResult.ok(musicList);
    }

    @PostMapping("/add")
    public BaseResult add(MusicList musicList,
                          HttpSession session,
                          @RequestParam(value = "listName", required = false) String listName,
                          @RequestParam(value = "label", required = false) String label){
        musicList.setListName(listName);
        musicList.setLabel(label);
        User user = (User) session.getAttribute("user");
        musicList.setUserId(user.getUserId());
        musicList.setCreaTime(new Date());
        musicList.setListPic("7pKS_S86OJo8cHcDNKFw==/109951163922821064.jpg");

        int i = musicListMapper.insertSelective(musicList);

        if (i == 1){
            return BaseResult.ok();
        }else {
            return BaseResult.notOk("新增失败");
        }
    }

    @PostMapping("/edit/{id}")
    public BaseResult edit(MusicList musicList,
                           HttpSession session,
                           @PathVariable("id" ) Integer id,
                           @RequestParam(value = "listName", required = false) String listName,
                           @RequestParam(value = "label", required = false) String label){
        System.out.println("id :"+id);
        System.out.println("listName :"+listName);
        System.out.println("label :"+label);

        User user = (User) session.getAttribute("user");
        musicList.setUserId(user.getUserId());
        musicList.setListId(id);
        musicList.setListName(listName);
        musicList.setLabel(label);
        musicList.setCreaTime(new Date());

        int i = musicListMapper.updateByPrimaryKey(musicList);

        System.out.println("musicListEdit :"+musicList);
        return BaseResult.ok();
    }

    @PostMapping("/delete/{id}")
    public BaseResult delete(HttpSession session, @PathVariable("id") Integer id){
        User user = (User)session.getAttribute("user");
        System.out.println("deleteid :"+id);

        MusicList musicList = new MusicList();
        musicList.setListId(id);
        int flag = musicListMapper.delete(musicList);
        if (flag == 1){
            return BaseResult.ok();
        }else {
            return BaseResult.notOk("删除失败");
        }
    }



}
