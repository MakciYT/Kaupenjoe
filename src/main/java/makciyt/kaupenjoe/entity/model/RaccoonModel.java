package makciyt.kaupenjoe.entity.model;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.RaccoonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RaccoonModel extends AnimatedGeoModel<RaccoonEntity> {
    @Override
    public ResourceLocation getModelLocation(RaccoonEntity object) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RaccoonEntity object) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RaccoonEntity animatable) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "animations/raccoon.animation.json");
    }
}
