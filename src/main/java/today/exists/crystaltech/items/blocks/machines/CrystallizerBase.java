package today.exists.crystaltech.items.blocks.machines;

import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.block.BlockMaterial;
import org.waveapi.api.items.block.WaveBlock;
import org.waveapi.api.items.block.blockentities.DeltaTicking;
import org.waveapi.api.items.block.blockentities.TileEntityBlock;
import org.waveapi.api.items.block.blockentities.TileEntityCreation;
import org.waveapi.api.items.block.blockentities.WaveTileEntity;
import org.waveapi.api.items.block.blockentities.types.ContainerTile;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import today.exists.crystaltech.Main;
import today.exists.crystaltech.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CrystallizerBase extends WaveBlock implements TileEntityBlock {
    public CrystallizerBase(String id) {
        super(id, Main.instance, BlockMaterial.STONE);
        setTab(Main.tab);
    }

    private List<Text> toolTip = new ArrayList<>();

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return toolTip;
    }

    public void addLore(TranslatedText[] text) {
        toolTip = Arrays.asList(text);
    }

    public abstract static class TileEntity extends WaveTileEntity implements DeltaTicking {

        public TileEntity(TileEntityCreation creation) {
            super(creation);
        }

        public abstract WaveItem getSource();

        public abstract WaveItem getResult();

        /**
         * @return How many ticks is takes per crystal
         */
        public int getSpeed() {
            return 10;
        }

        public int getOutputAmount() {
            return 3;
        }

        public int ticks;
        @Override
        public void tick(int passed) {
            ticks += passed;
            if (ticks > getSpeed()) {
                int amount =(int) Math.floor(ticks / (float)getSpeed());
                ticks -= amount * getSpeed();
                ContainerTile top = getWorld().getTileEntity(getPosition().addY(1), ContainerTile.class);
                ContainerTile bottom = getWorld().getTileEntity(getPosition().addY(-1), ContainerTile.class);
                int total = Utils.takeItems(top, amount, getSource());
                Utils.drop(getPosition().addY(-1), bottom, getWorld(),
                        new WaveItem[] {
                                getResult()
                        },
                        new int[] {
                                getOutputAmount() * total
                        }
                        );
            }
        }
    }

}
