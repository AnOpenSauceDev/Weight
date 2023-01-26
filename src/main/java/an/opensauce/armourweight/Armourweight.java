package an.opensauce.armourweight;

import an.opensauce.armourweight.api.armourType;
import an.opensauce.armourweight.util.Config;
import an.opensauce.armourweight.util.defaultdefs.VanillaDefs;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Armourweight implements ModInitializer {

    public static final String ModId = "armourweight";

    public static Logger MainLogger = LoggerFactory.getLogger(ModId);
    @Override
    public void onInitialize() {
        MainLogger.info("armour weight loaded!");
        VanillaDefs.Register();
        AutoConfig.register(Config.class, JanksonConfigSerializer::new);
    }
}
