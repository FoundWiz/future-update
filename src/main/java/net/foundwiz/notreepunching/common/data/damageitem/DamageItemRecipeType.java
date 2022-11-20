package net.foundwiz.notreepunching.common.data.damageitem;

import net.foundwiz.notreepunching.common.utils.Constants;
import net.minecraft.world.item.crafting.RecipeType;

public class DamageItemRecipeType implements RecipeType<DamageItemRecipe>{
    @Override
    public String toString() {
        return Constants.MOD_ID + ":damage_tools";
    }
}
