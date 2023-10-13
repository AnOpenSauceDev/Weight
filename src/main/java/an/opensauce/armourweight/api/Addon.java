package an.opensauce.armourweight.api;

import net.minecraft.entity.player.PlayerEntity;

public class Addon {

    public Addon(String version, String name){
        this.ADDON_VERSION = version;
        this.ADDON_NAME = name;
    }

    public String ADDON_VERSION;
    public String ADDON_NAME;

    public void onWeightCalculation(float weight, PlayerEntity player){

    }

    public void onAddonEnable(){

    }

}
