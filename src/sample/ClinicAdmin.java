package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ClinicAdmin extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //DataBase Connecter = new DataBase();

        Label back = new Label("Back");
        back.setTextFill(Color.BLUE);
        back.setFont(Font.font(17));
        //Button back = new Button("Back");
        HBox btnB = new HBox();
        btnB.getChildren().add(back);



        //...... ADDING COMPONANT
        Label id = new Label("Clinic ID");
        Label profile = new Label("Clinic Profile");
        Label services = new Label("Clinic Services");
        Label location = new Label("Clinic Location");
        Label website = new Label("Clinic Website");
        Label email = new Label("Clinic Email");
        Label rating = new Label("Clinic Rating");
        Label manid = new Label("Clinic ManID");
        Label status = new Label("Status ID");

        TextField tid = new TextField();
        TextField tprofile = new TextField();
        TextField tservices = new TextField();
        TextField tlocation = new TextField();
        TextField twebsite = new TextField();
        TextField temail = new TextField();
        TextField trating = new TextField();
        TextField tmanid = new TextField();
        TextField tstatus = new TextField();

        Button add = new Button("Add Clinic");


        // ...

        Label Title = new Label("Clinic Admin");
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


        TableColumn columnId = new TableColumn("C_ID");
        columnId.setStyle("-fx-alignment: CENTER;");
        columnId.setCellValueFactory(new PropertyValueFactory<>("C_ID"));
        TableColumn columnUser = new TableColumn("_Profile");
        columnUser.setStyle("-fx-alignment: CENTER;");
        columnUser.setCellValueFactory(new PropertyValueFactory<>("_Profile"));

        TableColumn columnFN = new TableColumn("Services");
        columnFN.setCellValueFactory(new PropertyValueFactory<>("Services"));
        columnFN.setStyle("-fx-alignment: CENTER;");
        TableColumn columnLN = new TableColumn("Location");
        columnLN.setCellValueFactory(new PropertyValueFactory<>("Location"));
        columnLN.setStyle("-fx-alignment: CENTER;");

        TableColumn columnPW = new TableColumn("EMail");
        columnPW.setCellValueFactory(new PropertyValueFactory<>("EMail"));
        columnPW.setStyle("-fx-alignment: CENTER;");
        TableColumn columnEmail = new TableColumn("Rating");
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        columnEmail.setStyle("-fx-alignment: CENTER;");


        TableColumn columnDate = new TableColumn("Clinic_ManID");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("Clinic_ManID"));
        columnDate.setStyle("-fx-alignment: CENTER;");



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
        Button btn1 = new Button("Submit");
       // Button btn2 = new Button("search");
       // Button btn3 = new Button("reset");

        //Add Columns and set their width
        tableView.getColumns().addAll(columnId,columnUser,columnFN,columnLN,columnPW,columnEmail,columnDate, columnState);
        //columnCourse.setPrefWidth(100);
        //columnCRN.setPrefWidth(75);
        //columnDay.setPrefWidth(75);
        //columnCredit.setPrefWidth(100);
       // columnState.setPrefWidth(150);

        tableView.setPrefSize(640, 250);


        //Adding the Main Drid for Coordinate the Page
        GridPane MainGrid = new GridPane();
        MainGrid.setAlignment(Pos.CENTER);
        MainGrid.setHgap(30);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        GridPane grid3 = new GridPane();
        MainGrid.add(grid, 1, 0);
        MainGrid.add(grid3, 0, 0);

        grid3.add(id,0,0);
        grid3.add(tid,1,0);

        grid3.add(profile,0,1);
        grid3.add(tprofile,1,1);

        grid3.add(services,0,2);
        grid3.add(tservices,1,2);

        grid3.add(location,0,3);
        grid3.add(tlocation,1,3);

        grid3.add(website,0,4);
        grid3.add(twebsite,1,4);

        grid3.add(email,0,5);
        grid3.add(temail,1,5);

        grid3.add(rating,0,6);
        grid3.add(trating,1,6);

        grid3.add(manid,0,7);
        grid3.add(tmanid,1,7);

        grid3.add(status,0,8);
        grid3.add(tstatus,1,8);
        grid3.add(add,0,9);

        //grid.add(btnB, 1, 0);
        //grid.add(Title, 1, 0);

        //grid.add(Term, 0, 2);
        grid.add(TableBox, 1, 0);
        grid.add(grid2, 1, 1);

        grid3.setVgap(10);
        grid3.setHgap(10);



        grid.add(btn1, 1, 2);
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

        primaryStage.setTitle("Clinics");
        primaryStage.setScene(new Scene(MainGrid, 1000, 450));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

