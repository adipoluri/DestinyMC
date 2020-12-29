package com.adipoluri.destinymod.entities;

import net.minecraft.client.particle.FireworkParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import com.adipoluri.destinymod.init.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class BulletEntity extends ProjectileItemEntity {
    private float damage;
    public BulletEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public BulletEntity(double x, double y, double z, World worldIn) {
        super(EntityInit.BULLET.get(), x, y, z, worldIn);
    }

    public BulletEntity(LivingEntity livingEntityIn, World worldIn, float damage) {
        super(EntityInit.BULLET.get(), livingEntityIn, worldIn);
        this.damage = damage;
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
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this,this.getEntity()),this.damage);

        }
        if(!this.getEntityWorld().isRemote()) {
            this.remove();
        }
    }


    @Override
    protected float getGravityVelocity() {
        return 0.0001F;
    }

}
