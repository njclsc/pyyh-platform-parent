package com.pyyh.collection.pojo;

import java.util.HashMap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public class SocketCommunicationPojo {
	private String type;
	private String key;
	//本地通信端口缓存
	private HashMap<String, ChannelFuture> localChannelFutures = new HashMap<String, ChannelFuture>();
	//远端通信端口缓存
	private HashMap<String, HashMap<String, Channel>> remoteChannelFutures = new HashMap<String, HashMap<String, Channel>>();
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public HashMap<String, ChannelFuture> getLocalChannelFutures() {
		return localChannelFutures;
	}
	public void setLocalChannelFutures(HashMap<String, ChannelFuture> localChannelFutures) {
		this.localChannelFutures = localChannelFutures;
	}
	public HashMap<String, HashMap<String, Channel>> getRemoteChannelFutures() {
		return remoteChannelFutures;
	}
	public void setRemoteChannelFutures(HashMap<String, HashMap<String, Channel>> remoteChannelFutures) {
		this.remoteChannelFutures = remoteChannelFutures;
	}
	
}
