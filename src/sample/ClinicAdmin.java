package sample;



import data_types.Clinics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableColumn.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;



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

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.prefs.Preferences;


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
        Label clId = new Label("ID");
        Label tclId = new Label();

        Label profile = new Label("Profile");
        TextField tprofile = new TextField();
        Label services = new Label("Services");
        TextField tservices = new TextField();
        Label location = new Label("Location");
        TextField tlocation = new TextField();

        Label website = new Label("Website");
        TextField twebsite = new TextField();
        Label email = new Label("Email");
        TextField temail = new TextField();

        Label rating = new Label("Rating");
        Label trating = new Label();

        Label clinicID = new Label("Clinic Admin");
        Label tClinicID = new Label();
        Label status = new Label("Status");
        TextField tstatus = new TextField();





        // ...

        Label Title = new Label("Clinic Admin");
        Title.setFont(new Font(20));
        Title.setTextAlignment(TextAlignment.CENTER);
        //ObservableList<String> options = FXCollections.observableArrayList("182", "181", "173");
        //ComboBox<String> Term = new ComboBox<String>(options);

        //Term.setPromptText(Login.Current_term + "");


        //Add Table of Courses Add and Drop
        HBox TableBox = new HBox();





        //Adding the Main Drid for Coordinate the Page
        GridPane MainGrid = new GridPane();
        MainGrid.setAlignment(Pos.CENTER);
        MainGrid.setHgap(30);


        GridPane grid = new GridPane();



        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);

        MainGrid.add(grid, 1, 0);
        MainGrid.add(grid3, 0, 0);






        grid3.add(clId, 0, 0);
        grid3.add(tclId, 1, 0);

        grid3.add(profile, 0, 1);
        grid3.add(tprofile, 1, 1);
        grid3.add(services, 0, 2);
        grid3.add(tservices, 1, 2);
        grid3.add(location, 0, 3);
        grid3.add(tlocation, 1, 3);
        grid3.add(website, 0, 4);
        grid3.add(twebsite, 1, 4);
        grid3.add(email, 0, 5);
        grid3.add(temail, 1, 5);
        grid3.add(rating, 0, 6);
        grid3.add(trating, 1, 6);

        grid3.add(clinicID, 0, 7);
        grid3.add(tClinicID, 1, 7);
        grid3.add(status, 0, 8);
        grid3.add(tstatus, 1, 8);

        grid3.setVgap(10);
        grid3.setHgap(10);



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
        //Add Clinic info
        try{

            DataBase db = new DataBase();
           // Clinics clinic = db.getClinic(Main.user);
            Preferences pref = Preferences.userNodeForPackage(Preferences.class);
            System.out.println(pref.get("User","root"));

            Clinics clinic = db.getClinic(pref.get("User","root"));
            System.out.println("new");

            System.out.println(pref.get("User","root"));

            //add data

            tclId.setText(clinic.getC_ID()+"");

        }catch (Exception e){
            System.out.println(e.getMessage());
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setHeaderText(null);
            message.setTitle("ERROR in CRN");
            message.setContentText(e.getMessage());

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
        primaryStage.setScene(new Scene(MainGrid, 900, 450));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

