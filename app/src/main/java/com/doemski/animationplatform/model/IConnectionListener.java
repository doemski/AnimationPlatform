package com.doemski.animationplatform.model;

public interface IConnectionListener {
    void onConnectionLost();
    void onConnectionEstablished();
    void onDataReceived(Packet data);
}