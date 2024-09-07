package application;

import java.io.IOException;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

	public class CostruzioneScenaAlan {

		@FXML
		private ProgressBar progressBar;

		@FXML
		private Button startButton;

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
	        Parent root = FXMLLoader.load(getClass().getResource("EsercizioFacileA.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    @FXML
	    public void ScenaEsercizioIntermedio(ActionEvent event) throws IOException {
	        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
	        Parent root = FXMLLoader.load(getClass().getResource("EsercizioMedioA1.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    @FXML
	    public void ScenaEsercizioDificile(ActionEvent event) throws IOException {
	        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
	        Parent root = FXMLLoader.load(getClass().getResource("EsercizioDifficileA.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }

		@FXML
		public void startProgress() {
			if (progressBar == null) {
				System.out.println("ProgressBar not initialized in this scene.");
				return;
			}

			// Create a task to simulate progress
			Task<Void> task = new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					for (int i = 0; i <= 100; i++) {
						Thread.sleep(50); // Simulate some work
						updateProgress(i, 100);
					}
					return null;
				}
			};

			// Bind the ProgressBar's progress property to the task's progress
			progressBar.progressProperty().bind(task.progressProperty());

			// Start the task in a new thread
			new Thread(task).start();
		}
	}
