package an.opensauce.armourweight.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class armourWeightDef {

    public armourType TYPE;
    public float weight;

    public Item armourItem;

    /**
     *
     * @param Type - armourType, can be null (don't do that though)
     * @param Weight - float value for how much your armour is going to "weigh"
     * @param ArmourItem - associated item that goes with your definition. ex:(null,3,Items.IRON_BOOTS)
     */
    public armourWeightDef(@Nullable armourType Type, float Weight, Item ArmourItem){
        if(TYPE != null) {
            TYPE = Type;
            weight = Weight;
            armourItem = ArmourItem;
        }else {
            TYPE = armourType.OTHER;
            weight = Weight;
            armourItem = ArmourItem;
        }
    }


    // in some instances like Mixins, this is the best way to grab a variable
    public armourType getType(){
        return this.TYPE;
    }

    public float getWeight(){
        return this.weight;
    }

    public Item getAssociatedItem(){
        return this.armourItem;
    }

}
