package net.foundwiz.notreepunching;

import com.mojang.logging.LogUtils;
import net.foundwiz.notreepunching.common.ModItems;
import net.foundwiz.notreepunching.common.Registry;
import net.foundwiz.notreepunching.common.config.CommonConfig;
import net.foundwiz.notreepunching.common.event.GroundBreak;
import net.foundwiz.notreepunching.common.event.PlankBreak;
import net.foundwiz.notreepunching.common.event.StoneBreak;
import net.foundwiz.notreepunching.common.event.WoodBreak;
import net.foundwiz.notreepunching.common.utils.Constants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NoTreePunching.MOD_ID)
public class NoTreePunching
{
    private static NoTreePunching instance;
    public org.apache.logging.log4j.Logger LOGGERS = LogManager.getLogger();
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "notreepunching";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public final Registry REGISTRY;

    public NoTreePunching(Registry registry) {
        instance = this;

        REGISTRY = new Registry();
        REGISTRY.RegisterAll(FMLJavaModLoadingContext.get());

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(new StoneBreak());
        MinecraftForge.EVENT_BUS.register(new PlankBreak());
        MinecraftForge.EVENT_BUS.register(new GroundBreak());
        MinecraftForge.EVENT_BUS.register(new WoodBreak());
        ModItems.register(modEventBus);

        this.configSetup();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static NoTreePunching getInstance() {
        return instance;
    }

    private void configSetup() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.COMMON_CONFIG);
        CommonConfig.loadConfig(CommonConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + "-common.toml"));
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
