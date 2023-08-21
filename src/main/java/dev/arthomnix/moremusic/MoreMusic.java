package dev.arthomnix.moremusic;

import dev.arthomnix.moremusic.config.MoreMusicConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.option.SoundOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;

import java.util.List;

public class MoreMusic implements ModInitializer {
    @Override
    public void onInitialize() {
        ScreenEvents.AFTER_INIT.register(((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof SoundOptionsScreen) {
                List<ClickableWidget> buttons = Screens.getButtons(screen);
                ClickableWidget doneButton = buttons.get(0);
                doneButton.setX(50);
                doneButton.setWidth((screen.width - 150) / 2);

                ButtonWidget openMoreMusicOptionsButton = ButtonWidget.builder(
                        Text.translatable("text.moremusic.button.open_config"),
                        button -> client.setScreenAndRender(AutoConfig.getConfigScreen(MoreMusicConfig.class, screen).get())
                ).dimensions(
                        doneButton.getX() + doneButton.getWidth() + 50,
                        doneButton.getY(),
                        doneButton.getWidth(),
                        doneButton.getHeight()
                ).build();

                buttons.add(openMoreMusicOptionsButton);
            }
        }));
    }
}
