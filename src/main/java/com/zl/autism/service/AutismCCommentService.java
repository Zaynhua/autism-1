package com.zl.autism.service;

import com.zl.autism.mapper.AutismCCommentMapper;
import com.zl.autism.mapper.AutismCommunitysMapper;
import com.zl.autism.model.AutismCComment;
import com.zl.autism.model.AutismCommunitys;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutismCCommentService {

    @Autowired
    private AutismCCommentMapper autismCCommentMapper;

    //增加游戏
    public String addCComment(AutismCComment comment) throws Exception{


        String uuid = RandomUtils.UUIDString();

        comment.setCommunitys_comment_id(uuid);

        String time = CommonUtil.getNowTimeStamp();
        comment.setCommunitys_comment_time(time);

        this.autismCCommentMapper.insertSelective(comment);
        return uuid;
    }


    //查询game
    public ArrayList<AutismCComment> getAutismCCommentList(ArrayList<String> uuidList){
        ArrayList<AutismCComment> list = this.autismCCommentMapper.getAutismCCommentList(uuidList);
        return list;
    }
}
