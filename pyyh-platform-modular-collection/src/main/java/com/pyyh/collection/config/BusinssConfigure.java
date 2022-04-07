package com.pyyh.collection.config;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import io.netty.channel.ChannelInboundHandlerAdapter;

@Configuration
public class BusinssConfigure {
	// -----------------业务数据处理------------------------
	// -----------------tcpServer------------------------
	@Value("#{'${business.tcpServer.allKeys}'.split(',')}")
	private String[] allKey;
	private static String[] _allKey;
	@Value("${business.tcpServer.usedKey}")
	private String usedKey;
	private static String _usedKey;
	// -----------------udp------------------------
	@Value("#{'${business.udp.allKeys}'.split(',')}")
	private String[] UdpAllKey;
	private static String[] _udpAllKey;
	@Value("${business.udp.usedKey}")
	private String UdpUsedKey;
	private static String _UdpUsedKey;
	// -----------------http------------------------
	@Value("#{'${business.http.allKeys}'.split(',')}")
	private String[] httpAllKey;
	@Value("${business.http.usedKey}")
	private String httpUsedKey;
	private static String[] _httpAllKey;
	private static String _httpUsedKey;
	
	@Bean(name = "initializers")
	public HashMap<String, ? extends ChannelInboundHandlerAdapter> initializers(){
		HashMap<String, ChannelInboundHandlerAdapter> initializers = new HashMap<>();
		//-----------------tcpServer------------------------
		{

		}
		//-----------------udp------------------------
		{

		}
		//-----------------http------------------------
		{

		}
		
		BusinssConfigure.set_allKey(_allKey);
		BusinssConfigure.set_udpAllKey(UdpAllKey);
		BusinssConfigure.set_httpAllKey(httpAllKey);
		BusinssConfigure.set_usedKey(usedKey);
		BusinssConfigure.set_UdpUsedKey(UdpUsedKey);
		BusinssConfigure.set_httpUsedKey(httpUsedKey);
		return initializers;
	}

	public String[] getAllKey() {
		return allKey;
	}

	public void setAllKey(String[] allKey) {
		this.allKey = allKey;
	}

	public String getUsedKey() {
		return usedKey;
	}

	public void setUsedKey(String usedKey) {
		this.usedKey = usedKey;
	}

	public static String get_usedKey() {
		return _usedKey;
	}

	public static void set_usedKey(String _usedKey) {
		BusinssConfigure._usedKey = _usedKey;
	}

	public String[] getUdpAllKey() {
		return UdpAllKey;
	}

	public void setUdpAllKey(String[] udpAllKey) {
		UdpAllKey = udpAllKey;
	}

	public String getUdpUsedKey() {
		return UdpUsedKey;
	}

	public void setUdpUsedKey(String udpUsedKey) {
		UdpUsedKey = udpUsedKey;
	}

	public static String get_UdpUsedKey() {
		return _UdpUsedKey;
	}

	public static void set_UdpUsedKey(String _UdpUsedKey) {
		BusinssConfigure._UdpUsedKey = _UdpUsedKey;
	}

	public String[] getHttpAllKey() {
		return httpAllKey;
	}

	public void setHttpAllKey(String[] httpAllKey) {
		this.httpAllKey = httpAllKey;
	}

	public String getHttpUsedKey() {
		return httpUsedKey;
	}

	public void setHttpUsedKey(String httpUsedKey) {
		this.httpUsedKey = httpUsedKey;
	}

	public static String get_httpUsedKey() {
		return _httpUsedKey;
	}

	public static String[] get_httpAllKey() {
		return _httpAllKey;
	}

	public static void set_httpAllKey(String[] _httpAllKey) {
		BusinssConfigure._httpAllKey = _httpAllKey;
	}

	public static void set_httpUsedKey(String _httpUsedKey) {
		BusinssConfigure._httpUsedKey = _httpUsedKey;
	}

	public static String[] get_allKey() {
		return _allKey;
	}

	public static void set_allKey(String[] _allKey) {
		BusinssConfigure._allKey = _allKey;
	}

	public static String[] get_udpAllKey() {
		return _udpAllKey;
	}

	public static void set_udpAllKey(String[] _udpAllKey) {
		BusinssConfigure._udpAllKey = _udpAllKey;
	}
	 
}
