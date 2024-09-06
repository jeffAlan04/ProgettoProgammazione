package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserLogin {

    @FXML
    private TextField usernameField; // Campo per inserire l'username
    @FXML
    private PasswordField passwordField; // Campo per inserire la password

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void effettuaLogin(ActionEvent event) {
        // Ottieni i dati inseriti dall'utente
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Verifica se i campi sono vuoti
        if (username.isEmpty() || password.isEmpty()) {
            mostraMessaggio("Errore", "Campi obbligatori vuoti", "Compila tutti i campi richiesti.");
            return;
        }

        // Verifica se le credenziali sono corrette
        boolean loginRiuscito = verificaCredenziali(username, password);

        if (loginRiuscito) {
            mostraMessaggio("Successo", "Login completato", "Benvenuto " + username + "!");
            ScenaDashbord(event,username);
            // Passa alla prossima scena o funzionalità dell'applicazione (da implementare)
        } else {
            mostraMessaggio("Errore", "Login fallito", "Username o password errati.");
        }
    }

    @FXML
    public void ScenaCreaNuovoUtente(ActionEvent event) {
        // Mostra un messaggio di informazione che la funzione non è implementata
        mostraMessaggio("Info", "Crea Nuovo Utente", "Questa funzione non è ancora implementata.");
    }

    private boolean verificaCredenziali(String username, String password) {
        // Verifica se le credenziali sono presenti nel file "users.txt"
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] credenziali = linea.split(":");
                if (credenziali[0].equals(username) && credenziali[1].equals(password)) {
                    return true; // Credenziali corrette
                }
            }
        } catch (IOException e) {
            mostraMessaggio("Errore", "Errore durante il login", "C'è stato un errore nella lettura delle credenziali.");
            e.printStackTrace();
        }
        return false; // Credenziali errate
    }

    @FXML
    public void ScenaLogin(ActionEvent event) throws IOException {
        // Carica il file FXML per la scena di login e cambia la scena
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void ScenaCreaNuovoUtente1(ActionEvent event) throws IOException {
        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
        Parent root = FXMLLoader.load(getClass().getResource("CreaNuovoUtente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void ScenaDashbord(ActionEvent event, String username) {
    	try {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashbord.fxml"));
    	Parent root = loader.load();
    	
    	Dashbord controller = loader.getController();
    	controller.impostaUtente(username);
    	
         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    	} catch(IOException e) {
    		mostraMessaggio("Errore" , "Errore durante il caricamento della dashboard", "C'e' stato un errore nel caricamento della dashboard.");
    		e.printStackTrace();
    	}
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
