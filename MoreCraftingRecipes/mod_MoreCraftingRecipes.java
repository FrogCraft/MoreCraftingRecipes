package MoreCraftingRecipes;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.*;

@Mod( modid = "mod_MoreCraftingRecipes", name="MoreCraftingRecipes", version="1.0")
@NetworkMod(clientSideRequired=true)
public class mod_MoreCraftingRecipes {	
	//IDs
	public static int EndCore_id,SpawnerPickaxe_id;
	
	//Flags
	public static boolean Wood_Crafting;
	public static boolean Wood_Convertions;
	public static boolean Planks_Crafting;
	public static boolean Exp_Smelting;
	public static boolean Leather_Smelting;
	public static boolean Reverse_CoalOre;
	public static boolean Reverse_IronOre;
	public static boolean Reverse_GoldOre;
	public static boolean Reverse_DiamondOre;
	public static boolean Reverse_EmeraldOre;	
	public static boolean Endportal_Enabled;
	public static boolean Skull_Convertions;
	public static boolean Feather_Crafting;
	public static boolean SlimeBall_Crafting;
	public static boolean BlazeRod_Crafting;
	public static boolean Fire_Crafting;
	public static boolean Reverse_Quartz;
	public static boolean Web_Crafting;
	public static boolean DragonEgg_Crafting;
	public static boolean NetherStar_Crafting;
	public static boolean SpawnerPickaxe_Enable;
	public static boolean Coal_crafting;
	public static boolean GhastTear_Crafting;	
	public static boolean Spawner_Crafting;
	
	//Strings
	public static String CoalBlock_Lang;
	public static String EndCore_Lang;
	public static String SpawnerPickaxe_Lang;
	
	//Items
	public static Item EndCore,SpawnerPickaxe;

	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        
        CoalBlock_Lang=config.get("Lang","CoalBlock","Coal Block").getString();
        EndCore_Lang=config.get("Lang","EndCore","End Core").getString();
        SpawnerPickaxe_Lang=config.get("Lang","SpawnerPickaxe","Spawner Pickaxe").getString();
        
        EndCore_id=config.getItem("Item_EndCore", 5000).getInt();   
        SpawnerPickaxe_id=config.getItem("Item_SpawnerPickaxe", 5001).getInt();
        
        Wood_Crafting=config.get(Configuration.CATEGORY_GENERAL, "Wood_Crafting", true).getBoolean(false);
        Wood_Convertions=config.get(Configuration.CATEGORY_GENERAL, "Wood_Convertions", true).getBoolean(false);
        Planks_Crafting=config.get(Configuration.CATEGORY_GENERAL, "Planks_Crafting", true).getBoolean(false);
        Exp_Smelting=config.get(Configuration.CATEGORY_GENERAL, "Exp_Smelting", true).getBoolean(false);
        Leather_Smelting=config.get(Configuration.CATEGORY_GENERAL, "Leather_Smelting", true).getBoolean(false);
        Reverse_CoalOre=config.get(Configuration.CATEGORY_GENERAL, "Reverse_CoalOre", true).getBoolean(false);
        Reverse_IronOre=config.get(Configuration.CATEGORY_GENERAL, "Reverse_IronOre", true).getBoolean(false);
        Reverse_GoldOre=config.get(Configuration.CATEGORY_GENERAL, "Reverse_GoldOre", true).getBoolean(false);
        Reverse_DiamondOre=config.get(Configuration.CATEGORY_GENERAL, "Reverse_DiamondOre", true).getBoolean(false);
        Reverse_EmeraldOre=config.get(Configuration.CATEGORY_GENERAL, "Reverse_EmeraldOre", true).getBoolean(false);
        Endportal_Enabled=config.get(Configuration.CATEGORY_GENERAL, "Endportal_Enabled", true).getBoolean(false);
        Skull_Convertions=config.get(Configuration.CATEGORY_GENERAL, "Skull_Convertions", true).getBoolean(false);
        Feather_Crafting=config.get(Configuration.CATEGORY_GENERAL, "Feather_Crafting", true).getBoolean(false);
        SlimeBall_Crafting=config.get(Configuration.CATEGORY_GENERAL, "SlimeBall_Crafting", true).getBoolean(false);
        BlazeRod_Crafting=config.get(Configuration.CATEGORY_GENERAL, "BlazeRod_Crafting", true).getBoolean(false);
        Fire_Crafting=config.get(Configuration.CATEGORY_GENERAL, "Fire_Crafting", true).getBoolean(false);
        Reverse_Quartz=config.get(Configuration.CATEGORY_GENERAL, "Reverse_Quartz", true).getBoolean(false);
        Web_Crafting=config.get(Configuration.CATEGORY_GENERAL, "Web_Crafting", true).getBoolean(false);
        DragonEgg_Crafting=config.get(Configuration.CATEGORY_GENERAL, "DragonEgg_Crafting", true).getBoolean(false);
        NetherStar_Crafting=config.get(Configuration.CATEGORY_GENERAL, "NetherStar_Crafting", true).getBoolean(false);
        SpawnerPickaxe_Enable=config.get(Configuration.CATEGORY_GENERAL, "SpawnerPickaxe_Enable", true).getBoolean(false);
        Coal_crafting=config.get(Configuration.CATEGORY_GENERAL, "Coal_crafting", true).getBoolean(false);
        GhastTear_Crafting=config.get(Configuration.CATEGORY_GENERAL, "GhastTear_Crafting", true).getBoolean(false);
        Spawner_Crafting=config.get(Configuration.CATEGORY_GENERAL, "Spawner_Crafting", true).getBoolean(false);
        
