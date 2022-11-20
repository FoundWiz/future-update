package net.foundwiz.notreepunching.common.utils;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Constants {
    public static final String MOD_ID = "notreepunching";
    public static final String MODNAME = "No Tree Punching (No Additional Features)";

    public static final TagKey<Item> OVERRIDE_PICKAXES = ItemTags
            .create(new ResourceLocation(MOD_ID, "override_pickaxes"));
    public static final TagKey<Item> OVERRIDE_AXES = ItemTags
            .create(new ResourceLocation(MOD_ID, "override_axes"));
    public static final TagKey<Block> IGNORED_WOOD_BLOCKS = BlockTags
            .create(new ResourceLocation(MOD_ID, "ignored_wood_blocks"));
    public static final TagKey<Block> IGNORED_STONE_BLOCKS = BlockTags
            .create(new ResourceLocation(MOD_ID, "ignored_stone_blocks"));
}
