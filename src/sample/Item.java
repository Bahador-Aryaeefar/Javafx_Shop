package sample;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class Item extends Pane
    {
    private Label name;
    private Label id;
    private Label info;
    private Button iinfo;
    private Label price;
    private Label stock;
    private Label number;
    private Button up;
    private Button down;
    private Label total;
    private Button edit;
    private Button remove;
    private int count;
    
    public int getCount()
        {
        return count;
        }
    
    public void setCount(int count)
        {
        this.count = count;
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
    
    public void setID(Label id)
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
    
    public Label getStock()
        {
        return stock;
        }
    
    public void setStock(Label stock)
        {
        this.stock = stock;
        }
    
    public Label getNumber()
        {
        return number;
        }
    
    public void setNumber(Label number)
        {
        this.number = number;
        }
    
    public Button getUp()
        {
        return up;
        }
    
    public void setUp(Button up)
        {
        this.up = up;
        }
    
    public Button getDown()
        {
        return down;
        }
    
    public void setDown(Button down)
        {
        this.down = down;
        }
    
    public Label getTotal()
        {
        return total;
        }
    
    public void setTotal(Label total)
        {
        this.total = total;
        }
    
    public Button getEdit()
        {
        return edit;
        }
    
    public void setEdit(Button edit)
        {
        this.edit = edit;
        }
    
    public Button getRemove()
        {
        return remove;
        }
    
    public void setRemove(Button remove)
        {
        this.remove = remove;
        }
    
    public Button getIinfo()
        {
        return iinfo;
        }
    
    public void setIinfo(Button iinfo)
        {
        this.iinfo = iinfo;
        }
    
    public Item(String Name, int Id, double Price, String Info, int Stock)
        {
        super();
        name = new Label(Name);
        name.prefWidthProperty().bind(prefWidthProperty().divide(9));
        name.setPrefHeight(80);
        name.setAlignment(Pos.CENTER);
        name.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        id = new Label(String.valueOf(Id));
        id.prefWidthProperty().bind(prefWidthProperty().divide(9));
        id.setPrefHeight(80);
        id.layoutXProperty().bind(prefWidthProperty().divide(9).multiply(1));
        id.setAlignment(Pos.CENTER);
        id.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        info = new Label(Info);
        
        iinfo = new Button();
        try
            {
            File f = new File("inf.png");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setFitHeight(30);
            iv.setFitWidth(30);
            iinfo.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        iinfo.prefWidthProperty().bind(prefWidthProperty().divide(9).divide(2));
        iinfo.setMinHeight(40);
        iinfo.setPrefHeight(40);
        iinfo.layoutXProperty().bind(prefWidthProperty().divide(9).divide(4).multiply(9));
        iinfo.setLayoutY(20);
        iinfo.setAlignment(Pos.CENTER);
        iinfo.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        price = new Label(String.valueOf(Price));
        price.prefWidthProperty().bind(prefWidthProperty().divide(9));
        price.setPrefHeight(80);
        price.layoutXProperty().bind(prefWidthProperty().divide(9).multiply(3));
        price.setAlignment(Pos.CENTER);
        price.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        stock = new Label(String.valueOf(Stock));
        stock.prefWidthProperty().bind(prefWidthProperty().divide(9));
        stock.setPrefHeight(80);
        stock.layoutXProperty().bind(prefWidthProperty().divide(9).multiply(4));
        stock.setAlignment(Pos.CENTER);
        stock.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        number = new Label("0");
        number.prefWidthProperty().bind(prefWidthProperty().divide(9));
        number.setPrefHeight(80);
        number.layoutXProperty().bind(prefWidthProperty().divide(9).multiply(5));
        number.setAlignment(Pos.CENTER);
        number.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        up = new Button("▲");
        up.prefWidthProperty().bind(prefWidthProperty().divide(9).divide(2));
        up.setMinHeight(30);
        up.setPrefHeight(30);
        up.layoutXProperty().bind(prefWidthProperty().divide(9).divide(4).multiply(25));
        up.setLayoutY(10);
        up.setAlignment(Pos.CENTER);
        up.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        down = new Button("▼");
        down.prefWidthProperty().bind(prefWidthProperty().divide(9).divide(2));
        down.setMinHeight(30);
        down.setPrefHeight(30);
        down.layoutYProperty().bind(prefHeightProperty().divide(2));
        down.layoutXProperty().bind(prefWidthProperty().divide(9).divide(4).multiply(25));
        down.setAlignment(Pos.CENTER);
        down.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        total = new Label("0.0");
        total.prefWidthProperty().bind(prefWidthProperty().divide(9));
        total.setPrefHeight(80);
        total.layoutXProperty().bind(prefWidthProperty().divide(9).multiply(7));
        total.setAlignment(Pos.CENTER);
        total.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        edit = new Button();
        try
            {
            File f = new File("e.png");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setFitHeight(20);
            iv.setFitWidth(20);
            edit.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        edit.prefWidthProperty().bind(prefWidthProperty().divide(9).add(-19).divide(2));
        edit.setMinHeight(30);
        edit.setPrefHeight(30);
        edit.setLayoutY(10);
        edit.layoutXProperty().bind(prefWidthProperty().divide(9).divide(4).multiply(33).add((-19 / 4)));
        edit.setAlignment(Pos.CENTER);
        edit.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        remove = new Button();
        try
            {
            File f = new File("r.jpg");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setFitHeight(20);
            iv.setFitWidth(20);
            remove.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        remove.prefWidthProperty().bind(prefWidthProperty().divide(9).add(-19).divide(2));
        edit.setMinHeight(30);
        edit.setPrefHeight(30);
        remove.layoutXProperty().bind(prefWidthProperty().divide(9).divide(4).multiply(33).add((-19 / 4)));
        remove.layoutYProperty().bind(prefHeightProperty().divide(2));
        remove.setAlignment(Pos.CENTER);
        remove.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");


        setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        getChildren().addAll(name,id,iinfo,price,stock,number,up,down,total,edit,remove);
        }
    }
