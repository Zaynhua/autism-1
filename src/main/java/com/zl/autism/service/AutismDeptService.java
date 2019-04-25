package com.zl.autism.service;

import com.zl.autism.mapper.AutismDeptMapper;
import com.zl.autism.model.AutismDept;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class AutismDeptService {

    @Autowired
    private AutismDeptMapper autismDeptMapper;

    //增
    public String addDept(AutismDept dept) throws Exception{
        if (StringUtils.isEmpty(dept.getName())){
            throw new Exception("机构名称不可为空");
        }

        String uuid = RandomUtils.UUIDString();

        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        dept.setUuid(uuid);
        dept.setCreateTime(nowTime);
        dept.setUpdateTime(nowTime);
        dept.setFlag("1");
        this.autismDeptMapper.insertSelective(dept);
        return uuid;
    }

    //删
    public String delDept(String uuid) throws Exception{
        if (StringUtils.isEmpty(uuid)){
            throw new Exception("id不可为空");
        }
        AutismDept orgDept = this.autismDeptMapper.selectByPrimaryKey(uuid);
        if (orgDept == null||orgDept.getFlag()=="0"){
            throw new Exception("该uuid无数据");
        }
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        orgDept.setFlag("0");
        orgDept.setUpdateTime(nowTime);
        this.autismDeptMapper.updateByPrimaryKeySelective(orgDept);
        return uuid;
    }

    //改
    public String updateDept(AutismDept dept) throws Exception{
        if (StringUtils.isEmpty(dept.getUuid())){
            throw new Exception("uuid不可为空");
        }
        AutismDept orgDept = this.autismDeptMapper.selectByPrimaryKey(dept.getUuid());
        if (orgDept==null || orgDept.getFlag()=="0"){
            throw new Exception("该uuid数据不存在");
        }
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        dept.setUpdateTime(nowTime);
        dept.setCreateTime(orgDept.getCreateTime());
        this.autismDeptMapper.updateByPrimaryKeySelective(dept);
        return dept.getUuid();
    }

    //查
    public ArrayList<AutismDept> getAutismDepts(ArrayList<String> uuids){
        ArrayList<AutismDept> autismDepts = this.autismDeptMapper.getAutismDept(uuids);
        return autismDepts;
    }

}
