package sample;



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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Admins extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //DataBase Connecter = new DataBase();

        Label back = new Label("Log out");
        back.setTextFill(Color.BLUE);
        back.setFont(Font.font(17));
        //Button back = new Button("Back");
        HBox btnB = new HBox();
        btnB.getChildren().add(back);



        //...... ADDING COMPONANT
        Label id = new Label("U ID");
        Label user = new Label("UserName");
        Label fname = new Label("FName");
        Label lname = new Label("LName");
        Label PW = new Label("Hashed_PW");
        Label email = new Label("Email");

        Label regdate = new Label("Reg_Date");
        Label status = new Label("Status ID");

        TextField tid = new TextField();
        TextField tuser = new TextField();
        TextField tfname = new TextField();
        TextField tlname = new TextField();
        PasswordField tPW = new PasswordField();
        TextField temail = new TextField();

        TextField tregdate = new TextField();

        TextField tstatus = new TextField();

        Button add = new Button("Add Clinic Admin");


        // ...

        Label Title = new Label("Clinic Admins");
        Title.setFont(new Font(20));
        Title.setTextAlignment(TextAlignment.CENTER);
        //ObservableList<String> options = FXCollections.observableArrayList("182", "181", "173");
        //ComboBox<String> Term = new ComboBox<String>(options);

        //Term.setPromptText(Login.Current_term + "");


        //Add Table of Courses Add and Drop
        HBox TableBox = new HBox();
        TableView<Users> tableView = new TableView<Users>();
        TableBox.getChildren().addAll(tableView);
        TableBox.setAlignment(Pos.CENTER);


        TableColumn<Users,Integer> columnId = new TableColumn<>("U_ID");
        columnId.setStyle("-fx-alignment: CENTER;");
        columnId.setCellValueFactory(new PropertyValueFactory<>("U_ID"));
        //columnId.setCellFactory(TextFieldTableCell.forTableColumn());

        columnId.setOnEditCommit((CellEditEvent<Users, Integer > t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setUID(Integer.valueOf((t.getNewValue())));

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"C_ID",(t.getNewValue()));
                    }catch (Exception e){

                    }

                }




        );





        TableColumn<Users,String> columnUser = new TableColumn<>("UserName");
        columnUser.setStyle("-fx-alignment: CENTER;");
        columnUser.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        columnUser.setCellFactory(TextFieldTableCell.forTableColumn());

        columnUser.setOnEditCommit((CellEditEvent<Users, String> t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setUserName((t.getNewValue()));

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"UserName",t.getNewValue());
                    }catch (Exception e){

                    }

                }



        );


        TableColumn<Users,String> columnFN = new TableColumn<>("FName");
        columnFN.setCellValueFactory(new PropertyValueFactory<>("FName"));
        columnFN.setStyle("-fx-alignment: CENTER;");
        columnFN.setCellFactory(TextFieldTableCell.forTableColumn());

        columnFN.setOnEditCommit((CellEditEvent<Users, String> t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setFName((t.getNewValue()));

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"FName",t.getNewValue());
                    }catch (Exception e){

                    }

                }



        );

        TableColumn<Users,String> columnLN = new TableColumn<>("LName");
        columnLN.setCellValueFactory(new PropertyValueFactory<>("LName"));
        columnLN.setStyle("-fx-alignment: CENTER;");
        columnLN.setCellFactory(TextFieldTableCell.forTableColumn());

        columnLN.setOnEditCommit((CellEditEvent<Users, String> t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setLname((t.getNewValue()));

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"LName",t.getNewValue());
                    }catch (Exception e){

                    }

                }



        );

        TableColumn<Users,String> columnPW = new TableColumn<>("PW");
        columnPW.setCellValueFactory(new PropertyValueFactory<>("Hashed_PW"));
        columnPW.setStyle("-fx-alignment: CENTER;");

        columnPW.setCellFactory(TextFieldTableCell.forTableColumn());

        columnPW.setOnEditCommit((CellEditEvent<Users, String> t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setHashPassword((t.getNewValue()));

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"Hashed_PW",t.getNewValue());
                    }catch (Exception e){

                    }

                }



        );


        TableColumn<Users,String> columnEmail = new TableColumn<>("EMail");
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("EMail"));
        columnEmail.setStyle("-fx-alignment: CENTER;");

        columnEmail.setCellFactory(TextFieldTableCell.forTableColumn());

        columnEmail.setOnEditCommit((CellEditEvent<Users, String > t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setEmail(t.getNewValue());

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"EMail",t.getNewValue());
                    }catch (Exception e){

                    }

                }



        );


        TableColumn<Users,String> columnDate = new TableColumn<>("Reg_Date");
        columnDate.setCellValueFactory(new PropertyValueFactory<>("Reg_Date"));
        columnDate.setStyle("-fx-alignment: CENTER;");
        //columnUser.setCellFactory(TextFieldTableCell.forTableColumn());

       /* columnUser.setOnEditCommit((CellEditEvent<Users, Integer> t) -> {

                    ((Users) t.getTableView()
                            .getItems()
                            .get(t.getTablePosition().getRow()))
                            .setDate(Integer.parseInt((t.getNewValue())));

                    try {
                        DataBase data = new DataBase();
                        data.userUpdate(t.getRowValue(),"Reg_Date",Integer.parseInt(t.getNewValue()));
                    }catch (Exception e){

                    }

                }



        );*/



        TableColumn<Users,String> columnState = new TableColumn<>("Status_ID");
        columnState.setCellValueFactory(new PropertyValueFactory<>("State"));
        columnState.setStyle("-fx-alignment: CENTER;");


        ArrayList<Users> x1 = new ArrayList<>();

        tableView.setEditable(true);
        add.setOnAction(ActionEvent ->{
            Users newUser = new Users(tuser.getText(),tPW.getText(),temail.getText(),tfname.getText(),tlname.getText(),tregdate.getText(),Integer.parseInt(tid.getText()),2,Integer.parseInt(tstatus.getText()));
            tableView.getItems().add(newUser);
            try{
                DataBase db = new DataBase();
                db.addUser(newUser);
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.show();
                System.out.print(e.getMessage());

            }
            System.out.print("work");
        });
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
        Button btn1 = new Button("Clinics");
        // Button btn2 = new Button("search");
        // Button btn3 = new Button("reset");

        //Add Columns and set their width
        tableView.getColumns().addAll(columnId, columnUser,columnFN,columnLN,columnPW,columnEmail,columnDate, columnState);
        //tableView.getColumns().addAll((Collection<? extends TableColumn<Object, ?>>) columnUser);

        //columnCourse.setPrefWidth(100);
        //columnCRN.setPrefWidth(75);
        //columnDay.setPrefWidth(75);
        //columnCredit.setPrefWidth(100);
        // columnState.setPrefWidth(150);

        tableView.setPrefSize(550, 250);


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
        MainGrid.add(grid, 1, 1);
        MainGrid.add(grid3, 0, 1);
        MainGrid.add(btnB, 0, 0);


        grid3.add(id,0,0);
        grid3.add(tid,1,0);

        grid3.add(user,0,1);
        grid3.add(tuser,1,1);

        grid3.add(fname,0,2);
        grid3.add(tfname,1,2);

        grid3.add(lname,0,3);
        grid3.add(tlname,1,3);

        grid3.add(PW,0,4);
        grid3.add(tPW,1,4);

        grid3.add(email,0,5);
        grid3.add(temail,1,5);

        grid3.add(regdate,0,6);
        grid3.add(tregdate,1,6);



        grid3.add(status,0,7);
        grid3.add(tstatus,1,7);
        grid3.add(add,0,8);

        //grid.add(btnB, 1, 0);
        //grid.add(Title, 1, 0);

        //grid.add(Term, 0, 2);
        grid.add(TableBox, 1, 1);
        grid.add(grid2, 1, 2);

        grid3.setVgap(10);
        grid3.setHgap(10);



        grid.add(btn1, 1, 3);
        grid.setPadding(new Insets(10, 10, 10, 10));

        //Set Back Action
        back.setOnMouseClicked((MouseEvent e) -> {
            Main show = new Main();
            try {
                show.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

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
            ArrayList<Users> arrlist = admin.getCAdmins();
            //Users user = admin.U_Login("a201","444");
            tableView.getItems().addAll(arrlist);

        }catch (Exception e){
            System.out.println(e.getMessage());

            // eXception & Errors
        }




        //reset CRN Text Field
        btn1.setOnAction((ActionEvent e) -> {
            Clinics st = new Clinics();
            try {
                st.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e1.getMessage());
                alert.show();
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

        primaryStage.setTitle("admins");
        primaryStage.setScene(new Scene(MainGrid, 950, 450));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

