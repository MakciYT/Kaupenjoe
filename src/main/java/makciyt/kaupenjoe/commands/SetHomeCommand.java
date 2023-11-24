package makciyt.kaupenjoe.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import makciyt.kaupenjoe.Kaupenjoe;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set")
                .executes(command -> setHome(command.getSource()))));
    }
    private int setHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        BlockPos playerPos = player.getPosition();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";
        player.getPersistentData().putIntArray(Kaupenjoe.MOD_ID+"homepos",
                new int[] { playerPos.getX(), playerPos.getY(), playerPos.getZ() });
        source.sendFeedback(new StringTextComponent(new TranslationTextComponent("command.kaupenjoe.sethome_feedback").getString()+pos),true);
        return 1;
    }
}