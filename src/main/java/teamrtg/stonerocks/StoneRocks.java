package teamrtg.stonerocks;

import java.util.Random;

import net.minecraftforge.common.MinecraftForge;
import teamrtg.stonerocks.config.ConfigManager;
import teamrtg.stonerocks.config.stonerocks.ConfigSR;
import teamrtg.stonerocks.event.EventManager;
import teamrtg.stonerocks.item.ItemRocks;
import teamrtg.stonerocks.proxy.CommonProxy;
import teamrtg.stonerocks.reference.ModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, acceptableRemoteVersions = "*")
public class StoneRocks {
    
    @Instance("stonerocks")
    public static StoneRocks instance;
    public static String configPath;
    public static EventManager eventMgr;
    
    @SidedProxy(serverSide = ModInfo.PROXY_COMMON, clientSide = ModInfo.PROXY_CLIENT)
    public static CommonProxy proxy;

    private ConfigManager configManager = new ConfigManager();

    public ConfigManager configManager(int dimension) {
        return configManager;
    }

    @EventHandler
    public void fmlLifeCycleEvent(FMLPreInitializationEvent event) 
    {    
        instance = this;
        Random rand = new Random();
        
        configPath = event.getModConfigurationDirectory() + "/";
        ConfigManager.init(configPath);
        
        ItemRocks.init();

        if (ConfigSR.modEnabled) {
        	
        	eventMgr = new EventManager(rand);
        	MinecraftForge.EVENT_BUS.register(eventMgr);
        }
    }
    
    @EventHandler
    public void fmlLifeCycleEvent(FMLInitializationEvent event) 
    {

    }
    
    @EventHandler
    public void fmlLifeCycle(FMLPostInitializationEvent event)
    {

    }
    
    @EventHandler
    public void fmlLifeCycle(FMLServerAboutToStartEvent event)
    {

    }
    
    @EventHandler
    public void fmlLifeCycle(FMLServerStartingEvent event)
    {

    }
    
    @EventHandler
    public void fmlLifeCycle(FMLServerStartedEvent event)
    {

    }

    @EventHandler
    public void fmlLifeCycle(FMLServerStoppingEvent event)
    {

    }
}
