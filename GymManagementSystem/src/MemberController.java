import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MemberController extends Application implements Initializable{
    
    public ObservableList<String> blood_group = FXCollections.observableArrayList("A", "A+", "A-", "AB" , "AB+", "AB-", "B","B+", "B-","O", "O+", "O-");
    public ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female", "Other");
    public ObservableList<String> martial_status = FXCollections.observableArrayList("Single", "Married", "Divorced", "Widow");
   
    
    @Override
    public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	Parent root = FXMLLoader.load(getClass().getResource("MemberLayout.fxml"));
	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	primaryStage.setTitle("Member Deatils!");
    	primaryStage.setScene(scene);
    	primaryStage.show();
     
    }
    
    
    
    public static void main(String args[]) {
	launch(args); 
    }
    
    @FXML
    public ComboBox<String> blood_group_cb;
    public ComboBox<String> gender_cb;
    public ComboBox<String> martial_status_cb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	try {
	    	blood_group_cb.setItems(blood_group);
	    	gender_cb.setItems(gender);
		martial_status_cb.setItems(martial_status);
	} catch (Exception e) {
	   e.printStackTrace();
	}
    }
    
    public String getBloodGroup(ActionEvent e) {
	System.out.println(blood_group_cb.getValue());
	return(blood_group_cb.getValue());	
    }

    public String getGender(ActionEvent e) {
	System.out.println(gender_cb.getValue());
	return(gender_cb.getValue());	
    }
    public String getMartialStatus(ActionEvent e) {
	System.out.println(martial_status_cb.getValue());
	return(martial_status_cb.getValue());
	
    }
    
}
