package com.zhao.server;

import static org.jboss.netty.channel.Channels.pipeline;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpContentCompressor;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("appChannelPipelineFactory")
public class AppChannelPipelineFactory implements ChannelPipelineFactory {
	@Autowired
	@Qualifier("appHandler")
	private AppHandler handler;

	public ChannelPipeline getPipeline() throws Exception {
		// TODO Auto-generated method stub
		// Create a default pipeline implementation.
		ChannelPipeline pipeline = pipeline();

		pipeline.addLast("decoder", new HttpRequestDecoder());
		pipeline.addLast("aggregator", new HttpChunkAggregator(1048576));
		pipeline.addLast("encoder", new HttpResponseEncoder());
		pipeline.addLast("deflater", new HttpContentCompressor());
		pipeline.addLast("handler", this.handler);
		return pipeline;
	}

	public AppHandler getHandler() {
		return handler;
	}

	public void setHandler(AppHandler handler) {
		this.handler = handler;
	}

}
