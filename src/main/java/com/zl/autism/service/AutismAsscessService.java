package com.zl.autism.service;

import com.zl.autism.mapper.AutismAsscessMapper;
import com.zl.autism.mapper.UserMapper;
import com.zl.autism.model.AutismAsscess;
import com.zl.autism.model.User;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class AutismAsscessService {

    @Autowired
    private AutismAsscessMapper autismAsscessMapper;

    @Autowired
    private UserMapper userMapper;

    //增加评估信息
    public String  addAsscess(AutismAsscess autismAsscess) throws Exception{

        if (StringUtils.isEmpty(autismAsscess.getInterventionId())){
            throw new Exception("干预对象id");
        }
        if (StringUtils.isEmpty(autismAsscess.getInterventionistId())){
            throw new Exception("干预师id");
        }

        String uuid = RandomUtils.UUIDString();
        autismAsscess.setUuid(uuid);
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        autismAsscess.setCreateTime(nowTime);
        autismAsscess.setUpdateTime(nowTime);
        autismAsscess.setFlag("1");
        this.autismAsscessMapper.insertSelective(autismAsscess);
        return uuid;
    }

    //删除评估信息
    public String delAsscess(String id) throws Exception{

        AutismAsscess orgAutismAsscess = this.autismAsscessMapper.selectByPrimaryKey(id);

        if (orgAutismAsscess ==null|| orgAutismAsscess.getFlag()=="0"){
            throw new Exception("无此评估信息");
        }

        orgAutismAsscess.setFlag("0");
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        orgAutismAsscess.setUpdateTime(nowTime);
        this.autismAsscessMapper.updateByPrimaryKeySelective(orgAutismAsscess);

        return orgAutismAsscess.getUuid();
    }

    //更新评估信息
    public String updateAsscess(AutismAsscess autismAsscess) throws Exception{

        if (StringUtils.isEmpty(autismAsscess.getUuid())){
            throw new Exception("无此uuid的信息");
        }

        AutismAsscess orgAutismAsscess = this.autismAsscessMapper.selectByPrimaryKey(autismAsscess.getUuid());
        if (orgAutismAsscess ==null|| orgAutismAsscess.getFlag()=="0"){
            throw new Exception("无此评估信息");
        }

        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        autismAsscess.setUpdateTime(nowTime);
        autismAsscess.setCreateTime(orgAutismAsscess.getCreateTime());
        this.autismAsscessMapper.updateByPrimaryKeySelective(autismAsscess);

        return autismAsscess.getUuid();
    }

    //查询评估信息
    public ArrayList<AutismAsscess> getAsscess(ArrayList<String> ids, ArrayList<String> interventionId, ArrayList<String> interventionistId){

        ArrayList<AutismAsscess> autismAsscesses = this.autismAsscessMapper.getAsscessList(ids,interventionId,interventionistId);

        for (AutismAsscess asscess:autismAsscesses) {
            User docter = this.userMapper.selectByPrimaryKey(asscess.getInterventionistId());
            User patient = this.userMapper.selectByPrimaryKey(asscess.getInterventionId());
            asscess.setDocter(docter);
            asscess.setPatient(patient);
        }
        return autismAsscesses;
    }

}
