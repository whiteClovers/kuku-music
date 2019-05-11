package com.xq.serviceadmin.service;

import com.xq.serviceadmin.entity.MusicList;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface MusicListService {

    public MusicList seleceById(String id);

    public List<MusicList> seleceById(Example example);

    public List<MusicList> seleceAll();

    public int insert(MusicList MusicList);

    public int deleteById(String id);

    public int deleteByExample(Example example);

    public int updateById(MusicList MusicList);

    public int updateByExample(MusicList MusicList, Example example);

    public int countByExample(Example example);

}

