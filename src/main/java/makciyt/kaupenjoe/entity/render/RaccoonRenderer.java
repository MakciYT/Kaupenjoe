package makciyt.kaupenjoe.entity.render;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.RaccoonEntity;
import makciyt.kaupenjoe.entity.model.RaccoonModel;
import makciyt.kaupenjoe.entity.variant.RaccoonVariant;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;
import java.util.Map;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public static final Map<RaccoonVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), (p_114874_) -> {
                p_114874_.put(RaccoonVariant.DEFAULT,
                        new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/raccoon/raccoon.png"));
                p_114874_.put(RaccoonVariant.DARK,
                        new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/raccoon/raccoondark.png"));
                p_114874_.put(RaccoonVariant.RED,
                        new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/raccoon/redraccoon.png"));
            });
    public RaccoonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RaccoonModel());
        this.shadowSize = 0.3f;
    }

    @Override
    public ResourceLocation getEntityTexture(RaccoonEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public RenderType getRenderType(RaccoonEntity animatable, float partialTicks, MatrixStack stack,
                                    @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isChild()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(0.8F, 0.8F, 0.8F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}