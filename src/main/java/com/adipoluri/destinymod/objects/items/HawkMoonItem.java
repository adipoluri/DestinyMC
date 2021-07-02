package com.adipoluri.destinymod.objects.items;


import com.adipoluri.destinymod.entities.BulletEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import java.util.List;

public class HawkMoonItem extends GunItem {
    public boolean singleFire;
    public HawkMoonItem(Properties properties) {
        super(properties);
        this.singleFire = true;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        StringBuilder str = new StringBuilder();
        if(Screen.hasShiftDown()) {
            str.append("   Impact: 78\n");
            str.append("   Range: 57\n");
            str.append("  Stability: 67\n");
            str.append(" Handling: 74\n");
            str.append("   Reload: 63\n");
            str.append("RPM: 140\n");
            str.append("Magazine: 8\n");
        } else {
            str.append("Hold Shift for Stats");
        }
        tooltip.add(new StringTextComponent(str.toString()));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        singleFire = true;
        ((PlayerEntity) entityLiving).jump();
    }
      
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(Hand.MAIN_HAND);
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



}
