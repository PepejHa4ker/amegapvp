package com.pepej.omegapvp.modules

import com.pepej.omegapvp.ModuleBase
import com.pepej.omegapvp.utils.withPlayerAndWorld
import net.minecraft.client.settings.KeyBinding

object ChatBindModule : ModuleBase() {

    private val commands = mutableSetOf("/feed")


    override fun keyBind(): KeyBinding {
        return KeyBinding("Чат", 90)
    }

    override fun onDisable() {
        withPlayerAndWorld { player, _ ->
            commands.forEach(player::sendChatMessage)
        }
    }
}