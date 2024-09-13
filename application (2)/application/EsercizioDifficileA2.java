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

        String commento = "// Leggere da tastiera delle stringhe fino a che viene inserita una stringa di lunghezza maggiore di\n" +
                "10 (da non considerare). Quindi stampare tutte le stringhe che contengono un numero di vocali\n" +
                "maggiore della media.\n";

        // Codice predefinito nell'area di testo
        String initialCode = "import java.util.*;\n" +
                "public class Es1{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tScanner scan = new Scanner(scan);\n" +
                "\t\tArrayList<String> listaStringhe = new ArrayList<>();\n" +
                "\t\tArrayList<Integer> numeroVocali = new ArrayList<>();\n" +
                "\t\tSystem.out.println(\"Insersci una stringa\");\n" +
                "\t\tString parolaInserita = scan.nextLine();\n" +
                "\t\tint contaVocaliTotale = 0;\n" +
                "\t\tint mediaVocali = 0;\n" +
                "\t\tString parolaMinuscola = parolaInserita.toLowerCase();\n" +
                "\t\twhile(parolaMinuscola.length() < 10){\n" +
                "\t\t\tint contaVocaliLocali = 0;\n" +
                "\t\t\tlistaStringhe.add(parolaInserita);\n" +
                "\t\t\tSystem.out.println(\"Insersci una stringa\");\n" +
                "\t\t    parolaInserita = scan.nextLine();\n" +
                "\t\t    for (int i = 0; i < parolaMinuscola.length() - 1; i++){\n" +
                "\t\t    \tif (\"a\".equals(parolaMinuscola.charAt(i)) || \"e\".equals(parolaMinuscola.charAt(i)) ||\n" +
                "\t\t    \t\t\"i\".equals(parolaMinuscola.charAt(i)) || \"o\".equals(parolaMinuscola.charAt(i)) ||\n" +
                "\t\t    \t\"u\".equals(parolaMinuscola.charAt(i))){\n" +
                "\t\t    \t\tcontaVocaliTotale++;\n" +
                "\t\t    \t\tcontaVocaliLocali++;\n" +
                "\t\t    \t}\n" +
                "\t\t    }\n" +
                "\t\t    numeroVocali.add(contaVocaliLocali);\n" +
                "\t\t}\t\t\t\t    \t\n" +
                "\t\tmediaVocali = contaVocaliTotale / listaStringhe;\n" +
                "\t\tfor (int i = 0; i < numeroVocali.size(); i++){\n" +
                "\t\t\tif (numeroVocali.get(i) > mediaVocali){\n" +
                "\t\t\t\tSystem.out.println(listaStringhe.get(i));\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t}\n" +
                "}";

        String correctCode = "import java.util.*;\n" +
                "public class StringheEVocali{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tScanner scan = new Scanner(scan);\n" +
                "\t\tArrayList<String> listaStringhe = new ArrayList<>();\n" +
                "\t\tArrayList<Integer> numeroVocali = new ArrayList<>();\n" +
                "\t\tSystem.out.println(\"Insersci una stringa\");\n" +
                "\t\tString parolaInserita = scan.nextLine();\n" +
                "\t\tint contaVocaliTotale = 0;\n" +
                "\t\tint mediaVocali = 0;\n" +
                "\t\tString parolaMinuscola = parolaInserita.toLowerCase();\n" +
                "\t\twhile(parolaMinuscola.length() < 10){\n" +
                "\t\t\tint contaVocaliLocali = 0;\n" +
                "\t\t\tlistaStringhe.add(parolaInserita);\n" +
                "\t\t\tSystem.out.println(\"Insersci una stringa\");\n" +
                "\t\t    parolaInserita = scan.nextLine();\n" +
                "\t\t    parolaMinuscola = parolaInserita.toLowerCase();\n" +
                "\t\t    for (int i = 0; i < parolaMinuscola.length() - 1; i++){\n" +
                "\t\t    \tif (\"a\".equals(parolaMinuscola.charAt(i)) || \"e\".equals(parolaMinuscola.charAt(i)) ||\n" +
                "\t\t    \t\t\"i\".equals(parolaMinuscola.charAt(i)) || \"o\".equals(parolaMinuscola.charAt(i)) ||\n" +
                "\t\t    \t\"u\".equals(parolaMinuscola.charAt(i))){\n" +
                "\t\t    \t\tcontaVocaliTotale++;\n" +
                "\t\t    \t\tcontaVocaliLocali++;\n" +
                "\t\t    \t}\n" +
                "\t\t    }\n" +
                "\t\t    numeroVocali.add(contaVocaliLocali);\n" +
                "\t\t}\t\t\t\t    \t\n" +
                "\t\tmediaVocali = contaVocaliTotale / listaStringhe.size();\n" +
                "\t\tfor (int i = 0; i < numeroVocali.size(); i++){\n" +
                "\t\t\tif (numeroVocali.get(i) > mediaVocali){\n" +
                "\t\t\t\tSystem.out.println(listaStringhe.get(i));\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";


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
