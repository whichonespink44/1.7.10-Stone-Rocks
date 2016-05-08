package teamrtg.stonerocks.item;

import teamrtg.stonerocks.reference.ModInfo;

public class ItemRockCobblestone extends ItemRock
{

    public ItemRockCobblestone()
    {
    	super();
    	
		setUnlocalizedName(ModInfo.MOD_ID + "_" + "rockCobblestone");
		setTextureName(ModInfo.MOD_ID + ":" + "rockCobblestone");
    }
}