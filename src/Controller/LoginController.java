    
package Controller;

import Model.MysqlConnector;
import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;


public class LoginController {
    @FXML
    public TextField txtUserName;
    
    @FXML
    public PasswordField txtHidePassword;
    
    @FXML
    public TextField txtShowPassword;
    
    @FXML
    public ImageView Open_Eye_Icon;
    
    @FXML
    public ImageView Close_Eye_Icon;
    
    @FXML
    public HBox showPassword;
    
    @FXML
    public HBox hidePassword;
    
    @FXML
    public ImageView backGround;
    
    String password;
    
    public void Initialize(){
        txtShowPassword.setVisible(true);
        Open_Eye_Icon.setVisible(true);
    }
    
    @FXML
    public void LostFocus(MouseEvent event){
        backGround.requestFocus();
    }
    
    @FXML
    public void HidePasswordOnAction(KeyEvent keyEvent){
        password = txtHidePassword.getText();
        txtShowPassword.setText(password);
    }
    
    @FXML
    public void ShowPasswordOnAction(KeyEvent keyEvent){
        password = txtShowPassword.getText();
        txtHidePassword.setText(password);
    }
    
    
    @FXML
    public void Close_Eye_ClickOnAction(MouseEvent mouseEvent){
        showPassword.setVisible(true);
        hidePassword.setVisible(false);
        
    }   
    @FXML
    public void Open_Eye_ClickOnAction(MouseEvent mouseEvent){
        showPassword.setVisible(false);
        hidePassword.setVisible(true);
    }
    
    
    @FXML
    public void CheckLogin(ActionEvent event){
        String userName = txtUserName.getText();
        if(userName.isEmpty() || password.isEmpty()){
            ShowErrorDialog("Vui lòng nhập tên đăng nhập và mật khẩu!");
            return;
        }
        
        //Chỉ cần try-catch hàm getConnection() 1 lần trong hàm CheckLogin(), những lần sau không cần try-catch
        try {
            Connection connection = MysqlConnector.getInstance().getConnection();
            if (connection == null) {
                ShowErrorDialog("Lỗi kết nối với cơ sở dữ liệu.");
            }

            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, userName);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    //Đổi scene sang HomeView -- làm sau
                } else {
                    ShowErrorDialog("Sai tên đăng nhập hoặc mật khẩu.");
                }
            }
        } catch (SQLException e) {
            ShowErrorDialog("Lỗi kết nối với cơ sở dữ liệu.");
        }
    }
    
    private void ShowErrorDialog(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
}
