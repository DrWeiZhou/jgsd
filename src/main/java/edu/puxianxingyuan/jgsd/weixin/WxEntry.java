package edu.puxianxingyuan.jgsd.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.puxianxingyuan.jgsd.weixin.tools.WxAdvancedUtil;

@Controller
@Scope("prototype")
public class WxEntry {

	@RequestMapping({ "/wx.htm" })
	void getUserInfo(HttpServletRequest req, HttpServletResponse res) {
		try {
//			System.out.println("getUserInfo is invoked!");
			String codeURL = WxAdvancedUtil.getWxCodeRequestURL(WxUtils.APPID, "http://u16801p829.51mypc.cn/bluemall/wxuser.htm", "snsapi_userinfo");
			//System.out.println("codeURL:"+codeURL);
			 
//			System.out.println("beginning redirect!");
			res.sendRedirect(codeURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
