package game;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * 
 * @author Lucas Nunes GS
 */

/**
 * 
 * Tela de Game over.
 */
public class GameOver extends Scene{
    private final Image gameover = new Image("ima/gameover.png");
    Label Capar_the_cat, Voltaraomenu;
    /**
     * 
     * @param root Nó raiz.
     * @param width definição de largura da tela de Game Over.
     * @param height definição de altura da tela de Game Over.
     */
    public GameOver(Pane root, double width, double height) {
        super(root, 800, 400);
        ImageView fundo2 = new ImageView(gameover);
        fundo2.setScaleX(1);
        fundo2.setScaleY(1);
        
        Font vida = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 30);
        
        Capar_the_cat = new Label("Aperte ESC para Fechar");
        Capar_the_cat.setTextFill(Color.WHITE);
	Capar_the_cat.setLayoutX(230);        
	Capar_the_cat.setLayoutY(350);
	Capar_the_cat.setFont(vida);
        
        Voltaraomenu = new Label("Aperte ENTER para voltar ao menu");
        Voltaraomenu.setTextFill(Color.WHITE);
        Voltaraomenu.setLayoutX(150);
        Voltaraomenu.setLayoutY(320);
        Voltaraomenu.setFont(vida);
        root.getChildren().addAll(fundo2,Capar_the_cat,Voltaraomenu);
    }   
    
}
