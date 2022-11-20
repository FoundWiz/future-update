package net.foundwiz.notreepunching.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;
import java.util.List;

@Mod.EventBusSubscriber
public class CommonConfig {
    public static final ForgeConfigSpec COMMON_CONFIG;
    private static final Builder COMMON_BUILDER = new Builder();

    public static ForgeConfigSpec.BooleanValue MAKE_GROUND_BLOCKS_HARDER;
    public static ForgeConfigSpec.BooleanValue SHOW_BREAKING_HELP;

    static {
        init();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

    private static void init() {
        String CATEGORY_GENERAL = "general";
        COMMON_BUILDER.comment("Miscellaneous").push(CATEGORY_GENERAL);

        MAKE_GROUND_BLOCKS_HARDER = COMMON_BUILDER.comment("Setting this to true will make ground blocks (e.g. sand, dirt, gravel) harder to break without the correct tool.").define("makeGroundBlocksHarder", true);
        SHOW_BREAKING_HELP = COMMON_BUILDER.comment("Setting this to true will let players know that they can't break certain blocks without a certain tool").define("showToolHelp", true);
        COMMON_BUILDER.pop();
    }
}