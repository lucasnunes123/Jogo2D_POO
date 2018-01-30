package ProjectJogo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Lucas Nunes GS
 */

public class ProjectJogo extends Application {
    
    private int posX = 25; 
    private final  int posY = 310;
    
    private final Image imageD = new Image("Imagens/carrinha.png");
    private final Image imageE = new Image("Imagens/carinha2.png");
    private final Image nativoima = new Image("Imagens/giphy.gif");
    private final Image cena = new Image("Imagens/Syberian.png");
            
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 400);
        scene.setFill(new ImagePattern(cena));
        
        
        Rectangle personagem = new Rectangle();
        Rectangle nativo = new Rectangle();
        
        //pulo_personagem
        TranslateTransition pulopersonagem = new TranslateTransition(Duration.millis(400),personagem);
        pulopersonagem.setByY(-100f);
        pulopersonagem.setCycleCount((int) 2f);
        pulopersonagem.setAutoReverse(true);
        //animação_nativo
        TranslateTransition anima_nativo = new TranslateTransition(Duration.millis(3500),nativo);
        anima_nativo.setByX(500f);
        anima_nativo.setByX(-500f);
        anima_nativo.setCycleCount((int) 1f);
        anima_nativo.setAutoReverse(true);
        anima_nativo.play();

        //Config_personagem
        personagem.setX(posX); // Posição inicial personagem
        personagem.setY(posY); //Posião inicial personagem
        personagem.setWidth(40); // largura personagem
        personagem.setHeight(50); // altura personagem
        personagem.setFill(new ImagePattern(imageD)); // preenchimento
        
        //Config_nativo
        nativo.setX(500);//Posição inicial nativo
        nativo.setY(posY);//Posição inicial nativo
        nativo.setWidth(70);//Largura nativo
        nativo.setHeight(60);//Altura nativo
        nativo.setFill(new ImagePattern(nativoima));
        
        root.getChildren().add(personagem);
        root.getChildren().add(nativo);
  
        //evento de tecla precionada
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
            
            //Movimento_personagens
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.UP)){
                    pulopersonagem.play();
                }
                if(event.getCode().equals(KeyCode.LEFT)){
                    if(posX < 1){
                        posX = 0;         
                    }
                
                   personagem.setX(posX);
                   posX = posX - 10; 
                   personagem.setX(posX);
                   personagem.setFill(new ImagePattern(imageE));
                }
                if(event.getCode().equals(KeyCode.RIGHT)){
                    if(posX > 760){
                        posX = 760;
                    }
                    personagem.setX(posX);
                    posX = posX + 10;
                    personagem.setX(posX);
                    personagem.setFill(new ImagePattern(imageD));
                }
                if(event.getCode().equals(KeyCode.ESCAPE)){
                    primaryStage.close();
                }
 
            }
            
        });
        
        primaryStage.setTitle("Metal Chucrute:Versão lukita");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }   
}