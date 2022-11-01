package me.jasperchasetoq.wolfymachines.implementation.items.electric.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

public class GlassCutter extends AContainer implements RecipeDisplayItem {

    @ParametersAreNonnullByDefault
    public GlassCutter(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);}
    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(3, new ItemStack[] {new ItemStack(Material.GLASS, 1)}, new ItemStack[] {new ItemStack(Material.GLASS_PANE, 8)});

    }
    @Override
    public String getMachineIdentifier() {
        return "GLASS_CUTTER";
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.GLASS);
    }
}