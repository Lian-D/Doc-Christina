package gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{
    @FXML
    private JFXButton intialize;

    @FXML
    private JFXButton documentation;

    public void intialize(){
        System.out.println("wow");
    }

    public void documentation(){
        System.out.println("wow2");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
