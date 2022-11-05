package me.jasperchasetoq.wolfymachines.implementation.setup;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.jasperchasetoq.wolfymachines.WolfyMachines;
import me.jasperchasetoq.wolfymachines.implementation.items.WolfyMachinesItems;
import me.jasperchasetoq.wolfymachines.implementation.items.electric.machines.EnderInfuser;
import me.jasperchasetoq.wolfymachines.implementation.items.electric.machines.GlassCutter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class WolfyMachinesItemSetup {
    private WolfyMachinesItemSetup() {
    }

    public static void setup(@Nonnull WolfyMachines plugin) {


        //machines
        new GlassCutter(WolfyMachinesItemGroups.Machines, WolfyMachinesItems.JC_Glass_Cutter, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.GLASS), new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.SHEARS), new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.STONECUTTER), new ItemStack(Material.IRON_BLOCK)})
                .setCapacity(500)
                .setEnergyConsumption(25)
                .setProcessingSpeed(1)
                .register(plugin);
        new EnderInfuser(WolfyMachinesItemGroups.Machines, WolfyMachinesItems.JC_Ender_Infuser, RecipeType.ANCIENT_ALTAR, new ItemStack[]{
                SlimefunItems.ENDER_RUNE, SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.ENDER_RUNE,
                SlimefunItems.MAGIC_EYE_OF_ENDER, new ItemStack(Material.BREWING_STAND), SlimefunItems.MAGIC_EYE_OF_ENDER,
                SlimefunItems.ENDER_RUNE, SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.ENDER_RUNE})
                .setCapacity(500)
                .setEnergyConsumption(25)
                .setProcessingSpeed(1)
                .register(plugin);

    }
}
