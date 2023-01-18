package com.example.carreraautos.controllers;

import com.example.carreraautos.models.Chofer;
import com.example.carreraautos.models.Vector;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnPreparar;

    @FXML
    private AnchorPane rootScene;

    private Circle v1;
    private Circle v2;
    private Circle v3;
    private Chofer c1;
    private Chofer c2;
    private Chofer c3;

    @FXML
    void btnIniciarOnMouse(MouseEvent event) {
        c1 = new Chofer();
        c1.setPosicion(new Vector(1,20,60));
        c1.addObserver(this);
        new Thread(c1).start();

        c2 = new Chofer();
        c2.setPosicion(new Vector(2,20,150));
        c2.addObserver(this);
        new Thread(c2).start();

        c3 = new Chofer();
        c3.setPosicion(new Vector(3,20,250));
        c3.addObserver(this);
        new Thread(c3).start();
    }

    @FXML
    void btnPrepararOnMouse(MouseEvent event) {
        //Circulo 1
        v1 = new Circle(10, Color.WHITE);
        v1.setLayoutX(20);
        v1.setLayoutY(60);
        //Circulo 2
        v2 = new Circle(10, Color.WHITE);
        v2.setLayoutX(20);
        v2.setLayoutY(150);
        //Circulo 3
        v3 = new Circle(10, Color.WHITE);
        v3.setLayoutX(20);
        v3.setLayoutY(250);
        rootScene.getChildren().addAll(v1,v2,v3);
        //v1.toFront();
    }


    @FXML
    public void initialize(){
        ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgs/pista.png")));
        rootScene.getChildren().add(fondo);
        Line line = new Line(590,0,590,400);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        rootScene.getChildren().add(line);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(Thread.currentThread().getName());
        Vector pos = (Vector)arg;
        switch (pos.getId()){
            case 1:
                Platform.runLater(()-> v1.setLayoutX(pos.getX()));
                break;
            case 2:
                Platform.runLater(()-> v2.setLayoutX(pos.getX()));
                break;
            case 3:
                Platform.runLater(()-> v3.setLayoutX(pos.getX()));
        }
        //Detener vehículo
        if (pos.getX() + 10 > 590){
            switch (pos.getId()){
                case 1: c1.setStatus(false); break;
                case 2: c2.setStatus(false); break;
                case 3: c3.setStatus(false); break;
            }
        }
    }
}
