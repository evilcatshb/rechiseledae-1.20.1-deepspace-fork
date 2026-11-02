package com.supermartijn642.rechiseled.ae;

import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.rechiseled.api.blocks.BlockModelType;
import com.supermartijn642.rechiseled.api.blocks.BlockSpecification;
import com.supermartijn642.rechiseled.api.blocks.RechiseledBlockBuilder;
import com.supermartijn642.rechiseled.api.blocks.RechiseledBlockType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Compatibility adapter for the Rechiseled 1.1.6 block-builder API.
 *
 * The upstream 1.0.1 Rechiseled: AE2 source was written against the
 * post-1.1.6 API. 1.1.6 supports full regular/connecting blocks only;
 * stair/slab builder operations are intentionally unsupported and are not exposed by this adapter.
 */
public final class RechiseledAEBlockCompatBuilder implements RechiseledBlockBuilder {
    private final RechiseledBlockBuilder delegate;

    public RechiseledAEBlockCompatBuilder(RechiseledBlockBuilder delegate) {
        this.delegate = delegate;
    }

    public RechiseledAEBlockCompatBuilder configure(Consumer<RechiseledAEBlockCompatBuilder> consumer) {
        consumer.accept(this);
        return this;
    }

    public RechiseledAEBlockCompatBuilder itemAndBlockTag(ResourceLocation id) {
        return blockTag(id);
    }

    public RechiseledAEBlockCompatBuilder blockTag(ResourceLocation id) {
        delegate.blockTag(id.getNamespace(), id.getPath());
        return this;
    }

    public RechiseledAEBlockCompatBuilder regularVariant(Supplier<Block> block, Supplier<Block> stairs, Supplier<Block> slab) {
        delegate.regularVariant(block);
        return this;
    }

    @Override public RechiseledAEBlockCompatBuilder properties(BlockProperties p) { delegate.properties(p); return this; }
    @Override public RechiseledAEBlockCompatBuilder copyProperties(Supplier<Block> b) { delegate.copyProperties(b); return this; }
    @Override public RechiseledAEBlockCompatBuilder properties(Consumer<BlockProperties> c) {
        BlockProperties p = BlockProperties.create();
        c.accept(p);
        delegate.properties(p);
        return this;
    }
    @Override public RechiseledAEBlockCompatBuilder itemGroups(CreativeModeTab g, CreativeModeTab... gs) { delegate.itemGroups(g, gs); return this; }
    @Override public RechiseledAEBlockCompatBuilder specification(BlockSpecification s) { delegate.specification(s); return this; }
    @Override public RechiseledAEBlockCompatBuilder noRegularVariant() { delegate.noRegularVariant(); return this; }
    @Override public RechiseledAEBlockCompatBuilder noConnectingVariant() { delegate.noConnectingVariant(); return this; }
    @Override public RechiseledAEBlockCompatBuilder regularVariant(Supplier<Block> b) { delegate.regularVariant(b); return this; }
    @Override public RechiseledAEBlockCompatBuilder connectingVariant(Supplier<Block> b) { delegate.connectingVariant(b); return this; }
    @Override public RechiseledAEBlockCompatBuilder recipe(ResourceLocation r) { delegate.recipe(r); return this; }
    @Override public RechiseledAEBlockCompatBuilder blockTag(String n, String i) { delegate.blockTag(n, i); return this; }
    @Override public RechiseledAEBlockCompatBuilder miningTagsFrom(Supplier<Block> b) { delegate.miningTagsFrom(b); return this; }
    @Override public RechiseledAEBlockCompatBuilder translation(String t) { delegate.translation(t); return this; }
    @Override public RechiseledAEBlockCompatBuilder model(BlockModelType m) { delegate.model(m); return this; }
    @Override public RechiseledBlockType build() { return delegate.build(); }
}
