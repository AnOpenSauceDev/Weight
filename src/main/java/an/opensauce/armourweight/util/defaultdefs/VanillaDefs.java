package an.opensauce.armourweight.util.defaultdefs;

import an.opensauce.armourweight.api.armourType;
import an.opensauce.armourweight.api.armourWeightDef;
import an.opensauce.armourweight.util.WeightUtil;
import net.minecraft.item.Items;

import static an.opensauce.armourweight.Armourweight.MainLogger;

/**
 * <li>The VERY long list that defines weights for all the vanilla armour.</>
 *  <li>this does serve as a pretty good example for anyone interested.</>
 */
public class VanillaDefs {




    //DEFS BEGIN
    static armourWeightDef leather_helmet = new armourWeightDef(armourType.HEAD,0.5f, Items.LEATHER_HELMET);
    static armourWeightDef leather_chestplate = new armourWeightDef(armourType.CHEST,0.5f, Items.LEATHER_CHESTPLATE);
    static armourWeightDef leather_leggings = new armourWeightDef(armourType.LEGS,0.5f, Items.LEATHER_LEGGINGS);
    static armourWeightDef leather_boots = new armourWeightDef(armourType.BOOTS,0.5f, Items.LEATHER_BOOTS);
    static armourWeightDef chain_helmet = new armourWeightDef(armourType.HEAD,1, Items.CHAINMAIL_HELMET);
    static armourWeightDef chain_chestplate = new armourWeightDef(armourType.CHEST,1, Items.CHAINMAIL_CHESTPLATE);
    static armourWeightDef chain_leggings = new armourWeightDef(armourType.LEGS,1, Items.CHAINMAIL_LEGGINGS);
    static armourWeightDef chain_boots = new armourWeightDef(armourType.BOOTS,1, Items.CHAINMAIL_BOOTS);
    static armourWeightDef iron_helmet = new armourWeightDef(armourType.HEAD,1.5f, Items.IRON_HELMET);
    static armourWeightDef iron_chestplate = new armourWeightDef(armourType.CHEST,2f, Items.IRON_CHESTPLATE);
    static armourWeightDef iron_leggings = new armourWeightDef(armourType.LEGS,1.5f, Items.IRON_LEGGINGS);
    static armourWeightDef iron_boots = new armourWeightDef(armourType.BOOTS,1.5f, Items.IRON_BOOTS);
    static armourWeightDef diamond_helmet = new armourWeightDef(armourType.HEAD,2f, Items.DIAMOND_HELMET);
    static armourWeightDef diamond_chestplate = new armourWeightDef(armourType.CHEST,2.5f, Items.DIAMOND_CHESTPLATE);
    static armourWeightDef diamond_leggings = new armourWeightDef(armourType.LEGS,2f, Items.DIAMOND_LEGGINGS);
    static armourWeightDef diamond_boots = new armourWeightDef(armourType.BOOTS,2f, Items.DIAMOND_BOOTS);
    static armourWeightDef gold_helmet = new armourWeightDef(armourType.HEAD,3, Items.GOLDEN_HELMET);
    static armourWeightDef gold_chestplate = new armourWeightDef(armourType.CHEST,3, Items.GOLDEN_CHESTPLATE);
    static armourWeightDef gold_leggings = new armourWeightDef(armourType.LEGS,3, Items.GOLDEN_LEGGINGS);
    static armourWeightDef gold_boots = new armourWeightDef(armourType.BOOTS,3, Items.GOLDEN_BOOTS);
    static armourWeightDef netherite_helmet = new armourWeightDef(armourType.HEAD,4, Items.NETHERITE_HELMET);
    static armourWeightDef netherite_chestplate = new armourWeightDef(armourType.CHEST,4, Items.NETHERITE_CHESTPLATE);
    static armourWeightDef netherite_leggings = new armourWeightDef(armourType.LEGS,4, Items.NETHERITE_LEGGINGS);
    static armourWeightDef netherite_boots = new armourWeightDef(armourType.BOOTS,4, Items.NETHERITE_BOOTS);
    static armourWeightDef turtle_shell = new armourWeightDef(armourType.HEAD,1,Items.TURTLE_HELMET);
    //DEF END

    public static void Register(){
        WeightUtil.addElement(leather_helmet);
        WeightUtil.addElement(leather_chestplate);
        WeightUtil.addElement(leather_leggings);
        WeightUtil.addElement(leather_boots);
        WeightUtil.addElement(chain_helmet);
        WeightUtil.addElement(chain_chestplate);
        WeightUtil.addElement(chain_leggings);
        WeightUtil.addElement(chain_boots);
        WeightUtil.addElement(iron_helmet);
        WeightUtil.addElement(iron_chestplate);
        WeightUtil.addElement(iron_leggings);
        WeightUtil.addElement(iron_boots);
        WeightUtil.addElement(diamond_helmet);
        WeightUtil.addElement(diamond_chestplate);
        WeightUtil.addElement(diamond_leggings);
        WeightUtil.addElement(diamond_boots);
        WeightUtil.addElement(gold_helmet);
        WeightUtil.addElement(gold_chestplate);
        WeightUtil.addElement(gold_leggings);
        WeightUtil.addElement(gold_boots);
        WeightUtil.addElement(netherite_helmet);
        WeightUtil.addElement(netherite_chestplate);
        WeightUtil.addElement(netherite_leggings);
        WeightUtil.addElement(netherite_boots);
        WeightUtil.addElement(turtle_shell);
        MainLogger.info("Registered vanilla weights!");
    }
}
