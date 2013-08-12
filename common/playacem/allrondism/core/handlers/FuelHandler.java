package playacem.allrondism.core.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {


    @Override
    public int getBurnTime(ItemStack fuel) {
        // TODO Add fuel relevant items
        if (fuel.itemID == Block.bedrock.blockID) {
            return 200 * 9001;
        }
        return 0;
    }

}