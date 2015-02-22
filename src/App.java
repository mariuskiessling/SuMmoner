import sum.komponenten.Textfeld;
import summoner.*;

public class App extends Summoner {

    public static void main(String[] args) {
        App app = new App();
    }

    public App() {
        super("Testanwendung", 400, 400);

        System.out.println(newUIElement("Textfeld", "test", "", false));
        System.out.println(newUIElement("Etikett", "hallo", "Hallo", false));
        System.out.println(newUIElement("Knopf", "hallo", "Sag hallo!", false));

        createUI();

        ((Textfeld) uie("test")).setzeFarbe(2);
    }

    public void hallo() {
        System.out.println("Hallo!");
    }
}
