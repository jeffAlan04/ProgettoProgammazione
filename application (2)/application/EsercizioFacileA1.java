package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EsercizioFacileA1 {

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
    private Button option1Button;

    @FXML
    private Button option2Button;

    @FXML
    private Button option3Button;

    @FXML
    public void initialize() {

        String commento = "// Il programma deve calcolare la somma dei numeri pari da 1 a 10.\n";

        // Codice predefinito nell'area di testo
        String initialCode = "public class SommaPari {\n" +
                "    public static void main(String[] args) {\n" +
                "        int somma = 0;\n" +
                "        for (int i = 1; i <= 10; i++) {\n" +
                "            if (i % 2 != 0) {\n" +
                "                somma += i;\n" +
                "            }\n" +
                "        }\n" +
                "        System.out.println(\"La somma è: \" + somma);\n" +
                "    }\n" +
                "}";

        String correctCode = "public class SommaPari {\n" +
                "    public static void main(String[] args) {\n" +
                "        int somma = 0;\n" +
                "        for (int i = 1; i <= 10; i++) {\n" +
                "            if (i % 2 == 0) {\n" +
                "                somma += i;\n" +
                "            }\n" +
                "        }\n" +
                "        System.out.println(\"La somma è: \" + somma);\n" +
                "    }\n" +
                "}";

        String prossimoLivello = "EsercizioFacileA2.fxml";

        ModelloEsercizio modelloEsercizio = new ModelloEsercizio() ;
        modelloEsercizio.initialize(commento,initialCode,
                correctCode, codeArea,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello);

        CostruzioneScenaAlan costruzioneScenaAlan = new CostruzioneScenaAlan();

        costruzioneScenaAlan.startProgress();

        setupAnswerButtons();
    }

    private void setupAnswerButtons() {
        // Set button actions to check for the correct answer
        option1Button.setOnAction(event -> checkAnswer(option1Button.getText()));
        option2Button.setOnAction(event -> checkAnswer(option2Button.getText()));
        option3Button.setOnAction(event -> checkAnswer(option3Button.getText()));
    }

    private void checkAnswer(String selectedAnswer) {
        String correctAnswer = "Correct Answer";  // Replace with the actual correct answer

        if (selectedAnswer.equals(correctAnswer)) {
            feedbackText.setText("Correct! Well done.");
        } else {
            feedbackText.setText("Incorrect. Try again.");
        }
    }
}
