package bot.script.wrappers;

import java.awt.Point;

import nl.wbot.bot.Bot;
import nl.wbot.bot.accessors.ItemDef;

import bot.script.enums.Tab;
import bot.script.methods.Game;
import bot.script.methods.Menu;
import bot.script.methods.Methods;
import bot.script.methods.Mouse;

/**
 * 
 * @author Webjoch
 * 
 */
public class Item extends Methods{
	int index, id;
	Interface iface;
	
	public Item(int index, int id, Interface iface){
		this.index = index;
		this.id = id;
		this.iface = iface;
	}
	
	public int getId(){
		return id;
	}
	
	public int getStacksize(){
		if (iface != null && iface.getItems() != null && iface.getItems().length > 0){
			return iface.getItems()[index] == id ? iface.getStacksize()[index] : 1;
		}
		return 1;
	}
	
	public Point getPoint(){
		int x, y;
		if (iface.getId() == 5382){
			x = (index % 8) * 46 + iface.getPoint().x + 20;
			y = (index / 8) * 35 + iface.getPoint().y + 20;
		}else{
			x = (index % 4) * 41 + iface.getPoint().x + 16;
			y = (index / 4) * 35 + iface.getPoint().y + 16;
		}
		return new Point(x, y);
	}
	
	public boolean interact(String action){
		if (Game.getTab() != Tab.INVENTORY){
			Game.openTab(Tab.INVENTORY);
		}
		Mouse.move(getPoint());
		sleep(200);
		return Menu.interact(action);
	}

	public ItemDef getDef(){
		return Bot.get().getMainClass().getItemDef(getId());
	}
}
