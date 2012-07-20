package bot.script.enums;

/** 
 * @author Webjoch
 * The indexes aren't complete!
 */
public enum Skill{
	ATACK(0),
	STRENGTH(2),
	DEFENCE(1),
	RANGED(4),
	PRAYER(5),
	MAGIC(6),
	RUNECRAFT(20),
	HITPOINTS(3),
	AGILITY(16),
	HERBLORE(15),
	THIEVING(17),
	CRAFTING(12),
	FLETCHING(9),
	SLAYER(18),
	MINING(14),
	SMITHING(13),
	FISHING(10),
	COOKING(7),
	FIREMAKING(11),
	WOODCUTTING(8),
	FARMING(19);
	
	int index;
	Skill(int index){
		this.index = index;
	}
	public int getIndex(){
		return index;
	}
}