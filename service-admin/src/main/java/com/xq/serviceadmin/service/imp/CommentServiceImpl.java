package com.xq.serviceadmin.service.imp;

import com.xq.serviceadmin.entity.Comment;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xq.serviceadmin.dao.CommentMapper;
import com.xq.serviceadmin.service.CommentService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    public Comment seleceById(String id){
        return commentMapper.selectByPrimaryKey(id);
    }

    public List<Comment> seleceById(Example example){
        return commentMapper.selectByExample(example);
    }

    public List<Comment> seleceAll(){
        return commentMapper.selectAll();
    }

    public int insert(Comment comment){
        return commentMapper.insert(comment);
    }

    public int deleteById(String id){
        return commentMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(Example example){
        return commentMapper.deleteByExample(example);
    }

    public int updateById(Comment comment){
        return commentMapper.updateByPrimaryKey(comment);
    }

    public int updateByExample(Comment comment, Example example){
        return commentMapper.updateByExampleSelective(comment, example);
    }

    public int countByExample(Example example){
        return commentMapper.selectCountByExample(example);
    }
}
