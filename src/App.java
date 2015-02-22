import sum.komponenten.Textfeld;
import summoner.*;

public class App extends Summoner {

    public static void main(String[] args) {
        App app = new App();
    }

    public App() {
        super("Testanwendung");

        newUIElement("Textfeld", "test", "", false);

        createUI();

        ((Textfeld) uie("test")).setzeFarbe(2);

    }
}
