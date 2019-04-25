package com.zl.autism.mapper;

import com.zl.autism.model.AutismDept;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

public interface AutismDeptMapper extends Mapper<AutismDept> {

    ArrayList<AutismDept> getAutismDept(@Param("uuids")ArrayList<String> uuids);
}
