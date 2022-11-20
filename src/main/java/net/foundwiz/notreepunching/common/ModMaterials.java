package net.foundwiz.notreepunching.common;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModMaterials {
    public static final ForgeTier FLINT = new ForgeTier(0, 30, 1.0f,
            0.0f, 8, ModTags.NEEDS_FLINT_TOOL,
            () -> Ingredient.of(Items.FLINT));
}
