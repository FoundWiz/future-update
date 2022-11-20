package net.foundwiz.notreepunching.common;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.foundwiz.notreepunching.NoTreePunching;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NoTreePunching.MOD_ID);

    public static final RegistryObject<Item> FLINT_HATCHET = ITEMS.register("flint_hatchet",
            () -> new AxeItem(ModMaterials.FLINT, 3, -3.2f,
                    new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
