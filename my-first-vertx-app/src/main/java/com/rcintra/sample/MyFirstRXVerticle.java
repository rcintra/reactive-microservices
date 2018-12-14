package com.rcintra.sample;

import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.http.HttpServer;

public class MyFirstRXVerticle extends AbstractVerticle {

	public void start() {
		HttpServer server = vertx.createHttpServer();
		server.requestStream().toObservable()
			.subscribe(req ->
				req.response().end("Hello from "
						+ Thread.currentThread().getName())
			);
		
		server
			.rxListen(8080)
			.subscribe();
	}
	
}
