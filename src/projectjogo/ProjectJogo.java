package projectjogo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Nunes GS
 */
public class ProjectJogo extends Application {
    
    private int posX = 25, posY = 250; 
    private int mov = 0;
    
    private Image imageD = new Image("carrinha.png");
    private Image imageE = new Image("carinha2.png");
    private Image nativoima = new Image("giphy.gif");
    private Image cena = new Image("original.png");
            
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 400);
        scene.setFill(new ImagePattern(cena));
        
        
        Rectangle personagem = new Rectangle();
        Rectangle nativo = new Rectangle();
        
        //Config_personagem
        personagem.setX(posX); // distancia da borda de cima
        personagem.setY(posY); // distancia da borda da esquerda
        personagem.setWidth(40); // largura
        personagem.setHeight(50); // altura
        personagem.setFill(new ImagePattern(imageD)); // preenchimento
        
        //Config_nativo
        nativo.setX(500);//Posição inicial nativo
        nativo.setY(posY);
        nativo.setWidth(70);//Largura
        nativo.setHeight(60);//Altura
        nativo.setFill(new ImagePattern(nativoima));
        
        root.getChildren().add(personagem);
        root.getChildren().add(nativo);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            //Movimento_personagens
            public void handle(KeyEvent event) {
               
                if(event.getCode().equals(KeyCode.LEFT)){
                    posX = posX - 20; 
                   personagem.setX(posX);
                   personagem.setFill(new ImagePattern(imageE));
                }
                if(event.getCode().equals(KeyCode.RIGHT)){
                    posX = posX + 20;
                    personagem.setX(posX);
                    personagem.setFill(new ImagePattern(imageD));

                }
            }
            
        });
        
        
        primaryStage.setTitle("Metal Slug:Versão lukita");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
