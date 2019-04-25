package com.zl.autism.service;

import java.util.ArrayList;

import com.zl.autism.mapper.AutismUserRelationMapper;
import com.zl.autism.model.AutismUserRelation;
import com.zl.autism.utils.CommonUtil;
import com.zl.autism.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zl.autism.mapper.UserMapper;
import com.zl.autism.model.User;
import com.zl.autism.utils.RandomUtils;
import org.springframework.util.StringUtils;


@Service
public class UserService{

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AutismUserRelationMapper userRelationMapper;


	public User login(String phone, String password) throws Exception{

		if (StringUtils.isEmpty(phone)) {
			throw new Exception("请传入电话号码");
		}
		if (StringUtils.isEmpty(password)) {
			throw new Exception("请传入密码");
		}
//		if (StringUtils.isEmpty(type)) {
//			throw new Exception("请传入用户类型");
//		}

		if (CommonUtil.isPhone(phone)==false){
			throw new Exception("手机号码格式有误");
		}

		//输入密码、用户名、类型后找到用户
		String encode = MD5.md5(password);
		User user = this.userMapper.login(phone, encode);
		if (user != null) {
			//有此用户
			//修改token值和token过期时间

			//获取session
//			HttpSession session = request.getSession();

			ArrayList<AutismUserRelation> relations = this.userRelationMapper.getRelations(null,user.getUuid());
			if (relations != null&&relations.size()>0){
				ArrayList<String> uuids = new ArrayList<String>();
				for (AutismUserRelation relation:relations) {
					uuids.add(relation.getRelationUserId());
				}
				ArrayList<User> userList = this.userMapper.getUserInfos(uuids,null,null);
				user.setrelatedUser(userList);
			}

			return user;
		}else {
			throw new Exception("手机号或密码不正确!");
		}
	}

	//获取用户详情
	public ArrayList<User> getUserInfo(ArrayList<String> uuid, ArrayList<String> openId,String type) throws Exception{
		ArrayList<User> users = this.userMapper.getUserInfos(uuid, openId,type);

		for (User user:users) {
			ArrayList<AutismUserRelation> relations = this.userRelationMapper.getRelations(null,user.getUuid());
			if (relations != null && relations.size()>0){
				ArrayList<String> uuidList = new ArrayList<String>();
				for (AutismUserRelation relation:relations) {
					uuidList.add(relation.getRelationUserId());
				}
				ArrayList<User> userList = this.userMapper.getUserInfos(uuidList,null,null);
				user.setrelatedUser(userList);
			}
		}


		return users;
	}

	@Transactional
	public String addUser(User user) throws Exception {
		if (StringUtils.isEmpty(user.getPhone())) {
			throw new Exception("用户电话不能为空");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			throw new Exception("用户密码不能为空");
		}
//		if (StringUtils.isEmpty(user.getType())) {
//			throw new Exception("用户类型不能为空");
//		}

		if (StringUtils.isEmpty(user.getName())){
			throw new Exception("用户名不能为空");
		}
		if (CommonUtil.isPhone(user.getPhone())==false){
			throw new Exception("手机号格式有误");
		}

//		if (CommonUtil.isEmail(user.getEmail())==false){
//			throw new Exception("邮箱格式有误");
//		}

		//判断是否有手机号码是否有相同
		User phoneUser = this.userMapper.getUserByPhone(user.getPhone());
		if (phoneUser!=null) {
			throw new Exception("该电话号码已注册");
		}

		String encode = MD5.md5(user.getPassword());
		user.setPassword(encode);

		String uuid = RandomUtils.UUIDString();
		String time = CommonUtil.getNowTimeStamp();
		int nowTime = Integer.valueOf(time).intValue();
		user.setUuid(uuid);
		user.setCreateTime(nowTime);
		user.setUpdateTime(nowTime);
		this.userMapper.insertSelective(user);
		return uuid;
	}

	public String deleteUser(String uuid) throws Exception {
		if (StringUtils.isEmpty(uuid)) {
			throw new Exception("未传入uuid");
		}
		User user = this.userMapper.selectByPrimaryKey(uuid);
		if (user==null||"0".equals(user.getFlag())) {
			throw new Exception("该用户不存在");
		}
//		int nowTime = (int)new Date().getTime();
		String time = CommonUtil.getNowTimeStamp();
		int nowTime = Integer.valueOf(time).intValue();
		user.setUpdateTime(nowTime);
		user.setFlag("0");
		this.userMapper.updateByPrimaryKeySelective(user);
		return uuid;
	}

	public String updateUser(User user,String newPsw) throws Exception {
		if (StringUtils.isEmpty(user.getUuid())) {
			throw new Exception("用户uuid不可为空");
		}
		User orgUser = this.userMapper.selectByPrimaryKey(user.getUuid());
		if (orgUser == null || "0".equals(orgUser.getFlag()) ) {
			throw new Exception("该用户不存在");
		}
		if (orgUser.getUpdateTime()==user.getUpdateTime()) {
			throw new Exception("此条消息正在被他人修改，请重新查询后再进行修改");
		}

		if (!StringUtils.isEmpty(user.getPhone())){
			throw new Exception("手机号不可修改");
		}
		if ((!StringUtils.isEmpty(user.getEmail()))&&CommonUtil.isEmail(user.getEmail())==false){
			throw new Exception("邮箱号格式有误");
		}

		if (!StringUtils.isEmpty(newPsw)){
			//修改密码操作
			if (StringUtils.isEmpty(user.getPassword())){
				throw new Exception("修改密码不可不传用户旧密码");
			}
			if (MD5.verify(user.getPassword(),orgUser.getPassword())){
				String encodNew = MD5.md5(newPsw);
				user.setPassword(encodNew);
			}
		}
		String time = CommonUtil.getNowTimeStamp();
		int nowTime = Integer.valueOf(time).intValue();
		user.setUpdateTime(nowTime);
		user.setCreateTime(orgUser.getCreateTime());
		user.setFlag("1");
		this.userMapper.updateByPrimaryKeySelective(user);
		return user.getUuid();
	}
	
}
