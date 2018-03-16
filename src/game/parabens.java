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
/**
 * 
 * @author Lucas Nunes GS
 */
/**
 * 
 * Classe tela Vitória.
 */
public class parabens extends Scene {
    private final Image gameover = new Image("ima/parabens.png");
    /**
     * 
     * @param root Nó raiz.
     * @param width Definição da largura da tela de vitória.
     * @param height Definição da altura da tela de vitória. 
     */
    public parabens(Pane root, double width, double height) {
        super(root, width, height);
       
        ImageView vitoria = new ImageView(gameover);
        vitoria.setScaleX(1);
        vitoria.setScaleY(1);
        
        root.getChildren().addAll(vitoria);
    }
    
}
