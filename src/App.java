import summoner.*;

import java.util.HashMap;
import java.util.Map;

public class App extends Summoner {

    public static void main(String [] args) {
        App app = new App();
    }

    public App() {
        super("Testanwendung");

        newUIElement("Textfeld", "", false);

        createUI();
    }
}