        config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {

		EndCore=new Item_EndCore(EndCore_id);
		SpawnerPickaxe= new Item_SpawnerPickaxe(SpawnerPickaxe_id);
		
		//Register Block
		LanguageRegistry.addName(EndCore,EndCore_Lang);
		LanguageRegistry.addName(SpawnerPickaxe,SpawnerPickaxe_Lang);
		
		//local variables
		CraftingManager m=CraftingManager.getInstance();
	
		
		if (Wood_Crafting)
			m.addRecipe(new ItemStack(Block.wood,1,0) ,new Object[] {" # ","# #"," # ",'#',Block.planks});
		
		if (Wood_Convertions){
			m.addRecipe(new ItemStack(Block.wood,2,1) ,new Object[] {"#","#",'#',new ItemStack(Block.wood,1,0)});
			m.addRecipe(new ItemStack(Block.wood,2,2) ,new Object[] {"#","#",'#',new ItemStack(Block.wood,1,1)});	
			m.addRecipe(new ItemStack(Block.wood,2,3) ,new Object[] {"#","#",'#',new ItemStack(Block.wood,1,2)});
			m.addRecipe(new ItemStack(Block.wood,2,0) ,new Object[] {"#","#",'#',new ItemStack(Block.wood,1,3)});		
		}	
			
		
		if (Planks_Crafting)
			m.addRecipe(new ItemStack(Block.planks,2,0) ,new Object[] {"##","##",'#',Item.stick});
		
		if (Leather_Smelting)
			FurnaceRecipes.smelting().addSmelting(new ItemStack(Item.rottenFlesh).itemID, new ItemStack(Item.leather), 1.0F);
		
		if (Exp_Smelting)
			FurnaceRecipes.smelting().addSmelting(new ItemStack(Item.glassBottle).itemID, new ItemStack(Item.expBottle), 1.0F);
		
		if (Reverse_CoalOre)
			m.addShapelessRecipe(new ItemStack(Block.oreCoal,1) ,new Object[] {Item.coal,Item.coal,Block.cobblestone,Block.cobblestone});
		
		if (Reverse_IronOre)
			m.addShapelessRecipe(new ItemStack(Block.oreIron,1) ,new Object[] {Item.ingotIron,Item.ingotIron,Block.cobblestone,Block.cobblestone});		
		
		if (Reverse_GoldOre)
			m.addShapelessRecipe(new ItemStack(Block.oreGold,1) ,new Object[] {Item.ingotGold,Item.ingotGold,Block.cobblestone,Block.cobblestone});		
	
		if (Reverse_DiamondOre)
			m.addShapelessRecipe(new ItemStack(Block.oreDiamond,1) ,new Object[] {Item.diamond,Block.cobblestone,Block.cobblestone});	
		
		if (Reverse_EmeraldOre)
			m.addShapelessRecipe(new ItemStack(Block.oreEmerald,1) ,new Object[] {Item.emerald,Block.cobblestone,Block.cobblestone});	
		
		if (Endportal_Enabled)
			m.addRecipe(new ItemStack(Block.endPortalFrame,1,0) ,new Object[] {"###","#X#","###",'#',Block.whiteStone,'X',Item.eyeOfEnder});
		
		if (Skull_Convertions){
			m.addRecipe(new ItemStack(Item.skull,1,1) ,new Object[] {"#",'#',new ItemStack(Item.skull,1,0)});
			m.addRecipe(new ItemStack(Item.skull,1,2) ,new Object[] {"#",'#',new ItemStack(Item.skull,1,1)});
			m.addRecipe(new ItemStack(Item.skull,1,3) ,new Object[] {"#",'#',new ItemStack(Item.skull,1,2)});
			m.addRecipe(new ItemStack(Item.skull,1,4) ,new Object[] {"#",'#',new ItemStack(Item.skull,1,3)});
			m.addRecipe(new ItemStack(Item.skull,1,0) ,new Object[] {"#",'#',new ItemStack(Item.skull,1,4)});			
		}	
		
		if (Feather_Crafting)
			m.addRecipe(new ItemStack(Item.feather,1), new Object []{" YY","YXY","XY ",'X',Item.stick,'Y',Item.silk});
		
		if (SlimeBall_Crafting)
			m.addShapelessRecipe(new ItemStack(Item.slimeBall), new Object []{Item.bucketMilk,Item.snowball,Item.seeds,Item.seeds,Item.seeds,Item.seeds,Item.seeds,Item.seeds,Item.seeds});
	
		if (BlazeRod_Crafting){
			m.addRecipe(new ItemStack(Item.blazeRod,2), new Object []{"XY","XY","XY",'X',Block.torchWood,'Y',Item.ingotGold});
			m.addRecipe(new ItemStack(Item.blazeRod,1), new Object []{"XY","XY","XY",'X',Item.stick,'Y',Item.blazePowder});
		}
		
		if (Fire_Crafting){
			m.addShapelessRecipe(new ItemStack(Block.fire), new Object []{Block.netherrack,Item.bucketLava});
		}
		
		if (Reverse_Quartz){
			m.addShapelessRecipe(new ItemStack(Item.netherQuartz,4), new Object []{Block.blockNetherQuartz});
			m.addRecipe(new ItemStack(Item.netherQuartz,4), new Object []{"#",'#',new ItemStack(Block.blockNetherQuartz,1,1)});
			m.addRecipe(new ItemStack(Item.netherQuartz,4), new Object []{"#",'#',new ItemStack(Block.blockNetherQuartz,1,2)});
		}
		
		if (Web_Crafting){
			m.addShapelessRecipe(new ItemStack(Block.web), new Object []{Item.silk});
			m.addShapelessRecipe(new ItemStack(Item.silk), new Object []{Block.web});			
		}
		
		if (DragonEgg_Crafting){
			m.addRecipe(new ItemStack(EndCore),new Object[]{"XYX","Y#Y","XYX",'#',Item.eyeOfEnder,'X',Block.whiteStone,'Y',Item.diamond});
			m.addRecipe(new ItemStack(Block.dragonEgg), new Object []{" # ","#X#","###",'#',Block.obsidian,'X',EndCore});
		}
		
		if (NetherStar_Crafting)
			m.addShapelessRecipe(new ItemStack(Item.netherStar), new Object []{Block.netherBrick,Block.glowStone,Block.slowSand,Block.oreNetherQuartz,Item.blazeRod,Block.netherrack,Item.bucketLava,Item.diamond,Item.emerald});
		
		if (SpawnerPickaxe_Enable)
			m.addShapelessRecipe(new ItemStack(SpawnerPickaxe),new Object[]{Item.pickaxeDiamond,Item.netherStar});
		
		if (Coal_crafting)
			m.addRecipe(new ItemStack(Item.coal,1,0), new Object []{" # ", "# #"," # ",'#',new ItemStack(Item.coal,1,1)});
	
		if(GhastTear_Crafting)
			m.addRecipe(new ItemStack(Item.ghastTear), new Object []{"###", "#X#","###",'X',Item.diamond,'#',Item.snowball});
		
		if(Spawner_Crafting)
			m.addRecipe(new ItemStack(Block.mobSpawner), new Object []{"#Y#", "#X#","#Z#",'X',Item.netherStar,'#',Block.netherFence,'Z',Item.magmaCream,'Y',Item.enderPearl});
	
		Block.mobSpawner.setCreativeTab(CreativeTabs.tabBlock);
	}
}

