package com.pepej.omegapvp

import com.pepej.omegapvp.modules.*
import com.pepej.omegapvp.utils.withPlayerAndWorld
import cpw.mods.fml.client.registry.KeyBindingRegistry
import cpw.mods.fml.common.ITickHandler
import cpw.mods.fml.common.TickType
import net.minecraft.client.settings.KeyBinding
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.Event
import net.minecraftforge.event.ForgeSubscribe
import java.util.*
import java.util.concurrent.CopyOnWriteArraySet

val modules = CopyOnWriteArraySet<Module>()

fun modules() = modules

val GENERIC_KEYBIND = KeyBinding("PVP", 90)

fun enabledModules() = modules.filter { it.enabled() }

interface Module {

    fun enabled(): Boolean

    fun onlyOnBind(): Boolean

    fun enable()

    fun disable()

    fun onEnable()

    fun onDisable()

    fun onTick(player: EntityPlayer);

    fun keyBind(): KeyBinding

}

interface EventedModule<E : Event> : Module {

    @ForgeSubscribe
    fun onEvent(event: E)
}

abstract class ModuleBase : Module {

    private var enabled: Boolean = false

    override fun enabled(): Boolean = enabled

    override fun enable() {
        enabled = true
    }

    override fun disable() {
        enabled = false
    }

    override fun onlyOnBind(): Boolean = true

    override fun onDisable() {}

    override fun onEnable() {}

    override fun onTick(player: EntityPlayer) {}
}

abstract class EventedModuleBase<T : Event> : ModuleBase(), EventedModule<T>

object ModuleTickHandler : ITickHandler {
    override fun tickStart(enumSet: EnumSet<TickType>, vararg objects: Any) {
    }

    override fun tickEnd(enumSet: EnumSet<TickType>, vararg objects: Any) {
        withPlayerAndWorld { player, _ ->

            modules.filter(Module::enabled)
                .forEach { it.onTick(player) }

        }
    }


    override fun ticks(): EnumSet<TickType> {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER, TickType.WORLD)
    }

    override fun getLabel(): String {
        return "OmegaPVP tick handler"
    }
}

class ModuleKeyHandler(keyBindings: Array<KeyBinding>, repeatings: BooleanArray) :
    KeyBindingRegistry.KeyHandler(keyBindings, repeatings) {
    override fun keyDown(
        enumSet: EnumSet<TickType>,
        keyBinding: KeyBinding,
        b: Boolean,
        b1: Boolean
    ) {
        modules().filter { it.keyBind().keyDescription == keyBinding.keyDescription }
            .forEach {
                if (!it.enabled()) {
                    it.enable()
                    it.onEnable()
                }
            }

    }

    override fun keyUp(enumSet: EnumSet<TickType>, keyBinding: KeyBinding, b: Boolean) {
        modules()
            .filter { it.keyBind().keyDescription == keyBinding.keyDescription }
            .filter { it.enabled() }
            .filter { it.onlyOnBind() }
            .forEach {
                it.disable()
                it.onDisable()
            }
    }

    override fun ticks(): EnumSet<TickType> {
        return EnumSet.of(TickType.CLIENT, TickType.WORLD)
    }

    override fun getLabel(): String {
        return "PVP"
    }
}

fun registerModule(module: Module) {
    modules.add(module)
    when (module) {
        is EventedModule<*> -> MinecraftForge.EVENT_BUS.register(module)

    }
}

fun init() {
    registerModule(AlwaysSprintModule)
    registerModule(ForceCritModule)
    registerModule(MassivenceHealModule)
    registerModule(ChatBindModule)
    registerModule(WayLineModule)

}



