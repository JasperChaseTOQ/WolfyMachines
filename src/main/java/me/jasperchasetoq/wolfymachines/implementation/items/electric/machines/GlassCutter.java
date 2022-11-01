package me.jasperchasetoq.wolfymachines.implementation.items.electric.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class GlassCutter extends AContainer implements RecipeDisplayItem {

    private static final int[] BORDER = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 17, 18, 22, 26, 27, 31, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    private static final int[] INPUT_BORDER = {10, 11, 12, 19, 21, 28, 29, 30};
    private static final int[] OUTPUT_BORDER = {14, 15, 16, 23, 25, 32, 33, 34};

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

    public int[] getInputSlots() {
        return new int[] {20};
    }

    public int[] getOutputSlots() {
        return new int[] {24};
    }
    protected void constructMenu(@Nonnull BlockMenuPreset preset) {
        for (int i : BORDER) {
            preset.addItem(i, MenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : INPUT_BORDER) {
            preset.addItem(i, new SlimefunItemStack("_UI_INPUT_SLOT", Material.CYAN_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : OUTPUT_BORDER) {
            preset.addItem(i, new SlimefunItemStack("_UI_OUTPUT_SLOT", Material.ORANGE_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : getOutputSlots()) {

            preset.addMenuClickHandler(i, new ChestMenu.AdvancedMenuClickHandler() {

                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }

}