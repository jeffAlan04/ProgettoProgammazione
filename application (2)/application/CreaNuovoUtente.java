package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreaNuovoUtente {

    @FXML
    private TextField usernameField; // Campo per inserire l'username
    @FXML
    private PasswordField passwordField; // Campo per inserire la password

    // Riferimenti agli oggetti di scena
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void salvaUtente() {
        // Ottieni i dati inseriti dall'utente
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Verifica se i campi sono vuoti
        if (username.isEmpty() || password.isEmpty()) {
            mostraMessaggio("Errore", "Campi obbligatori vuoti", "Compila tutti i campi richiesti.");
            return;
        }

        // Salva i dati dell'utente nel file "users.txt"
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)))) {
            out.println(username + ":" + password);
            mostraMessaggio("Successo", "Registrazione completata", "L'utente è stato registrato con successo.");
        } catch (IOException e) {
            mostraMessaggio("Errore", "Errore durante la registrazione", "C'è stato un errore nel salvataggio dell'utente.");
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("progressi.json", true)))) {
            out.println(username + ":" + "0-0:0");
        } catch (IOException e) {
            mostraMessaggio("Errore", "Errore durante il salvataggio dei punteggi", "C'è stato un errore nel salvataggio dell'utente.");
            e.printStackTrace();
        }
    }

    @FXML
    public void ScenaLogin(ActionEvent event) throws IOException {
        SceneManager.cambiaScena("Login.fxml", event);
    }

   /* @FXML
    public void ScenaCreaNuovoUtente1(ActionEvent event) throws IOException {
        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
        Parent root = FXMLLoader.load(getClass().getResource("CreaNuovoUtente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/
    
    // Metodo per chiudere l'applicazione con conferma
    @FXML
    public void ScenaChiusura(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Chiusura.confermaChiusura(stage);
    }

    private void mostraMessaggio(String titolo, String header, String contenuto) {
        // Mostra un messaggio di alert all'utente
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titolo);
        alert.setHeaderText(header);
        alert.setContentText(contenuto);
        alert.showAndWait();
    }
}
