package com.zl.autism.mapper;

import com.zl.autism.model.UserAndGame;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

public interface UserAndGameMapper extends Mapper<UserAndGame> {

    ArrayList<UserAndGame> getGameRelation(@Param("uuidList") ArrayList<String> uuidList);
}
