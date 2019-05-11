package com.xq.serviceadmin.dao;

import com.xq.serviceadmin.entity.MusicList;
import com.xq.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicListMapper extends MyMapper<MusicList> {
    List<MusicList> selectAllByUserId(@Param("userId") Integer userId);

    MusicList selectOneByListIdAndUserId(@Param("listId") Integer listId, @Param("userId") Integer userId);
}