package summoner;

import sum.ereignis.EBAnwendung;
import sum.ereignis.Ereignisanwendung;
import sum.komponenten.Etikett;
import sum.komponenten.Textfeld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summoner extends Ereignisanwendung {

    List<Map> elements;
    String title;

    public Summoner(String title) {
        super(200, 100);

        elements = new ArrayList<Map>();
        this.title = title;
    }

    public boolean newUIElement(String type, String content, boolean validation) {
        Map<String, Object> uiElement = new HashMap<String, Object>();

        boolean error = false;

        if (type == "Textfeld") {
            uiElement.put("type", "Textfield");
        } else {
            error = true;
        }

        uiElement.put("content", content);

        if (error == false) {
            elements.add(uiElement);
            return true;
        } else {
            return false;
        }

    }

    public void createUI() {
        Etikett titleLabel = new Etikett(0, 20, this.bildschirm().breite(), 30, this.title);
        titleLabel.setzeAusrichtung(1);
        titleLabel.setzeSchriftGroesse(25);

        for(Map uiElement:elements) {
            System.out.println(uiElement);

            if (uiElement.get("type") == "Textfield") {
                Textfeld textfield = new Textfeld(10, 50, this.bildschirm().breite()-20, 20, uiElement.get("content").toString());

            }

        }

    }

    public void bearbeiteLeerlauf() {
        System.out.println("Leerlauf");
    }

}