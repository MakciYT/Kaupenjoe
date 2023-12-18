package makciyt.kaupenjoe.util;

import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_TUTORIAL = "key.category.kaupenjoe.tutorial";
    public static final String KEY_DRINK_WATER = "key.kaupenjoe.drink_water";

    public static final net.minecraft.client.settings.KeyBinding DRINKING_KEY = new net.minecraft.client.settings.KeyBinding(KEY_DRINK_WATER,
            KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_Y, KEY_CATEGORY_TUTORIAL);
}