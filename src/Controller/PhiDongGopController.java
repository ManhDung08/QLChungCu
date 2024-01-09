package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PhiDongGopController {

    @FXML
    private Label feeLabel2;

    @FXML
    private Label feeLabel21;

    @FXML
    private TableView<?> feeTableView;

    @FXML
    private TableView<?> listFeeTableView;

    @FXML
    private TableColumn<?, ?> maHoKhauCol;

    @FXML
    private TableColumn<?, ?> ngayDongGop;

    @FXML
    private TextArea noteText;

    @FXML
    private TextField searchbar;

    @FXML
    private TableColumn<?, ?> soTienCol;

    @FXML
    private TableColumn<?, ?> soTienGoiYCol;

    @FXML
    private TextField soTienGoiYText;

    @FXML
    private TableColumn<?, ?> tenPhiCol;

    @FXML
    private TextField tenPhiText;

    @FXML
    void addFeeOnAction(ActionEvent event) {

    }

    @FXML
    void deleteFeeOnAction(ActionEvent event) {

    }

}
