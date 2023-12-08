
package Controller;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;



public class HomeController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private MenuItem changePwButton;

    @FXML
    private Button closeMenuButton;

    @FXML
    private MenuButton feeButton;

    @FXML
    private MenuButton homeOwnerButton;

    @FXML
    private MenuItem householdButton;

    @FXML
    private MenuItem livingFeeButton;

    @FXML
    private MenuItem logoutButton;

    @FXML
    private MenuItem managementFeeButton;

    @FXML
    private Button openMenuButton;

    @FXML
    private MenuItem parkingFeeButton;

    @FXML
    private MenuItem payButton;

    @FXML
    private MenuItem residentButton;

    @FXML
    private MenuItem serviceFeeButton;

    @FXML
    private MenuButton settingButton;

    @FXML
    private AnchorPane sidebarPane;

    @FXML
    private MenuItem statisticButton;

    @FXML
    private MenuItem userInfoButton;

    @FXML
    private MenuItem voluntaryFeeButton;
    
    
    private void ChangeViewInCenter(String fxmlFile){
        Parent root = null;
        try{
            root = FXMLLoader.load(HomeController.class.getResource("/View/" + fxmlFile));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        borderPane.setCenter(root);
    }
    
    
    @FXML
    public void initialize(){
        closeMenuButton.setVisible(true);
        openMenuButton.setVisible(false);
        
        
        homeOwnerButton.setOnShowing(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.15));
            slide.setNode(feeButton);
            slide.setToY(120);
            slide.play();
            feeButton.setTranslateY(220);
        });
        
        homeOwnerButton.setOnHidden(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.15));
            slide.setNode(feeButton);
            slide.setToY(0);
            slide.play();
            feeButton.setTranslateY(100);
        });
        
        feeButton.setOnMousePressed(event -> {
            if(!feeButton.isShowing()){
                PauseTransition delay = new PauseTransition(Duration.seconds(0.15));
                delay.setOnFinished(e -> {
                    feeButton.show();
                });
                delay.play();
            }
            else{
                feeButton.hide();
            }
        });
        
        
        
    }
    
    
    //Logout
    @FXML
    public void LogoutOnAction(ActionEvent event){ 
        ControllerUtil.ChangeScene("LoginView.fxml", "Login");
    }
    
    
    //Hiển thị thông tin cá nhân của admin
    @FXML
    public void UserInfoOnAction(ActionEvent event){
        
    }
    
    
    //Hiển thị màn hình thay đổi mật khẩu
    @FXML
    public void ChangePwOnAction(ActionEvent event){
        
    }
    
    
    @FXML
    public void HandleClick(ActionEvent event){
        if(event.getSource() == residentButton){  //Hiển thị bảng nhân khẩu
            
        }
        else if(event.getSource() == householdButton){   //Hiển thị bảng hộ khẩu
            
        }
        else if(event.getSource() == serviceFeeButton){  //Hiển thị bảng phí dịch vụ
            
        }
        else if(event.getSource() == managementFeeButton){   //Hiển thị bảng phí quản lý
            
        }
        else if(event.getSource() == parkingFeeButton){   //Hiển thị bảng phí gửi xe
            
        }
        else if(event.getSource() == livingFeeButton){   //Hiện thị bảng phí sinh hoạt
            
        }
        else if(event.getSource() == voluntaryFeeButton){  //Hiển thị bảng phí đóng góp
            
        }
        else if(event.getSource() == payButton){   //Hiển thị thanh toán
            
        }
        else if(event.getSource() == statisticButton){  //Hiển thị các thống kê
            
        }
    }
    
    //Hiển thị Sidebar
    @FXML
    public void OpenSidebarOnAction(ActionEvent event){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(sidebarPane);
        slide.setToX(0);
        slide.play();
        sidebarPane.setTranslateX(-250);
        slide.setOnFinished((ActionEvent e)-> {
            openMenuButton.setVisible(false);
            closeMenuButton.setVisible(true);
        });
    }
    
    //Đóng sidebar
    @FXML
    public void CloseSidebarOnAction(ActionEvent event){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(sidebarPane);
        slide.setToX(-250);
        slide.play();
        sidebarPane.setTranslateX(0);
        slide.setOnFinished((ActionEvent e)-> {
            openMenuButton.setVisible(true);
            closeMenuButton.setVisible(false);
        });
    }
    
    @FXML
    public void ShowHomeOwnerOnAction(MouseEvent event) {
        
    }

}
