package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;
public class Main extends Application {


    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/ICS_324_P";
            String username = "root";
            String pass = "asd123123";
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url,username,pass);
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

        //Connection  c = getConnection();
        Statement statement;


        Button btn = new Button("Ok");
        root.add(btn,0,1);
        //Connection conn = getConnection();
        //statement = c.createStatement();
        String datainfo = ("SELECT * FROM Status;");
        //ResultSet Result =statement.executeQuery(datainfo);


        Label label1 = new Label("\t0\t");
        Label label2 = new Label("\t0\t");
        String Result2 = "";
        Alert alert = new Alert(Alert.AlertType.WARNING);
       /* if (!Result.next()) {
            String Name = Result.getString("Status_ID");
            String GPA = Result.getString("Status_Name");
            String Major = Result.getString("Status_type");
            Result2 = Name+GPA+Major;
        }*/


        label1.setText(Result2);
        root.add(label1,0,0);
        root.add(label2,1,0);

        DataBase dataBase = new DataBase();
        label1.setText(dataBase.getStatus().toString());
        try {
            label2.setText(dataBase.getUser().toString());
        }catch(Exception e){
            alert.setContentText(e.getMessage());
            alert.show();
            System.out.println();
        }

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
