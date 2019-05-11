package com.xq.serviceadmin.dao;

import com.xq.serviceadmin.entity.Music;
import com.xq.utils.MyMapper;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface MusicMapper extends MyMapper<Music> {
    List<Music> selectByUserId(@Param("userId") Integer userId);

    List<Music> selectAllByUserIdAndMusicListId(@Param("userId")Integer userId,@Param("musicListId")Integer musicListId);


}