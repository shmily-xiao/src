package com.rsocket;

import io.rsocket.AbstractRSocket;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.RSocketFactory.ClientRSocketFactory;
import io.rsocket.RSocketFactory.ServerRSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

/**
 * @author wangzaijun
 * @date 2020/05/14
 */
public class RSocketTest {

    public static void main(String[] args) {
        RSocketFactory.receive().acceptor(((setup, sendingSocket) -> Mono.just(
            new AbstractRSocket() {
                @Override
                public Mono<Payload> requestResponse(Payload payload) {
                    return Mono.just(DefaultPayload.create("ECHO >> " + payload.getDataUtf8()));
                }
            }
        )))
            .transport(TcpServerTransport.create("localhost", 7000))
            .start()
            .subscribe();

        RSocket rSocket = RSocketFactory.connect()
            .transport(TcpClientTransport.create("localhost", 7000))
            .start()
            .block();

        rSocket.requestResponse(DefaultPayload.create("hello"))
            .map(Payload::getDataUtf8)
            .doOnNext(System.out::println)
            .block();

        rSocket.dispose();


    }
}
