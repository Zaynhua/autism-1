package com.zl.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="wx_user_token")
public class WxUserToken {

	@Id
	@Column(name="uuid")
	private String uuid;
	
	@Column(name="access_token")
	private String accessToken;
	
	@Column(name="expire_in")
	private String expireIn;
	
	@Column(name="refresh_token")
	private String refreshToken;
	
	@Column(name="open_id")
	private String openId;
	
	@Column(name="scope")
	private String scope;
	
	@Column(name="create_time")
	private int createTime;
	
	@Column(name="update_time")
	private int updateTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(String expireIn) {
		this.expireIn = expireIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
