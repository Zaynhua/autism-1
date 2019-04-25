package com.zl.autism.service;

import com.zl.autism.mapper.AutismUserRelationMapper;
import com.zl.autism.model.AutismUserRelation;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class AutismUserRelationService {

    @Autowired
    private AutismUserRelationMapper autismUserRelationMapper;

    //增加
    public String addRelation(AutismUserRelation userRelation) throws Exception{
        if (StringUtils.isEmpty(userRelation.getUserId())){
            throw new Exception("用户ID不可为空");
        }

        if (StringUtils.isEmpty(userRelation.getRelationUserId())){
            throw new Exception("关联用户id不可为空");
        }

        String uuid = RandomUtils.UUIDString();
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        userRelation.setUuid(uuid);
        userRelation.setFlag("1");
        userRelation.setCreateTime(nowTime);
        userRelation.setUpdateTime(nowTime);

        this.autismUserRelationMapper.insertSelective(userRelation);
        return uuid;
    }

    //删除
    public String delRelation(String uuid) throws Exception{
        if (StringUtils.isEmpty(uuid)){
            throw new Exception("uuid不可以为空");
        }
        AutismUserRelation userRelation = this.autismUserRelationMapper.selectByPrimaryKey(uuid);
        if (userRelation==null||userRelation.getFlag()=="0"){
            throw new Exception("该用户关联关系不存在");
        }
        userRelation.setFlag("0");
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        userRelation.setUpdateTime(nowTime);

        this.autismUserRelationMapper.updateByPrimaryKeySelective(userRelation);

        return uuid;
    }

    //改
    public String updateRelation(AutismUserRelation userRelation) throws Exception{
        if (StringUtils.isEmpty(userRelation.getUuid())){
            throw new Exception("uuid不可以为空");
        }
        AutismUserRelation orgRelation = this.autismUserRelationMapper.selectByPrimaryKey(userRelation.getUuid());
        if (orgRelation==null||orgRelation.getFlag()=="0"){
            throw new Exception("该用户关联关系不存在");
        }

        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        userRelation.setUpdateTime(nowTime);
        userRelation.setCreateTime(orgRelation.getCreateTime());
        this.autismUserRelationMapper.updateByPrimaryKeySelective(userRelation);

        return userRelation.getUuid();
    }

    //查
    public ArrayList<AutismUserRelation> getRelations(ArrayList<String> uuids,String userId) throws Exception{
        ArrayList<AutismUserRelation> list = this.autismUserRelationMapper.getRelations(uuids,userId);
        return list;
    }

}
