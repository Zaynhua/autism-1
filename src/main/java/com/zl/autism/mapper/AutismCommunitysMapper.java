package com.zl.autism.mapper;

import com.zl.autism.model.AutismCommunitys;
import com.zl.autism.model.AutismGame;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

import tk.mybatis.mapper.common.Mapper;

public interface AutismCommunitysMapper extends Mapper<AutismCommunitys> {
    ArrayList<AutismCommunitys> getAutismCommunitysList(@Param("idList") ArrayList<String> idList,
                                                        @Param("communitys_city") ArrayList<String> communitys_city);
}
