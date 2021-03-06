/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 * 
 * Classe Tanque(chefão).
 */
public class Tangue extends Rectangle {
        
    TranslateTransition MovTanque = new TranslateTransition(Duration.millis(400),this);
    /**
     * 
     * @param posicaox Definição da posição do tanque no eixo X.
     * @param posicaoy Definição da posição do tanque no eixo Y.
     * @param width Definição da largura do tanque.
     * @param height Definição da altura do tanque.
     */
    Tangue(int posicaox, int posicaoy, int width, int height) {
        this.setX(300);
        this.setY(posicaoy);
        this.setWidth(120);
        this.setHeight(80);
        this.setFill(new ImagePattern(new Image("ima/g.gif")));
        
        MovTanque.setByX(-100f);
        MovTanque.setCycleCount((int) 2f);
        MovTanque.setAutoReverse(true);
        MovTanque.play();  
    }
    
}
