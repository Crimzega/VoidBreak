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

public class EventsVBD2{

    public ItemStack enchantedItems;
    private boolean once;
    private int nothingFound;
    private int checkHit;

    public EventsVBD2(){
        once = false;
        nothingFound = 0;
        checkHit = 0;
    }

    @SubscribeEvent
    public void onCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[8]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 2);
            event.crafting.addEnchantment(Enchantment.smite, 1);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.swords[9]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 4);
            event.crafting.addEnchantment(Enchantment.smite, 3);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 2);
            event.crafting.addEnchantment(Enchantment.fireAspect, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[8]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 2);
            event.crafting.addEnchantment(Enchantment.unbreaking, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.spades[9]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 3);
            event.crafting.addEnchantment(Enchantment.unbreaking, 2);
            event.crafting.addEnchantment(Enchantment.fortune, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[8]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 2);
            event.crafting.addEnchantment(Enchantment.unbreaking, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.pickaxes[9]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 3);
            event.crafting.addEnchantment(Enchantment.unbreaking, 2);
            event.crafting.addEnchantment(Enchantment.fortune, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[8]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 2);
            event.crafting.addEnchantment(Enchantment.smite, 1);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.axes[9]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.sharpness, 4);

            event.crafting.addEnchantment(Enchantment.smite, 3);
            event.crafting.addEnchantment(Enchantment.baneOfArthropods, 2);
            event.crafting.addEnchantment(Enchantment.efficiency, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[6])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[8]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());

            event.crafting.addEnchantment(Enchantment.efficiency, 2);
            event.crafting.addEnchantment(Enchantment.unbreaking, 1);
        }
        if (event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[7])) || event.crafting.isItemEqual(new ItemStack(ContentsVBD2.hoes[9]))) {
            enchantedItems = new ItemStack(event.crafting.getItem());
            event.crafting.addEnchantment(Enchantment.efficiency, 3);
            event.crafting.addEnchantment(Enchantment.unbreaking, 2);
            event.crafting.addEnchantment(Enchantment.fortune, 1);
        }
    }

    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event){
        Item item = event.item.getEntityItem().getItem();
        if(item == ContentsVBD2.items[11]){
            ItemStack itemStack = new ItemStack(item);
            nothingFound += itemStack.stackSize;
            VoidBreakDemo2.log.info("Ball of Nothing found: " + nothingFound);
            if(nothingFound >= 9 && !once){
                event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[1], 1);
                once = true;
            }
        }
        if (item == ContentsVBD2.items[0]) {
            ItemStack itemStack2 = new ItemStack(item);
            if(itemStack2.getItemDamage() == 0) event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[2], 1);
            if(itemStack2.getItemDamage() == 1) event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[3], 1);
            if(itemStack2.getItemDamage() == 2) event.entityPlayer.addStat((StatBase)ContentsVBD2.achievements[4], 1);
        }
    }

    @SubscribeEvent
    public void onLogin(PlayerEvent.PlayerLoggedInEvent event){
        if(checkHit == 0){
            event.player.addStat((StatBase)ContentsVBD2.achievements[0], 1);
            ++checkHit;
        }
    }

    @SubscribeEvent
    public void onLogout(PlayerEvent.PlayerLoggedOutEvent event){
        once = false;
        checkHit = 0;
        nothingFound = 0;
    }

    @SubscribeEvent
    public void onSmelted(PlayerEvent.ItemSmeltedEvent event){}

}
