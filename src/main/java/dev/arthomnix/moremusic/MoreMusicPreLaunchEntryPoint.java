package dev.arthomnix.moremusic;

import dev.arthomnix.moremusic.config.MoreMusicConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class MoreMusicPreLaunchEntryPoint implements PreLaunchEntrypoint {
    public static MoreMusicConfig config;

    @Override
    public void onPreLaunch() {
        config = AutoConfig.register(MoreMusicConfig.class, GsonConfigSerializer::new).getConfig();
    }
}