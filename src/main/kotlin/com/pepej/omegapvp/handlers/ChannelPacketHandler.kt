package com.pepej.omegapvp.handlers

import com.pepej.omegapvp.events.PacketEvent
import com.pepej.omegapvp.events.TransferOrigin
import com.pepej.omegapvp.utils.post
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import net.minecraft.network.packet.Packet

class ChannelPacketHandler : ChannelDuplexHandler() {
    override fun channelRead(ctx: ChannelHandlerContext, input: Any) {
        val packet = input as Packet
        val packetEvent = PacketEvent(packet, TransferOrigin.RECEIVE)
        packetEvent.post()
        if (!packetEvent.isCanceled) {
            super.channelRead(ctx, input)
        }
    }

    override fun write(ctx: ChannelHandlerContext, output: Any, pr: ChannelPromise) {
        val packet = output as Packet
        val packetEvent = PacketEvent(packet, TransferOrigin.SEND)
        packetEvent.post()
        if (!packetEvent.isCanceled) {
            super.write(ctx, output, pr)
        }
    }
}