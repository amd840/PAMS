package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.sql.*;
import javax.swing.JButton;
import javafx.event.ActionEvent;

import java.util.Date;
public class Main extends Application {


    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/ICS_324_P";
            String url2 = "jdbc:mysql://pams.cknp9z0b9nmv.us-east-2.rds.amazonaws.com:3306/PAMS";

            String username = "root";
            String pass = "asd123123";
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url2,username,pass);
            System.out.println("seccufull");
            return connection;

        }catch (Exception e){

            System.out.println("..--.."+e.getMessage());

        }


        return null;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        GridPane root = new GridPane();
        GridPane textgrid = new GridPane();

        //Connection  c = getConnection();


        Button btn = new Button("register");
        Button sign = new Button("Sign in");

        //Connection conn = getConnection();
        //statement = c.createStatement();
        //ResultSet Result =statement.executeQuery(datainfo);

        TextField username = new TextField();
        username.setPromptText("Enter User Name");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");


        root.add(textgrid,0,0);
        root.add(sign,0,1);
        root.add(btn,0,2);
        root.setVgap(10);
        //sign.setMinWidth(150);
        sign.setPrefSize(200,30);
        btn.setPrefSize(200,30);

        Color color = Color.BLACK;
        username.setPrefSize(200,30);
        password.setPrefSize(200,30);

        textgrid.setAlignment(Pos.CENTER);
        btn.setAlignment(Pos.CENTER);
        sign.setAlignment(Pos.CENTER);

        textgrid.add(username,0,0);
        textgrid.add(password,0,1);
        textgrid.setVgap(5);

        DataBase dataBase = new DataBase();
        btn.setOnAction((ActionEvent a)-> {
            Register register = new Register();
            try {
                register.start(primaryStage);
            } catch (Exception e) {
                Alert at = new Alert(Alert.AlertType.ERROR);
                at.setContentText(e.getMessage());
                at.show();
                e.printStackTrace();
            }


        });

        /*
        // ----just for test----//
        //label1.setText(dataBase.getStatus().toString());
        try {
            //label2.setText(dataBase.getUser().toString());
        }catch(Exception e){
            alert.setContentText(e.getMessage());
            alert.show();
            System.out.println();
        }
        Users user1 = new Users("Ahmed","1234","","","","",111,1,1);
        try {
           // dataBase.addUser(user1);
        }catch (Exception e){
            alert.setContentText(e.getMessage());
            alert.show();
        }
        */
        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
