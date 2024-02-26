package com.pepej.omegapvp.utils

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityClientPlayerMP
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.Event

fun withPlayerAndWorld(block: (EntityClientPlayerMP, World) -> Unit) {
    val player = Minecraft.getMinecraft().thePlayer ?: return
    val world = Minecraft.getMinecraft().theWorld ?: return
    block(player, world)
}

fun Event.post() {
    MinecraftForge.EVENT_BUS.post(this)
}