package com.zl.autism.service;

import com.zl.autism.mapper.UserAndGameMapper;
import com.zl.autism.model.UserAndGame;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class UserAndGameService {

    @Autowired
    private UserAndGameMapper userAndGameMapper;

    //增加
    public String addUserRelation(UserAndGame game) throws Exception{
        if (StringUtils.isEmpty(game.getGameId())){
            throw new Exception("游戏id不可为空");
        }
        if (StringUtils.isEmpty(game.getUserId())){
            throw new Exception("患者id不可为空");
        }
        String uuid = RandomUtils.UUIDString();
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        game.setFlag("1");
        game.setUuid(uuid);
        game.setCreateTime(nowTime);
        game.setUpdateTime(nowTime);

        this.userAndGameMapper.insertSelective(game);

        return uuid;
    }


    public String delGameRelation(String uuid) throws Exception{

        if (StringUtils.isEmpty(uuid)){
            throw new Exception("uuid不可以为空");
        }

        UserAndGame orgGame = this.userAndGameMapper.selectByPrimaryKey(uuid);
        if (orgGame == null || orgGame.getFlag()=="0"){
            throw new Exception("该用户游戏关系不存在");
        }
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        orgGame.setFlag("0");
        orgGame.setUpdateTime(nowTime);
        this.userAndGameMapper.updateByPrimaryKeySelective(orgGame);
        return uuid;
    }

    public String updateGameRelation(UserAndGame game) throws Exception{

        if (StringUtils.isEmpty(game.getUuid())){
            throw new Exception("uuid不可为空");
        }

        UserAndGame orgGame = this.userAndGameMapper.selectByPrimaryKey(game.getUuid());
        if (orgGame == null || orgGame.getFlag()=="0"){
            throw new Exception("该用户游戏关系不存在");
        }

        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        game.setUpdateTime(nowTime);
        game.setCreateTime(orgGame.getCreateTime());

        this.userAndGameMapper.updateByPrimaryKeySelective(game);

        return game.getUuid();
    }

    public ArrayList<UserAndGame> getGameRelation(ArrayList<String> list) throws Exception{
        ArrayList<UserAndGame> data = this.userAndGameMapper.getGameRelation(list);
        return data;
    }
}
