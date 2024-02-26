package com.pepej.omegapvp

import cpw.mods.fml.relauncher.IFMLLoadingPlugin
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.MixinEnvironment
import org.spongepowered.asm.mixin.Mixins

class MixinLoader : IFMLLoadingPlugin {

    init {
        println("Initing")
        MixinBootstrap.init()
        Mixins.addConfiguration("mixins.omegapvp.json")
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);

    }

    override fun getLibraryRequestClass(): Array<String> {
        return arrayOf()

    }

    override fun getASMTransformerClass(): Array<String> {
        return arrayOf()
    }


    override fun getModContainerClass(): String? {
        return null
    }

    override fun getSetupClass(): String? {
        return null
    }

    override fun injectData(data: MutableMap<String, Any>) {
    }

}