package teamrtg.stonerocks.event;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import teamrtg.stonerocks.config.stonerocks.ConfigSR;
import teamrtg.stonerocks.item.ItemRock;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventManager
{

	private Block[] stoneBlocks;
	private byte[] stoneMetas;
	private Item[] dropItems;
	
    public EventManager()
    {
    	this.stoneBlocks = new Block[]{Blocks.stone, Blocks.cobblestone};
    	this.stoneMetas = new byte[]{(byte)0, (byte)0};
    	this.dropItems = new Item[]{ItemRock.itemRockStone, ItemRock.itemRockCobblestone};
    }
    
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onHarvestDrop(HarvestDropsEvent event)
    {
    	for (int index = 0; index < this.stoneBlocks.length; index++) {
    		
    		if (event.block == this.stoneBlocks[index] && event.blockMetadata == this.stoneMetas[index]) {
    			
    	    	if (event.isSilkTouching) { return; }
    	    	if (event.harvester == null) { return; }
    	    	
    	    	event.drops.clear();
    	    	event.dropChance = ConfigSR.dropChance;
    	    	
    	    	Random rand = new Random(event.world.getSeed());
    			
    			event.drops.add(new ItemStack(this.dropItems[index], ConfigSR.drops));
    			break;
    		}
    	}
    }
}