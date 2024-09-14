package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioDifficileA2 {
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
    private Button helpButton;

    @FXML
    public void initialize() {

        String commento = "//Ordinare un array di numeri in ordine crescente usando l'ordinamento a bolle.\n\n";

        // Codice predefinito nell'area di testo
        String initialCode = "public class BubbleSort {\n" +
                "    public static void main(String[] args) {\n" +
                "        int[] numeri = {5, 2, 9, 1, 5, 6};\n" +
                "        for (int i = 0; i < numeri.length; i++) {\n" +
                "            for (int j = 0; j < numeri.length - 1; j++) {\n" +
                "                if (numeri[j] < numeri) {\n" +
                "                    int temp = numeri[j];\n" +
                "                    numeri[j] = numeri[j];\n" +
                "                    numeri[j + 1] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        System.out.println(\"Array ordinato: \");\n" +
                "        for (int num : numeri) {\n" +
                "            System.out.print(num + \" \");\n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        String correctCode = "public class BubbleSort {\n" +
                "    public static void main(String[] args) {\n" +
                "        int[] numeri = {5, 2, 9, 1, 5, 6};\n" +
                "        for (int i = 0; i < numeri.length; i++) {\n" +
                "            for (int j = 0; j < numeri.length - 1; j++) {\n" +
                "                if (numeri[j] > numeri[j + 1]) {\n" +
                "                    int temp = numeri[j];\n" +
                "                    numeri[j] = numeri[j + 1];\n" +
                "                    numeri[j + 1] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        System.out.println(\"Array ordinato: \");\n" +
                "        for (int num : numeri) {\n" +
                "            System.out.print(num + \" \");\n" +
                "        }\n" +
                "    }\n" +
                "}\n";


        String prossimoLivello = "EsercizioDifficileA3.fxml";
        int livelloAttuale = 2;
        int esercizioAttuale = 1;

        ModelloEsercizioDifficile modelloEsercizioDifficile = new ModelloEsercizioDifficile();
        modelloEsercizioDifficile.initialize(commento,initialCode,
                correctCode, codeArea,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello, livelloAttuale, esercizioAttuale, helpButton);
        // Ascolta il pulsante di verifica
    }
}
