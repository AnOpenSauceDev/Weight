package an.opensauce.armourweight.mixin;


import an.opensauce.armourweight.util.Config;
import an.opensauce.armourweight.util.WeightUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class HudMixin extends DrawableHelper {

    @Shadow
    private MinecraftClient client;
    @Shadow
    private int scaledHeight;
    @Shadow
    private int scaledWidth;

    @Inject(method = "render",at = @At("TAIL"))
    public void renderWeightBar(MatrixStack matrices, float tickDelta, CallbackInfo ci){
        if(!Config.GetData().weightbar) { return; }
        this.client.getProfiler().push("armourbar");
        RenderSystem.setShaderTexture(0, DrawableHelper.GUI_ICONS_TEXTURE);
        //float f = Weight.CalculateWeight(MinecraftClient.getInstance().player); // old method
        float f = WeightUtil.CalculateWeight(MinecraftClient.getInstance().player);
      if(f > 0) {
          int i = 182;
          int x = this.scaledWidth / 2 - 91;
          int j = (int) (f * 18.0f);
          int k = this.scaledHeight - 32 + 3;
          k -= 26;

          this.drawTexture(matrices, x, k, 0, 84, 80, 5);
          if (0 > 0) {
              this.drawTexture(matrices, x, k, 0, 74, 80, 5);
          } else if (j > 0) {
              this.drawTexture(matrices, x, k, 0, 89, j / 2, 5);
          }
          this.client.getProfiler().pop();
      }
    }

    @Shadow
    public TextRenderer getTextRenderer() {
        return this.client.textRenderer;
    }

}
