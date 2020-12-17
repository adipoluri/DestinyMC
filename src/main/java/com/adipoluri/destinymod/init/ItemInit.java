package com.adipoluri.destinymod.init;
import com.adipoluri.destinymod.DestinyMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;


public class ItemInit {
    public static final RegistryObject<Item> HAWK_MOON = Registration.ITEMS.register("hawkmoon", () ->
            new Item(new Item.Properties().group(ItemGroup.COMBAT)));

    static void register(){}
}
