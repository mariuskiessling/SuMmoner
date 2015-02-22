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

    private List<Map> elements;
    private String title;
    private int bottom = 70;
    private int marginBottom = 10;

    public Summoner(String title, int width, int height) {
        super(width, height);

        elements = new ArrayList<Map>();
        this.title = title;
    }

    public boolean newUIElement(String type, String identifier, String content, boolean validation) {
        Map<String, Object> uiElement = new HashMap<String, Object>();

        boolean error = false;

        if (type == "Textfeld") {
            uiElement.put("type", "Textfield");
        } else if (type == "Etikett") {
            uiElement.put("type", "Label");
        } else if (type == "Knopf") {
            uiElement.put("type", "Button");
        } else {
            error = true;
        }

        if (identifier == "") {
            error = true;
        } else {
            boolean foundDouble = false;
            for (Map findUIElement : elements) {
                if (findUIElement.get(identifier) == identifier) {
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
                Textfeld textfield = new Textfeld(10, bottom, this.bildschirm().breite() - 20, 20, uiElement.get("content").toString());
                uiElement.put("element", textfield);

                bottom += textfield.hoehe() + marginBottom;
            }

            if (uiElement.get("type") == "Label") {
                Etikett etikett = new Etikett(10, bottom, this.bildschirm().breite() - 20, 20, uiElement.get("content").toString());
                uiElement.put("element", etikett);

                bottom += etikett.hoehe() + marginBottom;
            }

            if (uiElement.get("type") == "Button") {
                Knopf knopf = new Knopf(10, bottom, this.bildschirm().breite() - 20, 20, uiElement.get("content").toString(), uiElement.get("identifier").toString());
                uiElement.put("element", knopf);

                bottom += knopf.hoehe() + marginBottom;
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

        if (error) {
            return null;
        } else {
            return toReturn;
        }
    }


}