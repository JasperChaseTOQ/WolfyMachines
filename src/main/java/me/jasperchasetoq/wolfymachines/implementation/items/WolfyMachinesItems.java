package me.jasperchasetoq.wolfymachines.implementation.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;

public class WolfyMachinesItems {


    public static final SlimefunItemStack JC_Glass_Cutter = new SlimefunItemStack("JC_WM_GLASS_CUTTER", Material.STONECUTTER, "&fGlass Cutter", LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE), LoreBuilder.powerPerSecond(50), LoreBuilder.speed(1), LoreBuilder.powerBuffer(500));

}
