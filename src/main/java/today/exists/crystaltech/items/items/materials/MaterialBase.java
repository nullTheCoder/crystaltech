package today.exists.crystaltech.items.items.materials;

import org.waveapi.api.items.WaveItem;
import org.waveapi.api.items.inventory.ItemStack;
import org.waveapi.api.items.models.SimpleItemModel;
import org.waveapi.api.misc.Text;
import org.waveapi.api.misc.TranslatedText;
import today.exists.crystaltech.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaterialBase extends WaveItem {
    public MaterialBase(String id) {
        super(id, Main.instance);
        setTab(Main.tab);
        setModel(new SimpleItemModel("crystaltech/items/material/" + id + ".png"));
    }

    private List<Text> toolTip = new ArrayList<>();

    @Override
    public List<Text> addToolTip(ItemStack stack) {
        return toolTip;
    }

    public void addLore(TranslatedText[] text) {
        toolTip = Arrays.asList(text);
    }
}
