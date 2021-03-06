package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
/**
 * 
 * @author Lucas Nunes GS
 */
/**
 * 
 * Classe do inimigo 1°fase.
 */
public class Inimigo extends Rectangle {
    
    public Personagem inimigo;
    private int direita = 1;
    private int esquerda = 1;
    
    /**
     * 
     * @param posicaox Definição da posição do inimigo no eixo X.
     * @param posicaoy Definição da posição do inimigo no eixo Y.
     * @param width Definição da largura do inimigo.
     * @param height Definição da altura do inimigo.
     */
    Inimigo(int posicaox, int posicaoy, int width, int height) {
        this.setX(500);
        this.setY(posicaoy);
        this.setWidth(80);
        this.setHeight(80);
        this.setFill(new ImagePattern(new Image("ima/soldado.gif")));
    }
        /**
         *   Médoto para mover inimigo para a direita.
         */
        public void moverD1() {
  
        if(getX() < 750) {
            setX(getX()-5);
        switch (direita) {
            case 1:
                this.setFill(new ImagePattern(new Image("ima/s1.gif")));
                this.setY(290);
                break;
            case 2:
                this.setFill(new ImagePattern(new Image("ima/s2.gif")));
                this.setY(290);
                break;
            case 3:
                this.setFill(new ImagePattern(new Image("ima/s3.gif")));
                this.setY(290);
                break;
            case 4:
                this.setFill(new ImagePattern(new Image("ima/s4.gif")));
                this.setY(290);
                direita = 0;
                break;
        }
        
        direita++;
        }}
        
    
    }
    

