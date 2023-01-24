package an.opensauce.armourweight;

import an.opensauce.armourweight.api.armourType;
import an.opensauce.armourweight.util.Config;
import an.opensauce.armourweight.util.defaultdefs.VanillaDefs;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ModInitializer;

public class Armourweight implements ModInitializer {
    @Override
    public void onInitialize() {
        VanillaDefs.Register();

        AutoConfig.register(Config.class, JanksonConfigSerializer::new);
    }
}
