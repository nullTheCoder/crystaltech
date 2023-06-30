package today.exists.crystaltech.items.items.materials;

import org.waveapi.api.misc.TranslatedText;
import today.exists.crystaltech.Main;

public class IronCrystal extends MaterialBase {

    public static IronCrystal instance;
    public IronCrystal() {
        super("iron_crystal");
        instance = this;
        addLore(new TranslatedText[]{
                new TranslatedText("iron_crystal.0", Main.instance)
                        .addTranslation("en_us", "§8Obtained from Iron Crystallizer")
        });
        addTranslation("en_us", "Iron Crystal");
    }
}
