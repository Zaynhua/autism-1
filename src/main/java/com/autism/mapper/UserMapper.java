package com.autism.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.autism.model.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{

	public User login(@Param("phone")String phone,@Param("password")String password,@Param("type")String type);
	
	public ArrayList<User> getUserInfos(@Param("uuid")ArrayList<String> uuid,@Param("open_id")ArrayList<String> openId);
	
	public User getUserByPhone(@Param("phone")String phone);
}
