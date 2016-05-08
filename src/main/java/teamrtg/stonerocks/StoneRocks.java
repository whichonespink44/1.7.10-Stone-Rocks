package teamrtg.stonerocks;

import net.minecraftforge.common.MinecraftForge;
import teamrtg.stonerocks.config.ConfigManager;
import teamrtg.stonerocks.config.stonerocks.ConfigSR;
import teamrtg.stonerocks.event.EventManager;
import teamrtg.stonerocks.item.ItemRock;
import teamrtg.stonerocks.item.ItemRockCobblestone;
import teamrtg.stonerocks.item.ItemRockStone;
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
import cpw.mods.fml.common.registry.GameRegistry;

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
        
        ItemRock.itemRockStone = new ItemRockStone();
        ItemRock.itemRockCobblestone = new ItemRockCobblestone();
        
        GameRegistry.registerItem(ItemRock.itemRockStone, "Stone Rock");
        GameRegistry.registerItem(ItemRock.itemRockCobblestone, "Cobblestone Rock");
        
        eventMgr = new EventManager();
        
        if (ConfigSR.modEnabled) {
        	
        	MinecraftForge.EVENT_BUS.register(eventMgr);
        }
        
        configPath = event.getModConfigurationDirectory() + "/";
        ConfigManager.init(configPath);
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
