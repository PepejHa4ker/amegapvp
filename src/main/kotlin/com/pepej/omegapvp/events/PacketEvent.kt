package com.pepej.omegapvp.events

import net.minecraft.network.packet.Packet
import net.minecraftforge.event.Cancelable
import net.minecraftforge.event.Event

@Cancelable
class PacketEvent(val packet: Packet, val origin: TransferOrigin) : Event()

enum class TransferOrigin {
    SEND, RECEIVE
}