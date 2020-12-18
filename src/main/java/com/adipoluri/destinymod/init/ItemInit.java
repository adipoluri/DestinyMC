package com.adipoluri.destinymod.init;
import com.adipoluri.destinymod.DestinyMod;
import com.adipoluri.destinymod.objects.items.HawkMoonItem;
import net.minecraft.block.Block;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import javax.swing.text.html.parser.Entity;


public class ItemInit {
    public static final RegistryObject<Item> HAWK_MOON = Registration.ITEMS.register("hawkmoon", () ->
            new HawkMoonItem(new Item.Properties().group(DestinyMod.DestinyItemGroup.instance).maxStackSize(1)));

    public static final RegistryObject<Item> MONTE_CARLO = Registration.ITEMS.register("monte_carlo", () ->
            new Item(new Item.Properties().group(DestinyMod.DestinyItemGroup.instance).maxStackSize(1)));
    static void register(){}
}
