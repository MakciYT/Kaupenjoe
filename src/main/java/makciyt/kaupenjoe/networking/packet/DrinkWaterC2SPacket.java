package makciyt.kaupenjoe.networking.packet;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

//C2S - Client to Server
public class DrinkWaterC2SPacket {
    private static final String MESSAGE_DRINK_WATER = "message.kaupenjoe.drink_water";
    private static final String MESSAGE_NO_WATER = "message.kaupenjoe.no_water";

    public DrinkWaterC2SPacket() {

    }

    public DrinkWaterC2SPacket(PacketBuffer buf) {

    }

    public void toBytes(PacketBuffer buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayerEntity player = context.getSender();
            ServerWorld level = player.getServerWorld();

            if(hasWaterAroundThem(player, level, 2)) {
                // Notify the player that water has been drunk
                player.sendStatusMessage(new TranslationTextComponent(MESSAGE_DRINK_WATER).mergeStyle(TextFormatting.DARK_AQUA), false);
                // play the drinking sound
                level.playSound(null, player.getPosition(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                        0.5F, level.rand.nextFloat() * 0.1F + 0.9F);

                // increase the water level / thirst level of player
                // Output the current thirst level

            } else {
                // Notify the player that there is no water around!
                player.sendStatusMessage(new TranslationTextComponent(MESSAGE_NO_WATER).mergeStyle(TextFormatting.RED), false);
                // Output the current thirst level
            }
        });
        return true;
    }

    private boolean hasWaterAroundThem(ServerPlayerEntity player, ServerWorld level, double size) {
        //AABB is the bounding box
        return level.getStatesInArea(player.getBoundingBox().grow(size))
                .filter(state -> state.matchesBlock(Blocks.WATER)).toArray().length > 0;
    }
}
