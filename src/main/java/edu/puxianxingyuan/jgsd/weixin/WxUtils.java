package edu.puxianxingyuan.jgsd.weixin;

import org.jeewx.api.core.exception.WexinReqException;
import org.jeewx.api.wxbase.wxtoken.JwTokenAPI;


public class WxUtils {
	static String APPID = "wx944bc6ad0adfae1f";
	static String APPSECRET = "b5577000174638265c9d62ee5f980e78";
	
	public static String getAccessToken() throws WexinReqException{
		String accessToken = JwTokenAPI.getAccessToken(APPID, APPSECRET); 
		return accessToken;
	}
	
}
