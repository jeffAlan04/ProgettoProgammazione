package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ModelloEsercizioFacile {

    public void initialize(String testoDomanda,
                           Text codeArea, RadioButton r1, RadioButton r2, RadioButton r3,
                           int rispostaGiusta,
                           Button verifyButton, Text feedbackText,
                           Button esciButton,
                           Button nextButton, String prossimoLivello) {

        codeArea.setText(testoDomanda);
        nextButton.setDisable(true);
        nextButton.setStyle("-fx-background-color: grey; ");

        verifyButton.setOnAction(event -> {
            controllaRisposta(event, rispostaGiusta, r1, r2, r3, feedbackText, nextButton);
        });

        // Ascolta il pulsante di verifica
        esciButton.setOnAction(event -> {
            try {
                esci(event);
            } catch (IOException e) {
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

    private void controllaRisposta(ActionEvent event, int rispostaGiusta,
                                   RadioButton r1, RadioButton r2, RadioButton r3,
                                   Text feedbackText, Button nextButton) {
        if(rispostaGiusta == 1) {
            if(r1.isSelected()) {
                feedbackGiusto(feedbackText, nextButton);
            } else {
                feedbackSbagliato(feedbackText, nextButton);
            }
        }
        if(rispostaGiusta == 2) {
            if(r2.isSelected()) {
                feedbackGiusto(feedbackText, nextButton);
            } else {
                feedbackSbagliato(feedbackText, nextButton);
            }
        }
        if(rispostaGiusta == 3) {
            if(r3.isSelected()) {
                feedbackGiusto(feedbackText, nextButton);
            } else {
                feedbackSbagliato(feedbackText, nextButton);
            }
        }
    }

    private void feedbackGiusto(Text feedbackText, Button nextButton ) {
        feedbackText.setText("Bravo! Hai corretto correttamente il codice.");
        feedbackText.setFill(javafx.scene.paint.Color.GREEN);
        nextButton.setDisable(false);
        nextButton.setStyle("-fx-background-color: green; -fx-text-fill: white");
    }

    private void feedbackSbagliato(Text feedbackText, Button nextButton ) {
        feedbackText.setText("Errore! La condizione non è ancora corretta.");
        feedbackText.setFill(javafx.scene.paint.Color.RED);
        nextButton.setDisable(true);
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
}
