package an.opensauce.armourweight.deprecated;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


import java.util.Arrays;

@Deprecated
public class Weight {
    public static Item[] HeavyHelmets = {Items.IRON_HELMET,Items.GOLDEN_HELMET,Items.DIAMOND_HELMET,Items.NETHERITE_HELMET};
    public static Item[] LightHelmets = {Items.TURTLE_HELMET, Items.CHAINMAIL_HELMET, Items.LEATHER_HELMET};
    public static Item[] HeavyChestPlates = {Items.IRON_CHESTPLATE,Items.GOLDEN_CHESTPLATE,Items.DIAMOND_CHESTPLATE,Items.NETHERITE_CHESTPLATE};
    public static Item[] LightChestPlates = {Items.CHAINMAIL_CHESTPLATE, Items.LEATHER_CHESTPLATE};
    public static Item[] HeavyLegs = {Items.IRON_LEGGINGS,Items.GOLDEN_LEGGINGS,Items.DIAMOND_LEGGINGS,Items.NETHERITE_LEGGINGS};
    public static Item[] LightLegs =  {Items.CHAINMAIL_LEGGINGS, Items.LEATHER_LEGGINGS};
    public static Item[] HeavyBoots = {Items.IRON_BOOTS,Items.GOLDEN_BOOTS,Items.DIAMOND_BOOTS,Items.NETHERITE_BOOTS};
    public static Item[] LightBoots = {Items.CHAINMAIL_BOOTS, Items.LEATHER_BOOTS};

    public static float CalculateWeight(PlayerEntity player){
        float value = 0;
        // 3 = head
        // 2 = chestplate
        // 1 = leggings
        // 0 = boots


        //Max = 9 (the weight bar has a fit afterwards due to the level cap)
        if(Arrays.stream(HeavyHelmets).anyMatch(player.getInventory().armor.get(3).getItem()::equals)){
        value += 2;
        }
        if(Arrays.stream(LightHelmets).anyMatch(player.getInventory().armor.get(3).getItem()::equals)){
            value += 1;
        }
        if(Arrays.stream(HeavyChestPlates).anyMatch(player.getInventory().armor.get(2).getItem()::equals)){
            value += 3;
        }
        if(Arrays.stream(LightChestPlates).anyMatch(player.getInventory().armor.get(2).getItem()::equals)){
            value += 2;
        }
        if(Arrays.stream(HeavyLegs).anyMatch(player.getInventory().armor.get(1).getItem()::equals)){
            value += 2;
        }
        if(Arrays.stream(LightLegs).anyMatch(player.getInventory().armor.get(1).getItem()::equals)){
            value += 1;
        }
        if(Arrays.stream(HeavyBoots).anyMatch(player.getInventory().armor.get(0).getItem()::equals)){
            value += 2;
        }
        if(Arrays.stream(LightBoots).anyMatch(player.getInventory().armor.get(0).getItem()::equals)){
            value += 1;
        }


        return value;
    }

}
