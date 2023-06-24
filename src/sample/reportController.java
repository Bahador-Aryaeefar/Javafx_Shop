package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ResourceBundle;

public class reportController implements Initializable
    {
    public Pane sortPane;
    public ScrollPane ss;
    public Pane cPane;

    @Override
    public void initialize(URL location, ResourceBundle resources)
        {
        cPane.setStyle("-fx-background-color: #d2d2d2");
        cPane.prefWidthProperty().bind(ss.widthProperty().add(-8));
        cPane.setLayoutY(0);
        sortPane.prefWidthProperty().bind(ss.widthProperty());
        sortPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        
        Button name = new Button("Name");
        name.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(6));
        name.setPrefHeight(30);
        name.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button id = new Button("ID");
        id.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(6));
        id.setPrefHeight(30);
        id.layoutXProperty().bind(sortPane.prefWidthProperty().divide(6).multiply(1));
        id.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button info = new Button("Info");
        info.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(6));
        info.setPrefHeight(30);
        info.layoutXProperty().bind(sortPane.prefWidthProperty().divide(6).multiply(2));
        info.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button price = new Button("Price");
        price.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(6));
        price.setPrefHeight(30);
        price.layoutXProperty().bind(sortPane.prefWidthProperty().divide(6).multiply(3));
        price.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button number = new Button("Number");
        number.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(6));
        number.setPrefHeight(30);
        number.layoutXProperty().bind(sortPane.prefWidthProperty().divide(6).multiply(4));
        number.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button total = new Button("Total");
        total.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(6));
        total.setPrefHeight(30);
        total.layoutXProperty().bind(sortPane.prefWidthProperty().divide(6).multiply(5));
        total.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        
        sortPane.getChildren().addAll(name,id,info,price,number,total);
        }
    }
