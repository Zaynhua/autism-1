package com.zl.autism.mapper;

import com.zl.autism.model.AutismCComment;
import com.zl.autism.model.AutismCommunitys;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

import tk.mybatis.mapper.common.Mapper;

public interface AutismCCommentMapper extends Mapper<AutismCComment> {
    ArrayList<AutismCComment> getAutismCCommentList(@Param("idList") ArrayList<String> idList);
}
