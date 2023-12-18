package makciyt.kaupenjoe.events;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.commands.ReturnHomeCommand;
import makciyt.kaupenjoe.commands.SetHomeCommand;
import makciyt.kaupenjoe.networking.ModMessages;
import makciyt.kaupenjoe.networking.packet.DrinkWaterC2SPacket;
import makciyt.kaupenjoe.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Kaupenjoe.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getEntityWorld().isRemote()) {
            event.getPlayer().getPersistentData().putIntArray(Kaupenjoe.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(Kaupenjoe.MOD_ID + "homepos"));
        }
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBinding.DRINKING_KEY.isPressed()) {
            ModMessages.sendToServer(new DrinkWaterC2SPacket());
        }
    }
}