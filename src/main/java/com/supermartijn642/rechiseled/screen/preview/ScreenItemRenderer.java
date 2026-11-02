package com.supermartijn642.rechiseled.screen.preview;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.Item;

public final class ScreenItemRenderer {
    private ScreenItemRenderer() {}
    public static void drawItem(PoseStack poseStack, Item item, double x, double y, double scale, float yaw, float pitch, boolean doShading) {
        com.supermartijn642.rechiseled.screen.ScreenItemRender.drawItem(poseStack, item, x, y, scale, yaw, pitch, doShading);
    }
}
