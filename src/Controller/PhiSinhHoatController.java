package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PhiSinhHoatController {

    @FXML
    private Label feeLabel2;

    @FXML
    private TableView<?> feeTableView;

    @FXML
    private TableColumn<?, ?> maHoKhauCol;

    @FXML
    private TableColumn<?, ?> maHoKhauCol1;

    @FXML
    private ComboBox<?> monthCBox;

    @FXML
    private TextField searchbar;

    @FXML
    private TableColumn<?, ?> thang10Col;

    @FXML
    private TableColumn<?, ?> thang11Col;

    @FXML
    private TableColumn<?, ?> thang12Col;

    @FXML
    private TableColumn<?, ?> thang1Col;

    @FXML
    private TableColumn<?, ?> thang2Col;

    @FXML
    private TableColumn<?, ?> thang3Col;

    @FXML
    private TableColumn<?, ?> thang4Col;

    @FXML
    private TableColumn<?, ?> thang5Col;

    @FXML
    private TableColumn<?, ?> thang6Col;

    @FXML
    private TableColumn<?, ?> thang7Col;

    @FXML
    private TableColumn<?, ?> thang8Col;

    @FXML
    private TableColumn<?, ?> thang9Col;

    @FXML
    private TableColumn<?, ?> tienDienCol;

    @FXML
    private TextField tienDienText;

    @FXML
    private TableColumn<?, ?> tienInternetCol;

    @FXML
    private TextField tienInternetText;

    @FXML
    private TableColumn<?, ?> tienNuocCol;

    @FXML
    private TextField tienNuocText;

    @FXML
    private Button updateFeeOnAction;

    @FXML
    private TableView<?> updateFeeTableView;

    @FXML
    private ComboBox<?> updateMaHoKhauCBox;

    @FXML
    private ComboBox<?> updateMonthCBox;

    @FXML
    private ComboBox<?> yearCBox;

    @FXML
    void selectYearOnAction(ActionEvent event) {

    }

}