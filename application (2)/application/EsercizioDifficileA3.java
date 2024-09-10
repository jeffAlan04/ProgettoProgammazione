package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioDifficileA3 {
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

        String commento = "// Inversione di una stringa\n";

        // Codice predefinito nell'area di testo
        String initialCode = "public class MaxMatrice {\n" +
                "    public static void main(String[] args) {\n" +
                "        int[][] matrice = {\n" +
                "            {1, 2, 3},\n" +
                "            {4, 5, 6},\n" +
                "            {7, 8, 9}\n" +
                "        };\n" +
                "        int max = Integer.MIN_VALUE;\n" +
                "        for (int i = 0; i < matrice.length; i++) {\n" +
                "            for (int j = 0; j < matrice[i].length; j++) {\n" +
                "                if (matrice[i][j] < max) {\n" +
                "                    max = matrice[i][j];\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        System.out.println(\"Il massimo è: \" + max);\n" +
                "    }\n" +
                "}\n";

        String correctCode = "public class MaxMatrice {\n" +
                "    public static void main(String[] args) {\n" +
                "        int[][] matrice = {\n" +
                "            {1, 2, 3},\n" +
                "            {4, 5, 6},\n" +
                "            {7, 8, 9}\n" +
                "        };\n" +
                "        int max = Integer.MIN_VALUE;\n" +
                "        for (int i = 0; i < matrice.length; i++) {\n" +
                "            for (int j = 0; j < matrice[i].length; j++) {\n" +
                "                if (matrice[i][j] > max) {\n" +
                "                    max = matrice[i][j];\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        System.out.println(\"Il massimo è: \" + max);\n" +
                "    }\n" +
                "}\n";

        String prossimoLivello = "EsercizioDifficile2.fxml";
        int livelloAttuale = 2;
        int esercizioAttuale = 2;
        ModelloEsercizioDifficile modelloEsercizioDifficile = new ModelloEsercizioDifficile();
        modelloEsercizioDifficile.initialize(commento,initialCode,
                correctCode, codeArea,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello, livelloAttuale, esercizioAttuale);
        // Ascolta il pulsante di verifica
    }
}
