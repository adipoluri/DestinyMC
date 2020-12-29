package com.adipoluri.destinymod.objects.items;

import com.adipoluri.destinymod.entities.BulletEntity;
import javafx.stage.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import sun.security.util.Debug;

import javax.swing.*;
import java.util.List;

public abstract class GunItem extends Item {
    public boolean singleFire;
    public GunItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if((!worldIn.isRemote()) && singleFire) {
            BulletEntity bullet = new BulletEntity(playerIn, worldIn, ((float)playerIn.experienceLevel)/3);
            bullet.shoot(playerIn.getLookVec().getX(),
                    playerIn.getLookVec().getY(),
                    playerIn.getLookVec().getZ(),
                    3.5f, 1.0f);
            worldIn.addEntity(bullet);
            singleFire = false;
        }
        return new ActionResult<ItemStack>(ActionResultType.CONSUME, item);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if(!worldIn.isRemote()) {
            singleFire = true;
        }
    }


}
