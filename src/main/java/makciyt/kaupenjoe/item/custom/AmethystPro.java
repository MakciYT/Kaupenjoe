package makciyt.kaupenjoe.item.custom;

import makciyt.kaupenjoe.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

public class AmethystPro extends Item {
    public AmethystPro(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getPos()).getBlock();
        if(block == ModBlocks.AMETHYST_ORE.get()) {
            world.destroyBlock(context.getPos(), false);
            world.setBlockState(context.getPos(), ModBlocks.AMETHYST_BLOCK.get().getDefaultState());
        }
        context.getPlayer().inventory.add(39, ModBlocks.AMETHYST_BLOCK.get().asItem().getDefaultInstance());
        return super.onItemUseFirst(stack, context);
    }
}