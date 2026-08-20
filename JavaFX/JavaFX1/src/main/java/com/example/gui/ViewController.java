package com.example.gui;

import com.example.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    @FXML
    private Button btAll;

    private ObservableList<Person> obsList;

    @FXML
    public void onBtAllAction() {
        for (Person p : comboBoxPerson.getItems()) {
            System.out.println(p);
        }
    }

    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Vaca", "vaca@gmail.com"));
        list.add(new Person(2, "Boca", "boca@gmail.com"));
        list.add(new Person(3, "Zoi", "zoi@gmail.com"));
        list.add(new Person(4, "Boi", "boi@gmail.com"));
        list.add(new Person(5, "Gordo", "gordo@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }

}
