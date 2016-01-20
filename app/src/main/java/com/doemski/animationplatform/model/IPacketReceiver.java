package com.doemski.animationplatform.model;

public interface IPacketReceiver {
   void receive(Packet packet);
   boolean accept(PacketType type);
}
