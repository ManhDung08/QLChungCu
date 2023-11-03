
package Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;



public class HomeController {
    @FXML 
    private Button openMenuButton, closeMenuButton, nhanKhauButton;
    
    @FXML
    private AnchorPane sidebarPane;
    
    
    @FXML
    public void initialize(){
        closeMenuButton.setVisible(true);
        openMenuButton.setVisible(false);
    }
    
    @FXML
    public void LogoutOnAction(ActionEvent event){ 
        ControllerUtil.ChangeScene("LoginView.fxml", "Login");
    }
    
    @FXML
    public void UserInfoOnAction(ActionEvent event){
        
    }
    
    @FXML
    public void ChangePwOnAction(ActionEvent event){
        
    }
    
    @FXML
    public void OpenSidebarOnAction(ActionEvent event){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(sidebarPane);
        slide.setToX(0);
        slide.play();
        sidebarPane.setTranslateX(-250);
        slide.setOnFinished((ActionEvent e)-> {
            openMenuButton.setVisible(false);
            closeMenuButton.setVisible(true);
        });
    }
    
    @FXML
    public void CloseSidebarOnAction(ActionEvent event){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(sidebarPane);
        slide.setToX(-250);
        slide.play();
        sidebarPane.setTranslateX(0);
        slide.setOnFinished((ActionEvent e)-> {
            openMenuButton.setVisible(true);
            closeMenuButton.setVisible(false);
        });
    }
    
}
