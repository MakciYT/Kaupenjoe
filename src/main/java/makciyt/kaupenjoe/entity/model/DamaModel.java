package makciyt.kaupenjoe.entity.model;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.DamaEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class DamaModel extends AnimatedGeoModel<DamaEntity> {

    @Override
    public ResourceLocation getModelLocation(DamaEntity object) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "geo/dama.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DamaEntity object) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "textures/entity/dama/dama.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DamaEntity animatable) {
        return new ResourceLocation(Kaupenjoe.MOD_ID, "animations/dama.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(DamaEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        IBone right_arm = this.getAnimationProcessor().getBone("rightarm");
        IBone left_arm = this.getAnimationProcessor().getBone("leftarm");
        IBone right_leg = this.getAnimationProcessor().getBone("rightleg");
        IBone left_leg = this.getAnimationProcessor().getBone("leftleg");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        right_arm.setRotationX(MathHelper.cos(customPredicate.getLimbSwing() * 0.6662F + (float) Math.PI)
                * 2.0F * customPredicate.getLimbSwingAmount() * 0.5F);
        left_arm.setRotationX(MathHelper.cos(customPredicate.getLimbSwing() * 0.6662F)
                * 2.0F * customPredicate.getLimbSwingAmount() * 0.5F);
        right_leg.setRotationX(MathHelper.cos(customPredicate.getLimbSwing() * 0.6662F)
                * 1.4F * customPredicate.getLimbSwingAmount());
        left_leg.setRotationX(MathHelper.cos(customPredicate.getLimbSwing() * 0.6662F + (float) Math.PI)
                * 1.4F * customPredicate.getLimbSwingAmount());
    }
}
