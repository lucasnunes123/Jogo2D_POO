package game;

import javafx.scene.Parent;
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
 * Classe Tela de pause.
 */
public class Pause extends Scene {
    private final Image fundopause = new Image("ima/gover.png");
    Label Label_pause,label_continue,label_sair;
    
    Font fontepause = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 50);
    Font fonte = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 30);

    /**
     * 
     * @param root Nó raiz.
     * @param width Definindo largura na tela de pause.
     * @param height Definido altura na tela de pause.
     */
    public Pause(Pane root, double width, double height) {
        super(root, 800, 400);
        ImageView fundo = new ImageView(fundopause);
        fundo.setScaleX(1);
        fundo.setScaleY(1);
        
        Label_pause = new Label("PAUSE");
        Label_pause.setTextFill(Color.WHITE);
	Label_pause.setLayoutX(330);        
	Label_pause.setLayoutY(30);
	Label_pause.setFont(fontepause);
        
        label_continue = new Label("Espaço - continuar");
        label_continue.setTextFill(Color.WHITE);
        label_continue.setLayoutX(260);
        label_continue.setLayoutY(150);
        label_continue.setFont(fonte);
        
        label_sair = new Label("S - sair do jogo");
        label_sair.setTextFill(Color.WHITE);
        label_sair.setLayoutX(260);
        label_sair.setLayoutY(220);
        label_sair.setFont(fonte);
        
        
      root.getChildren().addAll(fundo,Label_pause,label_continue,label_sair);  
    }
    
}
