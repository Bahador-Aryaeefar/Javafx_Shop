package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class repItem extends Pane
    {
    private Label name;
    private Label id;
    private Label info;
    private Label price;
    private Label number;
    private Label total;
    private Button iinfo;
    private int count;

    public Button getIinfo()
        {
        return iinfo;
        }

    public void setIinfo(Button iinfo)
        {
        this.iinfo = iinfo;
        }

    public Label getName()
        {
        return name;
        }
    
    public void setName(Label name)
        {
        this.name = name;
        }
    
    public Label getID()
        {
        return id;
        }
    
    public void setId(Label id)
        {
        this.id = id;
        }
    
    public Label getInfo()
        {
        return info;
        }
    
    public void setInfo(Label info)
        {
        this.info = info;
        }
    
    public Label getPrice()
        {
        return price;
        }
    
    public void setPrice(Label price)
        {
        this.price = price;
        }
    
    public Label getNumber()
        {
        return number;
        }
    
    public void setNumber(Label number)
        {
        this.number = number;
        }
    
    public Label getTotal()
        {
        return total;
        }
    
    public void setTotal(Label total)
        {
        this.total = total;
        }
    
    public int getCount()
        {
        return count;
        }
    
    public void setCount(int count)
        {
        this.count = count;
        }
    
    public repItem(String Name, int Id, String Info, double Price, int Number,double Total)
        {
        super();
        
        name = new Label(Name);
        name.prefWidthProperty().bind(prefWidthProperty().divide(6));
        name.setPrefHeight(60);
        name.setAlignment(Pos.CENTER);
        name.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        id = new Label(String.valueOf(Id));
        id.prefWidthProperty().bind(prefWidthProperty().divide(6));
        id.setPrefHeight(60);
        id.layoutXProperty().bind(prefWidthProperty().divide(6).multiply(1));
        id.setAlignment(Pos.CENTER);
        id.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        info = new Label(Info);
        
        iinfo = new Button();
        try
            {
            File f = new File("inf.png");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setLayoutX(-1);
            iv.setFitHeight(25);
            iv.setFitWidth(25);
            iinfo.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        iinfo.prefWidthProperty().bind(prefWidthProperty().divide(6).divide(2));
        iinfo.setMinHeight(30);
        iinfo.setPrefHeight(30);
        iinfo.setLayoutY(15);
        iinfo.layoutXProperty().bind(prefWidthProperty().divide(6).divide(4).multiply(9));
        iinfo.setAlignment(Pos.CENTER);
        iinfo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        price = new Label(String.valueOf(Price));
        price.prefWidthProperty().bind(prefWidthProperty().divide(6));
        price.setPrefHeight(60);
        price.layoutXProperty().bind(prefWidthProperty().divide(6).multiply(3));
        price.setAlignment(Pos.CENTER);
        price.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        number = new Label(String.valueOf(Number));
        number.prefWidthProperty().bind(prefWidthProperty().divide(6));
        number.setPrefHeight(60);
        number.layoutXProperty().bind(prefWidthProperty().divide(6).multiply(4));
        number.setAlignment(Pos.CENTER);
        number.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        total = new Label(String.valueOf(Total));
        total.prefWidthProperty().bind(prefWidthProperty().divide(6).add(-19));
        total.setPrefHeight(60);
        total.layoutXProperty().bind(prefWidthProperty().divide(6).multiply(5));
        total.setAlignment(Pos.CENTER);
        total.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        getChildren().addAll(name,id,iinfo,price,number,total);
        }
    }
