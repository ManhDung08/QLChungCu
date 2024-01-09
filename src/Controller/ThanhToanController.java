package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ThanhToanController {

    @FXML
    private Label feeLabel2;

    @FXML
    private ComboBox<?> maHoKhauCBox;

    @FXML
    private TableColumn<?, ?> maHoKhauCol;

    @FXML
    private TableColumn<?, ?> ngayThanhToanCol;

    @FXML
    private TableView<?> paymentTableView;

    @FXML
    private CheckBox phiDichVuCheckBox;

    @FXML
    private CheckBox phiDongGopCheckBox;

    @FXML
    private CheckBox phiGuiXeCheckBox;

    @FXML
    private CheckBox phiQuanLyCheckBox;

    @FXML
    private CheckBox phiSinhHoatCheckBox;

    @FXML
    private TextField searchbar;

    @FXML
    private TextField soThangDichVuText;

    @FXML
    private TextField soThangGuiXeText;

    @FXML
    private TextField soThangQuanLyText;

    @FXML
    private TextField soTienDongGopText;

    @FXML
    private TableColumn<?, ?> soTienThanhToanCol;

    @FXML
    private ComboBox<?> tenPhiCBox;

    @FXML
    private Label totalFeeLabel;

    @FXML
    void confirmOnAction(ActionEvent event) {
        
    }

}
