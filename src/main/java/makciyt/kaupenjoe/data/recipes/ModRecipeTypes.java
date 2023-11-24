package makciyt.kaupenjoe.data.recipes;

import makciyt.kaupenjoe.Kaupenjoe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Kaupenjoe.MOD_ID);
    public static final RegistryObject<LightningChannelerRecipe.Serializer> LIGHTNING_SERIALIZER
            = RECIPE_SERIALIZER.register("lightning", LightningChannelerRecipe.Serializer::new);

    public static IRecipeType<LightningChannelerRecipe> LIGHTNING_RECIPE = new LightningChannelerRecipe.LightningRecipeType();

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
        Registry.register(Registry.RECIPE_TYPE, LightningChannelerRecipe.TYPE_ID, LIGHTNING_RECIPE);
    }
}