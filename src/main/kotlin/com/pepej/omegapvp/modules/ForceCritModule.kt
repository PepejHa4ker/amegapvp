package com.pepej.omegapvp.modules

import com.pepej.omegapvp.EventedModuleBase
import com.pepej.omegapvp.utils.withPlayerAndWorld
import net.minecraft.client.settings.KeyBinding
import net.minecraft.potion.Potion
import net.minecraftforge.event.ForgeSubscribe
import net.minecraftforge.event.entity.player.AttackEntityEvent

object ForceCritModule : EventedModuleBase<AttackEntityEvent>() {
    override fun keyBind(): KeyBinding {
        return KeyBinding("Crit", 90)
    }

    @ForgeSubscribe
    override fun onEvent(event: AttackEntityEvent) = withPlayerAndWorld { localPlayer, _ ->

        val player = event.entityPlayer

        if (player != localPlayer) {
            return@withPlayerAndWorld
        }
        if (player.onGround) {
            player.getActivePotionEffect(Potion.blindness)?.let {
                player.removePotionEffectClient(it.potionID)
            }
            player.addVelocity(0.0, 0.0625, 0.0)
            player.addVelocity(0.0, 0.0625013579, 0.0)
            player.addVelocity(0.0, 0.0000013579, 0.0)
            player.fallDistance = 0.1f
            player.onGround = false
        }
    }
}