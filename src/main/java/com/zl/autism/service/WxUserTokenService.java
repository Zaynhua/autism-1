package com.zl.autism.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zl.autism.mapper.WxUserTokenMapper;
import com.zl.autism.model.WxUserToken;
import com.zl.autism.utils.AuthUtil;
import com.zl.autism.utils.RandomUtils;

@Service
public class WxUserTokenService{

	@Autowired
	private WxUserTokenMapper wxUserTokenMapper;
	
	public WxUserToken getWxUserToken(HttpServletRequest request, HttpServletResponse response, String code) {
		String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+AuthUtil.APPID+"&secret="+AuthUtil.APPSCERET;
		JSONObject json=AuthUtil.doGetJson(accessTokenUrl);
		WxUserToken token = new WxUserToken();
		String accessToken = json.getString("access_token");
		token.setAccessToken(accessToken);
		String expires_in = json.getString("expires_in");
		token.setExpireIn(expires_in);
		String open_id = json.getString("open_id");
		token.setOpenId(open_id);
		String refresh_token = json.getString("refresh_token");
		token.setRefreshToken(refresh_token);
		String uuid = RandomUtils.UUIDString();
		token.setUuid(uuid);
		this.wxUserTokenMapper.insertSelective(token);
		
		return token;
	}

	
}
