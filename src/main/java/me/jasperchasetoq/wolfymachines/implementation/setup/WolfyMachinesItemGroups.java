package me.jasperchasetoq.wolfymachines.implementation.setup;

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.jasperchasetoq.wolfymachines.WolfyMachines;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class WolfyMachinesItemGroups {

    public static final NestedItemGroup NestedGeneral = new NestedItemGroup(new NamespacedKey(WolfyMachines.getInstance(), "GENERAL"), new CustomItemStack(Material.FURNACE, "&fWolfy Machines"));
    public static final SubItemGroup Machines = new SubItemGroup(new NamespacedKey(WolfyMachines.getInstance(), "MACHINES"), NestedGeneral, new CustomItemStack(Material.BLAST_FURNACE, "&fMachines"));

}