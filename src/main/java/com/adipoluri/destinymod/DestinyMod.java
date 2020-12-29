package com.adipoluri.destinymod;

import com.adipoluri.destinymod.entities.BulletEntity;
import com.adipoluri.destinymod.init.EntityInit;
import com.adipoluri.destinymod.init.ItemInit;
import com.adipoluri.destinymod.init.Registration;
import com.adipoluri.destinymod.objects.items.HawkMoonItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.datafix.fixes.ItemRename;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(DestinyMod.MOD_ID)
public class DestinyMod
{
    public static final String MOD_ID = "destinymod";
    private static final Logger LOGGER = LogManager.getLogger();
    public static DestinyMod instance;

    public DestinyMod() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        Registration.register();
        instance = this;

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLClientSetupEvent event)
    {
        registerEntityModels(event.getMinecraftSupplier());
    }

    private void registerEntityModels(Supplier<Minecraft> minecraft) {
        ItemRenderer renderer = minecraft.get().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BULLET.get(), (renderManager) -> new SpriteRenderer<>(renderManager, renderer));
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    public static class DestinyItemGroup extends ItemGroup {
        public static final DestinyItemGroup instance = new DestinyItemGroup(ItemGroup.GROUPS.length, "DestinyMC tab");

        private DestinyItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(new HawkMoonItem(new Item.Properties().group(DestinyMod.DestinyItemGroup.instance).maxStackSize(1)));
        }
    }

}
