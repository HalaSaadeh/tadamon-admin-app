package sample;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.*;
import io.opencensus.metrics.export.Distribution;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.python.util.PythonInterpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class Controller {

    public Button addEventButton;
    public TextField eventNameField, locationField, amountNeededField, amountRaisedField, repNameField, repOccupationField, repPhotoField, photoField;
    public ComboBox eventCategories;
    public TextArea descriptionField, donorsField, volunteersField,howToVolunteerField;
    public DatePicker endDatePicker;


    @FXML
    public void initialize() throws IOException, ExecutionException, InterruptedException {
        // Initialize the ComboBox with our categories
        eventCategories.setItems(FXCollections.observableArrayList("Health Crisis","Financial Crisis", "Wildfires",  "Natural Crisis", "Tech Crisis", "Winter Crisis", "Social Crisis"));

        // Fetch the service account key JSON file contents
        FileInputStream serviceAccount = new FileInputStream("D:/Apps/Tadamon Admin App/serviceAccount.json");

        // Initialize the app with a service account, granting admin privileges
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tadamon-78925.firebaseio.com").setStorageBucket("tadamon-78925.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);

        Bucket bucket = StorageClient.getInstance().bucket();



    }

    public void addEvent(ActionEvent actionEvent) {
        // Get donors and volunteers
        String[] donors = donorsField.getText().split(" ");
        String[] volunteers = volunteersField.getText().split(" ");

        // Get database instance
        Firestore db = FirestoreClient.getFirestore();


        // Add document data
        Map<String, Object> crisisevent = new HashMap<String, Object>();
        crisisevent.put("name", eventNameField.getText());
        crisisevent.put("category", eventCategories.getValue().toString());
        crisisevent.put("description", descriptionField.getText());
        //crisisevent.put("endDate", endDatePicker.getValue());
        crisisevent.put("location", locationField.getText());
        crisisevent.put("howtovolunteer", howToVolunteerField.getText());
        crisisevent.put("amountneeded", Integer.valueOf(amountNeededField.getText()));
        crisisevent.put("amountraised", Integer.valueOf(amountRaisedField.getText()));
        crisisevent.put("repname", repNameField.getText());
        crisisevent.put("repoccupation", repOccupationField.getText());
        crisisevent.put("donors", donors);
        crisisevent.put("volunteers", volunteers);
        ApiFuture<DocumentReference> result = db.collection("crisis_events").add(crisisevent);


        // photofield
        // repphoto field



    }

}
