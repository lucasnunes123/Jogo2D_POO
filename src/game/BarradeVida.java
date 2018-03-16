package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Lucas Nunes GS
 */

/**
 * 
 *  Classe para a barra de vida do personagem.
 */
public class BarradeVida extends Rectangle {
        public BarradeVida(){
            this.setX(26);
            this.setY(30);                 //Configurações da barra de vida
            this.setWidth(250);
            this.setHeight(25);
            this.setFill(Color.GREEN);
	     
}}