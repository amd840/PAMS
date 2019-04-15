package sample;

import data_types.Advertisements;
import data_types.Appointments;
import data_types.Dentists;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.prefs.Preferences;

public class patient extends Application {

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

        Label Title = new Label("Appointment");
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


        TableColumn columnId = new TableColumn("Apm_ID");
        columnId.setStyle("-fx-alignment: CENTER;");
        columnId.setCellValueFactory(new PropertyValueFactory<>("Apm_ID"));

        TableColumn columnDate = new TableColumn("Apm_Date");
        columnDate.setStyle("-fx-alignment: CENTER;");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("Apm_Date"));

        TableColumn columnType = new TableColumn("Apm_Type");
        columnType.setCellValueFactory(new PropertyValueFactory<>("Apm_Type"));
        columnType.setStyle("-fx-alignment: CENTER;");
        TableColumn columnPatient_ID = new TableColumn("Patient_ID");
        columnPatient_ID.setCellValueFactory(new PropertyValueFactory<>("Patient_ID"));
        columnPatient_ID.setStyle("-fx-alignment: CENTER;");

        TableColumn columnRecept_ID = new TableColumn("Recept_ID");
        columnRecept_ID.setCellValueFactory(new PropertyValueFactory<>("Recept_ID"));
        columnRecept_ID.setStyle("-fx-alignment: CENTER;");
        TableColumn columnDentist_ID = new TableColumn("Dentist_ID");
        columnDentist_ID.setCellValueFactory(new PropertyValueFactory<>("Dentist_ID"));
        columnDentist_ID.setStyle("-fx-alignment: CENTER;");



        TableColumn columnState = new TableColumn("Status_ID");
        columnState.setCellValueFactory(new PropertyValueFactory<>("Status"));
        columnState.setStyle("-fx-alignment: CENTER;");

        //add element in the table
        FlowPane adding = new FlowPane();
        //componant
        Label id = new Label("Apm_ID");
        Label start_date = new Label("Apm_Date");
        Label apmType = new Label("Apm_Type");
        Label receptId = new Label("Recept_ID");
        Label dentistId = new Label("Dentist_ID");

        // Label regdate = new Label("Reg_Date");
        //Label status = new Label("Status ID");

        TextField tid = new TextField();
        tid.setMaxWidth(50);
        TextField tstart_date = new TextField();
        tstart_date.setMaxWidth(60);


        TextField tapmType = new TextField();
        tapmType.setMaxWidth(100);



        /*TextField treceptId = new TextField();
        treceptId.setMaxWidth(50);*/
        ObservableList<String> options = FXCollections.observableArrayList();
        ArrayList<Users> stuff = new DataBase().getCRec();
        ArrayList<String> datastuff = new ArrayList<>();
        for(int i=0 ;i<stuff.size();i++){
            datastuff.add(stuff.get(i).getFName() +" "+stuff.get(i).getLName());
        }
        options.addAll(datastuff);

        ComboBox<Users> treceptId = new ComboBox(options);
        treceptId.setMaxWidth(150);

        //ArrayList<Dentists> stuff2 = new ArrayList<Dentists>();







        /*TextField tdentistId = new TextField();
        tdentistId.setMaxWidth(50);
        */
        ArrayList<Dentists> stuff2 = new ArrayList<>();

        ObservableList<String> options1 = FXCollections.observableArrayList();
        ArrayList<String> datastuff2 = new ArrayList<>();

        options1.addAll(datastuff2);

        ComboBox<String> tdentistId = new ComboBox(options1);
        tdentistId.setMaxWidth(150);

        treceptId.setOnAction((event) -> {

            //Login.Current_term = Integer.parseInt((String) Term.getSelectionModel().getSelectedItem());

            try {
                datastuff2.clear();
                stuff2.clear();
                stuff2.addAll(new DataBase().getDentists(stuff.get(treceptId.getSelectionModel().getSelectedIndex())));
                for(int i=0 ;i<stuff2.size();i++){
                    datastuff2.add(stuff2.get(i).getFName() +" "+stuff2.get(i).getLName());
                    options1.addAll(datastuff2);

                }
                tdentistId.setItems(options1);


            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });




        //TextField tregdate = new TextField();



        adding.getChildren().add(id);
        adding.getChildren().add(tid);
        adding.getChildren().add(start_date);
        adding.getChildren().add(tstart_date);

        adding.getChildren().add(apmType);
        adding.getChildren().add(tapmType);



        adding.getChildren().add(receptId);
        adding.getChildren().add(treceptId);

        adding.getChildren().add(dentistId);
        adding.getChildren().add(tdentistId);




        Button addnewAdd = new Button("add");
        addnewAdd.setOnAction((ActionEvent e) -> {
            //Users newUser = new Users(tuser.getText(),tPW.getText(),temail.getText(),tfname.getText(),tlname.getText(),"",Integer.parseInt(tid.getText()),3,Integer.parseInt(tstatus.getText()));
            String breakstr;
            try {
                //System.out.println((tid.getText()));
                Preferences pref = Preferences.userNodeForPackage(Preferences.class);
                String uid = (pref.get("User", "root"));
                DataBase date = new DataBase();
                String userType = date.getUserType(uid);

                //Advertisements advertisements = new Advertisements(Integer.valueOf(tid.getText()),tstart_date.getText(),tapmType.getText(),tcontent.getText(),Integer.valueOf(tfees.getText()),Integer.valueOf(uid));
                //Need To Update
                Appointments appointments = new Appointments(Integer.valueOf(tid.getText()),tstart_date.getText(),tapmType.getText(),Integer.valueOf(uid),Integer.valueOf(stuff.get(treceptId.getSelectionModel().getSelectedIndex()).getU_ID()),Integer.valueOf(stuff2.get(tdentistId.getSelectionModel().getSelectedIndex()).getD_ID()),0,userType);
                tableView.getItems().addAll(appointments);
                date.addAppointment(appointments);

            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println(e1.getMessage());
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(e1.getMessage());
                a.show();
            }

        });

        adding.getChildren().add(addnewAdd);
        adding.setHgap(10);
        adding.setVgap(10);


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
        Button btn1 = new Button("Register");
        // Button btn2 = new Button("search");
        // Button btn3 = new Button("reset");

        //Add Columns and set their width
        tableView.getColumns().addAll(columnId,columnDate, columnType,columnPatient_ID,columnRecept_ID,columnDentist_ID, columnState);
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


        grid.add(btnB, 0, 0);
        grid.add(Title, 0, 1);

        //grid.add(Term, 0, 2);
        grid.add(TableBox, 0, 2);
        grid.add(grid2, 0, 3);

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


        grid.add(btn1, 0, 5);
        grid.add(adding,0,6);

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
            Users user = admin.U_Login("a201","444");
            tableView.getItems().addAll(user);

        }catch (Exception e){
            System.out.println(e.getMessage());

            // eXception & Errors
        }




        //reset CRN Text Field
        /*btn3.setOnAction((ActionEvent e) -> {
            for (int i = 0; i < T.length; i++)
                T[i].clear();
        });
*/
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

        primaryStage.setTitle("ADD and DROP SYSTEM");
        primaryStage.setScene(new Scene(grid, 550, 450));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

