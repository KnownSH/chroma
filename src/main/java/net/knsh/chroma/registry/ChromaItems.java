package net.knsh.chroma.registry;

import com.tterrag.registrate.Registrate;
import net.knsh.chroma.registry.items.Alcohol;

public class ChromaItems {
    public static void register(Registrate registrate) {
        registrate.item("alcoholic_drink", Alcohol::new).register();
    }
}
