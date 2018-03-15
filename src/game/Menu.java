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
public class Menu extends Scene{
    
    private final Image fundo = new Image("ima/menu.png");
    private final Label enter, esc;
    public Menu(Pane root, double width, double height) {
        super(root, width, height);
        
        ImageView fundo1 = new ImageView(fundo);
        fundo1.setScaleX(1.2);
        fundo1.setScaleY(1.2);
        
        Font fonte = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 30);
        
        esc = new Label("ESC para sair");
        esc.setTextFill(Color.RED);
	esc.setLayoutX(250);
	esc.setLayoutY(330);
	esc.setFont(fonte);
        
        enter = new Label("Enter para começar");
        enter.setTextFill(Color.RED);
	enter.setLayoutX(250);
	enter.setLayoutY(290);
	enter.setFont(fonte);
        
        root.getChildren().add(fundo1);
        root.getChildren().add(enter);
        root.getChildren().add(esc);
        
    }
}
