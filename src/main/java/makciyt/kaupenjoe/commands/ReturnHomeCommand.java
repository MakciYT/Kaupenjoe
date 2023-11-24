package makciyt.kaupenjoe.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import makciyt.kaupenjoe.Kaupenjoe;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return")
                .executes(command -> returnHome(command.getSource()))));
    }
    private int returnHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray(Kaupenjoe.MOD_ID+"homepos").length != 0;
        if(hasHomepos) {
            int[] playerPos = player.getPersistentData().getIntArray(Kaupenjoe.MOD_ID+"homepos");
            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

            source.sendFeedback(new TranslationTextComponent("command.kaupenjoe.returnhome_success"), true);
            return 1;
        } else {
            source.sendFeedback(new TranslationTextComponent("command.kaupenjoe.returnhome_failed"), true);
            return -1;
        }
    }
}
