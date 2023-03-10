package an.opensauce.armourweight.util;

import an.opensauce.armourweight.api.armourType;
import an.opensauce.armourweight.api.armourWeightDef;
import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class WeightUtil {

    public static int count; //the "int" field (not the Integer class) will have its value as 0 by default on java, initialization is not needed.

    private static List<armourWeightDef> defs = new ArrayList<>();

    //for (PlayerEntity playerEntity : world.getPlayers()) {

    public static void addElement(armourWeightDef def){
        count++;
        defs.add(def);
    }

    public static armourWeightDef get(int index){
        return defs.get(index);
    }

    public int getCount(){
        return this.count;
    }

    /**
     *  <li>An advanced version of CalculateWeight. Gives programmers more fine control over what is calculated</>
     * @param type - What armour slot is being calculated
     * @param player - The PlayerEntity get the armour data out of.
     * @return
     */
    public static float CalculateWeightAdv(armourType type, PlayerEntity player){
        float weightVal = 0;
        for(armourWeightDef weightDef : defs){
            switch (type){ // make some slow code slightly faster
                case HEAD:
                if(weightDef.armourItem == player.getInventory().armor.get(3).getItem()){
                    weightVal += weightDef.weight;
                }
                break;
                case CHEST:
                    if(weightDef.armourItem == player.getInventory().armor.get(2).getItem()){
                        weightVal += weightDef.weight;
                    }
                    break;
                case LEGS:
                    if(weightDef.armourItem == player.getInventory().armor.get(1).getItem()){
                        weightVal += weightDef.weight;
                    }
                    break;
                case BOOTS:
                    if(weightDef.armourItem == player.getInventory().armor.get(0).getItem()){
                        weightVal += weightDef.weight;
                    }
                    break;
                case OTHER:
                    System.out.println("OTHER called when we haven't yet done it!");
                    break;
            }
        }
        return weightVal;
    }

    public static float CalculateWeight(PlayerEntity player){
        float weightVal = 0;
        for(armourWeightDef weightDef : defs){ // defs is the list, weightdef is the point in defs (big O(h) Notation isn't that big of a problem here)
            for (int i = 0; i < player.getInventory().armor.size(); i++){ // do it 4 times
                if(weightDef.armourItem == player.getInventory().armor.get(i).getItem()){ // if the armourItem of our weightDef is equal to the players equipped armour, add the weight of the def.
                    weightVal += weightDef.weight;
                }
            }
        }
        return weightVal;
    }

}
