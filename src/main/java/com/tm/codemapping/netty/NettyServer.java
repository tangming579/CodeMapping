package com.tm.codemapping.netty;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger logger = LoggerFactory.getLogger(NettyServer.class);
	
	@Autowired
	@Qualifier("serverBootstrap")
	private ServerBootstrap serverBootstrap;
	
	@Autowired
	@Qualifier("tcpSocketAddress")
	private InetSocketAddress tcpPort;

	private Channel serverChannel;
	
	@PostConstruct
    public void init() {
		logger.info("Netty init."+ tcpPort.getPort());
    }

	//@PostConstruct
	public void start() throws Exception {
		serverChannel =  serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync().channel();
		
		logger.info("Netty Start");
	}
	
	//@PreDestroy
	public void stop() throws Exception {
		serverChannel.close();
		serverChannel.parent().close();
		
		logger.info("Netty Stop");
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
