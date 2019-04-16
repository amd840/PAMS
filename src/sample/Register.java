package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.Statement;

public class Register extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Button back = new Button("Back");


        GridPane root = new GridPane();



        Button btn = new Button("Ok");


        Label label = new Label("National ID");
        Label label1 = new Label("UserName");
        Label label2 = new Label("Password");
        Label label3 = new Label("conformation");
        Label label4 = new Label("Email");
        //Label label5 = new Label("Email");
        Label label6 = new Label("First Name");
        Label label7 = new Label("Last Name");
        //Label label8 = new Label("Types");

        TextField ID = new TextField();
        TextField username = new TextField();
        PasswordField passWord = new PasswordField();
        PasswordField passWord2 = new PasswordField();
        TextField email = new TextField();
        // TextField email2 = new TextField();
        TextField fName = new TextField();
        TextField lName = new TextField();
        //TextField Types = new TextField();


        String Result2 = "";
        Alert alert = new Alert(Alert.AlertType.WARNING);

        root.add(back,0,0);

        root.add(label,0,1);
        label.setAlignment(Pos.CENTER_LEFT);
        root.add(label1,0,2);

        root.add(label2,0,3);
        root.add(label3,0,4);
        root.add(label4,0,5);
        //root.add(label5,0,5);
        root.add(label6,0,6);
        root.add(label7,0,7);
        //root.add(label8,0,8);

        root.add(ID,1,1);
        root.add(username,1,2);
        root.add(passWord,1,3);
        root.add(passWord2,1,4);
        root.add(email,1,5);
        // root.add(email2,1,5);
        root.add(fName,1,6);
        root.add(lName,1,7);
        //root.add(Types,1,8);

        HBox btnBox = new HBox();
        btnBox.getChildren().addAll(btn);
        btnBox.setMinWidth(90);
        btn.setMinWidth(90);
        root.add(btnBox,0,9);
        btnBox.setAlignment(Pos.CENTER_RIGHT);
        root.setVgap(8);
        root.setHgap(15);


        DataBase dataBase = new DataBase();
        btn.setOnAction((ActionEvent a)-> {
            String Email = email.getText();
            if(!passWord.getText().equals(passWord2.getText())){
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Password Don't Match");
                alert.show();
            }else if(!Email.contains("@")||!Email.contains(".")){
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Wrong Email");
                alert.show();
            }
            else {
                try{
                    Users user1 = new Users(username.getText(),passWord.getText(),email.getText(),fName.getText(),lName.getText(),"",new Integer(ID.getText()),4,1);
                    dataBase.addUser(user1);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("Registeration Success");
                    alert.show();

                }catch (Exception e){
                    alert.setContentText(e.getMessage());
                    alert.show();
                }

            }
        });

        back.setOnAction((ActionEvent e) -> {
            Main main = new Main();
            try {
                main.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
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
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

