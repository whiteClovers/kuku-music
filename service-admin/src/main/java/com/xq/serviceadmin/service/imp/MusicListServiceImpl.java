package com.xq.serviceadmin.service.imp;

import com.xq.serviceadmin.dao.MusicListMapper;
import com.xq.serviceadmin.entity.MusicList;
import com.xq.serviceadmin.service.MusicListService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicListServiceImpl implements MusicListService {

    @Resource
    private MusicListMapper musicListMapper;

    public MusicList seleceById(String id) {
        return musicListMapper.selectByPrimaryKey(id);
    }

    public List<MusicList> seleceById(Example example) {
        return musicListMapper.selectByExample(example);
    }

    public List<MusicList> seleceAll() {
        return musicListMapper.selectAll();
    }

    public int insert(MusicList musicList) {
        if (StringUtils.isEmpty(musicList.getListPic())){
            musicList.setListPic("7pKS_S86OJo8cHcDNKFw==/109951163922821064.jpg");
        }
        return musicListMapper.insert(musicList);
    }

    public int deleteById(String id) {
        return musicListMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(Example example) {
        return musicListMapper.deleteByExample(example);
    }

    public int updateById(MusicList musicList) {
        return musicListMapper.updateByPrimaryKey(musicList);
    }

    public int updateByExample(MusicList musicList, Example example) {
        return musicListMapper.updateByExampleSelective(musicList, example);
    }

    public int countByExample(Example example) {
        return musicListMapper.selectCountByExample(example);
    }
}

