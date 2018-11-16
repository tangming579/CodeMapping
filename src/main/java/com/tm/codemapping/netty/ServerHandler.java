package com.tm.codemapping.netty;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
* @author tangming
* @version 创建时间：2018年11月14日 下午7:56:02
* 类说明
*/
@Component
@Qualifier("serverHandler")
public class ServerHandler extends SimpleChannelInboundHandler<String> {

	@Override
    public void messageReceived(ChannelHandlerContext ctx, String msg)
            throws Exception {
        
		System.out.printf("Netty client msg:"+msg);
		
        if(msg.indexOf("bye")!=-1){
            //close
            ctx.channel().close();
        }else{
            //send to client
            ctx.channel().writeAndFlush("Yoru msg is:"+msg);
        }
    }
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.printf("Netty RamoteAddress : " + ctx.channel().remoteAddress() + " active !");

        ctx.channel().writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");

        super.channelActive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	System.out.printf("Netty ExceptionCaugth : " + cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    	System.out.printf("Netty Channel is disconnected");
        super.channelInactive(ctx);
    }
}
