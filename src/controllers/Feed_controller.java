package controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.StringJoiner;

import api.insert.Publication_insert;
import api.select.Publication_select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import models.Publication;
import models.User;

public class Feed_controller implements Initializable {
    @FXML
    private TextArea feed_thinking;

    @FXML
    private Pane mensage1;
    @FXML
    private Pane mensage2;
    @FXML
    private Pane mensage3;
    @FXML
    private Pane mensage4;
    @FXML
    private Pane mensage5;

    @FXML
    private Text name1;
    @FXML
    private Text name2;
    @FXML
    private Text name3;
    @FXML
    private Text name4;
    @FXML
    private Text name5;

    @FXML
    private Text date1;
    @FXML
    private Text date2;
    @FXML
    private Text date3;
    @FXML
    private Text date4;
    @FXML
    private Text date5;

    @FXML
    private TextField description1;
    @FXML
    private TextField description2;
    @FXML
    private TextField description3;
    @FXML
    private TextField description4;
    @FXML
    private TextField description5;

    @FXML
    private Text textNameAbrev1;
    @FXML
    private Text textNameAbrev2;
    @FXML
    private Text textNameAbrev3;
    @FXML
    private Text textNameAbrev4;
    @FXML
    private Text textNameAbrev5;

    Publication_insert publicationI = new Publication_insert();
    Publication_select publicationS = new Publication_select();
    App app = new App();
    User user;
    Alerts alert = new Alerts();
    Publication publication = new Publication();
    ArrayList<Publication> publicationsList = new ArrayList<Publication>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.mensage1 != null) {
            refreshFeed();
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        app.changeScreen("login");
    }

    @FXML
    void goTime(ActionEvent event) throws IOException {
        app.changeScreen("time");
    }

    @FXML
    void goSchedule(ActionEvent event) throws IOException {
        app.changeScreen("schedule");
    }

    @FXML
    void publish(ActionEvent event) {
        if (feed_thinking.getText().length() > 0) {
            Date dataHoraAtual = new Date();

            String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
            String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
            data = data + " às " + hora;

            publicationI.insert(feed_thinking.getText(), app.getUser()[1], data, Integer.parseInt(app.getUser()[0]));

            feed_thinking.setText("");
            refreshFeed();

        } else {
            alert.showAlert("Erro", "Texto a ser publicado vazio", "Warning");
        }
    }

    public void refreshFeed() {
        StringJoiner publications = publicationS.getAll();
        int cont = 0;
        int cont2 = 0;
        publication = new Publication();
        publicationsList.clear();
        for (int x = 0; x < publications.length(); x++) {
            if (publications.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < publications.length(); y++) {
                    if (publications.toString().substring(y, y + 1).equals(",")
                            || publications.toString().substring(y, y + 1).equals("]")) {
                        if (cont == 0) {
                            publication.setIdPublication(Integer.parseInt(publications.toString().substring(x + 1, y)));
                            cont++;
                        } else if (cont == 1) {
                            publication.setDescription(publications.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 2) {
                            publication.setUserName(publications.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 3) {
                            publication.setDate(publications.toString().substring(x + 1, y));
                            cont++;
                        } else {
                            publication.setUser(Integer.parseInt(publications.toString().substring(x + 1, y)));
                            publicationsList.add(publication);
                            publication = new Publication();
                            cont = 0;
                        }
                        break;
                    }
                }
            }
        }

        cont2 = Integer.parseInt(getCount());

        for (int i = 0; i < cont2; i++) {
            String name = publicationsList.get(i).getUserName();
            String[] palavras = name.split(" ");

            String primeiroNome = palavras[0];
            String segundoNome = "";

            if (palavras.length > 1) {
                segundoNome = palavras[1];
            }

            char primeiraLetraPrimeiroNome = primeiroNome.charAt(0);
            char primeiraLetraSegundoNome = ' ';

            if (segundoNome.length() > 0) {
                primeiraLetraSegundoNome = segundoNome.charAt(0);
            }

            String resultado = Character.toString(primeiraLetraPrimeiroNome)
                    + Character.toString(primeiraLetraSegundoNome);
            if (i == 0) {
                mensage1.setVisible(true);
                name1.setText(publicationsList.get(i).getUserName());
                date1.setText(publicationsList.get(i).getDate());
                description1.setText(publicationsList.get(i).getDescription());
                textNameAbrev1.setText(resultado);
            } else if (i == 1) {
                mensage2.setVisible(true);
                name2.setText(publicationsList.get(i).getUserName());
                date2.setText(publicationsList.get(i).getDate());
                description2.setText(publicationsList.get(i).getDescription());
                textNameAbrev2.setText(resultado);
            } else if (i == 2) {
                mensage3.setVisible(true);
                name3.setText(publicationsList.get(i).getUserName());
                date3.setText(publicationsList.get(i).getDate());
                description3.setText(publicationsList.get(i).getDescription());
                textNameAbrev3.setText(resultado);
            } else if (i == 3) {
                mensage4.setVisible(true);
                name4.setText(publicationsList.get(i).getUserName());
                date4.setText(publicationsList.get(i).getDate());
                description4.setText(publicationsList.get(i).getDescription());
                textNameAbrev4.setText(resultado);
            } else if (i == 4) {
                mensage5.setVisible(true);
                name5.setText(publicationsList.get(i).getUserName());
                date5.setText(publicationsList.get(i).getDate());
                description5.setText(publicationsList.get(i).getDescription());
                textNameAbrev5.setText(resultado);
            } else {
            }
        }
    }

    public String getCount() {
        String countP = publicationS.getCount();

        return countP;
    }

}
