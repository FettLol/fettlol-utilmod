package net.fettlol.utilmod.entities.render;

import net.fettlol.utilmod.entities.WanderingHeadHunterEntity;
import net.fettlol.utilmod.entities.render.feature.WanderingHeadHunterFeatureRenderer;
import net.fettlol.utilmod.util.RegistryHelper;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.VillagerHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class WanderingHeadHunterRender extends MobEntityRenderer<WanderingHeadHunterEntity, VillagerResemblingModel<WanderingHeadHunterEntity>> {

    private static final Identifier TEXTURE = RegistryHelper.fettlolId("textures/entity/headhunter.png");

    public WanderingHeadHunterRender(EntityRendererFactory.Context context) {
        super(context, new VillagerResemblingModel<>(context.getPart(EntityModelLayers.WANDERING_TRADER)), 0.5F);
        this.addFeature(new VillagerHeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
        this.addFeature(new WanderingHeadHunterFeatureRenderer<>(this));
    }

    @Override
    protected int getBlockLight(WanderingHeadHunterEntity headHunter, BlockPos blockPos) {
        return 15;
    }

    public Identifier getTexture(WanderingHeadHunterEntity headHunter) {
        return TEXTURE;
    }

    protected void scale(WanderingHeadHunterEntity headHunter, MatrixStack matrixStack, float f) {
        matrixStack.scale(0.94F, 0.94F, 0.94F);
    }

}
