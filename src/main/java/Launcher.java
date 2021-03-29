import com.thundertech.bubbles.controller.Controller;
import com.thundertech.bubbles.view.Render;
import com.thundertech.bubbles.view.Window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launcher extends Application {


    @Override
    public void start(Stage stage) {
        Window window = new Window(800, 600);
        Render render = new Render(window.getCanvas().getGraphicsContext2D());
        Controller controller = new Controller(window, render);

        loadScene(stage, window.getPane());

        controller.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void loadScene(Stage stage, Pane pane) {
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("[JEngine2D]");
        stage.setResizable(false);
        stage.show();
    }
}
