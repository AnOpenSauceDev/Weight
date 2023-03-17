package an.opensauce.armourweight.util;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@me.shedaniel.autoconfig.annotation.Config(name = "armourweight")
public class Config implements ConfigData {


//   public static class markerdata {

        @Comment("Show Bar?")
        public boolean weightbar = true;
        @Comment("Weight Marker 1 point")
        public float Marker1 = 3;
        @Comment("Weight Marker 2 point")
        public float Marker2 = 7;
        @Comment("Weight Marker 3 point")
        public float Markerfinal = 9;
  // }

   //public static class markereffects{
        @Comment("Marker effects, 1 = slowness, 2 = slowness + resistance, 3 = slowness + resistance + strength.")
        public float Marker1effects = 1;
        @Comment("Marker effects, 1 = slowness, 2 = slowness + resistance, 3 = slowness + resistance + strength.")
        public float Marker2effects = 2;
        @Comment("Marker effects, 1 = slowness, 2 = slowness + resistance, 3 = slowness + resistance + strength.")
        public float markerFinaleffects = 3;
        @Comment("Marker slowness amplifier 1")
        public float Marker1Amp = 0;
        @Comment("Marker slowness amplifier")
        public float Marker2Amp = 1;
        @Comment("Marker slowness amplifier")
        public float markerFinalAmp = 2;
   //}

    public static Config GetData(){
        return AutoConfig.getConfigHolder(Config.class).getConfig();
    }



}
