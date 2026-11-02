package com.supermartijn642.rechiseled.api.chiseling;

import net.minecraft.world.item.Item;

public final class ChiselingEntry {
    private final com.supermartijn642.rechiseled.chiseling.ChiselingEntry delegate;
    private final ChiselingRecipe recipe;
    ChiselingEntry(com.supermartijn642.rechiseled.chiseling.ChiselingEntry delegate, ChiselingRecipe recipe) { this.delegate=delegate; this.recipe=recipe; }
    public boolean hasShape(ChiselingBlockShape shape) { return shape==ChiselingBlockShape.BLOCK && (hasRegularItem(shape)||hasConnectingItem(shape)); }
    public boolean hasRegularItem(ChiselingBlockShape shape) { return shape==ChiselingBlockShape.BLOCK && delegate.hasRegularItem(); }
    public boolean hasConnectingItem(ChiselingBlockShape shape) { return shape==ChiselingBlockShape.BLOCK && delegate.hasConnectingItem(); }
    public ItemWithWorth getRegularItem(ChiselingBlockShape shape) { return hasRegularItem(shape)?new ItemWithWorth(delegate.getRegularItem(),1.0):null; }
    public ItemWithWorth getConnectingItem(ChiselingBlockShape shape) { return hasConnectingItem(shape)?new ItemWithWorth(delegate.getConnectingItem(),1.0):null; }
    public boolean contains(Item item) { return (delegate.hasRegularItem()&&delegate.getRegularItem()==item)||(delegate.hasConnectingItem()&&delegate.getConnectingItem()==item); }
    public Item getRegularItem() { return delegate.getRegularItem(); }
    public Item getConnectingItem() { return delegate.getConnectingItem(); }
    public net.minecraft.resources.ResourceLocation recipe() { return recipe.recipe(); }
}
