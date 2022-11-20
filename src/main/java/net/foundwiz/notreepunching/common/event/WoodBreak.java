package net.foundwiz.notreepunching.common.event;

import com.google.common.collect.Lists;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.foundwiz.notreepunching.NoTreePunching;
import net.foundwiz.notreepunching.common.config.CommonConfig;
import net.foundwiz.notreepunching.common.utils.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class WoodBreak {
    @SubscribeEvent
    public void registerEvent(PlayerEvent.BreakSpeed event) {
        final List<Material> hardMaterials = Lists.newArrayList(Material.WOOD, Material.NETHER_WOOD);

        if (event.getState() == null || event.getEntity() == null) {
            return;
        }

        ItemStack heldItem = event.getEntity().getMainHandItem();

        if (!hardMaterials.contains(event.getState().getMaterial())) {
            return;
        }

        if (event.getState().is(Constants.IGNORED_WOOD_BLOCKS)) {
            return;
        }

        if (heldItem.is(Constants.OVERRIDE_AXES)) {
            return;
        }

        if (!heldItem.canPerformAction(ToolActions.AXE_DIG)) {
            event.setCanceled(true);
        }
    }

    @Nullable
    public Entity getDirectEntity() {
        return null;
    }
}