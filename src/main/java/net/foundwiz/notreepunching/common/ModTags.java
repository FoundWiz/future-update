package net.foundwiz.notreepunching.common;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.foundwiz.notreepunching.NoTreePunching;

public class ModTags {
    public static final TagKey<Block> NEEDS_FLINT_TOOL = modBlockTag("needs_flint_tool");
    public static final TagKey<Block> WOODS = modBlockTag("woods");

    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(NoTreePunching.MOD_ID + ":" + path));
    }
}
