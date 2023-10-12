package an.opensauce.armourweight.api;

import an.opensauce.armourweight.Armourweight;

import java.util.List;
import java.util.Set;

public class RegistryTools {

    public static List<Addon> Addons;


    public static void addAPIAddon(Addon addon){

        Addons.add(addon);
        addon.onAddonEnable();

        Armourweight.MainLogger.info("Loaded Addon: " + addon.ADDON_NAME);

    }

}
