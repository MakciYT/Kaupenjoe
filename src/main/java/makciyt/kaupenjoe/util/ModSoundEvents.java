package makciyt.kaupenjoe.util;

import makciyt.kaupenjoe.Kaupenjoe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Kaupenjoe.MOD_ID);

    public static final RegistryObject<SoundEvent> SMALL_EXPLOSION = registerSoundEvent("small_explosion");

    public static final RegistryObject<SoundEvent> DAMIR_AMBIENT = registerSoundEvent("damir.ambient");
    public static final RegistryObject<SoundEvent> DAMIR_DEATH = registerSoundEvent("damir.death");
    public static final RegistryObject<SoundEvent> DAMIR_HURT = registerSoundEvent("damir.hurt");
    public static final RegistryObject<SoundEvent> DAMIR_FART = registerSoundEvent("damir.fart");
    public static final RegistryObject<SoundEvent> PIMPLE_POTION = registerSoundEvent("pimple_potion");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Kaupenjoe.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
