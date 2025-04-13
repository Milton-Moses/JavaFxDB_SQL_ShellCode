package org.example.javafxdb_sql_shellcode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.example.javafxdb_sql_shellcode.db.ConnDbOps;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class DB_GUI_Controller implements Initializable {

    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(1, "Jacob", "tester@email", "CPIS", "CS", "123"),
                    new Person(2, "Jacob2", "tester@email", "CPIS1", "CS", "123")

            );


    @FXML
    TextField first_name, email, phone, address, password;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn, tv_em, tv_phone, tv_add, tv_pass;

    @FXML
    ImageView img_view;

    private static ConnDbOps cdbop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_em.setCellValueFactory(new PropertyValueFactory<>("email"));
        tv_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tv_add.setCellValueFactory(new PropertyValueFactory<>("address"));
        tv_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
        cdbop = new ConnDbOps();

        tv.setItems(data);
    }


    @FXML
    protected void addNewRecord() {


        data.add(new Person(
                data.size()+1,
                first_name.getText(),
                email.getText(),
                phone.getText(),
                address.getText(),
                password.getText()

        ));
        cdbop.insertUser(first_name.getText(), email.getText(), phone.getText(), address.getText(), password.getText());
    }

    @FXML
    protected void clearForm() {
        first_name.clear();
        email.setText("");
        phone.setText("");
        address.setText("");
    }

    @FXML
    protected void closeApplication() {
        System.exit(0);
    }


    @FXML
    protected void editRecord() {
        Person p= tv.getSelectionModel().getSelectedItem();
        int c=data.indexOf(p);
        Person p2= new Person();
        p2.setId(c+1);
        p2.setFirstName(first_name.getText());
        p2.setPhone(email.getText());
        p2.setAddress(phone.getText());
        p2.setPassword(address.getText());
        data.remove(c);
        data.add(c,p2);
        tv.getSelectionModel().select(c);
    }

    @FXML
    protected void deleteRecord() {
        Person p= tv.getSelectionModel().getSelectedItem();
        data.remove(p);

    }



    @FXML
    protected void showImage() {
        File file= (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
        if(file!=null){
            img_view.setImage(new Image(file.toURI().toString()));

        }
    }





    @FXML
    protected void selectedItemTV(MouseEvent mouseEvent) {
        Person p= tv.getSelectionModel().getSelectedItem();
        first_name.setText(p.getFirstName());
        email.setText(p.getPhone());
        phone.setText(p.getAddress());
        address.setText(p.getPassword());


    }
}