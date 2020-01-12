/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techline.smssender;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//importjava.net.HttpURLConnection;
import java.net.URL;
import javafx.collections.ObservableList;

/**
 *
 * @author MIKE
 */


public class SendSmsFXMLController implements Initializable {

    private Label label;
    @FXML
    private Button send_btn;
    @FXML
    private Button clear_btn;
    @FXML
    private TextArea message_box;
    @FXML
    private TextField recipient_box;
//    @FXML
    @FXML
    private TextField sender_box;
//    @FXML
//    private ChoiceBox type_combo;
    
    
    private ObservableList msgTypeses;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       fillCombo(msgTypeses);
    }

    @FXML
    private void onSendButtonClicked(ActionEvent event) {
        //get vriables from text fields
        String myRecipient = recipient_box.getText();
        String myMessage = message_box.getText();
        String mySender = sender_box.getText();
        
//        Sender s = new Sender();
//        s.setMessage(myMessage);
//        s.setDestination(myRecipient);
//        s.setUsername("techcom1");
//        s.setPassword("7NO2kzoN");
//        s.setServer("ngn.rmlconnect.net");
//        s.setPort("8080");
//        s.setSource("test");
//        s.setDlr("1");
//        s.setType("0");
        Sender s = new Sender("ngn.rmlconnect.net", 8080, "techcom1", "7NO2kzoN", myMessage, "1", "0", myRecipient,
                        mySender);
        s.submitMessage();
    }

    @FXML
    private void onClearButtonClicked(ActionEvent event) {
        recipient_box.clear();
        message_box.clear();
    }

    private void fillCombo(ObservableList msgTypeses) {
        
        msgTypeses.add("--NONE SELECTED--");
        msgTypeses.add("PLAIN TEXT");
        msgTypeses.add("UNICODE");
        
       // type_combo.setItems(msgTypeses);
    }

  
}
