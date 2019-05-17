package com.zl.autism.mapper;

import com.zl.autism.model.AutismCComment;
import com.zl.autism.model.AutismNewsDetail;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

import tk.mybatis.mapper.common.Mapper;

public interface AutismNewsDetailMapper extends Mapper<AutismNewsDetail> {
    ArrayList<AutismNewsDetail> getAutismNewsDetailList(@Param("idList") ArrayList<String> idList);
}
