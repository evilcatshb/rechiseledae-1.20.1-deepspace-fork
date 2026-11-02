package com.supermartijn642.rechiseled.screen.preview;

import com.mojang.blaze3d.vertex.PoseStack;

public final class ScreenBlockRenderer {
    private ScreenBlockRenderer() {}
    public static void drawBlock(PoseStack poseStack, BlockCapture capture, double x, double y, double scale, float yaw, float pitch, boolean doShading) {
        com.supermartijn642.rechiseled.screen.ScreenBlockRenderer.drawBlock(poseStack, capture, x, y, scale, yaw, pitch, doShading);
    }
}
