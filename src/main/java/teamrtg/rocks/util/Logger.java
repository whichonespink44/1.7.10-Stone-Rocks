package teamrtg.rocks.util;

import org.apache.logging.log4j.Level;

import teamrtg.rocks.config.rocks.ConfigRocks;
import cpw.mods.fml.common.FMLLog;

public class Logger {

	public static void debug(String format, Object... data) {
		if (ConfigRocks.enableDebugging) FMLLog.log(Level.DEBUG, "[Rocks-DEBUG] " + format, data);
	}

	public static void info(String format, Object... data) {
		FMLLog.log(Level.INFO, "[Rocks-INFO] " + format, data);
	}

	public static void warn(String format, Object... data) {
		FMLLog.log(Level.WARN, "[Rocks-WARN] " + format, data);
	}

	public static void error(String format, Object... data) {
		FMLLog.log(Level.ERROR, "[Rocks-ERROR] " + format, data);
	}

	public static void fatal(String format, Object... data) {
		FMLLog.log(Level.FATAL, "[Rocks-FATAL] " + format, data);
	}
}