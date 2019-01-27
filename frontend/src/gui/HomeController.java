package gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{
    @FXML
    private JFXButton intialize;

    @FXML
    private JFXButton documentation;

    public void intialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Patientdata.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("PatientData");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void documentation(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Lian-D/nwHacks2019-Project").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
