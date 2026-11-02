package com.supermartijn642.rechiseled.api.chiseling;

import com.supermartijn642.rechiseled.chiseling.ChiselingRecipes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.IdentityHashMap;
import java.util.Map;

public final class ChiselingRecipeManager {
    private static final ChiselingRecipeManager INSTANCE=new ChiselingRecipeManager();
    private final Map<com.supermartijn642.rechiseled.chiseling.ChiselingRecipe,ChiselingRecipe> cache=new IdentityHashMap<>();
    private ChiselingRecipeManager(){}
    public static ChiselingRecipeManager get(Level level){return INSTANCE;}
    public static ChiselingRecipeManager get(boolean client){return INSTANCE;}
    public ChiselingRecipe getRecipeForItem(Item item){
        if(item==null)return null;
        var recipe=ChiselingRecipes.getRecipe(new ItemStack(item));
        return recipe==null?null:cache.computeIfAbsent(recipe,ChiselingRecipe::new);
    }
}
