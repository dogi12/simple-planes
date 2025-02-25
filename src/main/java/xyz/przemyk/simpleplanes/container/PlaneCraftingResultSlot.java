package xyz.przemyk.simpleplanes.container;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class PlaneCraftingResultSlot extends SlotItemHandler {

    private final PlaneWorkbenchContainer container;
    private final Player player;

    public PlaneCraftingResultSlot(Player player, PlaneWorkbenchContainer container, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
        this.player = player;
        this.container = container;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public void onTake(Player thePlayer, ItemStack stack) {
        stack.onCraftedBy(player.level, player, 1);
        container.onCrafting();
    }
}
