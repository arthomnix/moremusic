package dev.arthomnix.moremusic.mixin;

import com.mojang.datafixers.Products;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.util.Function4;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.arthomnix.moremusic.MoreMusicPreLaunchEntryPoint;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(MusicSound.class)
public class MusicSoundMixin {
    @Redirect(method = "method_28128", at = @At(value = "INVOKE", target = "Lcom/mojang/datafixers/Products$P4;apply(Lcom/mojang/datafixers/kinds/Applicative;Lcom/mojang/datafixers/util/Function4;)Lcom/mojang/datafixers/kinds/App;"))
    private static App<RecordCodecBuilder.Mu<MusicSound>, MusicSound> modifyDatapackSoundDelays(
            Products.P4<RecordCodecBuilder.Mu<MusicSound>, RegistryEntry<SoundEvent>, Integer, Integer, Boolean> instance,
            Applicative<RecordCodecBuilder.Mu<MusicSound>, ? extends Applicative.Mu> applicative,
            Function4<RegistryEntry<SoundEvent>, Integer, Integer, Boolean, MusicSound> function
    ) {
        return instance.apply(
                applicative,
                (sound, minDelay, maxDelay, replaceCurrentMusic) -> new MusicSound(
                        sound,
                        MoreMusicPreLaunchEntryPoint.config.normalGameplayDelays.minDelay,
                        MoreMusicPreLaunchEntryPoint.config.normalGameplayDelays.maxDelay,
                        replaceCurrentMusic
                )
        );
    }
}
