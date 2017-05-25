/*
 * Copyright 2017 Exorath
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.exorath.commons;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toonsev on 5/22/2017.
 */
public class ItemStackSerialize {
    public static JsonObject fromItemStack(ItemStack is) {

        JsonObject itemObject = new JsonObject();
        itemObject.addProperty("material", is.getType().name());
        itemObject.addProperty("amount", is.getAmount());
        itemObject.addProperty("durability", is.getDurability());
        if (is.getItemMeta().hasDisplayName())
            itemObject.addProperty("displayName", is.getItemMeta().getDisplayName());
        if (is.getItemMeta().hasLore()) {
            JsonArray lore = new JsonArray();
            for (String l : is.getItemMeta().getLore())
                lore.add(new JsonPrimitive(l));
            itemObject.add("lore", lore);
        }
        if (is.getItemMeta().hasEnchants()) {
            JsonArray enchantments = new JsonArray();
            for (Enchantment enchantment : is.getItemMeta().getEnchants().keySet()) {
                JsonObject ench = new JsonObject();
                ench.addProperty("enchantment", enchantment.getName());
                ench.addProperty("level", is.getItemMeta().getEnchants().get(enchantment));
                enchantments.add(ench);
            }
            itemObject.add("enchantments", enchantments);
        }
        return itemObject;
    }

    public static ItemStack toItemStack(JsonObject object) {
        Material mat = Material.getMaterial(object.get("material").getAsString());

        int amount = object.has("amount") ? object.get("amount").getAsInt() : 1;
        short durability = object.has("amount") ? object.get("durability").getAsShort() : 0;
        ItemStack item = new ItemStack(mat, amount, durability);
        ItemMeta meta = item.getItemMeta();
        if (object.has("displayName"))
            meta.setDisplayName(object.get("displayName").getAsString());
        if (object.has("lore")) {
            List<String> lore = new ArrayList<>();
            for (JsonElement el : object.get("lore").getAsJsonArray())
                lore.add(el.getAsString());
            meta.setLore(lore);
        }
        if (object.get("enchantments") != null) {
            for (JsonElement el : object.get("enchantments").getAsJsonArray()) {
                JsonObject enchantment = el.getAsJsonObject();
                meta.addEnchant(Enchantment.getByName(enchantment.get("enchantment").getAsString()), enchantment.get("level").getAsInt(), true);
            }
        }
        item.setItemMeta(meta);
        return item;
    }
}
