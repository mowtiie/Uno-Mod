package com.mowtiie.unomod.item;

import com.mowtiie.unomod.UnoMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    // CUSTOM ITEMS
    public static final Item COFFEE = registerItem("coffee", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(
                BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(UnoMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(UnoMod.MOD_ID, name))))
        );
    }

    public static void registerModItems() {
        UnoMod.LOGGER.info("Registering mod items for " + UnoMod.MOD_ID);

        // REGISTERS ITEMS
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(COFFEE);
        });
    }
}