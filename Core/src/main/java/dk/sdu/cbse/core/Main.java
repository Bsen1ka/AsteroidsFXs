package dk.sdu.cbse.core;


import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;
import dk.sdu.cbse.common.services.IPostService;

import java.util.Collection;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import static java.util.stream.Collectors.toList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ModuleConfig.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        Game game = context.getBean(Game.class);
        game.start(stage);
        game.render();
    }
}
