package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class Controller {
    @FXML
    public void helloclick(MouseEvent event) throws IOException{
        System.out.println("Hello is Clicked");
    }
}
