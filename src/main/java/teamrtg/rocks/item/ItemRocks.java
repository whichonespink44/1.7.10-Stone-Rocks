package teamrtg.rocks.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import teamrtg.rocks.config.rocks.ConfigRocks;
import teamrtg.rocks.reference.ModInfo;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRocks
{

	//public static Item rockStone;
	public static Item rockCobblestone;
    
    public static final void init()
    {
//        rockStone = new Item()
//	    	.setUnlocalizedName(ModInfo.MOD_ID + "_" + "rockStone")
//	    	.setTextureName(ModInfo.MOD_ID + ":" + "rockStone")
//	    	.setCreativeTab(CreativeTabs.tabMisc)
//	    	.setMaxStackSize(ConfigSR.stackSize)
//    	;
        
        rockCobblestone = new Item()
	    	.setUnlocalizedName(ModInfo.MOD_ID + "_" + "rockCobblestone")
	    	.setTextureName(ModInfo.MOD_ID + ":" + "rockCobblestone")
	    	.setCreativeTab(CreativeTabs.tabMisc)
	    	.setMaxStackSize(ConfigRocks.stackSize)
    	;
        
        //GameRegistry.registerItem(rockStone, "rockStone");
        GameRegistry.registerItem(rockCobblestone, "rockCobblestone");
        
        //GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone), rockStone, rockStone, rockStone, rockStone);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone), rockCobblestone, rockCobblestone, rockCobblestone, rockCobblestone);
    }
}