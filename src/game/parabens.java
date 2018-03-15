/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class parabens extends Scene {
    private final Image gameover = new Image("ima/parabens.png");
    public parabens(Pane root, double width, double height) {
        super(root, width, height);
       
        ImageView vitoria = new ImageView(gameover);
        vitoria.setScaleX(1);
        vitoria.setScaleY(1);
        
        root.getChildren().addAll(vitoria);
    }
    
}
