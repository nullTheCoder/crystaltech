package today.exists.crystaltech;

import org.waveapi.api.WaveMod;
import org.waveapi.api.items.WaveTab;
import today.exists.crystaltech.items.Items;

public class Main extends WaveMod {
    public static WaveMod instance;

    public Main () {
        instance = this;
    }

    public static WaveTab tab;

    @Override
    public void init() {
        tab = new WaveTab("crystaltech", "crystaltech/icon.png", this)
                .addTranslation("en_us", "CrystalTech");

        Items.register();


    }
}
