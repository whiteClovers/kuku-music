package com.xq.serviceadmin.MybatisGeneratorTest;

import com.xq.serviceadmin.ServiceAdminApplication;
import com.xq.serviceadmin.dao.MusicListMapper;
import com.xq.serviceadmin.dao.MusicMapper;
import com.xq.serviceadmin.dao.UserMapper;
import com.xq.serviceadmin.entity.MusicList;
import com.xq.serviceadmin.entity.cloudmusic.MusicRootBean;
import com.xq.serviceadmin.entity.cloudmusic.Result;
import com.xq.serviceadmin.entity.cloudmusic.Songs;
import com.xq.serviceadmin.service.CloudMusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-05 14:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
public class MusicTest {

    @Autowired
    CloudMusicService cloudMusicService;

    @Autowired
    MusicListMapper musicListMapper;


    @Test
    public void testMusicSearch() throws Exception {
        // 根据歌名搜索歌曲
        MusicRootBean musicSearch = cloudMusicService.musicSearch("陈奕迅", "1", "10", "1");
        Result result = musicSearch.getResult();
        List<Songs> songs = result.getSongs();

        // 打印搜索歌曲
        songs.forEach(song -> System.err.println(song));
    }

    @Test
    public void testMusicListAdd(){
        MusicList musicList = new MusicList();
        musicList.setListName("新增_欧美风");
        musicList.setLabel("欧美");
        musicList.setUserId(4);
        musicList.setCreaTime(new Date());

        int flag = musicListMapper.insertSelective(musicList);
        if (flag == 1){
            System.err.println("新增成功");
        }else {
            System.err.println("新增失败");
        }

    }


}
