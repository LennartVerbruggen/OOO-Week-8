package ui;

import domain.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class Main extends Application {
    private EncryptionMethodContext context;
    private TextField input = new TextField();
    private Label encryptLabel = new Label("");
    private Label decryptLabel = new Label("");
    
    @Override
    public void start (Stage stage) throws Exception {
        context = new EncryptionMethodContext();
        stage.setTitle("ComboBoxSample met strategy, enum en reflection");
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        ComboBox<String> encryptionMethodComboBox = new ComboBox<String>();
        ObservableList<String> encryptionMethods = FXCollections.observableList(context.getEncryptionMethodLijst());
        encryptionMethodComboBox.setItems(encryptionMethods);
        //encryptionMethodComboBox.setPromptText("Email address");
        encryptionMethodComboBox.setEditable(true);
        encryptionMethodComboBox.valueProperty().addListener(new ClickComboBoxLineHandler());
        grid.add(encryptionMethodComboBox, 0, 1);
        grid.add(input, 0, 0);
        grid.add(encryptLabel, 0, 2);
        grid.add(decryptLabel, 0, 3);
        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
    }

    class ClickComboBoxLineHandler implements ChangeListener<String> {
        @Override
        public void changed(ObservableValue ov, String t, String t1) {
            EncodingInterface encryptionMethodInterface = EncryptionMethodFactory.createEncryptionMethod(t1);
            context.setEncodingInterface(encryptionMethodInterface);
            encryptLabel.setText("Encrypt: " +  context.encrypt(input.getText()));
            decryptLabel.setText("Decrypt: " + context.decrypt(input.getText()));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
