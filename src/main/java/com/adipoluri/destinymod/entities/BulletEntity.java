package com.adipoluri.destinymod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import com.adipoluri.destinymod.init.*;
import net.minecraftforge.fml.network.NetworkHooks;

public class BulletEntity extends ProjectileItemEntity {


    public BulletEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public BulletEntity(double x, double y, double z, World worldIn) {
        super(EntityInit.BULLET.get(), x, y, z, worldIn);
    }

    public BulletEntity(LivingEntity livingEntityIn, World worldIn) {
        super(EntityInit.BULLET.get(), livingEntityIn, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.BULLET.get().asItem();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result).getEntity();
            int damage = 10;
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this,this.getEntity()),(float) damage);
        }

        if(!world.isRemote) {
            this.remove();
        }
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0001F;
    }
}
