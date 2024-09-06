package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ModelloEsercizio {
    public void initialize(String commento, String initialCode,
                           String correctCode, TextArea codeArea,
                           Button verifyButton, Text feedbackText,
                           Button esciButton,
                           Button nextButton, String prossimoLivello) {

        codeArea.appendText(commento);
        codeArea.appendText(initialCode);

        // Ascolta il pulsante di verifica
        verifyButton.setOnAction(event -> checkCode(correctCode, codeArea, feedbackText));
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


    // Metodo per verificare il codice inserito dall'utente
    private void checkCode(String correctCode, TextArea codeArea, Text feedbackText) {
        String userCode = codeArea.getText().trim();

        // Verifica se l'utente ha corretto la condizione nel modo giusto
        if (userCode.contains(correctCode.trim())) {
            feedbackText.setText("Bravo! Hai corretto correttamente il codice.");
            feedbackText.setFill(javafx.scene.paint.Color.GREEN);
        } else {
            feedbackText.setText("Errore! La condizione non è ancora corretta.");
            feedbackText.setFill(javafx.scene.paint.Color.RED);
        }
    }
    private void esci(ActionEvent event)throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashbord.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    private void prossimo(ActionEvent event, String prossimoLivello)throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(prossimoLivello)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
