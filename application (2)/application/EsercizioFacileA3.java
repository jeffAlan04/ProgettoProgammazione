package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioFacileA3 {
     @FXML
        private TextArea codeArea;

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

            String commento = "// Calcola la media di un array.\n";

            // Codice predefinito nell'area di testo
            String initialCode = "public class Media {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        int[] array = {1, 2, 3, 4, 5};\n" +
                    "        int somma = 0;\n" +
                    "        double media = 0;\n" +
                    "        for (int i = 0; i < array.length; i++) {\n" +
                    "            somma += i;\n" +
                    "        }\n" +
                    "        media = somma / array.length;\n"+
                    "        System.out.println(\"La media dell'array corrisponde a:  \" + media);\n" +
                    "    }\n" +
                    "}";

            String prossimoLivello = "EsercizioMedioA1.fxml";

            ModelloEsercizioFacile modelloEsercizioFacile = new ModelloEsercizioFacile();
            modelloEsercizioFacile.initialize(commento, initialCode,
                    codeArea, r1, r2, r3, 2,
                    verifyButton, feedbackText, esciButton,
                    nextButton, prossimoLivello);

            CostruzioneScenaAlan costruzioneScenaAlan = new CostruzioneScenaAlan();

            costruzioneScenaAlan.startProgress();
        }

    @FXML
    private void controllaRisposta(ActionEvent event) {
    }
}
