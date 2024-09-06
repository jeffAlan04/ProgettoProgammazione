package application;

	import java.io.IOException;

	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;

	public class EsercizioJames {
		
		@FXML
	    private Text nomeUtenteText; // Un elemento Text nella dashboard per mostrare il nome utente

	    // Metodo per impostare il nome utente
	    public void impostaUtente(String username) {
	        nomeUtenteText.setText("Benvenuto, " + username + "!");
	    }
	    
	    private Stage stage;
	    private Scene scene;
	    private Parent root;

	    @FXML
	    public void ScenaDashbord(ActionEvent event) throws IOException {
	        // Carica il file FXML per la scena di login e cambia la scena
	        Parent root = FXMLLoader.load(getClass().getResource("Dashbord.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    @FXML
	    public void ScenaEsercizioFacile(ActionEvent event) throws IOException {
	        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
	        Parent root = FXMLLoader.load(getClass().getResource("EsercizioFacileJ.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    @FXML
	    public void ScenaEsercizioIntermedio(ActionEvent event) throws IOException {
	        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
	        Parent root = FXMLLoader.load(getClass().getResource("EsercizioInetrmedioJ.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    @FXML
	    public void ScenaEsercizioDificile(ActionEvent event) throws IOException {
	        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
	        Parent root = FXMLLoader.load(getClass().getResource("EsercizioDifficileJ.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }

	}


