package makciyt.kaupenjoe.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class GMDOruzhieItem extends SwordItem {
    public GMDOruzhieItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200, 2));
        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 200));
        return super.hitEntity(stack, target, attacker);
    }
}
