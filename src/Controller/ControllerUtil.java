
package Controller;

import View.MainView;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//Lớp Util hỗ trợ các lớp khác trong package Controller

public class ControllerUtil {
    public static void ChangeScene(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerUtil.class.getResource("/View/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            Stage mainStage = MainView.getMainStage(); 
            mainStage.setScene(scene);
            mainStage.setTitle(title);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
