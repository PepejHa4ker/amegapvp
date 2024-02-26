package com.pepej.omegapvp.modules

import com.pepej.omegapvp.ModuleBase
import net.minecraft.client.settings.KeyBinding
import net.minecraft.entity.player.EntityPlayer

object AlwaysSprintModule : ModuleBase() {

    override fun keyBind(): KeyBinding {
        return KeyBinding("Бег", 90)

    }

    override fun onTick(player: EntityPlayer) {
        println(player.inventory.getCurrentItem())
        player.isSprinting = true
    }
}