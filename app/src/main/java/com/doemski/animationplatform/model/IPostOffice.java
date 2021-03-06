package com.doemski.animationplatform.model;

public interface IPostOffice extends IConnectionListener {
    void send(Packet packet);
    void register(IPacketReceiver receiver);
    void unregister(IPacketReceiver receiver);
    void receive(Packet packet);
}
