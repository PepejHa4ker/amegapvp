package com.pepej.omegapvp.mixins;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin {

    @Shadow(remap = false)
    protected boolean sleeping;


}
