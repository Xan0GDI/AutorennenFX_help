package com.example.autorennenfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.util.Objects;
import java.text.DecimalFormat;

public class Fahrrad extends Fahrzeug {

    private static final Media KLINGEL =
            new Media(Objects.requireNonNull(Fahrrad.class.getResource("klingel.wav")).toString());

    private static final Image FAHRRAD_IMAGE =
            new Image(Objects.requireNonNull(Fahrrad.class.getResource("fahrrad.png")).toExternalForm());

    public Fahrrad(double y, Color farbe) {
        super(y, farbe, 45, 15, 0.3, 0.7);
    }

    public void klingeln() {
        MediaPlayer mp = new MediaPlayer(KLINGEL);
        mp.play();
    }

    @Override
    public void anzeigen(GraphicsContext gc) {
        // Bild auf 30px Höhe skalieren, Breite im Seitenverhältnis
        double targetHeight = 30;
        double scale = targetHeight / FAHRRAD_IMAGE.getHeight();
        double targetWidth = FAHRRAD_IMAGE.getWidth() * scale;

        gc.drawImage(FAHRRAD_IMAGE, getX(), getY(), targetWidth, targetHeight);
    }

    public String getGeschwindigkeit() {
        DecimalFormat df = new DecimalFormat("000");
        return df.format(geschwindigkeit * 10);
    }
}