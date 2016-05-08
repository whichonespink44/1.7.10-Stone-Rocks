package teamrtg.stonerocks.config;

import java.io.File;

import teamrtg.stonerocks.config.stonerocks.ConfigSR;

public class ConfigManager
{
    
    public static File srConfigFile;

    private ConfigSR configSR = new ConfigSR();
    public ConfigSR rtg() {
        return configSR;
    }
    
    public static void init(String configpath)
    {
    
    	srConfigFile = new File(configpath + "stonerocks.cfg");
        
    	ConfigSR.init(srConfigFile);
    }
}
