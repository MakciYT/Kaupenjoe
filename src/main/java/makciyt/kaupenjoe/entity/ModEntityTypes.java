package makciyt.kaupenjoe.entity;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.entity.custom.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, Kaupenjoe.MOD_ID);

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFF_ZOMBIE =
            ENTITY_TYPES.register("buff_zombie",
                    () -> EntityType.Builder.create(BuffZombieEntity::new,
                                    EntityClassification.MONSTER).size(1f, 3f)
                            .build(new ResourceLocation(Kaupenjoe.MOD_ID, "buff_zombie").toString()));

    public static final RegistryObject<EntityType<PigeonEntity>> PIGEON =
            ENTITY_TYPES.register("pigeon",
                    () -> EntityType.Builder.create(PigeonEntity::new,
                                    EntityClassification.CREATURE).size(0.4f, 0.3f)
                            .build(new ResourceLocation(Kaupenjoe.MOD_ID, "pigeon").toString()));

    public static final RegistryObject<EntityType<DamirEntity>> DAMIR =
            ENTITY_TYPES.register("damir",
                    () -> EntityType.Builder.create(DamirEntity::new,
                                    EntityClassification.CREATURE).size(1.2f, 3.4f)
                            .build(new ResourceLocation(Kaupenjoe.MOD_ID, "damir").toString()));

    public static final RegistryObject<EntityType<ModBoatEntity>> REDWOOD_BOAT =
            ENTITY_TYPES.register("redwood_boat",
                    () -> EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new,
                                    EntityClassification.CREATURE).size(1.375F, 0.5625F)
                            .build(new ResourceLocation(Kaupenjoe.MOD_ID, "redwood_boat").toString()));

    public static final RegistryObject<EntityType<RaccoonEntity>> RACCOON =
            ENTITY_TYPES.register("raccoon",
                    () -> EntityType.Builder.create(RaccoonEntity::new, EntityClassification.CREATURE)
                            .size(0.8f, 0.6f)
                            .build(new ResourceLocation(Kaupenjoe.MOD_ID, "raccoon").toString()));

    public static final RegistryObject<EntityType<DamaEntity>> DAMA =
            ENTITY_TYPES.register("dama",
                    () -> EntityType.Builder.create(DamaEntity::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.8f)
                            .build(new ResourceLocation(Kaupenjoe.MOD_ID, "dama").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}