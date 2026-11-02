package com.supermartijn642.rechiseled.ae;

import com.supermartijn642.core.registry.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import java.util.function.Supplier;
import static com.supermartijn642.rechiseled.ae.RechiseledAE.REGISTRATION;

public class RechiseledAERecipes {
    public static final ResourceLocation CERTUS_QUARTZ_BLOCK = location("certus_quartz_block");
    public static final ResourceLocation FLUIX_BLOCK = location("fluix_block");
    public static final ResourceLocation SKY_STONE_BLOCK = location("sky_stone_block");

    private static ResourceLocation location(String name) {
        return new ResourceLocation(RechiseledAE.MODID, name);
    }

    private static Supplier<ItemLike> getBlock(String identifier) {
        ResourceLocation location = new ResourceLocation(identifier);
        return () -> {
            if (!Registries.BLOCKS.hasIdentifier(location))
                throw new RuntimeException("Unknown block '" + identifier + "'!");
            return Registries.BLOCKS.getValue(location);
        };
    }

    public static void init() {
        // Rechiseled 1.1.6 has regular/connecting block entries only.
        regularSet(CERTUS_QUARTZ_BLOCK, "ae2:quartz_block", "ae2:quartz_block");
        regularSet(CERTUS_QUARTZ_BLOCK, "ae2:smooth_quartz_block", "ae2:smooth_quartz_block");
        regularSet(CERTUS_QUARTZ_BLOCK, "ae2:chiseled_quartz_block", "ae2:chiseled_quartz_block");
        regularSet(SKY_STONE_BLOCK, "ae2:sky_stone_block", "ae2:sky_stone_block");
        regularSet(SKY_STONE_BLOCK, "ae2:sky_stone_small_brick", "ae2:sky_stone_small_brick");
    }

    private static void regularSet(ResourceLocation recipe, String regularIdentifier, String connectingIdentifier) {
        Supplier<ItemLike> regular = getBlock(regularIdentifier);
        Supplier<ItemLike> connecting = getBlock(connectingIdentifier);
        REGISTRATION.chiselingEntry(recipe, regular, connecting);
    }
}
