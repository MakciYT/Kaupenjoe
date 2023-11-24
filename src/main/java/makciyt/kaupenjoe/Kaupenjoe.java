package makciyt.kaupenjoe;

import com.google.common.collect.ImmutableMap;
import makciyt.kaupenjoe.block.ModBlocks;
import makciyt.kaupenjoe.block.ModWoodTypes;
import makciyt.kaupenjoe.container.ModContainers;
import makciyt.kaupenjoe.data.recipes.ModRecipeTypes;
import makciyt.kaupenjoe.entity.ModEntityTypes;
import makciyt.kaupenjoe.entity.render.*;
import makciyt.kaupenjoe.fluid.ModFluids;
import makciyt.kaupenjoe.item.ModItems;
import makciyt.kaupenjoe.paintings.ModPaintings;
import makciyt.kaupenjoe.screen.LightningChannelerScreen;
import makciyt.kaupenjoe.tileentity.ModTileEntities;
import makciyt.kaupenjoe.util.ModItemModelProperties;
import makciyt.kaupenjoe.util.ModSoundEvents;
import makciyt.kaupenjoe.world.biome.ModBiomes;
import makciyt.kaupenjoe.world.gen.ModBiomeGeneration;
import makciyt.kaupenjoe.world.structure.ModStructures;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Kaupenjoe.MOD_ID)
public class Kaupenjoe {
    public static final String MOD_ID = "kaupenjoe";
    private static final Logger LOGGER = LogManager.getLogger();
    public Kaupenjoe() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);
        ModStructures.register(eventBus);
        ModFluids.register(eventBus);
        ModRecipeTypes.register(eventBus);
        ModSoundEvents.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModBiomes.register(eventBus);
        ModPaintings.register(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);
        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                    .put(ModBlocks.REDWOOD_LOG.get(), ModBlocks.STRIPPED_REDWOOD_LOG.get())
                    .put(ModBlocks.REDWOOD_WOOD.get(), ModBlocks.STRIPPED_REDWOOD_WOOD.get()).build();
            ModStructures.setupStructures();
            WoodType.register(ModWoodTypes.REDWOOD);
            ModBiomeGeneration.generateBiomes();
            EntitySpawnPlacementRegistry.register(ModEntityTypes.BUFF_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);
            EntitySpawnPlacementRegistry.register(ModEntityTypes.PIGEON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        });
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.AMETHYST_DOOR.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.AMETHYST_TRAPDOOR.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.OATS.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_LEAVES.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.HYACINTH.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModFluids.OIL_FLUID.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModFluids.OIL_BLOCK.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModFluids.OIL_FLOWING.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.SPEAKER.get(), RenderType.getCutout());
            ScreenManager.registerFactory(ModContainers.LIGHTNING_CHANNELER_CONTAINER.get(),
                    LightningChannelerScreen::new);
            Atlases.addWoodType(ModWoodTypes.REDWOOD);
            ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(), SignTileEntityRenderer::new);
            ModItemModelProperties.makeBow(ModItems.KAUPENBOW.get());
        });
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIGEON.get(), PigeonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DAMIR.get(), DamirRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.REDWOOD_BOAT.get(), ModBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RACCOON.get(), RaccoonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DAMA.get(), DamaRenderer::new);
    }
}