package com.xq.serviceadmin.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xq.serviceadmin.dao.MusicMapper;
import com.xq.serviceadmin.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService {

    @Resource
    private MusicMapper musicMapper;

}






