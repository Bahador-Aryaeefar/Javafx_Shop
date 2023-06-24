package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable
    {
    
    //FXML/////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private Button pur;
    @FXML
    private Button addIc;
    @FXML
    private Button reportIc;
    @FXML
    private Button saveIc;
    @FXML
    private Button clearIc;
    @FXML
    private Label profitP;
    @FXML
    private Label totalP;
    @FXML
    private Pane sortPane;
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane ss;
    @FXML
    private Pane mPane;
    
    //Fields///////////////////////////////////////////////////////////////////////////////////////
    
    private ArrayList<Item> items;
    private ArrayList<repItem> repItems;
    private double totalPrice;
    private double profit;
    Sort<Item> sort;
    
    //Constructors/////////////////////////////////////////////////////////////////////////////////
    
    public Controller()
        {
        repItems = new ArrayList<>();
        items = new ArrayList<>();
        sort = new Sort<>(items);
        totalPrice = 0;
        profit = 0;
        }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
        {
        try
            {
            File f = new File("b.jpg");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            BackgroundImage back = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            grid.setBackground(new Background(back));
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        
        try
            {
            File f = new File("a.jpg");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setFitHeight(50);
            iv.setFitWidth(50);
            iv.setLayoutY(-1);
            iv.setLayoutX(-1);
            addIc.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        
        try
            {
            File f = new File("s.png");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setFitHeight(35);
            iv.setFitWidth(35);
            saveIc.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        
        try
            {
            File f = new File("buy.png");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            ImageView iv = new ImageView(img);
            iv.setFitHeight(60);
            iv.setFitWidth(60);
            pur.setGraphic(iv);
            }
        catch (FileNotFoundException e)
            {
            System.out.println(e);
            }
        
        addIc.setStyle("-fx-background-radius: 50%");
        clearIc.setStyle("-fx-background-radius: 0 0 50% 50%");
        reportIc.setStyle("-fx-background-radius: 50% 50% 0% 0%");
        saveIc.setStyle("-fx-background-radius: 50%");
        pur.setStyle("-fx-background-radius: 50%");
        
        mPane.setStyle("-fx-background-color: #d2d2d2");
        mPane.prefWidthProperty().bind(ss.widthProperty().add(-4));
        mPane.prefHeightProperty().bind(ss.heightProperty().add(items.size() * 80));
        mPane.setLayoutY(0);
        sortPane.prefWidthProperty().bind(ss.widthProperty());
        sortPane.setStyle("-fx-background-radius: 20%");
        
        Button name = new Button("Name");
        name.setAlignment(Pos.CENTER);
        name.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        name.setPrefHeight(40);
        name.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n" + "-fx-background-radius: 50% 0% 0% 0% ; \n" + "-fx-border-radius: 50% 0% 0% 0%");
        
        Button id = new Button("ID");
        id.setAlignment(Pos.CENTER);
        id.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        id.setPrefHeight(40);
        id.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(1));
        id.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        Button info = new Button("Info");
        info.setAlignment(Pos.CENTER);
        info.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        info.setPrefHeight(40);
        info.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(2));
        info.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        Button price = new Button("Price");
        price.setAlignment(Pos.CENTER);
        price.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        price.setPrefHeight(40);
        price.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(3));
        price.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        Button stock = new Button("Stock");
        stock.setAlignment(Pos.CENTER);
        stock.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        stock.setPrefHeight(40);
        stock.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(4));
        stock.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        Button number = new Button("Number");
        number.setAlignment(Pos.CENTER);
        number.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(2));
        number.setPrefHeight(40);
        number.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(5));
        number.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        Button total = new Button("Total");
        total.setAlignment(Pos.CENTER);
        total.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        total.setPrefHeight(40);
        total.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(7));
        total.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n");
        
        Button edit = new Button("Edit");
        edit.setAlignment(Pos.CENTER);
        edit.prefWidthProperty().bind(sortPane.prefWidthProperty().divide(9));
        edit.setPrefHeight(40);
        edit.layoutXProperty().bind(sortPane.prefWidthProperty().divide(9).multiply(8));
        edit.setStyle("-fx-border-color: black ;\n" + "-fx-border-width: 1 ; \n" + "-fx-background-radius: 0% 50% 0% 0%; \n" + "-fx-border-radius: 0% 50% 0% 0%");
        
        sortPane.getChildren().addAll(name, id, info, price, stock, number, total, edit);
        
        name.setOnAction(this::sortName);
        id.setOnAction(this::sortId);
        price.setOnAction(this::sortPrice);
        stock.setOnAction(this::sortStock);
        number.setOnAction(this::sortNumber);
        total.setOnAction(this::sortTotal);
        
        try
            {
            File f = new File("lib.txt");
            Scanner input = new Scanner(f);
            int size = input.nextInt();
            input.nextLine();
            for (int i = 0; i < size; i++)
                {
                String nname = input.nextLine();
                String iid = input.nextLine();
                String iinfo = input.nextLine();
                String pprice = input.nextLine();
                String sstock = input.nextLine();
                String nnumber = input.nextLine();
                String ttotal = input.nextLine();
                add2(new Item(nname, Integer.parseInt(iid), Double.parseDouble(pprice), iinfo, Integer.parseInt(sstock)), nnumber, ttotal);
                }
            totalPrice = Double.parseDouble(input.nextLine());
            profit = Double.parseDouble(input.nextLine());
            totalP.setText(" " + totalPrice);
            profitP.setText(" " + profit);
            size = input.nextInt();
            input.nextLine();
            for (int i = 0; i < size; i++)
                {
                String nname = input.nextLine();
                String iid = input.nextLine();
                String iinfo = input.nextLine();
                String pprice = input.nextLine();
                String nnumber = input.nextLine();
                String ttotal = input.nextLine();
                repItems.add(new repItem(nname, Integer.parseInt(iid), iinfo, Double.parseDouble(pprice), Integer.parseInt(nnumber), Double.parseDouble(ttotal)));
                }
            }
        catch (Exception exception)
            {
            System.out.println(exception);
            }
        }
    
    //Add methods//////////////////////////////////////////////////////////////////////////////////
    
    public void add1(ActionEvent actionEvent) throws Exception
        {
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Stage secStage = new Stage();
        secStage.setTitle("Add");
        secStage.setScene(new Scene(root, 700, 700));
        secStage.initModality(Modality.APPLICATION_MODAL);
        secStage.show();
        TextField Name = (TextField) secStage.getScene().lookup("#nameT");
        TextField Id = (TextField) secStage.getScene().lookup("#idT");
        TextField Price = (TextField) secStage.getScene().lookup("#priceT");
        TextField Stock = (TextField) secStage.getScene().lookup("#stockT");
        TextArea Info = (TextArea) secStage.getScene().lookup("#infoT");
        
        Button but1 = (Button) secStage.getScene().lookup("#butt");
        but1.setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                if (Name.getText().isEmpty())
                    {
                    alert.setContentText("Invalid name");
                    alert.show();
                    return;
                    }
                
                try
                    {
                    Integer.parseInt(Id.getText());
                    }
                catch (Exception e)
                    {
                    alert.setContentText("Invalid ID");
                    alert.show();
                    return;
                    }
                if (Integer.parseInt(Id.getText()) <= 0)
                    {
                    alert.setContentText("Invalid ID");
                    alert.show();
                    return;
                    }
                
                try
                    {
                    Double.parseDouble(Price.getText());
                    }
                catch (Exception e)
                    {
                    alert.setContentText("Invalid Price");
                    alert.show();
                    return;
                    }
                if (Double.parseDouble(Price.getText()) <= 0)
                    {
                    alert.setContentText("Invalid Price");
                    alert.show();
                    return;
                    }
                
                
                try
                    {
                    Integer.parseInt(Stock.getText());
                    }
                catch (Exception e)
                    {
                    alert.setContentText("Invalid Stock");
                    alert.show();
                    return;
                    }
                if (Integer.parseInt(Stock.getText()) < 0)
                    {
                    alert.setContentText("Invalid Stock");
                    alert.show();
                    return;
                    }
                
                items.add(new Item(Name.getText(), Integer.parseInt(Id.getText()), Double.parseDouble(Price.getText()), Info.getText(), Integer.parseInt(Stock.getText())));
                items.get(items.size() - 1).setCount(items.size() - 1);
                items.get(items.size() - 1).prefWidthProperty().bind(ss.widthProperty());
                items.get(items.size() - 1).setPrefHeight(80);
                items.get(items.size() - 1).setLayoutY((items.size() - 1) * 80 + 1);
                mPane.getChildren().add(items.get(items.size() - 1));
                mPane.prefHeightProperty().bind(ss.heightProperty().add(items.size() * 80));
                
                Item temp = items.get(items.size() - 1);
                
                temp.getIinfo().setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        Alert infor = new Alert(Alert.AlertType.INFORMATION);
                        infor.setTitle("Description");
                        infor.setHeaderText("Description");
                        infor.setContentText(temp.getInfo().getText());
                        infor.show();
                        }
                    });
                
                temp.getUp().setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        if (Integer.parseInt(temp.getNumber().getText()) < Integer.parseInt(temp.getStock().getText()))
                            {
                            temp.getNumber().setText(String.valueOf(Integer.parseInt(temp.getNumber().getText()) + 1));
                            temp.getTotal().setText(String.valueOf(Double.parseDouble(temp.getPrice().getText()) * Integer.parseInt(temp.getNumber().getText())));
                            totalPrice += Double.parseDouble(temp.getPrice().getText());
                            totalP.setText(" " + totalPrice);
                            }
                        }
                    });
                
                temp.getDown().setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        if (Integer.parseInt(temp.getNumber().getText()) > 0)
                            {
                            temp.getNumber().setText(String.valueOf(Integer.parseInt(temp.getNumber().getText()) - 1));
                            temp.getTotal().setText(String.valueOf(Double.parseDouble(temp.getPrice().getText()) * Integer.parseInt(temp.getNumber().getText())));
                            totalPrice -= Double.parseDouble(temp.getPrice().getText());
                            totalP.setText(" " + totalPrice);
                            }
                        }
                    });
                
                temp.getEdit().setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        Parent root2 = null;
                        try
                            {
                            root2 = FXMLLoader.load(getClass().getResource("add.fxml"));
                            }
                        catch (IOException e)
                            {
                            e.printStackTrace();
                            }
                        Stage editStage = new Stage();
                        editStage.setTitle("Edit");
                        editStage.setScene(new Scene(root2, 700, 700));
                        editStage.initModality(Modality.APPLICATION_MODAL);
                        editStage.show();
                        
                        TextField Name = (TextField) editStage.getScene().lookup("#nameT");
                        TextField Id = (TextField) editStage.getScene().lookup("#idT");
                        TextField Price = (TextField) editStage.getScene().lookup("#priceT");
                        TextField Stock = (TextField) editStage.getScene().lookup("#stockT");
                        TextArea Info = (TextArea) editStage.getScene().lookup("#infoT");
                        
                        Name.setText(temp.getName().getText());
                        Id.setText(temp.getID().getText());
                        Price.setText(String.valueOf(Double.parseDouble(temp.getPrice().getText())));
                        Info.setText(temp.getInfo().getText());
                        Stock.setText(temp.getStock().getText());
                        
                        Button butt1 = (Button) editStage.getScene().lookup("#butt");
                        butt1.setText("Edit");
                        butt1.setOnAction(new EventHandler<ActionEvent>()
                            {
                            @Override
                            public void handle(ActionEvent event)
                                {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                if (Name.getText().isEmpty())
                                    {
                                    alert.setContentText("Invalid name");
                                    alert.show();
                                    return;
                                    }
                                
                                try
                                    {
                                    Integer.parseInt(Id.getText());
                                    }
                                catch (Exception e)
                                    {
                                    alert.setContentText("Invalid ID");
                                    alert.show();
                                    return;
                                    }
                                if (Integer.parseInt(Id.getText()) <= 0)
                                    {
                                    alert.setContentText("Invalid ID");
                                    alert.show();
                                    return;
                                    }
                                
                                try
                                    {
                                    Double.parseDouble(Price.getText());
                                    }
                                catch (Exception e)
                                    {
                                    alert.setContentText("Invalid Price");
                                    alert.show();
                                    return;
                                    }
                                if (Double.parseDouble(Price.getText()) <= 0)
                                    {
                                    alert.setContentText("Invalid Price");
                                    alert.show();
                                    return;
                                    }
                                
                                
                                try
                                    {
                                    Integer.parseInt(Stock.getText());
                                    }
                                catch (Exception e)
                                    {
                                    alert.setContentText("Invalid Stock");
                                    alert.show();
                                    return;
                                    }
                                if (Integer.parseInt(Stock.getText()) < 0)
                                    {
                                    alert.setContentText("Invalid Stock");
                                    alert.show();
                                    return;
                                    }
                                
                                totalPrice -= (Integer.parseInt(temp.getNumber().getText()) * Double.parseDouble(temp.getPrice().getText()));
                                totalP.setText(" " + totalPrice);
                                temp.getName().setText(Name.getText());
                                temp.getID().setText(Id.getText());
                                temp.getPrice().setText(String.valueOf(Double.parseDouble(Price.getText())));
                                temp.getInfo().setText(Info.getText());
                                temp.getStock().setText(Stock.getText());
                                temp.getNumber().setText("0");
                                temp.getTotal().setText("0.0");
                                editStage.close();
                                }
                            });
                        
                        Button butt2 = (Button) editStage.getScene().lookup("#cancel");
                        butt2.setOnAction(new EventHandler<ActionEvent>()
                            {
                            @Override
                            public void handle(ActionEvent event)
                                {
                                editStage.close();
                                }
                            });
                        }
                    });
                
                temp.getRemove().setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        totalPrice -= Double.parseDouble(temp.getTotal().getText());
                        totalP.setText(" " + totalPrice);
                        items.remove(temp.getCount());
                        for (int i = 0; i < items.size(); i++)
                            {
                            items.get(i).setCount(i);
                            }
                        reDraw();
                        }
                    });
                
                secStage.close();
                }
            });
        
        Button but2 = (Button) secStage.getScene().lookup("#cancel");
        but2.setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                secStage.close();
                }
            });
        }
    
    public void add2(Item i, String nn, String tt)
        {
        items.add(i);
        items.get(items.size() - 1).getNumber().setText(nn);
        items.get(items.size() - 1).getTotal().setText(tt);
        items.get(items.size() - 1).setCount(items.size() - 1);
        items.get(items.size() - 1).prefWidthProperty().bind(ss.widthProperty());
        items.get(items.size() - 1).setPrefHeight(80);
        items.get(items.size() - 1).setLayoutY((items.size() - 1) * 80 + 1);
        mPane.getChildren().add(items.get(items.size() - 1));
        mPane.prefHeightProperty().bind(ss.heightProperty().add(items.size() * 80));
        
        Item temp = items.get(items.size() - 1);
        
        temp.getIinfo().setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                Alert infor = new Alert(Alert.AlertType.INFORMATION);
                infor.setTitle("Description");
                infor.setHeaderText("Description");
                infor.setContentText(temp.getInfo().getText());
                infor.show();
                }
            });
        
        temp.getUp().setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                if (Integer.parseInt(temp.getNumber().getText()) < Integer.parseInt(temp.getStock().getText()))
                    {
                    temp.getNumber().setText(String.valueOf(Integer.parseInt(temp.getNumber().getText()) + 1));
                    temp.getTotal().setText(String.valueOf(Double.parseDouble(temp.getPrice().getText()) * Integer.parseInt(temp.getNumber().getText())));
                    totalPrice += Double.parseDouble(temp.getPrice().getText());
                    totalP.setText(" " + totalPrice);
                    }
                }
            });
        
        temp.getDown().setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                if (Integer.parseInt(temp.getNumber().getText()) > 0)
                    {
                    temp.getNumber().setText(String.valueOf(Integer.parseInt(temp.getNumber().getText()) - 1));
                    temp.getTotal().setText(String.valueOf(Double.parseDouble(temp.getPrice().getText()) * Integer.parseInt(temp.getNumber().getText())));
                    totalPrice -= Double.parseDouble(temp.getPrice().getText());
                    totalP.setText(" " + totalPrice);
                    }
                }
            });
        
        temp.getEdit().setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                Parent root2 = null;
                try
                    {
                    root2 = FXMLLoader.load(getClass().getResource("add.fxml"));
                    }
                catch (IOException e)
                    {
                    e.printStackTrace();
                    }
                Stage editStage = new Stage();
                editStage.setTitle("Edit");
                editStage.setScene(new Scene(root2, 700, 700));
                editStage.initModality(Modality.APPLICATION_MODAL);
                editStage.show();
                
                TextField Name = (TextField) editStage.getScene().lookup("#nameT");
                TextField Id = (TextField) editStage.getScene().lookup("#idT");
                TextField Price = (TextField) editStage.getScene().lookup("#priceT");
                TextField Stock = (TextField) editStage.getScene().lookup("#stockT");
                TextArea Info = (TextArea) editStage.getScene().lookup("#infoT");
                
                Name.setText(temp.getName().getText());
                Id.setText(temp.getID().getText());
                Price.setText(temp.getPrice().getText());
                Info.setText(temp.getInfo().getText());
                Stock.setText(temp.getStock().getText());
                
                Button butt1 = (Button) editStage.getScene().lookup("#butt");
                butt1.setText("Edit");
                butt1.setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        if (Name.getText().isEmpty())
                            {
                            alert.setContentText("Invalid name");
                            alert.show();
                            return;
                            }
                        
                        try
                            {
                            Integer.parseInt(Id.getText());
                            }
                        catch (Exception e)
                            {
                            alert.setContentText("Invalid ID");
                            alert.show();
                            return;
                            }
                        if (Integer.parseInt(Id.getText()) <= 0)
                            {
                            alert.setContentText("Invalid ID");
                            alert.show();
                            return;
                            }
                        
                        try
                            {
                            Double.parseDouble(Price.getText());
                            }
                        catch (Exception e)
                            {
                            alert.setContentText("Invalid Price");
                            alert.show();
                            return;
                            }
                        if (Double.parseDouble(Price.getText()) <= 0)
                            {
                            alert.setContentText("Invalid Price");
                            alert.show();
                            return;
                            }
                        
                        
                        try
                            {
                            Integer.parseInt(Stock.getText());
                            }
                        catch (Exception e)
                            {
                            alert.setContentText("Invalid Stock");
                            alert.show();
                            return;
                            }
                        if (Integer.parseInt(Stock.getText()) < 0)
                            {
                            alert.setContentText("Invalid Stock");
                            alert.show();
                            return;
                            }
                        
                        totalPrice -= (Integer.parseInt(temp.getNumber().getText()) * Double.parseDouble(temp.getPrice().getText()));
                        totalP.setText(" " + totalPrice);
                        temp.getName().setText(Name.getText());
                        temp.getID().setText(Id.getText());
                        temp.getPrice().setText(String.valueOf(Double.parseDouble(Price.getText())));
                        temp.getInfo().setText(Info.getText());
                        temp.getStock().setText(Stock.getText());
                        temp.getNumber().setText("0");
                        temp.getTotal().setText("0");
                        editStage.close();
                        }
                    });
                
                Button butt2 = (Button) editStage.getScene().lookup("#cancel");
                butt2.setOnAction(new EventHandler<ActionEvent>()
                    {
                    @Override
                    public void handle(ActionEvent event)
                        {
                        editStage.close();
                        }
                    });
                }
            });
        
        temp.getRemove().setOnAction(new EventHandler<ActionEvent>()
            {
            @Override
            public void handle(ActionEvent event)
                {
                totalPrice -= Double.parseDouble(temp.getTotal().getText());
                totalP.setText(" " + totalPrice);
                items.remove(temp.getCount());
                for (int i = 0; i < items.size(); i++)
                    {
                    items.get(i).setCount(i);
                    }
                reDraw();
                }
            });
        }
    
    public void reDraw()
        {
        mPane.getChildren().clear();
        mPane.prefHeightProperty().bind(ss.heightProperty().add(items.size() * 80));
        for (int i = 0; i < items.size(); i++)
            {
            items.get(i).setLayoutY(i * 80);
            mPane.getChildren().add(items.get(i));
            }
        }
    
    //Purchase/////////////////////////////////////////////////////////////////////////////////////
    
    public void purchase(ActionEvent actionEvent)
        {
        profit += totalPrice;
        totalPrice = 0;
        profitP.setText(" " + profit);
        totalP.setText(" " + totalPrice);
        for (int i = 0; i < items.size(); i++)
            {
            if (!items.get(i).getNumber().getText().equals("0"))
                {
                Item temp = items.get(i);
                repItems.add(new repItem(temp.getName().getText(), Integer.parseInt(temp.getID().getText()), temp.getInfo().getText(), Double.parseDouble(temp.getPrice().getText()), Integer.parseInt(temp.getNumber().getText()), Double.parseDouble(temp.getTotal().getText())));
                items.get(i).getStock().setText(String.valueOf(Integer.parseInt(items.get(i).getStock().getText()) - Integer.parseInt(items.get(i).getNumber().getText())));
                items.get(i).getNumber().setText("0");
                items.get(i).getTotal().setText("0.0");
                }
            }
        }
    
    public void report(ActionEvent actionEvent) throws Exception
        {
        Parent root = FXMLLoader.load(getClass().getResource("report.fxml"));
        Stage reportStage = new Stage();
        reportStage.setTitle("Report");
        reportStage.setScene(new Scene(root, 940, 500));
        reportStage.initModality(Modality.APPLICATION_MODAL);
        reportStage.show();
        
        ScrollPane repSS = (ScrollPane) reportStage.getScene().lookup("#ss");
        Pane cPane = (Pane) reportStage.getScene().lookup("#cPane");
        cPane.getChildren().clear();
        cPane.prefHeightProperty().bind(repSS.heightProperty().add(repItems.size() * 60));
        for (int i = 0; i < repItems.size(); i++)
            {
            repItem temp = repItems.get(i);
            repItems.get(i).getIinfo().setOnAction(new EventHandler<ActionEvent>()
                {
                @Override
                public void handle(ActionEvent event)
                    {
                    Alert infor = new Alert(Alert.AlertType.INFORMATION);
                    infor.setTitle("Description");
                    infor.setHeaderText("Description");
                    infor.setContentText(temp.getInfo().getText());
                    infor.show();
                    }
                });
            repItems.get(i).prefWidthProperty().bind(repSS.widthProperty());
            repItems.get(i).setPrefHeight(60);
            repItems.get(i).setLayoutY(i * 60);
            repItems.get(i).setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            cPane.getChildren().add(repItems.get(i));
            }
        }
    
    public void clear(ActionEvent actionEvent)
        {
        profit = 0;
        profitP.setText(" " + profit);
        repItems = new ArrayList<>();
        }
    
    //Sort methods/////////////////////////////////////////////////////////////////////////////////
    
    public void sortName(ActionEvent actionEvent)
        {
        sort.sort(new Comparator<Item>()
            {
            @Override
            public boolean compare(Item o1, Item o2)
                {
                if (o1.getName().getText().compareTo(o2.getName().getText()) > 0) return true;
                else return false;
                }
            });
        for (int i = 0; i < items.size(); i++) items.get(i).setCount(i);
        reDraw();
        }
    
    public void sortId(ActionEvent actionEvent)
        {
        sort.sort(new Comparator<Item>()
            {
            @Override
            public boolean compare(Item o1, Item o2)
                {
                return (Integer.parseInt(o2.getID().getText()) < Integer.parseInt(o1.getID().getText()));
                }
            });
        for (int i = 0; i < items.size(); i++) items.get(i).setCount(i);
        reDraw();
        }
    
    public void sortPrice(ActionEvent actionEvent)
        {
        sort.sort(new Comparator<Item>()
            {
            @Override
            public boolean compare(Item o1, Item o2)
                {
                return (Double.parseDouble(o2.getPrice().getText()) < Double.parseDouble(o1.getPrice().getText()));
                }
            });
        for (int i = 0; i < items.size(); i++) items.get(i).setCount(i);
        reDraw();
        }
    
    public void sortStock(ActionEvent actionEvent)
        {
        sort.sort(new Comparator<Item>()
            {
            @Override
            public boolean compare(Item o1, Item o2)
                {
                return (Integer.parseInt(o2.getStock().getText()) > Integer.parseInt(o1.getStock().getText()));
                }
            });
        for (int i = 0; i < items.size(); i++) items.get(i).setCount(i);
        reDraw();
        }
    
    public void sortNumber(ActionEvent actionEvent)
        {
        sort.sort(new Comparator<Item>()
            {
            @Override
            public boolean compare(Item o1, Item o2)
                {
                return (Integer.parseInt(o2.getNumber().getText()) > Integer.parseInt(o1.getNumber().getText()));
                }
            });
        for (int i = 0; i < items.size(); i++) items.get(i).setCount(i);
        reDraw();
        }
    
    public void sortTotal(ActionEvent actionEvent)
        {
        sort.sort(new Comparator<Item>()
            {
            @Override
            public boolean compare(Item o1, Item o2)
                {
                return (Double.parseDouble(o2.getTotal().getText()) > Double.parseDouble(o1.getTotal().getText()));
                }
            });
        for (int i = 0; i < items.size(); i++) items.get(i).setCount(i);
        reDraw();
        }
    
    //Save/////////////////////////////////////////////////////////////////////////////////////////
    
    public void save(ActionEvent actionEvent) throws Exception
        {
        PrintWriter pw = new PrintWriter("lib.txt");
        pw.println(items.size());
        for (int i = 0; i < items.size(); i++)
            {
            pw.println(items.get(i).getName().getText());
            pw.println(items.get(i).getID().getText());
            pw.println(items.get(i).getInfo().getText());
            pw.println(items.get(i).getPrice().getText());
            pw.println(items.get(i).getStock().getText());
            pw.println(items.get(i).getNumber().getText());
            pw.println(items.get(i).getTotal().getText());
            }
        pw.println(totalPrice);
        pw.println(profit);
        pw.println(repItems.size());
        for (int i = 0; i < repItems.size(); i++)
            {
            pw.println(repItems.get(i).getName().getText());
            pw.println(repItems.get(i).getID().getText());
            pw.println(repItems.get(i).getInfo().getText());
            pw.println(repItems.get(i).getPrice().getText());
            pw.println(repItems.get(i).getNumber().getText());
            pw.println(repItems.get(i).getTotal().getText());
            }
        pw.close();
        }
        
    }
