package an.opensauce.armourweight.mixin;


import an.opensauce.armourweight.util.Config;
import an.opensauce.armourweight.util.WeightUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;




@Mixin(InGameHud.class)
public abstract class HudMixin {

    @Shadow @Final private static Identifier ICONS;
    @Shadow
    private MinecraftClient client;
    @Shadow
    private int scaledHeight;
    @Shadow
    private int scaledWidth;


    //static Identifier ICONS_TEXTURE = new Identifier("minecraft","textures/gui/icons.png"); // By pure dumb luck I somehow managed to have a mixin conflict with this
    @Inject(method = "render",at = @At("TAIL"))
    public void renderWeightBar(DrawContext context, float tickDelta, CallbackInfo ci){
        if(!Config.GetData().weightbar) { return; }
        float f = WeightUtil.CalculateWeight(MinecraftClient.getInstance().player);
      if(f > 0) {
          int i = 182;
          int x = this.scaledWidth / 2 - 91;
          int j = (int) (f * 18.0f);
          int k = this.scaledHeight - 32 + 3;
          k -= 26;

          context.drawTexture(ICONS, x, k, 0, 84, 80, 5);
          if (0 > 0) {
              context.drawTexture(ICONS, x, k, 0, 74, 80, 5);
          } else if (j > 0) {
              context.drawTexture(ICONS, x, k, 0, 89, j / 2, 5);
          }
      }
    }

    @Shadow
    public TextRenderer getTextRenderer() {
        return this.client.textRenderer;
    }

}
