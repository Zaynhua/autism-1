package com.zl.autism.mapper;

import com.zl.autism.model.AutismUserRelation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

public interface AutismUserRelationMapper extends Mapper<AutismUserRelation> {

    ArrayList<AutismUserRelation> getRelations(@Param("uuids")ArrayList<String> uuids,@Param("userId")String userId);

}
