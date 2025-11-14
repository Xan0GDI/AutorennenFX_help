package com.example.autorennenfx;

import java.util.ArrayList;

public class Flotte {

    private final ArrayList<Fahrzeug> fahrzeuge = new ArrayList<>();

    public void add(Fahrzeug f) { fahrzeuge.add(f); }

    public ArrayList<Fahrzeug> getFahrzeuge() { return fahrzeuge; }

    public void beschleunigen(int index) { fahrzeuge.get(index).beschleunigen(); }

    public void bremsen(int index) { fahrzeuge.get(index).bremsen(); }

    public void hupe(int index) { fahrzeuge.get(index).erschrecken(); }

    public void shockCheck() {
        for (int i = 0; i < fahrzeuge.size(); i++) {
            for (int j = 0; j < fahrzeuge.size(); j++) {
                if (i == j) continue;

                Fahrzeug a = fahrzeuge.get(i);
                Fahrzeug b = fahrzeuge.get(j);

                if (Math.abs(a.getX() - b.getX()) < 40) {
                    a.erschrecken();
                }
            }
        }
    }
}
