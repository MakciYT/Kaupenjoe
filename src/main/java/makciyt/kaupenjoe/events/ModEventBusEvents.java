package makciyt.kaupenjoe.events;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.ModEntityTypes;
import makciyt.kaupenjoe.entity.custom.*;
import makciyt.kaupenjoe.events.loot.FirestoneAdditionModifier;
import makciyt.kaupenjoe.events.loot.FirestoneStructureAdditionModifier;
import makciyt.kaupenjoe.item.custom.ModSpawnEggItem;
import makciyt.kaupenjoe.util.KeyBinding;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Kaupenjoe.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.PIGEON.get(), PigeonEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.DAMIR.get(), DamirEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
        event.put(ModEntityTypes.DAMA.get(), DamaEntity.setAttributes());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(new FirestoneAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Kaupenjoe.MOD_ID,"firestone_from_magma")),
                new FirestoneStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Kaupenjoe.MOD_ID,"firestone_in_igloo"))
        );
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyRegister(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(KeyBinding.DRINKING_KEY);
    }
}