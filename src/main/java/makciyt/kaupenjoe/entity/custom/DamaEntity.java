package makciyt.kaupenjoe.entity.custom;

import makciyt.kaupenjoe.util.ModSoundEvents;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Timer;
import java.util.TimerTask;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class DamaEntity extends MonsterEntity implements IAnimatable {
    public boolean rightClickFlag = false;
    public boolean timerFlag = true;
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public DamaEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap setAttributes() {
        return MonsterEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.1f)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).create();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 2.5D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 3.0D, false));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(!rightClickFlag) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dama.idle", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    //Не getEntityInteractionResult, т.к. там, если держишь яйцо призыва, анимация не работает, и во всех предметах, которые работают на
    //правой кнопке мыши, там громкость пердежа тише, я ваще понятия не имею че это, видимо баги от можангов...
    //Еще в файле с анимацией поле loop бессмысленное, нужно указывать именно здесь.
    //Рассказал че тут происходит в своем очередном txt файле
    @Override
    public ActionResultType applyPlayerInteraction(PlayerEntity player, Vector3d vec, Hand hand) {
        if (timerFlag) {
            timerFlag = false;
            rightClickFlag = true;
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    rightClickFlag = false;
                    timerFlag = true;
                }
            };
            timer.schedule(task, 1160);
        }
        playSound(ModSoundEvents.DAMIR_FART.get(), 1.0F, 1.0F);
        return super.applyPlayerInteraction(player, vec, hand); //без разницы
    }

    private <E extends IAnimatable> PlayState predicate2(AnimationEvent<E> event) {
        if(rightClickFlag) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dama.fart", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
        data.addAnimationController(new AnimationController(this, "controller2", 0, this::predicate2));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected float getSoundPitch() {
        return 1F;
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 3 + this.world.rand.nextInt(5);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.DAMIR_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.DAMIR_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSoundEvents.DAMIR_HURT.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_HOGLIN_STEP, 0.20F, 0.5F);
    }
}
