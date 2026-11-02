package com.supermartijn642.rechiseled.screen.preview;

import net.minecraft.resources.ResourceLocation;

public enum PreviewMode {
    PANEL("icon_3x3.png"),
    ROW("icon_3x1.png"),
    SINGLE("icon_1x1.png");

    private final ResourceLocation icon;
    PreviewMode(String name) {
        this.icon = new ResourceLocation("rechiseled", "textures/screen/" + name);
    }
    public ResourceLocation icon(boolean selected) {
        return icon;
    }
}
