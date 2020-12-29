package com.adipoluri.destinymod.init;

import com.adipoluri.destinymod.DestinyMod;
import com.adipoluri.destinymod.entities.BulletEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;


public class EntityInit {

    public static final RegistryObject<EntityType<BulletEntity>> BULLET = Registration.ENTITY_TYPES.register("bullet",
            () -> EntityType.Builder.<BulletEntity>create(BulletEntity::new, EntityClassification.MISC)
                    .size(0.25f, 0.25f)
                    .build(new ResourceLocation(DestinyMod.MOD_ID, "bullet").toString()));

    static void register(){}

}
