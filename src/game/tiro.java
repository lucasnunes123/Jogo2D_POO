package game;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
/**
 *
 * @author Lucas Nunes GS
 */
public class tiro extends Rectangle {
    TranslateTransition acao = new TranslateTransition(Duration.millis(400),this);
    
    Personagem tyra = new Personagem(25,290,70, 70);
    
    tiro(int posicaox, int posicaoy, int width, int height) {
        this.setX(300);
        this.setY(290);
        this.setWidth(50);
        this.setHeight(50);
        this.setFill(new ImagePattern(new Image("ima/tiro.png")));
        
        acao.setByY(posicaoy);
        acao.setByX(-100f);
        acao.setCycleCount((int) 1f);
        acao.setAutoReverse(true);
    }
}
