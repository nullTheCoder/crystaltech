package today.exists.crystaltech.items.blocks.machines;

import org.waveapi.api.items.MinecraftItems;
import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.blockentities.DeltaTicking;
import org.waveapi.api.items.block.blockentities.TileEntityBlock;
import org.waveapi.api.items.block.blockentities.TileEntityCreation;
import org.waveapi.api.items.block.blockentities.WaveTileEntity;
import today.exists.crystaltech.items.items.materials.IronCrystal;

public class IronCrystallizer extends CrystallizerBase implements TileEntityBlock {


    public IronCrystallizer() {
        super("iron_crystallizer");
    }

    @Override
    public Class<? extends WaveTileEntity> getTileEntity() {
        return tile.class;
    }

    public static class tile extends CrystallizerBase.TileEntity implements DeltaTicking {

        public tile(TileEntityCreation creation) {
            super(creation);
        }

        @Override
        public WaveItem getSource() {
            return MinecraftItems.IRON_INGOT;
        }

        @Override
        public WaveItem getResult() {
            return IronCrystal.instance;
        }
    }

}
