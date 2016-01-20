package com.doemski.animationplatform.model;

public interface IConnection {
    void connect(String address);
    boolean isConnected();
    void transfer(Packet data);
    void register(IConnectionListener listener);
}
