package com.zhao.server;

import static org.jboss.netty.handler.codec.http.HttpHeaders.is100ContinueExpected;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.jboss.netty.util.CharsetUtil;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zhao.factory.AppFactory;
import com.zhao.model.RequestModel;

@Component("appHandler")
public class AppHandler extends SimpleChannelUpstreamHandler {
	private HttpRequest request;
	private boolean readingChunks;
	private final StringBuilder buf = new StringBuilder();

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		e.getCause().printStackTrace();
		e.getChannel().close();
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		buf.delete(0, buf.length());
		if (!readingChunks) {
			HttpRequest request = this.request = (HttpRequest) e.getMessage();
			if (is100ContinueExpected(request)) {
				send100Continue(e);
			}
			QueryStringDecoder queryStringDecoder = new QueryStringDecoder(
					request.getUri(), CharsetUtil.UTF_8);
			Map<String, List<String>> params = queryStringDecoder
					.getParameters();
			String requestUrl = "";
			if (!params.isEmpty()) {
				for (Entry<String, List<String>> p : params.entrySet()) {
					List<String> vals = p.getValue();
					requestUrl = vals.get(0);
				}
			}
			System.out.println("nnnnnnnnnnnnn+" + requestUrl);
			if (requestUrl != "") {
				RequestModel model = JSON.parseObject(requestUrl,
						RequestModel.class);
				AppFactory factory = new AppFactory(model);
				buf.append(factory.getMessage());
				if (request.isChunked()) {
					readingChunks = true;
				} else {
					ChannelBuffer content = request.getContent();
					if (content.readable()) {
						buf.append("CONTENT: "
								+ content.toString(CharsetUtil.UTF_8) + "\r\n");
					}
					writeResponse(e);
				}
			} else {
				writeResponse(e);
			}
		}
	}

	private void writeResponse(MessageEvent e) {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
		response.setContent(ChannelBuffers.copiedBuffer(buf.toString(),
				CharsetUtil.UTF_8));
		response.setHeader(CONTENT_TYPE, "text/plain; charset=UTF-8");
		ChannelFuture future = e.getChannel().write(response);
		future.addListener(ChannelFutureListener.CLOSE);
	}

	private static void send100Continue(MessageEvent e) {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, CONTINUE);
		e.getChannel().write(response);
	}

}
