package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioMedioA1 {
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

        String commento = "// Somma degli elementi in un array\n";

        // Codice predefinito nell'area di testo
        String initialCode = "public class InvertiStringa {\n" +
                "    public static void main(String[] args) {\n" +
                "        String str = \"ciao\";\n" +
                "        String invertita = \"\";\n" +
                "        for (int i = 0; i < str.length(); i++) {\n" +
                "            invertita += str.charAt(i);\n" +
                "        }\n" +
                "        System.out.println(\"Stringa invertita: \" + invertita);\n" +
                "    }\n" +
                "}\n";

        String correctCode = "public class InvertiStringa {\n" +
                "    public static void main(String[] args) {\n" +
                "        String str = \"ciao\";\n" +
                "        String invertita = \"\";\n" +
                "        for (int i = str.length() - 1; i >= 0; i--) {\n" +
                "            invertita += str.charAt(i);\n" +
                "        }\n" +
                "        System.out.println(\"Stringa invertita: \" + invertita);\n" +
                "    }\n" +
                "}\n";

        String prossimoLivello = "EsercizioMedio2.fxml";

        ModelloEsercizio modelloEsercizio = new ModelloEsercizio();
        modelloEsercizio.initialize(commento,initialCode,
                correctCode, codeArea,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello);
        // Ascolta il pulsante di verifica
    }
}
