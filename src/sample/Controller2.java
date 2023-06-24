package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable
    {
    public Button butt;

    public TextField nameT;
    
    public TextField idT;
    
    public TextField priceT;
    
    public TextArea infoT;
    
    public TextField stockT;
    
    public Button cancel;
    
    public GridPane grid;

    @Override
    public void initialize(URL location, ResourceBundle resources)
        {
        try
            {
            File f = new File("b.jpg");
            FileInputStream inputImg = new FileInputStream(f);
            Image img = new Image(inputImg);
            BackgroundImage back = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            grid.setBackground(new Background(back));
            }
        catch (FileNotFoundException e)
            {
            e.printStackTrace();
            }
        }
    }
