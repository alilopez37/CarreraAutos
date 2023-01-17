package com.example.carreraautos.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HelloController {

    @FXML
    private AnchorPane rootScene;

    @FXML
    public void initialize(){
        System.out.println(getClass().getResource("/assets/imgs/pista.png"));
        ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgs/pista.png")));
        rootScene.getChildren().add(fondo);
    }
}
