package com.supermartijn642.rechiseled.api.chiseling;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ChiselingRecipe {
    private final com.supermartijn642.rechiseled.chiseling.ChiselingRecipe delegate;
    private final List<ChiselingEntry> entries;
    ChiselingRecipe(com.supermartijn642.rechiseled.chiseling.ChiselingRecipe delegate) {
        this.delegate=delegate;
        List<ChiselingEntry> wrapped=new ArrayList<>();
        for (var entry:delegate.getEntries()) wrapped.add(new ChiselingEntry(entry,this));
        this.entries=Collections.unmodifiableList(wrapped);
    }
    public List<ChiselingEntry> entries(){return entries;}
    public List<ChiselingEntry> getEntries(){return entries;}
    public boolean contains(Item item){return entries.stream().anyMatch(e->e.contains(item));}
    public boolean contains(ItemStack stack){return delegate.contains(stack);}
    public ItemWithWorth getWorth(Item item){return contains(item)?new ItemWithWorth(item,1.0):null;}
    public ResourceLocation recipe(){return delegate.getRecipeId();}
    public ResourceLocation owner(){return new ResourceLocation("rechiseled","builtin");}
}
