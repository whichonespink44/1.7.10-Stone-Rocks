package teamrtg.rocks.event;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import teamrtg.rocks.config.rocks.ConfigRocks;
import teamrtg.rocks.item.ItemRocks;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventManager
{

	private Block[] stoneBlocks;
	private byte[] stoneMetas;
	private Item[] dropItems;
	private Random rand;
	
    public EventManager(Random rand)
    {
    	this.rand = rand;
    	this.stoneBlocks = new Block[]{Blocks.stone, Blocks.cobblestone};
    	this.stoneMetas = new byte[]{(byte)0, (byte)0};
    	this.dropItems = new Item[]{ItemRocks.rockCobblestone, ItemRocks.rockCobblestone};
    }
    
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onHarvestDrop(HarvestDropsEvent event)
    {
    	for (int index = 0; index < this.stoneBlocks.length; index++) {
    		
    		if (event.block == this.stoneBlocks[index] && event.blockMetadata == this.stoneMetas[index]) {
    			
    	    	if (event.isSilkTouching) { return; }
    	    	if (event.harvester == null) { return; }
    	    	
    	    	event.drops.clear();
    	    	event.dropChance = ConfigRocks.dropChance;

    			event.drops.add(
    				new ItemStack(
    					this.dropItems[index],
    					ConfigRocks.minDrops + this.rand.nextInt(ConfigRocks.maxDrops - ConfigRocks.minDrops + 1)
    				)
    			);
    			
    			break;
    		}
    	}
    }
}