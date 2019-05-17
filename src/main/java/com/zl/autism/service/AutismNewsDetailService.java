package com.zl.autism.service;

import com.zl.autism.mapper.AutismCCommentMapper;
import com.zl.autism.mapper.AutismNewsDetailMapper;
import com.zl.autism.model.AutismCComment;
import com.zl.autism.model.AutismNewsDetail;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutismNewsDetailService {

    @Autowired
    private AutismNewsDetailMapper autismNewsDetailMapper;



    //查询game
    public ArrayList<AutismNewsDetail> getAutismCCommentList(ArrayList<String> uuidList){
        ArrayList<AutismNewsDetail> list = this.autismNewsDetailMapper.getAutismNewsDetailList(uuidList);
        return list;
    }
}
