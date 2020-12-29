package com.adipoluri.destinymod.init;
import com.adipoluri.destinymod.DestinyMod;
import com.adipoluri.destinymod.objects.items.BulletItem;
import com.adipoluri.destinymod.objects.items.HawkMoonItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;



public class ItemInit {
    public static final RegistryObject<Item> HAWK_MOON = Registration.ITEMS.register("hawkmoon", () ->
            new HawkMoonItem(new Item.Properties().group(DestinyMod.DestinyItemGroup.instance).maxStackSize(1)));

    public static final RegistryObject<Item> MONTE_CARLO = Registration.ITEMS.register("monte_carlo", () ->
            new Item(new Item.Properties().group(DestinyMod.DestinyItemGroup.instance).maxStackSize(1)));

    public static final RegistryObject<Item> BULLET = Registration.ITEMS.register("bullet", () ->
            new BulletItem(new Item.Properties().group(DestinyMod.DestinyItemGroup.instance).maxStackSize(16)));
    static void register(){}
}
