package an.opensauce.armourweight.mixin;


import an.opensauce.armourweight.util.Config;
import an.opensauce.armourweight.util.WeightUtil;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends Entity {

    public PlayerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void AddWeight(CallbackInfo ci){
        PlayerEntity player = (PlayerEntity)(Entity)this;
        float v = WeightUtil.CalculateWeight(player);
        Config cfg = Config.GetData();

       if(v > cfg.Marker1){
           if(v > cfg.Marker2){
               if(v >= cfg.markerFinalAmp){
                HandleEffects(player,(int)cfg.markerFinaleffects,(int)cfg.markerFinalAmp);
                    }
                    else {
                        HandleEffects(player,(int)cfg.Marker2effects,(int)cfg.Marker2Amp);
                    }
           }else {
               HandleEffects(player,(int)cfg.Marker1effects,(int)cfg.Marker1Amp);
           }
       }
    }

    void HandleEffects(PlayerEntity player, int id, int amp){
        if(id == 1){
            //player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,(10*20),1,!false,false,false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,(20),amp,!false,false,false));

        } else if (id == 2) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,(20),0,true,false,false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,(20),amp,true,false,false));
        } else if (id == 3) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,(20),amp,true,false,false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,(20),1,true,false,false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,(20),(amp/2),true,false,false));

        }else{
            System.out.println("WARNING: INVALID VALUE GIVEN FOR EFFECTS");
        }
    }


}
