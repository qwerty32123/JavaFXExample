package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SecondController {

    @FXML
    private TextField NombreInputText;

    @FXML
    private TextField ApellidosInputText;

    @FXML
    private TextField TelefonoTextField;

    @FXML
    private Button ReservarButton;

    @FXML
    private Label FReservaLabel;

    @FXML
    private DatePicker FReservaDatePicker;

    @FXML
    private Label TEventoLabel;

    @FXML
    private ComboBox<String> TEventoComboBox;

    @FXML
    private Label TCocinaLabel;

    @FXML
    private ComboBox<String> TCocinaComboBox;

    @FXML
    private Label NPersonasLabel;

    @FXML
    private Spinner<Integer> NPersonasSpinner;

    @FXML
    private Label JCongresoLabel;

    @FXML
    private Spinner<Integer> JCongresoSpinner;

    @FXML
    private RadioButton HabAsisRaddioButton;

    @FXML
    private void telefonoclear() {
        this.TelefonoTextField.clear();
    }
    @FXML
    private void nombreclear() {
        this.NombreInputText.clear();
    }
    @FXML
    private void apellidosclear() {
        this.ApellidosInputText.clear();
    }
    private void disableDatePicker(){
        this.FReservaDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });
    }
    @FXML
    private void TEventoComboBoxListener() {
        String selection = this.TEventoComboBox.getValue();
        if (selection.equalsIgnoreCase("Congreso")){
            this.HabAsisRaddioButton.setDisable(false);
            this.JCongresoSpinner.setDisable(false);
        }
        else{
            this.HabAsisRaddioButton.setDisable(true);
            this.JCongresoSpinner.setDisable(true);
        }

    }

    private void close(){
        Stage stage = (Stage) this.ReservarButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void ReservaBottonAction(){
        if(this.NombreInputText.getText().trim().isEmpty() || this.ApellidosInputText.getText().trim().isEmpty()|| this.TelefonoTextField.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion");
            alert.setHeaderText("ALGUN CAMPO ESTA VACIO");
            alert.setContentText("El telefono, el nombre o los apellidos no pueden estar vacios, por favor revisa estos campos antes de reservar");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
            return;
            };

        String nombre = this.NombreInputText.getText();
        String apellidos = this.ApellidosInputText.getText();
        String telefono = this.TelefonoTextField.getText();
        LocalDate localDate = this.FReservaDatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        String evento = this.TEventoComboBox.getValue();
        String cocina = this.TCocinaComboBox.getValue();
        int personas = this.NPersonasSpinner.getValue();
        String baseMsg = "Informacion de reserva Usted ha realizado la siguiente reserva: \nA nombre de: "+nombre+ " "+apellidos + "\n Con numero de telefono: "
                + telefono + "\nen fecha: " + date + " \nevento:" + evento + "\nTipo de cocina: "+cocina + "\n numero de personas: "+ personas;
        if(evento.equalsIgnoreCase("congreso")){
            int jornadas = this.JCongresoSpinner.getValue();
            boolean HabitacionesAsistentes = this.HabAsisRaddioButton.isSelected();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String basemessage = baseMsg + "\nJornadas: "+ jornadas;
            if(HabitacionesAsistentes){
                basemessage = basemessage +" con habbitaciones para los asistentes:";

            }

            alert.setTitle("Reserva Realizada");
            alert.setHeaderText("Information reserva");
            alert.setContentText(basemessage);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Reserva Realizada");
            alert.setHeaderText("Information reserva");
            alert.setContentText(baseMsg);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();


        }
        close();


        }


    private void enableTEventoComboBox(){

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Presentacion",
                        "Jornada",
                        "Congreso"
                );

        this.TEventoComboBox.setItems(options);
        this.TEventoComboBox.getSelectionModel().selectFirst();

    }
    private void enableTCocinaComboBox(){

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "General",
                        "Celiacos",
                        "Vegetarianos",
                        "Veganos"

                );

        this.TCocinaComboBox.setItems(options);
        this.TCocinaComboBox.getSelectionModel().selectFirst();

    }
    private void initSpinners(){
        SpinnerValueFactory.IntegerSpinnerValueFactory spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50);
        SpinnerValueFactory.IntegerSpinnerValueFactory spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50);



        this.NPersonasSpinner.setValueFactory(spinner);
        this.JCongresoSpinner.setValueFactory(spinner2);
    }

    public void initialize() {
        this.HabAsisRaddioButton.setDisable(true);
        this.JCongresoSpinner.setDisable(true);
        this.FReservaDatePicker.setValue(LocalDate.now());
        disableDatePicker();
        enableTEventoComboBox();
        enableTCocinaComboBox();
        initSpinners();


    }


}

