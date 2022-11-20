package net.foundwiz.notreepunching.common;

import com.google.common.collect.Lists;
import net.foundwiz.notreepunching.common.data.damageitem.DamageItemRecipeSerializer;
import net.foundwiz.notreepunching.common.data.damageitem.DamageItemRecipeType;
import net.foundwiz.notreepunching.common.utils.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class Registry {
    public final DeferredRegister<RecipeType<?>> RecipeTypeRegistry = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Constants.MOD_ID);
    public final DeferredRegister<RecipeSerializer<?>> SerializerRegistry = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Constants.MOD_ID);

    public final DeferredRegister<Feature<?>> FeatureRegistry = DeferredRegister.create(net.minecraft.core.Registry.FEATURE_REGISTRY, Constants.MOD_ID);
    public final DeferredRegister<ConfiguredFeature<?, ?>> ConfiguredFeatureRegistry = DeferredRegister.create(net.minecraft.core.Registry.CONFIGURED_FEATURE_REGISTRY, Constants.MOD_ID);
    public final DeferredRegister<PlacedFeature> PlacedFeatureRegistry = DeferredRegister.create(net.minecraft.core.Registry.PLACED_FEATURE_REGISTRY, Constants.MOD_ID);


    public Registry() {
        RegisterRecipeStuff();
    }

    public void RegisterAll(FMLJavaModLoadingContext ctx) {
        RecipeTypeRegistry.register(ctx.getModEventBus());
        SerializerRegistry.register(ctx.getModEventBus());
        FeatureRegistry.register(ctx.getModEventBus());
        ConfiguredFeatureRegistry.register(ctx.getModEventBus());
    }

    public void RegisterRecipeStuff() {
        SerializerRegistry.register("damage_tools", DamageItemRecipeSerializer::new);
        RecipeTypeRegistry.register("damage_tools", DamageItemRecipeType::new);
    }
}
