package sample;

import data_types.Clinics;
import data_types.Dentists;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.sql.*;
import javax.swing.JButton;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.Date;

public class Guest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //DataBase Connecter = new DataBase();

        Label back = new Label("Back");
        back.setTextFill(Color.BLUE);
        back.setFont(Font.font(17));
        //Button back = new Button("Back");
        HBox btnB = new HBox();
        btnB.getChildren().add(back);

        // ...

        Label Title = new Label("PAMS");
        Title.setFont(new Font(20));
        Title.setTextAlignment(TextAlignment.CENTER);
        //ObservableList<String> options = FXCollections.observableArrayList("182", "181", "173");
        //ComboBox<String> Term = new ComboBox<String>(options);

        //Term.setPromptText(Login.Current_term + "");


        //Add Table of Courses Add and Drop
        HBox TableBox = new HBox();
        TableView<Object> tableView = new TableView<Object>();
        TableBox.getChildren().addAll(tableView);
        TableBox.setAlignment(Pos.CENTER);


        TableColumn columnId = new TableColumn("D_ID");
        columnId.setStyle("-fx-alignment: CENTER;");
        columnId.setCellValueFactory(new PropertyValueFactory<>("D_ID"));
        TableColumn columnUser = new TableColumn("_Profile");
        columnUser.setStyle("-fx-alignment: CENTER;");
        columnUser.setCellValueFactory(new PropertyValueFactory<>("_Profile"));

        TableColumn columnFN = new TableColumn("FName");
        columnFN.setCellValueFactory(new PropertyValueFactory<>("FName"));
        columnFN.setStyle("-fx-alignment: CENTER;");
        TableColumn columnLN = new TableColumn("LName");
        columnLN.setCellValueFactory(new PropertyValueFactory<>("LName"));
        columnLN.setStyle("-fx-alignment: CENTER;");

        TableColumn columnY = new TableColumn("Years_Active");
        columnY.setCellValueFactory(new PropertyValueFactory<>("Years_Active"));
        columnY.setStyle("-fx-alignment: CENTER;");

        TableColumn columnrate = new TableColumn("Rating");
        columnrate.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        columnrate.setStyle("-fx-alignment: CENTER;");
        TableColumn columnEmail = new TableColumn("EMail");
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("EMail"));
        columnEmail.setStyle("-fx-alignment: CENTER;");

        TableColumn columnweb = new TableColumn("Website");
        columnweb.setCellValueFactory(new PropertyValueFactory<>("Website"));
        columnweb.setStyle("-fx-alignment: CENTER;");

        TableColumn columnSpecialty_ID = new TableColumn("Specialty_ID");
        columnSpecialty_ID.setCellValueFactory(new PropertyValueFactory<>("Specialty_ID"));
        columnSpecialty_ID.setStyle("-fx-alignment: CENTER;");


        TableColumn columnClinic_ID = new TableColumn("Clinic_ID");
        columnClinic_ID.setCellValueFactory(new PropertyValueFactory<>("Clinic_ID"));
        columnClinic_ID.setStyle("-fx-alignment: CENTER;");


        TableColumn columnClinic_Office = new TableColumn("Clinic_Office");
        columnClinic_Office.setCellValueFactory(new PropertyValueFactory<>("Clinic_Office"));
        columnClinic_Office.setStyle("-fx-alignment: CENTER;");

        TableColumn columnClinic_Num = new TableColumn("Clinic_Num");
        columnClinic_Num.setCellValueFactory(new PropertyValueFactory<>("Clinic_Num"));
        columnClinic_Num.setStyle("-fx-alignment: CENTER;");



        TableColumn columnState = new TableColumn("Status_ID");
        columnState.setCellValueFactory(new PropertyValueFactory<>("Status_ID"));
        columnState.setStyle("-fx-alignment: CENTER;");
        ArrayList<Users> x1 = new ArrayList<>();
        /* x1 = Connecter.getUser();

        Users[] x = new Users[x1.size()];
        for(int i=0 ; i<x1.size();i++)
            x[i]=x1.get(i);

        if (x != null)
            tableView.getItems().addAll(x);
*/
        //TextField[] T = new TextField[8];
        /*for (int i = 0; i < T.length; i++)
            T[i] = new TextField();
           */
        //Add Butttons
        Button btn1 = new Button("Log in");
        Button btn2 = new Button("Register");

        // Button btn2 = new Button("search");
        // Button btn3 = new Button("reset");

        //Add Columns and set their width
        tableView.getColumns().addAll(columnId,columnFN,columnLN,columnUser,columnY,columnweb,columnEmail,columnrate,columnSpecialty_ID,columnClinic_ID,columnClinic_Office,columnClinic_Num, columnState);

       //add element in the table

       /* x1 = Connecter.getUser();

        Users[] x = new Users[x1.size()];
        for(int i=0 ; i<x1.size();i++)
            x[i]=x1.get(i);

        if (x != null)
            tableView.getItems().addAll(x);
        */


        //TextField[] T = new TextField[8];
        /*for (int i = 0; i < T.length; i++)
            T[i] = new TextField();
           */
        //Add Butttons
        // Button btn2 = new Button("search");
        // Button btn3 = new Button("reset");

        //Add Columns and set their width
        //columnCourse.setPrefWidth(100);
        //columnCRN.setPrefWidth(75);
        //columnDay.setPrefWidth(75);
        //columnCredit.setPrefWidth(100);
        // columnState.setPrefWidth(150);

        tableView.setPrefSize(500, 150);


        //Adding the Main Drid for Coordinate the Page
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        GridPane grid3 = new GridPane();


        grid.add(Title, 0, 0);

        //grid.add(Term, 0, 2);
        grid.add(TableBox, 0, 1);
        //grid.add(grid2, 0, 2);

        grid3.setVgap(10);


        //grid5.setHgap(10);
        /*for (int i = 0; i < T.length; i++)
            grid5.add(T[i], i, 0);
*/
        //grid6.add(btn1, 0, 0);
        //grid6.add(btn2, 1, 0);
        // grid6.add(btn3, 2, 0);

        //grid3.add(grid5, 0, 1);
        //grid3.add(btn1, 0, 2);

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(btn1,btn2);
        flowPane.setHgap(10);
        grid.add(flowPane, 0, 2);
        grid.setPadding(new Insets(10, 10, 10, 10));

        //Set Back Action
        /*back.setOnMouseClicked((MouseEvent e) -> {
            MainView show = new MainView();
            try {
                Connecter.Save();
                show.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });*/

        //Setect the Term Action
        /*Term.setOnAction((event) -> {

            Login.Current_term = Integer.parseInt((String) Term.getSelectionModel().getSelectedItem());
            try {
                tableView.getItems().clear();
                Section[] obj = Connecter.GetStudentTermSection();
                if (obj != null)
                    tableView.getItems().addAll(obj);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });*/
        //Add Clinics

        try{
            tableView.getItems().clear();
            //Users user = Main.TheUser;

            DataBase admin = new DataBase();
            ArrayList<Dentists> dentists = new ArrayList<>();
            //cl = admin.ClinicAdd
            dentists=admin.getDentists();
            //Users user = admin.U_Login("a201","444");
            tableView.getItems().addAll(dentists);

        }catch (Exception e){
            System.out.println(e.getMessage());

            // eXception & Errors
        }




        //reset CRN Text Field
        btn1.setOnAction((ActionEvent e) -> {
            Main log = new Main();
            try {
                log.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        btn2.setOnAction((ActionEvent e) -> {
            Register register = new Register();
            try {
                register.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //Set the message that will show the errors
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        message.setHeaderText(null);
        message.setTitle("ERROR in CRN");


        //Add or Drop Courses
        /*btn1.setOnAction((ActionEvent e) -> {
            boolean Error=false;
            int size;
            try {
                size = Connecter.GetStudentSectionsNumber();
                for (int i = 0; i < size; i++) {
                    Object cellobj = ((TableColumn) tableView.getColumns().get(4)).getCellObservableValue(i).getValue();
                    String value = (String) ((ComboBox) cellobj).getSelectionModel().getSelectedItem();
                    if (value != null && value.equals("Drop")) {
                        cellobj = (((TableColumn) tableView.getColumns().get(1)).getCellObservableValue(i).getValue());
                        Connecter.DropCourse((Integer) cellobj);
                    }

                }
            } catch (Exception e1) {
                Error=true;
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            for (int i = 0; i < T.length; i++) {
                if (!T[i].getText().isEmpty()) {
                    try {
                        Connecter.AddCourse(Integer.parseInt(T[i].getText()));

                    } catch (NumberFormatException e2) {
                        Error=true;
                        message.setContentText("please write a correct CRN");
                        message.show();

                        // e2.printStackTrace();
                    } catch (Exception e1) {
                        Error=true;
                        message.setContentText(e1.getMessage());
                        message.show();
                        // e1.printStackTrace();
                    }

                }

            }


            tableView.getItems().clear();
            Section[] obj;
            try {
                obj = Connecter.GetStudentTermSection();
                if (obj != null)
                    tableView.getItems().addAll(obj);
            } catch (Exception e1) {
                Error=true;
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if(!Error)
                for (int i = 0; i < T.length; i++)
                    T[i].clear();

        });*/

        primaryStage.setTitle("Guest");
        primaryStage.setScene(new Scene(grid, 550, 300));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

