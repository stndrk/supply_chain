package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
    public static DatabaseConnection connection;
    public static Group root;
    public static String emailId;

    @Override
    public void start(Stage primaryStage) throws Exception{
        emailId = "";
        connection = new DatabaseConnection();
        root = new Group();
        Header header = new Header();
        productPage products = new productPage();
        ListView<HBox> productList = products.showProducts();
        AnchorPane productPane = new AnchorPane();
        productPane.setLayoutX(150);
        productPane.setLayoutY(100);
        productPane.getChildren().add(productList);
        root.getChildren().addAll(header.root,productPane);
        primaryStage.setTitle("Supply Chain");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e ->{

            try {
                connection.con.close();
                System.out.println("Connection is closed");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
