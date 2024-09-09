package application;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
    private static final String FILE_PATH = "progressi.json"; // JSON file path


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

    public static void aggiornaProgresso(int livelloAttuale, int esercizioAttuale) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<User> userList = new ArrayList<>();

        // Read existing users from the JSON file
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Type userListType = new TypeToken<ArrayList<User>>() {
                }.getType();
                userList = gson.fromJson(reader, userListType);// Load existing users

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int index = 0;

        User user = new User();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(Sessione.getUsername())) {
                index = i;
                user = userList.get(i);
                if (esercizioAttuale == 1) {
                    user.setEsercizio(2);
                } else if (esercizioAttuale == 2) {
                    user.setEsercizio(3);
                } else {
                    if (livelloAttuale == 1) {
                        user.setLivello(2);
                        user.setEsercizio(1);
                    } else if (livelloAttuale == 2) {
                        user.setLivello(3);
                        user.setEsercizio(1);
                    }
                }
                System.out.println("Esercizio: " + user.getEsercizio());
                break;
            }
        }
        userList.set(index, user);

        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getUserName());
            System.out.println(userList.get(i).getEsercizio());
        }
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
