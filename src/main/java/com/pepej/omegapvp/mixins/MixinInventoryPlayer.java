package com.pepej.omegapvp.mixins;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = InventoryPlayer.class, remap = false)
public class MixinInventoryPlayer {

    @Shadow(remap = false)
    public EntityPlayer player;
    @Shadow(remap = false)
    public int currentItem;


    /**
     *
     */
    @Overwrite()
    public ItemStack getCurrentItem() {
        System.out.println("getCurrentItem");
        return new ItemStack(Item.bed);
    }


}
