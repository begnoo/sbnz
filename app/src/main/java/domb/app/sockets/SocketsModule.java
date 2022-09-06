package domb.app.sockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

@Component
public class SocketsModule {

  private final SocketIOServer server;
  private final SocketIONamespace namespace;

  @Autowired
  public SocketsModule(SocketIOServer server) {
    this.server = server;
    this.namespace = server.addNamespace("/events");
    this.namespace.addConnectListener(onConnected());
    this.namespace.addDisconnectListener(onDisconnected());

  }

  private ConnectListener onConnected() {
    return client -> {
      HandshakeData handshakeData = client.getHandshakeData();
      System.out.format("Client[%s] - Connected to sockets module through '%s'", client.getSessionId().toString(),
          handshakeData.getUrl());
    };
  }

  private DisconnectListener onDisconnected() {
    return client -> System.out.format("Client[%s] - Disconnected from sockets module.", client.getSessionId().toString());
  }

  public void brodcast(Notification notification) {
    namespace.getBroadcastOperations().sendEvent("event", notification);
  }

}
