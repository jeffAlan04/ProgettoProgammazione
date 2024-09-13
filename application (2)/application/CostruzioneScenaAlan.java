package application;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CostruzioneScenaAlan {

    @FXML
    private Button iniziaBtnFacile;

    @FXML
    private Button iniziaBtnMedio;

    @FXML
    private Button iniziaBtnDifficile;

    private Stage stage;
    private Scene scene;
    private static final String FILE_PATH = "progressi.json"; // JSON file path
    private String scena = "";

    @FXML
    public void initialize() {
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
        for (User user : userList) {
            if (user.getUserName() != null  && user.getUserName().equals(Sessione.getUsername())) {
                scena = aggiornaScena(user, iniziaBtnFacile, iniziaBtnMedio, iniziaBtnDifficile);
            } else {
                System.out.println("Hello world");
            }
        }
    }

    @FXML
    public void ScenaDashbord(ActionEvent event) throws IOException {
        // Carica il file FXML per la scena di login e cambia la scena
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashbord.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ScenaEsercizioFacile(ActionEvent event) throws IOException {
        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(this.scena)));
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(this.scena)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ScenaEsercizioDificile(ActionEvent event) throws IOException {
        // Carica il file FXML per la scena di creazione nuovo utente e cambia la scena
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(this.scena)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void aggiornaProgresso(int livelloAttuale, int esercizioAttuale, boolean suggerimentoAttivato) {
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

                if (suggerimentoAttivato) user.setPunteggio(user.getPunteggio() + 10);

                else user.setPunteggio(user.getPunteggio() + 20);

               if (esercizioAttuale == 0 && livelloAttuale == 0){
                   user.setEsercizio(1);
                   break;
                } else if (esercizioAttuale == 1 && livelloAttuale == 0) {
                   user.setEsercizio(2);
                   break;
               }else if (esercizioAttuale == 2 && livelloAttuale == 0) {
                   user.setEsercizio(0);
                   user.setLivello(1);
                   break;
               }else if (esercizioAttuale == 0 && livelloAttuale == 1) {
                   user.setEsercizio(1);
                   break;
               }else if (esercizioAttuale == 1 && livelloAttuale == 1) {
                   user.setEsercizio(2);
                   break;
               }else if (esercizioAttuale == 2 && livelloAttuale == 1) {
                   user.setEsercizio(0);
                   user.setLivello(2);
                   break;
               }else if (esercizioAttuale == 0 && livelloAttuale == 2) {
                   user.setEsercizio(1);
                   break;
               }else if (esercizioAttuale == 1 && livelloAttuale == 2) {
                   user.setEsercizio(2);
                   break;
               }
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

    public String aggiornaScena(User user, Button iniziaBtnFacile,
                              Button iniziaBtnMedio, Button iniziaBtnDifficile) {
        int livello = user.getLivello();
        int esercizio = user.getEsercizio();

        String prossimoLivello = "";

        if (livello == 0 && esercizio == 0) {
            iniziaBtnMedio.setDisable(true);
            iniziaBtnDifficile.setDisable(true);
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            iniziaBtnDifficile.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "DescrizioneFacileA.fxml";
        }
        else if (livello == 0 && esercizio == 1) {
            iniziaBtnMedio.setDisable(true);
            iniziaBtnDifficile.setDisable(true);
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            iniziaBtnDifficile.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "EsercizioFacileA2.fxml";
        }
        else if (livello == 0 && esercizio == 2) {
            iniziaBtnMedio.setDisable(true);
            iniziaBtnDifficile.setDisable(true);
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            iniziaBtnDifficile.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "EsercizioFacileA3.fxml";
        }
        else if (livello == 1 && esercizio == 0) {
            iniziaBtnFacile.setDisable(true);
            iniziaBtnDifficile.setDisable(true);
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            iniziaBtnDifficile.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "DescrizioneMedioA.fxml";
        }
        else if (livello == 1 && esercizio == 1) {
            iniziaBtnFacile.setDisable(true);
            iniziaBtnDifficile.setDisable(true);
            iniziaBtnFacile.setStyle("-fx-background-color: grey; ");
            iniziaBtnDifficile.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "EsercizioMedioA2.fxml";
        }
        else if (livello == 1 && esercizio == 2) {
            iniziaBtnFacile.setDisable(true);
            iniziaBtnDifficile.setDisable(true);
            iniziaBtnFacile.setStyle("-fx-background-color: grey; ");
            iniziaBtnDifficile.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "EsercizioMedioA3.fxml";
        }
        else if (livello == 2 && esercizio == 0) {
            iniziaBtnFacile.setDisable(true);
            iniziaBtnMedio.setDisable(true);
            iniziaBtnFacile.setStyle("-fx-background-color: grey; ");
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "DescrizioneDifficileA.fxml";
        }
        else if (livello == 2 && esercizio == 1) {
            iniziaBtnFacile.setDisable(true);
            iniziaBtnMedio.setDisable(true);
            iniziaBtnFacile.setStyle("-fx-background-color: grey; ");
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "EsercizioDifficileA2.fxml";
        }
        else if (livello == 2 && esercizio == 2) {
            iniziaBtnFacile.setDisable(true);
            iniziaBtnMedio.setDisable(true);
            iniziaBtnFacile.setStyle("-fx-background-color: grey; ");
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            prossimoLivello = "EsercizioDifficileA3.fxml";
        }
        else{
            iniziaBtnFacile.setDisable(true);
            iniziaBtnMedio.setDisable(true);
            iniziaBtnFacile.setStyle("-fx-background-color: grey; ");
            iniziaBtnMedio.setStyle("-fx-background-color: grey; ");
            //prossimoLivello = "EsercizioRisultati.fxml";
        }
        return prossimoLivello;
    }
}
