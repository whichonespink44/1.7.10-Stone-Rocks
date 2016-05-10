package teamrtg.rocks.config;

import java.io.File;

import teamrtg.rocks.config.rocks.ConfigRocks;

public class ConfigManager
{
    
    public static File srConfigFile;

    private ConfigRocks configSR = new ConfigRocks();
    public ConfigRocks rtg() {
        return configSR;
    }
    
    public static void init(String configpath)
    {
    
    	srConfigFile = new File(configpath + "rocks.cfg");
        
    	ConfigRocks.init(srConfigFile);
    }
}
