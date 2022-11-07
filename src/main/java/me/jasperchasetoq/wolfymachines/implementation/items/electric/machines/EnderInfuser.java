package me.jasperchasetoq.wolfymachines.implementation.items.electric.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.jasperchasetoq.wolfylibrary.slimefun.items.machines.MenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


@SuppressWarnings("deprecation")
public class EnderInfuser extends AContainer implements NotHopperable {


    //Inventory Menu Slots
    private static final int[] FIRST_INPUT_BORDER = {1, 2, 3, 10, 12, 19, 20, 21};
    private static final int[] SECOND_INPUT_BORDER = {5, 6, 7, 14, 16, 23, 24, 25};
    private static final int[] FIRST_OUTPUT_BORDER = {30, 31, 32, 39, 41, 48, 49, 50};
    private static final int[] BACKGROUND = {0, 4, 8, 9, 13, 17, 18, 22, 26, 27, 28, 29, 33, 34, 35, 36, 37, 38, 42, 43, 44, 45, 46, 47, 51, 52, 53};

    @ParametersAreNonnullByDefault
    public EnderInfuser(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemHandler(onBreak());

        new BlockMenuPreset(getId(), "&fEnder Infuser") {
            @Override
            public void init() {
                constructMenu(this);
            }

            @Override
            public boolean canOpen(Block b, Player p) {
                return p.hasPermission("slimefun.inventory.bypass") || Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
            }


            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow == ItemTransportFlow.INSERT) {
                    return getInputSlots();
                } else {
                    return getOutputSlots();
                }
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(DirtyChestMenu menu, ItemTransportFlow flow, ItemStack item) {
                if (flow == ItemTransportFlow.INSERT) {
                    if (item.getType() == Material.ENDER_PEARL) {
                        return getFirstInputSlot();
                    } else {
                        return getSecondInputSlot();
                    }
                } else {
                    return getFirstOutputSlot();
                }
            }
        };
    }
    @Override
    protected void registerDefaultRecipes() {

        registerRecipe(3, new ItemStack[] {new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_1, 1),new ItemStack(Material.ENDER_PEARL, 1)}, new ItemStack[] {new SlimefunItemStack(SlimefunItems.ENDER_LUMP_1, 1)});

    }
    @Override
    public String getMachineIdentifier() {
        return "ENDER_WM_INFUSER";
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.ENDER_EYE);
    }


    //Item Input and Output slots
    public int[] getFirstInputSlot() {
        return new int[] {11};
    }
    public int[] getSecondInputSlot() {
        return new int[] {15};
    }
    public int[] getFirstOutputSlot() {
        return new int[] {40};
    }

    protected void constructMenu(@Nonnull BlockMenuPreset preset) {
        for (int i : BACKGROUND) {
            preset.addItem(i, MenuUtils.getWolfyMachineMenuBackgroundTile(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : FIRST_INPUT_BORDER) {
            preset.addItem(i, MenuUtils.getWolfyMachineMenuInputOneTile(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : SECOND_INPUT_BORDER) {
            preset.addItem(i, MenuUtils.getWolfyMachineMenuInputTwoTile(), ChestMenuUtils.getEmptyClickHandler());
        }


        for (int i : FIRST_OUTPUT_BORDER) {
            preset.addItem(i, MenuUtils.getWolfyMachineMenuOutputOneTile(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int i : getFirstOutputSlot()) {

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
    public BlockBreakHandler onBreak() {
        return new BlockBreakHandler(false, false) {

            @Override
            public void onPlayerBreak(BlockBreakEvent blockbreak, ItemStack item, List<ItemStack> drops) {
                Block machineblock = blockbreak.getBlock();
                BlockMenu inv = BlockStorage.getInventory(machineblock);

                if (inv != null) {
                    inv.dropItems(machineblock.getLocation(), getFirstInputSlot());
                    inv.dropItems(machineblock.getLocation(), getSecondInputSlot());
                    inv.dropItems(machineblock.getLocation(), getFirstOutputSlot());
                }
            }
        };
    }

}

