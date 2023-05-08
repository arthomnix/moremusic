package dev.arthomnix.moremusic.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "moremusic")
@Config.Gui.Background("minecraft:textures/block/note_block.png")
public class MoreMusicConfig implements ConfigData {
    public static class MusicDelays {
        @ConfigEntry.Gui.Tooltip
        public int minDelay = 20;

        @ConfigEntry.Gui.Tooltip
        public int maxDelay = 40;
    }

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public MusicDelays menuDelays = new MusicDelays();

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public MusicDelays normalGameplayDelays = new MusicDelays();

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public MusicDelays creativeGameplayDelays = new MusicDelays();

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public MusicDelays endGameplayDelays = new MusicDelays();
}