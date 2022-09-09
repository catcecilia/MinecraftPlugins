package com.mrmister.cowshear;

import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import static org.bukkit.Material.*;

public final class CowShear extends JavaPlugin implements Listener {
    @EventHandler
    public void cowShearAndSlaughter(EntityDamageByEntityEvent e) {
        ItemStack leather = new ItemStack(LEATHER, 1);
        Entity damager = e.getDamager();
        Entity damagee = e.getEntity();

        if (damagee instanceof Cow) {
            if(damager instanceof Player) {
                Player damagerPlayer = (Player) damager;

                ItemStack shears = new ItemStack(SHEARS);
                if (damagerPlayer.getInventory().getItemInMainHand().equals(shears)) {
                    e.setDamage(5.5);
                    damagerPlayer.getPlayer().getInventory().addItem(leather);
                }

                //Somehow find a way to shear instead of having to hit it
                //regardless of hit or shear, have a 2 second delay in setting
                // damage or shearing. Cow needs to recover


            }
       }

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Let the cow shearing, COMMENCE!");
        //registering events
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
