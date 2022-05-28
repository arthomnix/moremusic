package dev.arthomnix.moremusic.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "moremusic")
@Config.Gui.Background("minecraft:textures/block/note_block.png")
public class MoreMusicConfig implements ConfigData {
    public static class MusicDelays {
        public int minDelay = 20;
        public int maxDelay = 40;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public MusicDelays menuDelays = new MusicDelays();

    @ConfigEntry.Gui.CollapsibleObject
    public MusicDelays normalGameplayDelays = new MusicDelays();

    @ConfigEntry.Gui.CollapsibleObject
    public MusicDelays creativeGameplayDelays = new MusicDelays();

    @ConfigEntry.Gui.CollapsibleObject
    public MusicDelays endGameplayDelays = new MusicDelays();
}