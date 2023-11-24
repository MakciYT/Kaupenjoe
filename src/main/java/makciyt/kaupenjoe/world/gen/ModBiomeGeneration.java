package makciyt.kaupenjoe.world.gen;

import makciyt.kaupenjoe.world.biome.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class ModBiomeGeneration {
    //weight - размер биома, размеры тут какие то странные:
    //1 = 300-400 блоков в длину/ширину, 20 = 650-800 блоков в длину/ширину, 5000 = 2500 блоков в длину/ширину
    public static void generateBiomes() {
        addBiome(ModBiomes.RIFT_BIOME.get(), BiomeManager.BiomeType.WARM, 20, HOT, DEAD, DRY);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}