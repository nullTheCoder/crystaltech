package today.exists.crystaltech.items;

import today.exists.crystaltech.items.blocks.machines.IronCrystallizer;
import today.exists.crystaltech.items.items.materials.IronCrystal;

public class Items {
    public static void register() {
        materials();
        machines();
    }

    public static void materials() {
        new IronCrystal();
    }

    public static void machines() {
        new IronCrystallizer();
    }
}
