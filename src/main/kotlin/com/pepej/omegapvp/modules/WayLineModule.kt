package com.pepej.omegapvp.modules

import com.pepej.omegapvp.EventedModuleBase
import com.pepej.omegapvp.GENERIC_KEYBIND
import com.pepej.omegapvp.utils.drawWayLine
import net.minecraft.client.renderer.entity.RenderManager
import net.minecraft.client.settings.KeyBinding
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.client.event.RenderWorldLastEvent

object WayLineModule : EventedModuleBase<RenderWorldLastEvent>() {

    private val poses = mutableSetOf<DoubleArray>()

    override fun keyBind(): KeyBinding {
        return GENERIC_KEYBIND
    }

    override fun onTick(player: EntityPlayer) {
        if (!player.isDead && !player.isPlayerSleeping ) {
            poses.add(
                doubleArrayOf(RenderManager.renderPosX, RenderManager.renderPosY - player.height, RenderManager.renderPosZ)
            )
        }
    }

    override fun onEvent(event: RenderWorldLastEvent) {
        drawWayLine(poses, 0F, 255F, 255F, 255F, 3F)
    }
}