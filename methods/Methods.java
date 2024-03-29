package bot.script.methods;

import java.util.logging.Logger;

import bot.script.util.Condition;
import nl.wbot.bot.Bot;

import bot.script.util.Random;

/**
 * 
 * @author Webjoch
 *
 * Most classes extends this class
 *
 */
public class Methods {
	public static Logger log = Logger.getLogger(Bot.class.getName());
	
	public static void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public static void sleep(int begin, int end){
		sleep(Random.nextInt(begin, end));
	}

    public static void sleep(int maxtime, Condition c) {
        for (int i = 0; i < maxtime / 50 && !c.validate(); i++) {
            sleep(maxtime / 50);
        }
    }
	
	public static boolean inArray(int[] array, int needle){
		for(int value : array){
			if (value == needle){
				return true;
			}
		}
		return false;
	}
	
	public static boolean inArray(String[] array, String needle){
		if (needle == null) return false;
		for(String value : array){
			if (value == null) continue;
			if (value.toLowerCase().equals(needle.toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
	public static void log(Object text){
		log.info(""+text);
	}
	
	public static String timeToString(int time){
		int seconds = (int) (time / 1000) % 60 ;
		int minutes = (int) ((time / (1000*60)) % 60);
		int hours   = (int) ((time / (1000*60*60)) % 24);
		return (hours < 10 ? "0"+hours : hours)+":"+(minutes < 10 ? "0"+minutes : minutes)+":"+(seconds < 10 ? "0"+seconds : seconds); 
	}
}
