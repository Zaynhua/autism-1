package com.zl.autism.service;

import com.zl.autism.mapper.AutismCommunitysMapper;
import com.zl.autism.mapper.AutismGameMapper;
import com.zl.autism.model.AutismCommunitys;
import com.zl.autism.model.AutismGame;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class AutismCommunitysService {

    @Autowired
    private AutismCommunitysMapper autismCommunitysMapper;

    //增加游戏
    public String addCommunity(AutismCommunitys communitys) throws Exception{


        String uuid = RandomUtils.UUIDString();

        communitys.setCommunitys_id(uuid);

        this.autismCommunitysMapper.insertSelective(communitys);
        return uuid;
    }


    //查询game
    public ArrayList<AutismCommunitys> getAutismCommunitysList(ArrayList<String> uuidList, ArrayList<String> communitys_city){
        ArrayList<AutismCommunitys> list = this.autismCommunitysMapper.getAutismCommunitysList(uuidList, communitys_city);
        return list;
    }
}
