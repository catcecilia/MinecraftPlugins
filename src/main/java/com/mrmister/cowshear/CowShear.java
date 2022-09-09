package com.mrmister.cowshear;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

import static org.bukkit.Material.*;
import static org.bukkit.event.player.PlayerAnimationType.ARM_SWING;

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
