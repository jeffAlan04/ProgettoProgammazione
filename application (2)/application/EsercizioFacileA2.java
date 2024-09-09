package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioFacileA2 {
    @FXML
    private Text codeArea;

    @FXML
    private Button verifyButton;

    @FXML
    private Text feedbackText;

    @FXML
    private Button esciButton;

    @FXML
    private Button nextButton;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r3;

    @FXML
    public void initialize() {

        // Codice predefinito nell'area di testo
        String testoDomanda = "// Questo programma deve calcolare il fattoriale di un numero.\n" +
                "public class Fattoriale {\n" +
                "    public static void main(String[] args) {\n" +
                "        int n = 5;\n" +
                "        int fattoriale = 1;\n" +
                "        for (int i = 1; i <= n; i++) {\n" +
                "            fattoriale -= i;\n" +
                "        }\n" +
                "        System.out.println(\"Il fattoriale di \" + n + \" è: \" + fattoriale);\n" +
                "    }\n" +
                "}";

        String prossimoLivello = "EsercizioFacileA3.fxml";
        int livelloAttuale = 1;
        int esercizioAttuale = 2;

        ModelloEsercizioFacile modelloEsercizioFacile = new ModelloEsercizioFacile();
        modelloEsercizioFacile.initialize(testoDomanda,
                codeArea, r1, r2, r3, 1,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello, livelloAttuale, esercizioAttuale);

        CostruzioneScenaAlan costruzioneScenaAlan = new CostruzioneScenaAlan();

        costruzioneScenaAlan.startProgress();
    }

    @FXML
    private void controllaRisposta(ActionEvent event) {
    }
}
