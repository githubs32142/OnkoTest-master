package projekt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jess.JessException;
import jess.Rete;

import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Andrzej Kierepka
 */
public class IonizingRadiationTestController implements Initializable {

    private FactorWindowController window;
    private boolean end = false;// kiedy klikneliśmy na koniec(wystaw diagnozę)    
    private int index;
    @FXML
    private Label question;
    @FXML
    private RadioButton answer1;
    @FXML
    private ToggleGroup tg;
    @FXML
    private RadioButton answer2;
    @FXML
    private Button next;
    List<String> qList = new ArrayList<>();// lista pytań
    List<String> a1List = new ArrayList<>();
    List<String> a2List = new ArrayList<>();
    List<Integer> pList = new ArrayList<>();// ilość punktów przyznanych za każdą odpowiedź
    @FXML
    private ProgressBar progres;
    @FXML
    private Label text;

    /**
     * Inicjalizacja kontriolera
     *
     * @param url wskaźnik do "zasobu" w sieci World Wide Web
     * @param rb  wersja językowa
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qList.add("Czy w ostatnim roku miałeś wykonanych więcej niż 2 badania tomografi komputerowej?");
        qList.add("Czy w ostatnim roku miałeś wykonane więcej niż 4 badania RTG?");
        a1List.add("Nie");
        a1List.add("Nie");
        a2List.add("Tak");
        a2List.add("Tak");
        for (int i = 0; i < 2; i++) {
            pList.add(0);
        }
        question.setText(qList.get(0));
        answer1.setText(a1List.get(0));
        answer2.setText(a2List.get(0));
        answer1.setSelected(true);
        text.setText("Krok " + (index + 1) + "/" + pList.size());
        progres.setProgress(((index + 1) / (double) pList.size()));
    }

    /**
     * * Metoda polegająca na kliknięciu w 1 odpowiedź
     *
     * @param event obsługa zdarzenia
     */
    @FXML
    private void answer1Action(ActionEvent event) {
        pList.set(index, 0);
    }

    /**
     * * Metoda polegająca na kliknięciu w 2 odpowiedź
     *
     * @param event obsługa zdarzenia
     */
    @FXML
    private void answer2Action(ActionEvent event) {
        pList.set(index, 1);
    }

    /**
     * * Metoda, która powoduje przejście do kolejnego pytania.
     *
     * @param event obsługa zdarzenia polegająca na kliknięciu w przycisk
     */
    @FXML
    private void next(ActionEvent event) {
        if (index <= 2) {
            index++;
        }
        if (index == 2) {
            makeAllDiagnose();
            Stage stage;
            stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.close();
        }
        if (index < 2) {
            text.setText("Krok " + (index + 1) + "/" + pList.size());
            progres.setProgress(((index + 1) / (double) pList.size()));
            if (index == 1) {
                next.setText("Zakończ");
            }
            question.setText(qList.get(index));
            answer1.setText(a1List.get(index));
            answer2.setText(a2List.get(index));
            if (pList.get(index) == 0) {
                answer1.setSelected(true);
            }
            if (pList.get(index) == 1) {
                answer2.setSelected(true);
            }
        }
    }

    /**
     * * Metoda, która powoduje przejście wstecz
     *
     * @param event obsługa zdarzenia wstecz
     */
    @FXML
    private void back(ActionEvent event) {
        if (index > 0) {
            index--;
        }
        if (index >= 0) {
            text.setText("Krok " + (index + 1) + "/" + pList.size());
            progres.setProgress(((index + 1) / (double) pList.size()));
            question.setText(qList.get(index));
            answer1.setText(a1List.get(index));
            answer2.setText(a2List.get(index));
            if (pList.get(index) == 0) {
                answer1.setSelected(true);
            }
            if (pList.get(index) == 1) {
                answer2.setSelected(true);
            }
        }
    }

    /**
     * * Metoda, która zamyka okno
     *
     * @param event obsługa zdarzenia
     */
    private void closeWindow(ActionEvent event) {
        Stage stage;
        stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.close();
    }

    public int getIndex() {
        return index;
    }

    /**
     * * Metoda ktora zwraca w postaci ciągu znaków wyrażenie które będzie
     * potrzebne wykonania wniskowania
     *
     * @return
     * @rerurn wyrażenie potrzebne do wykonania wniskowania
     */
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("( assert ( Point");
        for (int i = 0; i < pList.size(); i++) {
            tmp.append("( answer").append(i + 1).append(" ").append(pList.get(i)).append(") ");
        }
        tmp.append(") )");
        return tmp.toString();
    }

    /**
     * * wyświetla wyniki diagnozy
     *
     * @param message rezultat diagnozy
     */
    private void showOutputMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wynik diagnozy");
        alert.setHeaderText("Otrzymane rezulataty");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * * Wykonyje diagnoze,wyświetla dignoze i czyści wartości zmiennych.
     */
    private void makeAllDiagnose() {
        makeDiagnostic(toString());
        index = 0;
        for (int i = 0; i < pList.size(); i++) {
            pList.set(i, 0);
        }
        index = 0;
        end = false;
        next.setText("Dalej >");
        question.setText(qList.get(getIndex()));
        answer1.setText(a1List.get(getIndex()));
        answer2.setText(a2List.get(getIndex()));

    }

    public void makeDiagnostic(String s) {
        boolean add = false;
        StringBuilder text = new StringBuilder();
        try {
            Rete engine = new Rete();
            engine.reset();
            StringWriter o = new StringWriter();
            engine.addOutputRouter("t", o);
            String result = new String();
            // Load the pricing rules
            engine.batch("projekt/JESS/ionizingradiation.clp");
            engine.eval(s);
            engine.run();
            result = o.toString();
            engine.clear();
            if (result == null ? "" == null : result.equals("")) {
                result = "Brak diagnozy";
            }
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == '1') {
                    add = true;
                } else {
                    text.append(result.charAt(i));
                }
            }
            if (add) {
                window.changeFactToRight("Promieniowanie jonizujące");
            }
            showOutputMessage(text.toString());

        } catch (JessException ex) {
            Logger.getLogger(SmokingTestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * * Metoda, która ustawia kontroler klasy głownej
     *
     * @param window kontroler klasy głównej
     */
    public void setWindow(FactorWindowController window) {
        this.window = window;
    }
}
