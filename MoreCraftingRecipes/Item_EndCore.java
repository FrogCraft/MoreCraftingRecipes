package MoreCraftingRecipes;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Item_EndCore extends Item {

	public Item_EndCore(int id) {
		super(id);
		// TODO Auto-generated constructor stub
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Item_EndCore");
	}

	public void registerIcons(IconRegister iconRegister)
	{
	    itemIcon = iconRegister.registerIcon("MoreCraftingRecipes:Item_EndCore");
	}
}
