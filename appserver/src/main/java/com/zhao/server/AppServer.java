package com.zhao.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zhao.util.PropertiesHelp;

@Component("appServer")
public class AppServer implements IServer {
	private static int port = PropertiesHelp.getInstance().getPort();
	@Autowired
	@Qualifier("appChannelPipelineFactory")
	private AppChannelPipelineFactory channelFactory;
	private Channel channel;

	public void start() {
		// TODO Auto-generated method stub
		ServerBootstrap bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		bootstrap.setPipelineFactory(this.channelFactory);
		channel = bootstrap.bind(new InetSocketAddress(port));
	}

	public void restart() {
		// TODO Auto-generated method stub
		this.stop();
		this.start();
	}

	public void stop() {
		// TODO Auto-generated method stub
		if (channel != null) {
			this.channel.close().addListener(ChannelFutureListener.CLOSE);
		}
	}

	public AppChannelPipelineFactory getChannelFactory() {
		return channelFactory;
	}

	public void setChannelFactory(AppChannelPipelineFactory channelFactory) {
		this.channelFactory = channelFactory;
	}

	// private static void start() {
	// ServerBootstrap bootstrap = new ServerBootstrap(
	// new NioServerSocketChannelFactory(
	// Executors.newCachedThreadPool(),
	// Executors.newCachedThreadPool()));
	// bootstrap.setPipelineFactory(new AppChannelPipelineFactory());
	// bootstrap.bind(new InetSocketAddress(port));
	// }
	//
	// public static void main(String[] args) {
	// AppServer.start();
	// }
}
