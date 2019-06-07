package razintent;

import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import razintent.abstracts.CustomIntent;


@SpireInitializer
public class RazIntent implements PostInitializeSubscriber {

    public static final String MOD_NAME = "razintent";



    public RazIntent() {
        BaseMod.subscribe(this);
    }

    public static final String getResourcePath(String resource) {
        return MOD_NAME + "/img/" + resource;
    }

    public static void initialize() {
        new RazIntent();
    }

    @Override
    public void receivePostInitialize() {
        Texture badgeTexture = new Texture(getResourcePath("badge.png"));
        ModPanel modPanel = new ModPanel();

        BaseMod.registerModBadge(
                badgeTexture, "Raz's Intent", "Razash",
                "Makes you able to add your own intents to the game.", modPanel);

    }

    public static void addIntent(CustomIntent ci) {
        CustomIntent.intents.put(ci.intent, ci);
    }


    private static String getLanguageString() {
        // Note to translators - add your language here (by alphabetical order).
        switch (Settings.language) {
            default:
                return "eng";
        }
    }

}