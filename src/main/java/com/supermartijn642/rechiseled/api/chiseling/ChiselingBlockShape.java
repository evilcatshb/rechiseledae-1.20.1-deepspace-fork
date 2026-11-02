package com.supermartijn642.rechiseled.api.chiseling;
import net.minecraft.network.chat.Component;
public enum ChiselingBlockShape { BLOCK, STAIRS, SLAB; public Component translation(){ return Component.translatable("rechiseledae.chiseling_pattern_encoder.shape." + name().toLowerCase()); } }
