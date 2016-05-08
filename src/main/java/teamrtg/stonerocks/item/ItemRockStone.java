package teamrtg.stonerocks.item;

import teamrtg.stonerocks.reference.ModInfo;

public class ItemRockStone extends ItemRock
{

    public ItemRockStone()
    {
    	super();
    	
		setUnlocalizedName(ModInfo.MOD_ID + "_" + "rockStone");
		setTextureName(ModInfo.MOD_ID + ":" + "rockStone");
    }
}