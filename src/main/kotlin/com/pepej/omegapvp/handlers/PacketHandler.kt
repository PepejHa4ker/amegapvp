package com.pepej.omegapvp.handlers

import com.pepej.omegapvp.utils.str
import net.minecraft.client.multiplayer.NetClientHandler
import net.minecraft.network.NetworkManager

object PacketHandler {

    private var inited: Boolean = false

    fun init(clientHandler: NetClientHandler) {
        if (clientHandler.netManager !is NetworkManager) {
            return
        }
        if (inited) {
            return
        }
        (clientHandler.netManager as NetworkManager).channel().pipeline().addBefore("manager", str(), ChannelPacketHandler()) // not packet_handler legacy piece of shit :(
        inited = true
    }
}
