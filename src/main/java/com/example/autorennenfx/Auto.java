package com.example.autorennenfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;
import java.util.Objects;

public class Auto extends Fahrzeug {

    private static final Media HUPE =
            new Media(Objects.requireNonNull(Auto.class.getResource("hupe.wav")).toString());

    private static final Image AUTO_IMAGE =
            new Image(Objects.requireNonNull(Auto.class.getResource("auto.png")).toExternalForm());

    public Auto(double y, Color farbe) {
        super(y, farbe, 55, 30, 0.5, 1.2);
    }

    public String getGeschwindigkeit() {
        DecimalFormat df = new DecimalFormat("000");
        return df.format(geschwindigkeit * 10);
    }

    public void hupen() {
        MediaPlayer mp = new MediaPlayer(HUPE);
        mp.play();
    }

    @Override
    public void anzeigen(GraphicsContext gc) {
        // Auto-Bild zeichnen
        gc.drawImage(AUTO_IMAGE, getX(), getY());
    }
}