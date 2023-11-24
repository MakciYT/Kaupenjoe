package makciyt.kaupenjoe.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.RaccoonEntity;
import makciyt.kaupenjoe.entity.model.RaccoonModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public RaccoonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RaccoonModel());
        this.shadowSize = 0.3f;
    }

    @Override
    public ResourceLocation getEntityTexture(RaccoonEntity entity) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }

    @Override
    public RenderType getRenderType(RaccoonEntity animatable, float partialTicks, MatrixStack stack,
                                    @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}