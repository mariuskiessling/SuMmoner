package summoner;

import sum.ereignis.*;
import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.komponenten.Etikett;
import sum.komponenten.Textfeld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summoner extends EBAnwendung {

    List<Map> elements;
    String title;

    public Summoner(String title) {
        super(200, 100);

        elements = new ArrayList<Map>();
        this.title = title;
    }

    public boolean newUIElement(String type, String identifier, String content, boolean validation) {
        Map<String, Object> uiElement = new HashMap<String, Object>();

        boolean error = false;

        if (type == "Textfeld") {
            uiElement.put("type", "Textfield");
        } else {
            error = true;
        }

        if (identifier == "") {
            error = true;
        } else {
            boolean foundDouble = false;
            for (Map findUIElement : elements) {
                if (findUIElement.get(identifier) != null) {
                    foundDouble = true;
                }
            }

            if (foundDouble) {
                error = true;
            } else {
                uiElement.put("identifier", identifier);
            }
        }

        uiElement.put("content", content);
        uiElement.put("element", null);

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

        for (Map uiElement : elements) {

            if (uiElement.get("type") == "Textfield") {
                Textfeld textfield = new Textfeld(10, 50, this.bildschirm().breite() - 20, 20, uiElement.get("content").toString());
                uiElement.put("element", textfield);
                System.out.println(uiElement.get("element"));
            }
        }
    }

    public Object uie(String identifier) {
        boolean error = true;
        Object toReturn = null;

        for (Map findUIElement : elements) {
            if (findUIElement.get("identifier") == identifier) {
                toReturn = findUIElement.get("element");
                error = false;
            }
        }

        System.out.println(toReturn);

        if (error) {
            return null;
        } else {
            return toReturn;
        }
    }


}