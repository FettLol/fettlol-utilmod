package net.fettlol.utilmod.mixin.lilypads;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Original code from "mixin/entity/betterlilypads/SprintingParticles" in TinyTweaks by hephaestus.
 *
 * This code makes tweaks to lily pads to make them better to work with.
 */

@Mixin(Entity.class)
public abstract class SprintingParticlesMixin {
    @Shadow public World world;

    @Redirect(method = "spawnSprintingParticles", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"))
    private BlockState lilyPadsOnWater(World world, BlockPos pos) {
        BlockState original = world.getBlockState(pos);
        BlockState above = world.getBlockState(pos.up());

        return original.getBlock().equals(Blocks.WATER) && above.getBlock().equals(Blocks.LILY_PAD) ? above : original;
    }
}