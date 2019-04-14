package sample;

import data_types.Advertisements;
import data_types.Appointments;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
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

public class ad extends Application {

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

        Label Title = new Label("Receptionist Editing");
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




        TableColumn columnId = new TableColumn("Ad_ID");
        columnId.setStyle("-fx-alignment: CENTER;");
        columnId.setCellValueFactory(new PropertyValueFactory<>("Ad_ID"));

        TableColumn columnStart = new TableColumn("Start_Date");
        columnStart.setStyle("-fx-alignment: CENTER;");
        columnStart.setCellValueFactory(new PropertyValueFactory<>("Start_Date"));

        TableColumn columnEnd = new TableColumn("End_Date");
        columnEnd.setCellValueFactory(new PropertyValueFactory<>("End_Date"));
        columnEnd.setStyle("-fx-alignment: CENTER;");
        TableColumn columnContent = new TableColumn("Content");
        columnContent.setCellValueFactory(new PropertyValueFactory<>("Content"));
        columnContent.setStyle("-fx-alignment: CENTER;");

        TableColumn columnFee = new TableColumn("Fees");
        columnFee.setCellValueFactory(new PropertyValueFactory<>("Fees"));
        columnFee.setStyle("-fx-alignment: CENTER;");

        TableColumn columnAdmin = new TableColumn("SysAdmin_ID");
        columnAdmin.setCellValueFactory(new PropertyValueFactory<>("SysAdmin_ID"));
        columnAdmin.setStyle("-fx-alignment: CENTER;");



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
        Button btn1 = new Button("Register");
        // Button btn2 = new Button("search");
        // Button btn3 = new Button("reset");

        //Add Columns and set their width
        tableView.getColumns().addAll(columnId,columnStart,columnEnd,columnContent,columnFee,columnAdmin);
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



        //grid.add(btnB, 0, 0);
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

        try {
            tableView.getItems().clear();
            //Users user = Main.TheUser;

            DataBase admin = new DataBase();
            //Users user = admin.U_Login("a201","444");
            Preferences pref = Preferences.userNodeForPackage(Preferences.class);
            String uid = (pref.get("User", "root"));

            Users clinicadmin = admin.getClinicAdmin(uid);
            ArrayList<Advertisements> ads = admin.getAdvertisment(clinicadmin);
            //Users user = admin.
            tableView.getItems().addAll(ads);

        }catch (SQLException e1){
                System.out.println(e1.getMessage());
                System.out.println("SQL");

                // eXception & Errors
            }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("General Error");

            // eXception & Errors
        }

        /*FlowPane flowPane = new FlowPane();

        for (int i=0 ;i<5 ;i++){
            flowPane.getChildren().add(new Label("LAbel"+i));
        }*/


        //grid.add(flowPane,0,6);

        FlowPane adding = new FlowPane();
        //componant
        Label id = new Label("Ad ID");
        Label start_date = new Label("Start_Date");
        Label end_date = new Label("End_Date");
        Label content = new Label("Content");
        Label fees = new Label("Fees");
        Label sysAdmin_id = new Label("SysAdmin_ID");

        // Label regdate = new Label("Reg_Date");
        //Label status = new Label("Status ID");

        TextField tid = new TextField();
        tid.setMaxWidth(50);
        TextField tstart_date = new TextField();
        tstart_date.setMaxWidth(60);

        TextField tend_date = new TextField();
        tend_date.setMaxWidth(60);

        TextField tcontent = new TextField();
        tcontent.setMaxWidth(100);

        TextField tfees = new TextField();
        tfees.setMaxWidth(70);

        TextField tsysAdmin_id = new TextField();
        tsysAdmin_id.setMaxWidth(50);
        //TextField tregdate = new TextField();



        adding.getChildren().add(id);
        adding.getChildren().add(tid);
        adding.getChildren().add(start_date);
        adding.getChildren().add(tstart_date);
        adding.getChildren().add(end_date);

        adding.getChildren().add(tend_date);
        adding.getChildren().add(content);

        adding.getChildren().add(tcontent);
        adding.getChildren().add(fees);
        adding.getChildren().add(tfees);

        adding.getChildren().add(sysAdmin_id);
        adding.getChildren().add(tsysAdmin_id);


        Button addnewAdd = new Button("add");

        adding.getChildren().add(addnewAdd);
        adding.setHgap(10);
        adding.setVgap(10);

        grid.add(adding,0,6);



        //reset CRN Text Field
        addnewAdd.setOnAction((ActionEvent e) -> {
            //Users newUser = new Users(tuser.getText(),tPW.getText(),temail.getText(),tfname.getText(),tlname.getText(),"",Integer.parseInt(tid.getText()),3,Integer.parseInt(tstatus.getText()));
            String breakstr;
            try {
                //System.out.println((tid.getText()));
                Preferences pref = Preferences.userNodeForPackage(Preferences.class);
                String uid = (pref.get("User", "root"));

                Advertisements advertisements = new Advertisements(Integer.valueOf(tid.getText()),tstart_date.getText(),tend_date.getText(),tcontent.getText(),Integer.valueOf(tfees.getText()),Integer.valueOf(uid));
                tableView.getItems().addAll(advertisements);

                new DataBase().addAd(advertisements);
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println(e1.getMessage());
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(e1.getMessage());
                a.show();
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

        primaryStage.setTitle("ADD and DROP SYSTEM");
        primaryStage.setScene(new Scene(grid, 550, 450));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

