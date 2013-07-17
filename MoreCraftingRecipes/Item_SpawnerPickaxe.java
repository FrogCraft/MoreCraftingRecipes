package MoreCraftingRecipes;

import cpw.mods.fml.relauncher.Side;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChatMessageComponent;

public class Item_SpawnerPickaxe extends ItemPickaxe{

	public Item_SpawnerPickaxe(int id) {
		super(id,EnumToolMaterial.STONE);
		setUnlocalizedName("Item_SpawnerPickaxe");
	}

	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat) {
		if (world.getBlockId(x, y, z)==Block.mobSpawner.blockID& !world.isRemote){
			TileEntityMobSpawner theTileEntity=	(TileEntityMobSpawner)world.getBlockTileEntity(x, y, z);
	
			int monster_id=getId(theTileEntity.getSpawnerLogic().getEntityNameToSpawn());
			monster_id=monster_id+1;
			if (monster_id==24){
				monster_id=0;
			}
			
			theTileEntity.getSpawnerLogic().setMobID(getName(monster_id));
			world.markBlockForRenderUpdate(x,  y,  z);
			player.sendChatToPlayer(ChatMessageComponent.func_111066_d("Current Mob: "+String.valueOf(monster_id)+" - "+getName(monster_id)));
		}
		return true;	
	}
		
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving){
		par1ItemStack.damageItem(1, par7EntityLiving);

		if(par3 == Block.mobSpawner.blockID)
			dropBlockAsItem_do(par2World,par4,par5,par6,new ItemStack(Block.mobSpawner,1,par2World.getBlockMetadata(par4, par5, par6)));
		return false;
	}
	
    void dropBlockAsItem_do(World par1World, int par2, int par3, int par4, ItemStack par5ItemStack){
        if (!par1World.isRemote && par1World.getGameRules().getGameRuleBooleanValue("doTileDrops"))
        {
            float f = 0.7F;
            double d0 = (double)(par1World.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(par1World.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(par1World.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(par1World, (double)par2 + d0, (double)par3 + d1, (double)par4 + d2, par5ItemStack);
            entityitem.delayBeforeCanPickup = 10;
            par1World.spawnEntityInWorld(entityitem);
        }
    }
	
	public void registerIcons(IconRegister iconRegister)
	{
	    itemIcon = iconRegister.registerIcon("MoreCraftingRecipes:Item_SpawnerPickaxe");
	}
	
	
	public String getName(int id)
    {
        if(id == 0)
        {
            return "Creeper";
        }
        else if(id == 1)
        {
            return "Skeleton";
        }
        else if(id == 2)
        {
            return "Spider";
        }
        else if(id == 3)
        {
            return "Giant";
        }
        else if(id == 4)
        {
            return "Zombie";
        }
        else if(id == 5)
        {
            return "Slime";
        }
        else if(id == 6)
        {
            return "Ghast";
        }
        else if(id == 7)
        {
            return "PigZombie";
        }
        else if(id == 8)
        {
            return "Enderman";
        }
        else if(id == 9)
        {
            return "CaveSpider";
        }
        else if(id == 10)
        {
            return "SilverFish";
        }
        else if(id == 11)
        {
            return "Blaze";
        }
        else if(id == 12)
        {
            return "LavaSlime";
        }
        else if(id == 13)
        {
            return "Pig";
        }
        else if(id == 14)
        {
            return "Sheep";
        }
        else if(id == 15)
        {
            return "Cow";
        }
        else if(id == 16)
        {
            return "Chicken";
        }
        else if(id == 17)
        {
            return "Squid";
        }
        else if(id == 18)
        {
            return "Wolf";
        }
        else if(id == 19)
        {
            return "MushroomCow";
        }
        else if(id == 20)
        {
            return "SnowMan";
        }
        else if(id == 21)
        {
            return "Ozelot";
        }
        else if(id == 22)
        {
            return "VillagerGolem";
        }
        else if(id == 23)
        {
            return "Villager";
        }
        else
        {
            return null;
        }
    }
    public int getId(String name)
    {
        if(name.equals("Creeper"))
        {
            return 0;
        }
        else if(name.equals("Skeleton"))
        {
            return 1;
        }
        else if(name.equals("Spider"))
        {
            return 2;
        }
        else if(name.equals("Giant"))
        {
            return 3;
        }
        else if(name.equals("Zombie"))
        {
            return 4;
        }
        else if(name.equals("Slime"))
        {
            return 5;
        }
        else if(name.equals("Ghast"))
        {
            return 6;
        }
        else if(name.equals("PigZombie"))
        {
            return 7;
        }
        else if(name.equals("Enderman"))
        {
            return 8;
        }
        else if(name.equals("CaveSpider"))
        {
            return 9;
        }
        else if(name.equals("SilverFish"))
        {
            return 10;
        }
        else if(name.equals("Blaze"))
        {
            return 11;
        }
        else if(name.equals("LavaSlime"))
        {
            return 12;
        }
        else if(name.equals("Pig"))
        {
            return 13;
        }
        else if(name.equals("Sheep"))
        {
            return 14;
        }
        else if(name.equals("Cow"))
        {
            return 15;
        }
        else if(name.equals("Chicken"))
        {
            return 16;
        }
        else if(name.equals("Squid"))
        {
            return 17;
        }
        else if(name.equals("Wolf"))
        {
            return 18;
        }
        else if(name.equals("MushroomCow"))
        {
            return 19;
        }
        else if(name.equals("SnowMan"))
        {
            return 20;
        }
        else if(name.equals("Ozelot"))
        {
            return 21;
        }
        else if(name.equals("VillagerGolem"))
        {
            return 22;
        }
        else if(name.equals("Villager"))
        {
            return 23;
        }
        else
        {
            return -1;
        }
    }
}
