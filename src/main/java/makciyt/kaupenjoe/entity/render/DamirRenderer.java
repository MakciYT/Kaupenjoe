package makciyt.kaupenjoe.entity.render;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.DamirEntity;
import makciyt.kaupenjoe.entity.model.DamirModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DamirRenderer extends MobRenderer<DamirEntity, DamirModel<DamirEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/damir.png");

    public DamirRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DamirModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(DamirEntity entity) {
        return TEXTURE;
    }
}