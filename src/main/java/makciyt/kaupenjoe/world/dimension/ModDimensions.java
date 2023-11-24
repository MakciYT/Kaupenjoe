package makciyt.kaupenjoe.world.dimension;

import makciyt.kaupenjoe.Kaupenjoe;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static RegistryKey<World> KJDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(Kaupenjoe.MOD_ID, "kjdim"));
}
