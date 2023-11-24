package makciyt.kaupenjoe.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.DamaEntity;
import makciyt.kaupenjoe.entity.model.DamaModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class DamaRenderer extends GeoEntityRenderer<DamaEntity> {
    public DamaRenderer(EntityRendererManager renderManager) {
        super(renderManager, new DamaModel());
        this.shadowSize = 0.5f;
    }

    @Override
    public ResourceLocation getEntityTexture(DamaEntity entity) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/dama/dama.png");
    }

    @Override
    public RenderType getRenderType(DamaEntity animatable, float partialTicks, MatrixStack stack,
                                    @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.935F, 0.935F, 0.935F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
