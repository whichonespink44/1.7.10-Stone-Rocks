package teamrtg.stonerocks.config.stonerocks;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import teamrtg.stonerocks.util.Logger;

public class ConfigSR
{
	public static Configuration config;
	
	public static boolean enableDebugging = false;
	public static boolean modEnabled = true;
	public static float dropChance = 1.0f;
	public static int drops = 9;
	public static int stackSize = 64;
	public static String[] blocks = new String[]{"minecraft:stone:0", "minecraft:cobblestone:0"};

	public static void init(File configFile)
	{
		config = new Configuration(configFile);
		
		try 
		{
			config.load();
			
			enableDebugging = config.getBoolean(
                "Enable Debugging",
                "General",
                enableDebugging,
                "If TRUE, debugging information will be logged."
                + Configuration.NEW_LINE
            );
			
			modEnabled = config.getBoolean(
	                "Enable Stone Rocks",
	                "General",
	                modEnabled,
	                "If FALSE, rocks will not drop from stone blocks."
	                + Configuration.NEW_LINE
	            );
			
			dropChance = config.getFloat(
		        "Drop Chance",
		        "General",
		        dropChance,
		        0f,
		        1.0f,
		        "The chance that rocks will drop when a stone block is harvested."
		        + Configuration.NEW_LINE +
		        "1.0 = 100% chance; 0.5 = 50% chance; 0 = Rocks will not drop."
		        + Configuration.NEW_LINE
		    );
			
			drops = config.getInt(
                "Drops",
                "General",
                drops,
                0,
                Integer.MAX_VALUE,
                "The number of rocks that drop from a harvested stone block."
                + Configuration.NEW_LINE
            );
			
			stackSize = config.getInt(
                "Stack Size",
                "General",
                stackSize,
                1,
                64,
                "The maximum number of rocks that can go in one stack."
                + Configuration.NEW_LINE
            );
			
			blocks = config.getStringList(
				"Stone Blocks",
				"General",
				blocks,
				"modid:blockid:blockmeta"
				+ Configuration.NEW_LINE
			);
		}
		catch (Exception e) 
		{
		    Logger.error("Stone Rocks has had a problem loading its configuration.");	
		}
		finally 
		{
			if (config.hasChanged())
			{
				config.save();
			}
		}
	}
}