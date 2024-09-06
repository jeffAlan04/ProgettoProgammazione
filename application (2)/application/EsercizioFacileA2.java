package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioFacileA2 {
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
    public void initialize() {

        String commento = "// Questo programma deve calcolare il fattoriale di un numero.\n";

        // Codice predefinito nell'area di testo
        String initialCode = "public class Fattoriale {\n" +
                "    public static void main(String[] args) {\n" +
                "        int n = 5;\n" +
                "        int fattoriale = 1;\n" +
                "        for (int i = 1; i <= n; i++) {\n" +
                "            fattoriale -= i;\n" +
                "        }\n" +
                "        System.out.println(\"Il fattoriale di \" + n + \" è: \" + fattoriale);\n" +
                "    }\n" +
                "}";

        String correctCode = "public class Fattoriale {\n" +
                "    public static void main(String[] args) {\n" +
                "        int n = 5;\n" +
                "        int fattoriale = 1;\n" +
                "        for (int i = 1; i <= n; i++) {\n" +
                "            fattoriale *= i;" +
                "        }\n" +
                "        System.out.println(\"Il fattoriale di \" + n + \" è: \" + fattoriale);\n" +
                "    }\n" +
                "}";

        String prossimoLivello = "EsercizioFacileA3.fxml";

        ModelloEsercizio modelloEsercizio = new ModelloEsercizio();
        modelloEsercizio.initialize(commento, initialCode,
                correctCode, codeArea,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello);
    }
}
