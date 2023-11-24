package makciyt.kaupenjoe.entity.render;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.PigeonEntity;
import makciyt.kaupenjoe.entity.model.PigeonModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PigeonRenderer extends MobRenderer<PigeonEntity, PigeonModel<PigeonEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/pigeon.png");

    public PigeonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PigeonModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(PigeonEntity entity) {
        return TEXTURE;
    }
}