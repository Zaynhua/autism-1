package com.zl.autism.mapper;

import com.zl.autism.model.AutismGame;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

public interface AutismGameMapper  extends Mapper<AutismGame> {
    ArrayList<AutismGame> getAutismGameList(@Param("idList") ArrayList<String> idList);
}
