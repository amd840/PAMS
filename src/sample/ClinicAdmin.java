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

        DataBase Connecter = new DataBase();

        Label back = new Label("Back");
        back.setTextFill(Color.BLUE);
        back.setFont(Font.font(17));
        //Button back = new Button("Back");
        HBox btnB = new HBox();
        btnB.getChildren().add(back);

        // ...

        Label Title = new Label("Add and Drop");
        Title.setFont(new Font(20));
        Title.setTextAlignment(TextAlignment.CENTER);
        ObservableList<String> options = FXCollections.observableArrayList("182", "181", "173");
        ComboBox<String> Term = new ComboBox<String>(options);

        //Term.setPromptText(Login.Current_term + "");


        //Add Table of Courses Add and Drop
        HBox TableBox = new HBox();
        TableView<Object> tableView = new TableView<Object>();
        TableBox.getChildren().addAll(tableView);
        TableBox.setAlignment(Pos.CENTER);


        TableColumn columnCourse = new TableColumn("Course");
        columnCourse.setStyle("-fx-alignment: CENTER;");
        columnCourse.setCellValueFactory(new PropertyValueFactory<>("Course"));
        TableColumn columnCRN = new TableColumn("CRN");
        columnCRN.setStyle("-fx-alignment: CENTER;");
        columnCRN.setCellValueFactory(new PropertyValueFactory<>("CRN"));

        TableColumn columnDay = new TableColumn("Day");
        columnDay.setCellValueFactory(new PropertyValueFactory<>("Day"));
        columnDay.setStyle("-fx-alignment: CENTER;");
        TableColumn columnCredit = new TableColumn("Credit");
        columnCredit.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        columnCredit.setStyle("-fx-alignment: CENTER;");
        TableColumn columnState = new TableColumn("State");
        columnState.setCellValueFactory(new PropertyValueFactory<>("State"));
        columnState.setStyle("-fx-alignment: CENTER;");
        ArrayList<Users> x1 = new ArrayList<>();
         x1 = Connecter.getUser();

        Users[] x = new Users[x1.size()];
        for(int i=0 ; i<x1.size();i++)
            x[i]=x1.get(i);

        if (x != null)
            tableView.getItems().addAll(x);

        TextField[] T = new TextField[8];
        for (int i = 0; i < T.length; i++)
            T[i] = new TextField();

        //Add Butttons
        Button btn1 = new Button("Submit");
        Button btn2 = new Button("search");
        Button btn3 = new Button("reset");

        //Add Columns and set their width
        tableView.getColumns().addAll(columnCourse, columnCRN, columnDay, columnCredit, columnState);
        columnCourse.setPrefWidth(100);
        columnCRN.setPrefWidth(75);
        columnDay.setPrefWidth(75);
        columnCredit.setPrefWidth(100);
        columnState.setPrefWidth(150);

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
        grid3.setAlignment(Pos.CENTER);
        GridPane grid4 = new GridPane();
        GridPane grid5 = new GridPane();
        grid5.setAlignment(Pos.CENTER);
        GridPane grid6 = new GridPane();

        grid.add(btnB, 0, 0);
        grid.add(Title, 0, 1);

        grid.add(Term, 0, 2);
        grid.add(TableBox, 0, 3);
        grid.add(grid2, 0, 4);

        grid3.setVgap(10);

        grid4.add(new Label("Add Course CRN"), 0, 0);

        grid5.setHgap(10);
        grid6.setHgap(10);
        for (int i = 0; i < T.length; i++)
            grid5.add(T[i], i, 0);

        grid6.add(btn1, 0, 0);
        grid6.add(btn2, 1, 0);
        grid6.add(btn3, 2, 0);

        grid3.add(grid4, 0, 0);
        grid3.add(grid5, 0, 1);
        grid3.add(grid6, 0, 2);

        grid5.setPadding(new Insets(0, 10, 0, 5));

        grid.add(grid3, 0, 5);
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


        //reset CRN Text Field
        btn3.setOnAction((ActionEvent e) -> {
            for (int i = 0; i < T.length; i++)
                T[i].clear();
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

