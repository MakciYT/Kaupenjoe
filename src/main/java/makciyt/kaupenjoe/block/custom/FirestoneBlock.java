package makciyt.kaupenjoe.block.custom;

import makciyt.kaupenjoe.item.custom.Firestone;
import makciyt.kaupenjoe.util.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class FirestoneBlock extends Block {
    public FirestoneBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            if(handIn == Hand.MAIN_HAND) {
                System.out.println("I right-clicked a FirestoneBlock. Called for the Main Hand!");
                //1 параметр - игроки которые услышат звук, он очень странный
                //В данном случае звук идет от игрока и его слышат другие БЛИЖАйШИЕ игроки и сам игрок,
                //причем громкость не утихает от дальности игрока и на 16 блоке его резко становиться не слышно.
                //null потому что другие не работают, кроме Minecraft.getInstance().player но результат тот же, и еще есть play(),
                //который дальше закомментирован, там звук слышит только админ сервера, это не означает что это для клиента
                //"player.getPosition()" это то откуда идет звук, в данном случае из игрока, можно например указать из блока: "pos"
                //soundcategory отвечает за те самые настройки музыки и звука
                //(при MASTER слышно если настройка главной громкости не на нуле, при BLOCKS - если настройка громкости блоков не на нуле)
                //volume от 0 до 1, float числа работают
                //pitch от 0 до 2, float числа хз, где то слышу разницу, где то нет, но врят ли тебе они нужны
                worldIn.playSound(null, player.getPosition(), ModSoundEvents.SMALL_EXPLOSION.get(),
                        SoundCategory.BLOCKS, 1, 1);
                //Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(ModSoundEvents.SMALL_EXPLOSION.get(), 1.0F));
            }
            if(handIn == Hand.OFF_HAND) {
                System.out.println("I right-clicked a FirestoneBlock. Called for the Off Hand!");
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        float chance = 0.35f;
        if(chance < rand.nextFloat()) {
            worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0d,0.05d,0d);

            worldIn.addParticle(new BlockParticleData(ParticleTypes.BLOCK, stateIn), pos.getX() + rand.nextDouble(),
                    pos.getY() + 1d, pos.getZ() + rand.nextDouble(),
                    0.0D, 0.2D, 0.0D);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote()) {
            System.out.println("I left-clicked a FirestoneBlock");
        }
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn, 5);
    }
}