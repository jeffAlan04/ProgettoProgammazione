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
    public void initialize() {

        String commento = "// Inversione di una stringa\n";

        // Codice predefinito nell'area di testo
        String initialCode = "import java.util.*;\n" +
                "import java.io.*;\n" +
                "public class Es1{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tScanner scan = new Scanner(System.in);\n" +
                "\t\tArrayList<Integer> x = new ArrayList<Integer>();\n" +
                "\t\tSystem.out.println(\"Inserire un numero\");\n" +
                "\t\tint n = scan.nextInt();\n" +
                "\t\tint counter = 0;\n" +
                "\t\twhile(n > -1){\n" +
                "\t\t\tx.add(n);\n" +
                "\t\t\tSystem.out.println(\"Inserire un numero\");\n" +
                "\t\t\tn = scan.nextInt();\n" +
                "\t\t}\n" +
                "\t\twhile (x.get(counter) != counter || x.get(counter) < x.size()){\n" +
                "\t\t\tSystem.out.println(x.get(counter));\n" +
                "\t\t\tif (x.get(counter) > x.size())\n" +
                "\t\t\t\tbreak;\n" +
                "\t\t\telse\n" +
                "\t\t\t\tcounter = x.get(counter);\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        String correctCode = "import java.util.*;\n" +
                "import java.io.*;\n" +
                "public class Es1{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tScanner scan = new Scanner(System.in);\n" +
                "\t\tArrayList<Integer> x = new ArrayList<Integer>();\n" +
                "\t\tSystem.out.println(\"Inserire un numero\");\n" +
                "\t\tint n = scan.nextInt();\n" +
                "\t\tint counter = 0;\n" +
                "\t\twhile(n > -1){\n" +
                "\t\t\tx.add(n);\n" +
                "\t\t\tSystem.out.println(\"Inserire un numero\");\n" +
                "\t\t\tn = scan.nextInt();\n" +
                "\t\t}\n" +
                "\t\twhile (x.get(counter) != counter || x.get(counter) < x.size()){\n" +
                "\t\t\tSystem.out.println(x.get(counter));\n" +
                "\t\t\tif (x.get(counter) > x.size())\n" +
                "\t\t\t\tbreak;\n" +
                "\t\t\telse\n" +
                "\t\t\t\tcounter = x.get(counter);\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        String prossimoLivello = "EsercizioDifficile2.fxml";

        ModelloEsercizio modelloEsercizio = new ModelloEsercizio();
        modelloEsercizio.initialize(commento,initialCode,
                correctCode, codeArea,
                verifyButton, feedbackText, esciButton,
                nextButton, prossimoLivello);
        // Ascolta il pulsante di verifica
    }
}
