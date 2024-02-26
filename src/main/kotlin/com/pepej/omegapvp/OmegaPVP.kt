import com.pepej.omegapvp.ModuleKeyHandler
import com.pepej.omegapvp.ModuleTickHandler
import com.pepej.omegapvp.init
import com.pepej.omegapvp.modules
import cpw.mods.fml.client.registry.KeyBindingRegistry
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.PostInit
import cpw.mods.fml.common.Mod.PreInit
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.TickRegistry
import cpw.mods.fml.relauncher.Side

@Mod(modid = "omegapvp", name = "omegapvp", version = "1.4.7")
class OmegaPVP {

    @Mod.Instance
    lateinit var instance: OmegaPVP

    @PreInit
    fun preInit(event: FMLPreInitializationEvent) {
    }

    @PostInit
    fun postInit(event: FMLPostInitializationEvent) {
        init()
        TickRegistry.registerTickHandler(ModuleTickHandler, Side.CLIENT)
        KeyBindingRegistry.registerKeyBinding(ModuleKeyHandler(modules().map { it.keyBind() }.toTypedArray(), modules().map { false }.toBooleanArray()))
    }



}


