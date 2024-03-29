package net.fettlol.utilmod.init;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fettlol.utilmod.concerns.PlayerPlacedLootCondition;
import net.fettlol.utilmod.registry.LootApi;
import net.fettlol.utilmod.util.LootTableHelper;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.CopyNbtLootFunction;
import net.minecraft.loot.provider.nbt.ContextLootNbtProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class FettlolLootTables {

    public static void init() {
        // LootTableEvents.REPLACE.register((resourceManager, lootManager, identifier, original, source) -> {
        //     return customSpawnerBlockHandling(identifier);
        // });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, tableBuilder, source) -> {
            updateOreLootTables(identifier, tableBuilder);
            updateChestLootTables(identifier, tableBuilder);
            updateMobLootTables(identifier, tableBuilder);
        });
    }

    private static void updateOreLootTables(Identifier identifier, LootTable.Builder tableBuilder) {
        if (LootTableHelper.isLapisOre(identifier)) {
            LootApi.addToOreLootTable(tableBuilder, 1, 0.06F, "fettlol:aquamarine_gem");
        }

        if (LootTableHelper.isDiamondOre(identifier)) {
            LootApi.addToOreLootTable(tableBuilder, 2, 0.04F, "fettlol:soul_shard");
        }
    }

    private static void updateMobLootTables(Identifier identifier, LootTable.Builder tableBuilder) {
        if (LootTableHelper.isEnderman(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 1, 0.02F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isPhantom(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 1, 0.05F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isShulker(identifier)) {
            LootApi.addToLootTable(tableBuilder, 1, 1, "minecraft:shulker_shell");
            LootApi.addToLootTable(tableBuilder, 1, 0.02F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isEnderDragon(identifier)) {
            LootApi.addToLootTable(tableBuilder, 4, 0.5F, "fettlol:jade_gem");
            LootApi.addToLootTable(tableBuilder, 4, 0.5F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 1, 1, "minecraft:dragon_egg");
        }

        if (LootTableHelper.isDrowned(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 2, 0.1F, "minecraft:clay");
        }

        if (LootTableHelper.isHusk(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 2, 0.1F, "minecraft:sand");
        }

        if (LootTableHelper.isStray(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 2, 0.1F, "minecraft:blue_ice");
        }

        if (LootTableHelper.isZombie(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 2, 0.1F, "minecraft:gravel");
        }

        if (LootTableHelper.isGuardian(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 2, 0.05F, "minecraft:lapis_lazuli");
        }

        if (LootTableHelper.isWitherSkeleton(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 3, 0.15F, "fettlol:wither_bone");
            LootApi.addToMobLootTable(tableBuilder,2, 0.1F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isWither(identifier)) {
            LootApi.addToMobLootTable(tableBuilder,1, 0.75F, "fettlol:soul_gem");
        }

        if (LootTableHelper.isHostileWaterMob(identifier)) {
            LootApi.addToMobLootTable(tableBuilder, 1, 0.03F, "fettlol:aquamarine_gem");
        }

        if (LootTableHelper.isWitch(identifier)) {
            LootApi.addToLootTable(tableBuilder, 1, 0.1F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isEvoker(identifier)) {
            LootApi.addToLootTable(tableBuilder, 1, 0.25F, "fettlol:jade_gem");
        }
    }


    private static void updateChestLootTables(Identifier identifier, LootTable.Builder tableBuilder) {
        if (LootTableHelper.isNetherEndgameChest(identifier)) {
            LootApi.addToLootTableWithRandomEnchantment(tableBuilder, 1, 0.03F, "fettlol:knightfall");
        }

        if (LootTableHelper.isNetherTempleChest(identifier)) {
            LootApi.addToLootTableWithRandomEnchantment(tableBuilder, 1, 0.02F, "fettlol:knightfall");
        }

        if (LootTableHelper.isEndEndgameChest(identifier)) {
            LootApi.addToLootTableWithRandomEnchantment(tableBuilder, 1, 0.04F, "fettlol:peacekeeper");
        }

        if (LootTableHelper.isDesertPyramid(identifier)) {
            LootApi.addToLootTable(tableBuilder, 2, 0.03F, "fettlol:soul_shard");
            LootApi.addToLootTable(tableBuilder, 2, 0.03F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isShipwreckTreasure(identifier)) {
            LootApi.addToLootTable(tableBuilder, 2, 0.06F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 2, 0.06F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isMansionChest(identifier)) {
            LootApi.addToLootTable(tableBuilder, 2, 0.05F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 2, 0.05F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isFishingTreasure(identifier)) {
            LootApi.addToLootTable(tableBuilder, 1, 0.05F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 1, 0.05F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isAbandonedMineshaftChest(identifier)) {
            LootApi.addToLootTable(tableBuilder, 1, 0.04F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 1, 0.04F, "fettlol:jade_gem");
            LootApi.addToLootTable(tableBuilder, 2, 0.03F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isSimpleDungeonChest(identifier)) {
            LootApi.addToLootTable(tableBuilder, 1, 0.08F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 1, 0.08F, "fettlol:jade_gem");
            LootApi.addToLootTable(tableBuilder, 3, 0.05F, "fettlol:soul_shard");
        }

        if (LootTableHelper.isBuriedTreasureChest(identifier)) {
            LootApi.addToLootTable(tableBuilder, 2, 0.04F, "fettlol:aquamarine_gem");
            LootApi.addToLootTable(tableBuilder, 2, 0.04F, "fettlol:jade_gem");
        }

        if (LootTableHelper.isStrongholdChest(identifier)) {
            LootApi.addToLootTable(tableBuilder, 3, 0.12F, "fettlol:soul_shard");
            LootApi.addToLootTable(tableBuilder, 2, 0.06F, "fettlol:jade_gem");
            LootApi.addToLootTable(tableBuilder, 2, 0.06F, "fettlol:aquamarine_gem");
        }
    }

    private static LootTable customSpawnerBlockHandling(Identifier identifier) {
        if (LootTableHelper.isSpawner(identifier)) {
            return LootTable.builder().pool(
                LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(PlayerPlacedLootCondition::new)
                    .with(ItemEntry.builder(Items.SPAWNER)
                        .apply(CopyNbtLootFunction.builder(ContextLootNbtProvider.BLOCK_ENTITY)
                            .withOperation("SpawnPotentials", "SpawnPotentials")
                            .withOperation("SpawnData", "SpawnData")
                            .withOperation("IsPlayerPlaced", "IsPlayerPlaced")
                        )
                    )
            ).build();
        }

        return null;
    }
}
