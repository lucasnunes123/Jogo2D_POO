/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Lucas Nunes GS
 */
public class Tiro{
    ImageView tiro = new ImageView("ima/tiro.gif");
    TranslateTransition acaotiro = new TranslateTransition(Duration.millis(400),tiro);
            
   public Tiro(){
       
    }
   public void atirar(double posicao_inimigo,double posicaoP,Pane root){
       tiro.setScaleX(0.1);
       tiro.setScaleY(0.1);
       root.getChildren().add(tiro);
       tiro.setX(posicaoP);
       tiro.setY(265);
       acaotiro.setByX(posicao_inimigo);
       acaotiro.setCycleCount((int) 2f);
       acaotiro.setAutoReverse(true);
       acaotiro.play();
       Timeline acao = new Timeline(new KeyFrame(Duration.millis(400), lamb -> root.getChildren().removeAll(tiro)));
       acao.play();
   }
}
