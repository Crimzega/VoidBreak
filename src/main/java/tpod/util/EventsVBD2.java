package tpod.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import tpod.lib.ContentsVBD2;
import tpod.mods.VoidBreakDemo2;

public class EventsVBD2
{
    public ItemStack enchantedItems;
    private boolean once;
    private int nothingFound;
    private int checkHit;
    
    public EventsVBD2() {
        this.once = false;
        this.nothingFound = 0;
        this.checkHit = 0;
    }
    
    @SubscribeEvent
    public void onCrafted(final PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[8]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 2);
            event.crafting.addEnchantment(Enchantment.smite, 1);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[9]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 4);
            event.crafting.addEnchantment(Enchantment.smite, 3);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 2);
            event.crafting.addEnchantment(Enchantment.fireAspect, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[8]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 2);
            event.crafting.addEnchantment(Enchantment.unbreaking, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[9]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 3);
            event.crafting.addEnchantment(Enchantment.unbreaking, 2);
            event.crafting.addEnchantment(Enchantment.fortune, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[8]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 2);
            event.crafting.addEnchantment(Enchantment.unbreaking, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[9]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 3);
            event.crafting.addEnchantment(Enchantment.unbreaking, 2);
            event.crafting.addEnchantment(Enchantment.fortune, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[8]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 2);
            event.crafting.addEnchantment(Enchantment.smite, 1);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[9]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 4);
            event.crafting.addEnchantment(Enchantment.smite, 3);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 2);
            event.crafting.addEnchantment(Enchantment.efficiency, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[8]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 2);
            event.crafting.addEnchantment(Enchantment.unbreaking, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[9]))) {
            this.enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 3);
            event.crafting.addEnchantment(Enchantment.unbreaking, 2);
            event.crafting.addEnchantment(Enchantment.fortune, 1);
        }
    }
    
    @SubscribeEvent
    public void onItemPickup(final EntityItemPickupEvent event) {
        final Item item = event.item.getEntityItem().getItem();
        if (item == ContentsVBD2.items[11]) {
            final ItemStack itemStack = new ItemStack(item);
            this.nothingFound += itemStack.stackSize;
            VoidBreakDemo2.log.info("Ball of Nothing found: " + this.nothingFound);
            if (this.nothingFound >= 9 && !this.once) {
                event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[1], 1);
                this.once = true;
            }
        }
        if (item == ContentsVBD2.items[0]) {
            final ItemStack itemStack2 = new ItemStack(item);
            if (itemStack2.getItemDamage() == 0) {
                event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[2], 1);
            }
            if (itemStack2.getItemDamage() == 1) {
                event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[3], 1);
            }
            if (itemStack2.getItemDamage() == 2) {
                event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[4], 1);
            }
        }
    }
    
    @SubscribeEvent
    public void onLogin(final PlayerEvent.PlayerLoggedInEvent event) {
        if (this.checkHit == 0) {
            event.player.addStat((StatBase)ContentsVBD2.achievements[0], 1);
            ++this.checkHit;
        }
    }
    
    @SubscribeEvent
    public void onLogout(final PlayerEvent.PlayerLoggedOutEvent event) {
        this.once = false;
        this.checkHit = 0;
        this.nothingFound = 0;
    }
    
    @SubscribeEvent
    public void onSmelted(final PlayerEvent.ItemSmeltedEvent event) {
    }
}
