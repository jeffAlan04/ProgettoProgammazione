package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class RisultatoA {

    @FXML
    public void ScenaEsercizioAlan(ActionEvent event) throws IOException {
        // Usa SceneManager per cambiare scena verso "EsercizioAlan.fxml"
        SceneManager.cambiaScena("EsercizioAlan.fxml", event);
    }

    @FXML
    public void ScenaChiusura(ActionEvent event) {
        // Gestisce la chiusura dell'applicazione
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Chiusura.confermaChiusura(stage);
    }
}
