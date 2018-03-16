package game;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
/**
 * 
 * @author Lucas Nunes GS
 */
/**
 * 
 * Classe do personagem.
 */
public class Personagem extends Rectangle {
    
    private int direita = 1;
    private int esquerda = 1;
    Image bala = new Image("ima/tiro.gif");
    
    private int sentido = 1;
  
    ImageView tiro = new ImageView("ima/tiro.gif");
    
    TranslateTransition pulopersonagem = new TranslateTransition(Duration.millis(400),this);
    /**
     * 
     * @param posicaox Definindo a posição do personagem no eixo X.  
     * @param posicaoy  Definindo a posição do personagem no eixo Y.
     * @param width Definindo largura do personagem.
     * @param height Definido altura do personagem.
     */
    Personagem(int posicaox, int posicaoy, int width, int height) {
        this.setX(posicaox);
        this.setY(posicaoy);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(new ImagePattern(new Image("ima/TyraPD.gif")));
        
        pulopersonagem.setByY(-100f);
        pulopersonagem.setCycleCount((int) 2f);
        pulopersonagem.setAutoReverse(true);
        
    }
        /**
         * Método para movimentar o personagem para a direita.
         */
        public void moverD() {
  
        if(getX() < 750) {
            setX(getX()+10);
        switch (direita) {
            case 1:
                this.setFill(new ImagePattern(new Image("ima/tyraCD.gif")));
                this.setY(290);
                break;
            case 2:
                this.setFill(new ImagePattern(new Image("ima/TyraPD.gif")));
                this.setY(290);
                break;
            case 3:
                this.setFill(new ImagePattern(new Image("ima/tyraCD.gif")));
                this.setY(290);
                break;
            case 4:
                this.setFill(new ImagePattern(new Image("ima/TyraPD.gif")));
                this.setY(290);
                direita = 0;
                break;
        }
        
        direita++;
        }}
        /**
         * Método para movimentar personagem a esquerda.
         */
        public void moverE(){
        if (getX() > 0) {
            setX(getX()-10);
        switch (esquerda) {
            case 1:
                this.setFill(new ImagePattern(new Image("ima/turaCE.gif")));
                this.setY(290);
                break;
            case 2:
                this.setFill(new ImagePattern(new Image("ima/TyraPE.gif")));
                this.setY(290);
                break;
            case 3:
                this.setFill(new ImagePattern(new Image("ima/turaCE.gif")));
                this.setY(290);
                break;
            case 4:
                this.setFill(new ImagePattern(new Image("ima/TyraPE.gif")));
                this.setY(290);
                esquerda = 0;
                break;
        }
        
        esquerda++;
    }}
        /**
         * Método para fazer o personagem se agachar.
         */
        public void Baixo(){
           this.setY(300);
           this.setWidth(70);
           this.setHeight(70);
           this.setFill(new ImagePattern(new Image("ima/TyraAgachada.gif"))); 
        }
        /**
         * Método para o pulo do personagem.
         */
        public void Cima(){
           this.setFill(new ImagePattern(new Image("ima/TyraSalto.gif"))); 
           pulopersonagem.play();         
        }
}
