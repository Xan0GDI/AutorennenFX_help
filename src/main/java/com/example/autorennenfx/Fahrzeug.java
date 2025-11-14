package com.example.autorennenfx;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Fahrzeug {

    private double x;
    private final double y;
    private final int laenge;
    private final Color farbe;

    protected double geschwindigkeit;
    private final double maxGeschwindigkeit;
    private final double beschleunigung;
    private final double bremskraft;

    public Fahrzeug(double y, Color farbe, int laenge,
                    double maxGeschwindigkeit,
                    double beschleunigung,
                    double bremskraft) {

        this.x = 100 - laenge;
        this.y = y;
        this.laenge = laenge;
        this.farbe = farbe;

        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.beschleunigung = beschleunigung;
        this.bremskraft = bremskraft;

        this.geschwindigkeit = 0;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public Color getFarbe() { return farbe; }

    public Point2D getPoint() { return new Point2D(x, y); }

    public void beschleunigen() {
        geschwindigkeit += beschleunigung;
        if (geschwindigkeit > maxGeschwindigkeit)
            geschwindigkeit = maxGeschwindigkeit;
    }

    public void bremsen() {
        geschwindigkeit -= bremskraft;
        if (geschwindigkeit < 0)
            geschwindigkeit = 0;
    }

    public void erschrecken() {
        geschwindigkeit *= 0.3;   // shock → lose 70% speed
    }

    public void fahren() {
        x += geschwindigkeit;
    }

    public void rundeGgfVollenden(double fensterBreite) {
        if (x > fensterBreite)
            x = -laenge;
    }

    public abstract void anzeigen(GraphicsContext gc);
}
