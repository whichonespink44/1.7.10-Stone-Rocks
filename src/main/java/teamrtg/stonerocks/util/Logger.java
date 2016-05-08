package teamrtg.stonerocks.util;

import org.apache.logging.log4j.Level;

import teamrtg.stonerocks.config.stonerocks.ConfigSR;
import cpw.mods.fml.common.FMLLog;

public class Logger {

	public static void debug(String format, Object... data) {
		if (ConfigSR.enableDebugging) FMLLog.log(Level.DEBUG, "[StoneRocks-DEBUG] " + format, data);
	}

	public static void info(String format, Object... data) {
		FMLLog.log(Level.INFO, "[StoneRocks-INFO] " + format, data);
	}

	public static void warn(String format, Object... data) {
		FMLLog.log(Level.WARN, "[StoneRocks-WARN] " + format, data);
	}

	public static void error(String format, Object... data) {
		FMLLog.log(Level.ERROR, "[StoneRocks-ERROR] " + format, data);
	}

	public static void fatal(String format, Object... data) {
		FMLLog.log(Level.FATAL, "[StoneRocks-FATAL] " + format, data);
	}
}