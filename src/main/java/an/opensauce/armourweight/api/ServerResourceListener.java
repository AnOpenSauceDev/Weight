package an.opensauce.armourweight.api;

import an.opensauce.armourweight.util.WeightUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static an.opensauce.armourweight.Armourweight.MainLogger;
import static an.opensauce.armourweight.Armourweight.ModId;

public class ServerResourceListener implements SimpleSynchronousResourceReloadListener {

    @Override
    public Identifier getFabricId() {
        return new Identifier(ModId,"weightdata");
    }

    @Override
    public void reload(ResourceManager manager) {
              // grab our IDs
        Set<Identifier> col = manager.findResources("weightdata", path -> path.getPath().endsWith(".json")).keySet();
        MainLogger.info("attempting to register " + col.size() + " custom weight definitions...");

        // iterate throughout our IDs
        for(Identifier id : col){
            // try to find each .json
            try (InputStream stream = manager.getResource(id).get().getInputStream()) {
                //convert the binary to a JSON string
                String data = IOUtils.toString(stream, StandardCharsets.UTF_8);

                // do dark magic (change later)
                JsonObject object = new Gson().fromJson(data, JsonObject.class);

                // search of an "id" string element, then set that as our value
                String ArmourIdNamespace = object.get("id_namespace").getAsString(); // item as an identifier (namespace)
                String ArmourIdPath = object.get("id_path").getAsString(); // item as an identifier ("path")
                float weight = object.get("weight").getAsFloat(); // weight
                String Type = object.get("type").getAsString(); // armorType


                // _almost_ programming horror.
                if(Type == "head"){
                    armourWeightDef def = new armourWeightDef(armourType.HEAD,weight, Registries.ITEM.get(new Identifier(ArmourIdNamespace,ArmourIdPath)));
                    WeightUtil.addElement(def);
                }else  if (Type == "chest"){
                    armourWeightDef def = new armourWeightDef(armourType.CHEST,weight, Registries.ITEM.get(new Identifier(ArmourIdNamespace,ArmourIdPath)));
                    WeightUtil.addElement(def);
                } else if (Type == "leggings") {
                    armourWeightDef def = new armourWeightDef(armourType.LEGS,weight, Registries.ITEM.get(new Identifier(ArmourIdNamespace,ArmourIdPath)));
                    WeightUtil.addElement(def);
                } else if (Type == "boots") {
                    armourWeightDef def = new armourWeightDef(armourType.BOOTS,weight, Registries.ITEM.get(new Identifier(ArmourIdNamespace,ArmourIdPath)));
                    WeightUtil.addElement(def);
                }else {
                    armourWeightDef def = new armourWeightDef(armourType.OTHER,weight, Registries.ITEM.get(new Identifier(ArmourIdNamespace,ArmourIdPath)));
                    WeightUtil.addElement(def);
                }




            }catch (Exception ex){
                MainLogger.error("resource data failed to load, printing error...");
                MainLogger.error(ex.getMessage());
            }
        }

    }
}
