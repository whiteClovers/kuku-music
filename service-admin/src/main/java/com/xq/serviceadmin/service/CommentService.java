package com.xq.serviceadmin.service;

import com.xq.serviceadmin.entity.Comment;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface CommentService{

    public Comment seleceById(String id);
    public List<Comment> seleceById(Example example);
    public List<Comment> seleceAll();

    public int insert(Comment Comment);

    public int deleteById(String id);
    public int deleteByExample(Example example);

    public int updateById(Comment Comment);
    public int updateByExample(Comment Comment, Example example);

    public int countByExample(Example example);

}
