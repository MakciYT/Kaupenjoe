package makciyt.kaupenjoe.item;

import makciyt.kaupenjoe.Kaupenjoe;
import makciyt.kaupenjoe.block.ModBlocks;
import makciyt.kaupenjoe.entity.ModEntityTypes;
import makciyt.kaupenjoe.fluid.ModFluids;
import makciyt.kaupenjoe.item.custom.*;
import makciyt.kaupenjoe.util.ModSoundEvents;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Kaupenjoe.MOD_ID);
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));
    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Firestone(new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP).maxDamage(8)));
    public static final RegistryObject<Item> AMETHYST_PRO = ITEMS.register("amethyst_pro",
            () -> new AmethystPro(new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModItemTier.AMETHYST, 2, 3f,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(ModItemTier.AMETHYST, 0, -1f,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModItemTier.AMETHYST, 0, -1f,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModItemTier.AMETHYST, 4, -6f,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModItemTier.AMETHYST, 0, 0f,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ModArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));
    public static final RegistryObject<Item> AMETHYST_HORSE_ARMOR = ITEMS.register("amethyst_horse_armor",
            () -> new HorseArmorItem(9, "amethyst",
                    new Item.Properties().maxStackSize(1).group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign",
            () -> new SignItem(new Item.Properties().maxStackSize(16).group(ModItemGroup.KAUPENJOE_GROUP),
                    ModBlocks.REDWOOD_SIGN.get(), ModBlocks.REDWOOD_WALL_SIGN.get()));

    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(() -> ModFluids.OIL_FLUID.get(),
                    new Item.Properties().maxStackSize(1).group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> OATS = ITEMS.register("oats",
            () -> new BlockItem(ModBlocks.OATS.get(), new Item.Properties()
                    .food(new Food.Builder().hunger(1).saturation(0.1f).fastToEat().build())
                    .group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<ModSpawnEggItem> BUFF_ZOMBIE_SPAWN_EGG = ITEMS.register("buff_zombie_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BUFF_ZOMBIE, 0x464F56, 0x1D6336,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<ModSpawnEggItem> PIGEON_SPAWN_EGG = ITEMS.register("pigeon_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.PIGEON, 0x879995, 0x576ABC,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> RACCOON_SPAWN_EGG = ITEMS.register("raccoon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.RACCOON,0x948e8d, 0x3b3635,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> DAMA_SPAWN_EGG = ITEMS.register("dama_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DAMA,0x4f4f4f, 0x00ff37,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> GMD_ORUZHIE = ITEMS.register("gmd_oruzhie",
            () -> new GMDOruzhieItem(ModItemTier.AMETHYST, 2, 3f,
                    new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new BowItem(new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> MUSIC_DISC_PIMPLE_POTION = ITEMS.register("music_disc_pimple_potion",
            () -> new MusicDiscItem(1, () -> ModSoundEvents.PIMPLE_POTION.get(),
                    new Item.Properties().maxStackSize(1).group(ModItemGroup.KAUPENJOE_GROUP)));

    public static final RegistryObject<Item> REDWOOD_BOAT = ITEMS.register("redwood_boat",
            () -> new ModBoatItem(new Item.Properties().group(ModItemGroup.KAUPENJOE_GROUP), "redwood"));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}