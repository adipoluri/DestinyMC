package com.adipoluri.destinymod.objects.items;


import com.adipoluri.destinymod.entities.BulletEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class HawkMoonItem extends GunItem {
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
}
