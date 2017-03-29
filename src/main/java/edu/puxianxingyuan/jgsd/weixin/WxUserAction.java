package edu.puxianxingyuan.jgsd.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.puxianxingyuan.jgsd.weixin.tools.WxAdvancedUtil;
import edu.puxianxingyuan.jgsd.weixin.tools.WxCommonUtil;
import edu.puxianxingyuan.jgsd.weixin.tools.bean.WxOauth2Token;

@Controller
public class WxUserAction {

	@RequestMapping({ "/wxuser.htm" })
	public String getWxUserInfo(HttpServletRequest req,
			HttpServletResponse res, String code) {
		try {
//			System.out.println("weUserGetUserInfo is invoked!");
			if (code != null) {
				// System.out.println("I have got code!:" + code);

				WxOauth2Token wat = WxAdvancedUtil.getOauth2AccessToken(
						WxUtils.APPID, WxUtils.APPSECRET, code);
				if (wat != null) {
					// System.out.println("I have got token!:" +
					// wat.getAccessToken());

					String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
					requestUrl = requestUrl.replace("ACCESS_TOKEN",
							wat.getAccessToken()).replace("OPENID",
							wat.getOpenId());
					// 通过网页授权获取用户信息
					JSONObject jsonObject = WxCommonUtil.httpsRequest(
							requestUrl, "GET", null);
					if (jsonObject != null) {
						String username = "";
						String openid = "";
						try {
							username = jsonObject.getString("nickname");
							openid = jsonObject.getString("openid");
//							System.out.println("I have got userInfo!:"
//									+ username);
//							System.out.println("I got openid:" + openid);
						} catch (Exception e) {System.out.println(e);
						}
						return "forward:/register_finish_wx.htm?username="
								+ username + "&openid=" + openid;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 未成功获得微信用户信息
		return "forward:404.htm";
	}

	String list(String signature, String timestamp, String nonce, String echostr) {
		return echostr;
	}
}
