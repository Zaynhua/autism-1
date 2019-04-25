package com.zl.autism.mapper;

import com.zl.autism.model.AutismAsscess;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

public interface AutismAsscessMapper extends Mapper<AutismAsscess> {

    ArrayList<AutismAsscess> getAsscessList(@Param("ids")ArrayList<String > ids,
                                            @Param("interventionIds")ArrayList<String> interventionIds,
                                            @Param("interventionistIds")ArrayList<String> interventionistIds);

}
