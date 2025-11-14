package com.example.autorennenfx;

import java.util.ArrayList;

public class Flotte {

    private final ArrayList<Fahrzeug> fahrzeuge = new ArrayList<>();

    public void add(Fahrzeug f) { fahrzeuge.add(f); }

    public ArrayList<Fahrzeug> getFahrzeuge() { return fahrzeuge; }

    public void beschleunigen(int index) { fahrzeuge.get(index).beschleunigen(); }

    public void bremsen(int index) { fahrzeuge.get(index).bremsen(); }

    public void hupe(int index) { fahrzeuge.get(index).erschrecken(); }

    public void shockCheck(Fahrzeug ausloeser) {
        Fahrzeug ziel = null;
        double minDist = Double.MAX_VALUE;

        for (Fahrzeug f : fahrzeuge) {
            if (f == ausloeser) continue; // der Huper/Klingler selbst bleibt unberührt

            double dist = Math.abs(f.getX() - ausloeser.getX());
            if (dist < 40 && dist < minDist) {
                minDist = dist;
                ziel = f;
            }
        }

        if (ziel != null) {
            ziel.erschrecken();
        }
    }
}