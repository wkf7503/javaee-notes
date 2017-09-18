package io.github.zp1024.javaee.jsp.util;

import io.github.zp1024.javaee.jsp.util.ip.IPSeeker;

public class IpUtil {

	public static String getIpAddress(String ip) {
		try{
			return IPSeeker.getInstance().getAddress(ip);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "δ֪����";
	}

}
