package com.poliukou.grpc;

import com.poliukou.grpc.PingPongProto.PingRequest;
import com.poliukou.grpc.PingPongProto.PongResponse;
import com.poliukou.grpc.PingPongServiceGrpc.PingPongServiceImplBase;
import io.grpc.stub.StreamObserver;

public class PingPongServiceImpl extends PingPongServiceImplBase {

  @Override
  public void sendPing(PingRequest request, StreamObserver<PongResponse> responseObserver) {
    String clientMessage = request.getMessage();
    System.out.println("Received request: " + clientMessage);

    PongResponse response = PongResponse.newBuilder()
        .setMessage("Pong")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
