package net.niev.morefold.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent VEGETABLE_STEW = new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f).usingConvertsTo(Items.BOWL).build();
}
