package com.poliukou.grpc;

import com.poliukou.grpc.PingPongProto.PingRequest;
import com.poliukou.grpc.PingPongProto.PongResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PingPongClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    PingPongServiceGrpc.PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);

    PingRequest request = PingRequest.newBuilder()
        .setMessage("Ping")
        .build();

    PongResponse response = stub.sendPing(request);

    System.out.println("Received response: " + response.getMessage());

    channel.shutdown();
  }
}
