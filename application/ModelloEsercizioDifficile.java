package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ModelloEsercizioDifficile {

    boolean suggerimentoAttivato = false;

    public void initialize(String commento, String initialCode,
                           String correctCode, TextArea codeArea,
                           Button verifyButton, Text feedbackText,
                           Button esciButton,
                           Button nextButton, String prossimoLivello,
                           int livelloAttuale, int esercizioAttuale, Button helpButton) {

        codeArea.appendText(commento);
        codeArea.appendText(initialCode);

        nextButton.setDisable(true);
        nextButton.setStyle("-fx-background-color: grey; ");

        verifyButton.setOnAction(event -> checkCode(correctCode, codeArea,
                feedbackText, nextButton, livelloAttuale, esercizioAttuale));
        esciButton.setOnAction(event -> {
            try {
                esci(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        helpButton.setOnAction(event -> {
            try{
                suggerimenti(event);
                suggerimentoAttivato = true;
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });

        nextButton.setOnAction(event -> {
            try {
                prossimo(event, prossimoLivello);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // Metodo per verificare il codice inserito dall'utente
    private void checkCode(String correctCode, TextArea codeArea, Text feedbackText,
                           Button nextButton, int livelloAttuale, int esercizioAttuale) {
        String userCode = codeArea.getText().trim();

        // Verifica se l'utente ha corretto la condizione nel modo giusto
        if (userCode.contains(correctCode.trim())) {
            feedbackText.setText("Complimenti! Hai corretto correttamente il codice.");
            feedbackText.setFill(javafx.scene.paint.Color.GREEN);
            nextButton.setDisable(false);
            nextButton.setStyle("-fx-background-color: #00BFFF; -fx-text-fill: white");
            CostruzioneScenaAlan.aggiornaProgresso(livelloAttuale, esercizioAttuale, suggerimentoAttivato);

        } else {
            feedbackText.setText("Errore! La condizione non è ancora corretta.");
            feedbackText.setFill(javafx.scene.paint.Color.RED);
            nextButton.setDisable(true);
        }
    }

    private void esci(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashbord.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void prossimo(ActionEvent event, String prossimoLivello) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(prossimoLivello)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void suggerimenti(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Modal.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }
}
