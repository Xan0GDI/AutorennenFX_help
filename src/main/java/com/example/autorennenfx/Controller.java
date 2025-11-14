package com.example.autorennenfx;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller {

    @FXML private Canvas cvsFahrbahn;
    @FXML private Label lblTacho1;
    @FXML private Label lblTacho2;

    private final Flotte flotte = new Flotte();

    private Auto auto1;
    private Auto auto2;
    private Fahrrad bike;

    @FXML
    public void initialize() {
        auto1 = new Auto(50, Color.RED);
        auto2 = new Auto(130, Color.BLUE);
        bike = new Fahrrad(220, Color.GREEN);

        flotte.add(auto1);
        flotte.add(auto2);
        flotte.add(bike);

        new AnimationTimer() {
            @Override
            public void handle(long now) { update(); }
        }.start();
    }


    // ---------------- Buttons ----------------

    @FXML
    void actGas1() { auto1.beschleunigen(); }

    @FXML
    void actBremse1() { auto1.bremsen(); }

    @FXML
    void actHupe1() {
        auto1.hupen();
        flotte.shockCheck();
    }

    @FXML
    void actGas2() { auto2.beschleunigen(); }

    @FXML
    void actBremse2() { auto2.bremsen(); }

    @FXML
    void actHupe2() {
        auto2.hupen();
        flotte.shockCheck();
    }

    @FXML
    void actTreten() { bike.beschleunigen(); }

    @FXML
    void actBremse3() { bike.bremsen(); }

    @FXML
    void actKlingeln() {
        bike.klingeln();
        flotte.shockCheck();
    }


    // ---------------- Update Loop ----------------

    private void update() {
        GraphicsContext gc = cvsFahrbahn.getGraphicsContext2D();
        gc.clearRect(0, 0, cvsFahrbahn.getWidth(), cvsFahrbahn.getHeight());

        for (Fahrzeug f : flotte.getFahrzeuge()) {
            f.fahren();
            f.rundeGgfVollenden(cvsFahrbahn.getWidth());
            f.anzeigen(gc);
        }

        lblTacho1.setText(auto1.getGeschwindigkeit());
        lblTacho2.setText(auto2.getGeschwindigkeit());
    }

}
