package com.zl.autism.service;

import com.zl.autism.mapper.AutismGameMapper;
import com.zl.autism.model.AutismGame;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class AutismGameService {

    @Autowired
    private AutismGameMapper autismGameMapper;

    //增加游戏
    public String addGame(AutismGame game) throws Exception{

        if (StringUtils.isEmpty(game.getName())){
            throw new Exception("游戏名称不可为空");
        }

        if (StringUtils.isEmpty(game.getDevId())){
            throw new Exception("开发者id不可为空");
        }

        String uuid = RandomUtils.UUIDString();
        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        game.setUuid(uuid);
        game.setUpdateTime(nowTime);
        game.setCreateTime(nowTime);
        game.setFlag("1");

        this.autismGameMapper.insertSelective(game);
        return uuid;
    }

    //删除游戏
    public String delGame(String uuid) throws Exception{
        if (StringUtils.isEmpty(uuid)){
            throw new Exception("uuid不能为空");
        }

        AutismGame orgGame = this.autismGameMapper.selectByPrimaryKey(uuid);
        if (orgGame == null || orgGame.getFlag()=="0"){
            throw new Exception("不存在该游戏");
        }

        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();

        orgGame.setFlag("0");
        orgGame.setUpdateTime(nowTime);

        this.autismGameMapper.updateByPrimaryKey(orgGame);

        return uuid;
    }

    //更新游戏
    public String updateGame(AutismGame game) throws Exception{

        if (StringUtils.isEmpty(game.getUuid())){
            throw new Exception("uuid不可以为空");
        }

        AutismGame orgGame = this.autismGameMapper.selectByPrimaryKey(game.getUuid());
        if (orgGame == null || orgGame.getFlag()=="0"){
            throw new Exception("不存在该游戏");
        }

        if (StringUtils.isEmpty(game.getName())){
            throw new Exception("游戏名称不可为空");
        }

        if (StringUtils.isEmpty(game.getDevId())){
            throw new Exception("开发者id不可为空");
        }

        String time = CommonUtil.getNowTimeStamp();
        int nowTime = Integer.valueOf(time).intValue();
        game.setUpdateTime(nowTime);
        game.setCreateTime(orgGame.getCreateTime());
//        this.autismGameMapper.updateByPrimaryKey(game);
        this.autismGameMapper.updateByPrimaryKeySelective(game);
        return game.getUuid();

    }

    //查询game
    public ArrayList<AutismGame> getAutismGameList(ArrayList<String> uuidList){
        ArrayList<AutismGame> list = this.autismGameMapper.getAutismGameList(uuidList);
        return list;
    }
}
