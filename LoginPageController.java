package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController {
    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @FXML
    public void login(MouseEvent event) throws SQLException, IOException {
            String query = String.format("Select * from user where emailID = '%s' AND pass = '%s'",email.getText(),password.getText());
            ResultSet res = Main.connection.executeQuery(query);


            if(res.next()) {
                String userType = res.getString("userType");
                Main.emailId = res.getString("emailId");
                if (userType.equals("Buyer")) {
                    System.out.println("Logged in as Buyer");
                    productPage products = new productPage();
                    Header header = new Header();

                    ListView<HBox> productList = products.showProducts();

                    AnchorPane productPane = new AnchorPane();
                    productPane.setLayoutX(150);
                    productPane.setLayoutY(100);
                    productPane.getChildren().add(productList);
                    Main.root.getChildren().clear();
                    Main.root.getChildren().addAll(header.root,productPane);



                } else {
                    System.out.println("Logged in as Seller");
                    AnchorPane sellerPage = FXMLLoader.load((getClass().getResource("SellerPage.fxml")));
                    Main.root.getChildren().add(sellerPage);

                }
            }
            else
            {
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Login");
                ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("Login Failed!! Please Try Again");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
    }

}
