package com.tm.codemapping.netty;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
* @author tangming
* @version 创建时间：2018年11月14日 下午8:08:55
* 类说明
*/
@Component
@Qualifier("serverChannelInitializer")
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	private final static int READER_IDLE_TIME_SECONDS = 20;//读操作空闲20秒
	private final static int WRITER_IDLE_TIME_SECONDS = 20;//写操作空闲20秒
	private final static int ALL_IDLE_TIME_SECONDS = 40;//读写全部空闲40秒
	
    
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
    	ChannelPipeline p = socketChannel.pipeline();
    	
    	p.addLast("idleStateHandler", new IdleStateHandler(READER_IDLE_TIME_SECONDS
    			, WRITER_IDLE_TIME_SECONDS, ALL_IDLE_TIME_SECONDS, TimeUnit.SECONDS));	 
    }
}
