package dev.nanosync.xmutante.custom;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class XMenuGlowEnchant extends Enchantment {

    public XMenuGlowEnchant() {
        super(90);
    }

    @Override
    public boolean canEnchantItem(ItemStack arg0) {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment arg0) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    public void setGlow(int index, Inventory inventory, boolean glowEnable){
        ItemMeta itemMeta = inventory.getItem(index).getItemMeta();
        if (glowEnable){
            itemMeta.addEnchant(this, 1, true);
        } else {
            itemMeta.removeEnchant(this);
        }
        inventory.getItem(index).setItemMeta(itemMeta);
    }
}
