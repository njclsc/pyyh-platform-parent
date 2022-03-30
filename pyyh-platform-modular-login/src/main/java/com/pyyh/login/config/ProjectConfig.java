package com.pyyh.login.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.pyyh.login.business.atomizer.pojo.UserPojo;

@Configuration
public class ProjectConfig {
	private static String JWT_ALG;
	private static String JWT_TYP;
	private static String JWT_SECRET;
	private static long JWT_EXPIRES;
	private static String SERVER_TARGET;

	// flag : 1=生成token; 2=解析token; 3=其他操作
	public static String tokenOperate(int flag, Object _infoOrToken) {
		if (flag == 1) {
			Map<String, Object> h_map = new HashMap<>();
			h_map.put("alg", ProjectConfig.getJWT_ALG());
			h_map.put("typ", ProjectConfig.getJWT_TYP());
			UserPojo infoOrToken = (UserPojo) _infoOrToken;
			return JWT.create().withHeader(h_map).withClaim("userIndex", "" + infoOrToken.getId())
					.withClaim("account", infoOrToken.getAccount())
					// .withClaim("roleIndex", "" + infoOrToken.getRoleIndex())
					.withClaim("organizationCode", infoOrToken.getOrganizationCode())
					.withIssuedAt(new Date(System.currentTimeMillis()))
					.withExpiresAt(new Date(System.currentTimeMillis() + ProjectConfig.getJWT_EXPIRES()))
					.withSubject(infoOrToken.getAccount()).sign(Algorithm.HMAC256(ProjectConfig.JWT_SECRET));
		} else if (flag == 2) {
			Map<String, Claim> claims = JWT.decode((String) _infoOrToken).getClaims();
			UserPojo up = new UserPojo();
			up.setAccount(claims.get("account").asString());
			up.setId(Integer.parseInt(claims.get("userIndex").asString()));
			up.setOrganizationCode(claims.get("organizationCode").asString());
//			up.setRoleIndex(Integer.parseInt(claims.get("roleIndex").asString()));
			return JSONObject.toJSONString(up);
		} else {
			return "";
		}

	}

	@Bean
	public Object initInfo(@Value("${token.jwt.alg}") String alg, @Value("${token.jwt.typ}") String typ,
			@Value("${token.jwt.secret}") String secret, @Value("${token.jwt.expires}") long expires) {
		ProjectConfig.setJWT_ALG(alg);
		ProjectConfig.setJWT_TYP(typ);
		ProjectConfig.setJWT_SECRET(secret);
		ProjectConfig.setJWT_EXPIRES(expires);
		return null;
	}

	public static String getJWT_ALG() {
		return JWT_ALG;
	}

	public static void setJWT_ALG(String jWT_ALG) {
		JWT_ALG = jWT_ALG;
	}

	public static String getJWT_TYP() {
		return JWT_TYP;
	}

	public static void setJWT_TYP(String jWT_TYP) {
		JWT_TYP = jWT_TYP;
	}

	public static String getJWT_SECRET() {
		return JWT_SECRET;
	}

	public static void setJWT_SECRET(String jWT_SECRET) {
		JWT_SECRET = jWT_SECRET;
	}

	public static long getJWT_EXPIRES() {
		return JWT_EXPIRES;
	}

	public static void setJWT_EXPIRES(long jWT_EXPIRES) {
		JWT_EXPIRES = jWT_EXPIRES;
	}

	public static String getSERVER_TARGET() {
		return SERVER_TARGET;
	}

	public static void setSERVER_TARGET(String sERVER_TARGET) {
		SERVER_TARGET = sERVER_TARGET;
	}
}
