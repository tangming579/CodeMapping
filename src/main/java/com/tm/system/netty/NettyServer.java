package com.tm.system.netty;

import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;

/**
* @author tangming
* @version 创建时间：2018年11月13日 下午7:00:59
* 类说明
*/

@Component
public class NettyServer {

	@Autowired
	@Qualifier("serverBootstrap")
	private ServerBootstrap serverBootstrap;
	
	@Autowired
	@Qualifier("tcpSocketAddress")
	private InetSocketAddress tcpPort;

	private Channel serverChannel;

	public void start() throws Exception {
		serverChannel =  serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync().channel();
	}
	
	public void stop() throws Exception {
		serverChannel.close();
		serverChannel.parent().close();
	}

	public ServerBootstrap getServerBootstrap() {
		return serverBootstrap;
	}

	public void setServerBootstrap(ServerBootstrap serverBootstrap) {
		this.serverBootstrap = serverBootstrap;
	}

	public InetSocketAddress getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(InetSocketAddress tcpPort) {
		this.tcpPort = tcpPort;
	}
}
