package net.fettlol.utilmod.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fettlol.utilmod.entities.WanderingHeadHunterEntity;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.registry.Registry;

public class FettlolEntities {

    public static final EntityType<WanderingHeadHunterEntity> WANDERING_HEAD_HUNTER =
        Registry.register(
            Registry.ENTITY_TYPE,
            RegistryHelper.fettlolId("wandering_headhunter"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, WanderingHeadHunterEntity::new)
                .dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                .trackRangeBlocks(12)
                .build()
        );


    public static void init() {
        FabricDefaultAttributeRegistry.register(WANDERING_HEAD_HUNTER, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D));
    }
}
