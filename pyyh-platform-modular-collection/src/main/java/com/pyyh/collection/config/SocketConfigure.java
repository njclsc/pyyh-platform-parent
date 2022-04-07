package com.pyyh.collection.config;

import java.net.InetSocketAddress;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pyyh.collection.pojo.SocketCommunicationPojo;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Configuration
public class SocketConfigure {
	//---------------tcpserver---------------
		@Value("${communication.tcp.server.used}")
		private boolean tcpServer;
		private static boolean _tcpServer;
		@Value("${communication.tcp.server.tcpServerBacklog}")
		private int tcpServerBacklog;
		@Value("${communication.tcp.server.tcpBufMin}")
		private int tcpBufMin;
		@Value("${communication.tcp.server.tcpBufInit}")
		private int tcpBufInit;
		@Value("${communication.tcp.server.tcpBufMax}")
		private int tcpBufMax;
		@Value("#{'${communication.tcp.server.serverAddress}'.split(',')}")
		private String[] serverAddress;
		//tcp指令接受端口
		private static String tcpReciveCmdAddr;
		//---------------udp---------------
		@Value("${communication.udp.used}")
		private boolean udp;
		private static boolean _udp;
		@Value("${communication.udp.udpBufMin}")
		private int udpBufMin;
		@Value("${communication.udp.udpBufInit}")
		private int udpBufInit;
		@Value("${communication.udp.udpBufMax}")
		private int udpBufMax;
		@Value("#{'${communication.udp.udpAddress}'.split(',')}")
		private String[] udpAddress;
		//---------------http---------------
		@Value("${communication.http.used}")
		private boolean http;
		private static boolean _http;
		@Value("${communication.http.httpBufMin}")
		private int httpBufMin;
		@Value("${communication.http.httpBufInit}")
		private int httpBufInit;
		@Value("${communication.http.httpBufMax}")
		private int httpBufMax;
		@Value("#{'${communication.http.httpAddress}'.split(',')}")
		private String[] httpAddress;
		//----------------------------------
		private static SocketCommunicationPojo tcpService;
		@Autowired
		@Qualifier("initializers")
		private HashMap<String, ? extends ChannelInboundHandlerAdapter> initializers;
		
		@Bean(name = "tcpServer")
		public SocketCommunicationPojo initLocalTcpServer(){
			SocketCommunicationPojo cp = null;
			if(tcpServer){
				cp = new SocketCommunicationPojo();
				cp.setType("tcpServer");
				EventLoopGroup boss = new NioEventLoopGroup();
				EventLoopGroup work = new NioEventLoopGroup();
				ServerBootstrap bootstrap = new ServerBootstrap();
				bootstrap.group(boss, work).channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, tcpServerBacklog)
					.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(tcpBufMin, tcpBufInit, tcpBufMax))
					.childHandler(initializers.get(BusinssConfigure.get_usedKey()));
				for(String s : serverAddress){
					try{
						String[] address = s.split(":");
						String ip = address[0].trim();
						int port = Integer.parseInt(address[1].trim());
						ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(ip, port));
						cp.setKey(ip + ":" + port);
						cp.getLocalChannelFutures().put(ip + ":" + port, channelFuture);
						cp.getRemoteChannelFutures().put(ip + ":" + port, new HashMap<String, Channel>());
						SocketConfigure.setTcpReciveCmdAddr(s);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				SocketConfigure.set_tcpServer(tcpServer);
			}
			SocketConfigure.setTcpService(cp);
			return cp;
		}
		@Bean(name = "udp")
		public SocketCommunicationPojo initLocalUdpServer(){
			System.out.println("*********");
			SocketCommunicationPojo cp = null;
			if(udp){
				cp = new SocketCommunicationPojo();
				cp.setType("udp");
				EventLoopGroup work = new NioEventLoopGroup();
				Bootstrap bootstrap = new Bootstrap();
				bootstrap.group(work).channel(NioDatagramChannel.class)
					.option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(udpBufMin, udpBufInit, udpBufMax))
					.handler(initializers.get(BusinssConfigure.get_UdpUsedKey()));
				for(String s : udpAddress){
					try{
						String[] address = s.split(":");
						String ip = address[0].trim();
						int port = Integer.parseInt(address[1].trim());
						ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(ip, port));
						cp.setKey(ip + ":" + port);
						cp.getLocalChannelFutures().put(ip + ":" + port, channelFuture);
						cp.getRemoteChannelFutures().put(ip + ":" + port, new HashMap<String, Channel>());
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				SocketConfigure.set_udp(udp);
			}
			return cp;
		}
		@Bean(name = "http")
		public SocketCommunicationPojo initLocalHttpServer(){
			SocketCommunicationPojo cp = null;
			if(http){
				cp = new SocketCommunicationPojo();
				cp.setType("http");
				EventLoopGroup boss = new NioEventLoopGroup();
				EventLoopGroup work = new NioEventLoopGroup();
				ServerBootstrap bootstrap = new ServerBootstrap();
				bootstrap.group(boss, work).channel(NioServerSocketChannel.class)
					.option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(httpBufMin, httpBufInit, httpBufMax))
					.childHandler(initializers.get(BusinssConfigure.get_httpUsedKey()));
				for(String s : httpAddress){
					try{
						String[] address = s.split(":");
						String ip = address[0].trim();
						int port = Integer.parseInt(address[1].trim());
						ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(ip, port));
						cp.setKey(ip + ":" + port);
						cp.getLocalChannelFutures().put(ip + ":" + port, channelFuture);
						cp.getRemoteChannelFutures().put(ip + ":" + port, new HashMap<String, Channel>());
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				SocketConfigure.set_http(http);
			}
			return cp;
		}
		public static SocketCommunicationPojo getTcpService() {
			return tcpService;
		}
		public static void setTcpService(SocketCommunicationPojo tcpService) {
			SocketConfigure.tcpService = tcpService;
		}
		public static String getTcpReciveCmdAddr() {
			return tcpReciveCmdAddr;
		}
		public static void setTcpReciveCmdAddr(String tcpReciveCmdAddr) {
			SocketConfigure.tcpReciveCmdAddr = tcpReciveCmdAddr;
		}
		public boolean isTcpServer() {
			return tcpServer;
		}
		public void setTcpServer(boolean tcpServer) {
			this.tcpServer = tcpServer;
		}
		public boolean isUdp() {
			return udp;
		}
		public void setUdp(boolean udp) {
			this.udp = udp;
		}
		public boolean isHttp() {
			return http;
		}
		public void setHttp(boolean http) {
			this.http = http;
		}
		public static boolean is_tcpServer() {
			return _tcpServer;
		}
		public static void set_tcpServer(boolean _tcpServer) {
			SocketConfigure._tcpServer = _tcpServer;
		}
		public static boolean is_udp() {
			return _udp;
		}
		public static void set_udp(boolean _udp) {
			SocketConfigure._udp = _udp;
		}
		public static boolean is_http() {
			return _http;
		}
		public static void set_http(boolean _http) {
			SocketConfigure._http = _http;
		}
}
