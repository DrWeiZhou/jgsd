package edu.puxianxingyuan.jgsd.weixin;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.jeewx.api.mp.aes.WXBizMsgCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WxVerifyUrl {

	@RequestMapping({ "/verifyURL" })
	void getUserInfo(String signature, String timestamp, String nonce, String echostr, HttpServletResponse res) {
		try {
			String token = "goodluck";
			
			System.out.println("verifyURL is invoked!");
			System.out.println("signature:"+signature);
			System.out.println("timestamp:"+timestamp);
			System.out.println("nonce:"+nonce);
			
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt("goodluck",
					"mSNUY7qtKcVFivBuuputZTPWLxCCk2jZ0epcjAvFd94", "wx944bc6ad0adfae1f");
			System.out.println("wxcpt is ok!");
			
			String[] array = new String[] { token, timestamp, nonce };
			StringBuffer sb = new StringBuffer();
			// 字符串排序
			Arrays.sort(array);
			for (int i = 0; i < 3; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			String shaStr =  hexstr.toString();
			System.out.println("shaStr:"+shaStr);
			System.out.println("echostr:"+echostr);
			
			//wxcpt.verifyUrl(signature, timestamp, nonce, echostr);
			if(signature.equals(shaStr))
				res.getWriter().print(echostr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String list(String signature, String timestamp, String nonce, String echostr) {
		return echostr;
	}
}
