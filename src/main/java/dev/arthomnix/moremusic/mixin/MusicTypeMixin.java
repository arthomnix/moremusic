package dev.arthomnix.moremusic.mixin;

import dev.arthomnix.moremusic.MoreMusicPreLaunchEntryPoint;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.MusicType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// so it turns out mcdev really doesn't like new object redirects
@SuppressWarnings({"InvalidInjectorMethodSignature", "MixinAnnotationTarget", "UnresolvedMixinReference"})
@Environment(EnvType.CLIENT)
@Mixin(MusicType.class)
public class MusicTypeMixin {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/sound/MusicSound;", ordinal = 0))
    private static MusicSound modifyMenuDelays(RegistryEntry<SoundEvent> sound, int minDelay, int maxDelay, boolean replaceCurrentMusic) {
        return new MusicSound(
                sound,
                MoreMusicPreLaunchEntryPoint.config.menuDelays.minDelay,
                MoreMusicPreLaunchEntryPoint.config.menuDelays.maxDelay,
                replaceCurrentMusic
        );
    }

    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/sound/MusicSound;", ordinal = 1))
    private static MusicSound modifyCreativeDelays(RegistryEntry<SoundEvent> sound, int minDelay, int maxDelay, boolean replaceCurrentMusic) {
        return new MusicSound(
                sound,
                MoreMusicPreLaunchEntryPoint.config.creativeGameplayDelays.minDelay,
                MoreMusicPreLaunchEntryPoint.config.creativeGameplayDelays.maxDelay,
                replaceCurrentMusic
        );
    }

    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/sound/MusicSound;", ordinal = 4))
    private static MusicSound modifyEndDelays(RegistryEntry<SoundEvent> sound, int minDelay, int maxDelay, boolean replaceCurrentMusic) {
        return new MusicSound(
                sound,
                MoreMusicPreLaunchEntryPoint.config.endGameplayDelays.minDelay,
                MoreMusicPreLaunchEntryPoint.config.endGameplayDelays.maxDelay,
                replaceCurrentMusic
        );
    }

    @Redirect(method = "createIngameMusic", at = @At(value = "NEW", target = "Lnet/minecraft/sound/MusicSound;"))
    private static MusicSound modifyIngameMusicDelays(RegistryEntry<SoundEvent> sound, int minDelay, int maxDelay, boolean replaceCurrentMusic) {
        return new MusicSound(
                sound,
                MoreMusicPreLaunchEntryPoint.config.normalGameplayDelays.minDelay,
                MoreMusicPreLaunchEntryPoint.config.normalGameplayDelays.maxDelay,
                replaceCurrentMusic
        );
    }
}