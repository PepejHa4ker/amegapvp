package com.pepej.omegapvp.modules

import com.pepej.omegapvp.GENERIC_KEYBIND
import com.pepej.omegapvp.ModuleBase
import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import java.util.*

typealias SearchResult = Pair<Int, ItemStack>

object MassivenceHealModule : ModuleBase() {

    override fun onTick(player: EntityPlayer) {
        if (player.health > 19) {
            return
        }

        useMassivence(player)
    }

    override fun keyBind(): KeyBinding = GENERIC_KEYBIND
    private fun useMassivence(player: EntityPlayer) {
        findMassivence(player)?.let { (slot, item) ->
            player.cooldownTracker.removeCooldown(item.item)
            val oldSlot = player.inventory.currentItem
            player.inventory.currentItem = slot
            Minecraft.getMinecraft().playerController.sendUseItem(player, player.worldObj, item)
            player.stopUsingItem()
            player.inventory.currentItem = oldSlot
        }
    }

    private fun swapMassivence(player: EntityPlayer) {
        val mainInventory = player.inventory.mainInventory
    }

    private fun findMassivence(player: EntityPlayer): SearchResult? {
        if (player.inventory.mainInventory.size < 9) {
            return null
        }
        val massivenceComparator = Comparator
            .comparing { r: SearchResult -> if (r.second.isItemEnchanted) 1 else 0 }
            .thenComparing { r -> r.second.itemDamage }
        return (0..9)
            .filter { player.inventory.getStackInSlot(it) != null }
            .map { SearchResult(it, player.inventory.getStackInSlot(it)) }
            .filter { it.second.itemName == "item.namkormira" || it.second.itemID == 5357 }
            .maxWithOrNull(massivenceComparator)
    }
}