package game;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Nunes GS
 */
/**
 * 
 *  Classe MAIN do jogo.
 */
public class Game extends Application {
    private final int posX = 25;
    private final int posY = 290;
    
    /**
     *  Adicionando Audio menu,gameover,1° e 2° fase.
     */   
    AudioClip MMenu = new AudioClip(getClass().getResource("/audio/menu.mp3").toString());              
    AudioClip MFase1 = new AudioClip(getClass().getResource("/audio/fase1.mp3").toString());            
    AudioClip MFase2 = new AudioClip(getClass().getResource("/audio/Fase2.mp3").toString());            
    AudioClip Gover = new AudioClip(getClass().getResource("/audio/gameovernaruto.mp3").toString());
    AudioClip Mvitoria = new AudioClip(getClass().getResource("/audio/climaMusic.mp3").toString());
    
    @Override
    public void start(Stage primaryStage) {
        /**
         *  Tela Menu e adicionando a primeira tela.
         */
        Pane rootMenu = new Pane();  
        Menu menu = new Menu(rootMenu, 800, 400);
        primaryStage.setScene(menu);
        MMenu.play();
        /**
         *  Tela 1°fase.
         */
        Pane rootmetal = new Pane();
        syberian1 metal = new syberian1(rootmetal, 800, 400);
        /**
         *  Tela GameOver.
         */
        Pane rootgame = new Pane();
        GameOver over = new GameOver(rootgame, 800, 400);
        /**
         *  Tela 2°Fase.
         */
        Pane root2 = new Pane();
        Desert deserto = new Desert(root2, 800, 400);
        /**
         *  Tela de Vitoria.
         */
        Pane rootG = new Pane();
        parabens Parabens = new parabens(rootG, 800, 400);
        /**
         *  Tela de Pause.
         */
        Pane rootpause = new Pane();
        Pause pause = new Pause(rootpause, 800, 400);
        
        /**
        *   Chamando menu,ao clicar ENTER será direcionado a tela da 1° fase.
        *   Ao clicar em ESC o jogo será fechado.
        */
        menu.setOnKeyPressed((KeyEvent event)-> {
            if(event.getCode().equals(KeyCode.ENTER)){
                primaryStage.setScene(metal);               //Chamando 1°FASE
                MMenu.stop();
                MFase1.play();
            }if(event.getCode().equals(KeyCode.ESCAPE)){
                primaryStage.close();
            }  
        });   
        primaryStage.setResizable(false);
        primaryStage.setTitle("Metal Chucrute");
        primaryStage.show();
 
        /**
         *  Capturando Eventos de tecla para a movimentação do personagem,contando dano do Personagem e inimigos.
         *  chamando telas de 2°fase e de game over.
         */
        metal.setOnKeyPressed((KeyEvent event) -> {
            metal.Danotyra();
            metal.countvida();
            metal.Danoslo2();
            
            if(metal.countvida == 0){
                primaryStage.setScene(over);
                MFase1.stop();
                Gover.play();
            }if(metal.countvidainimigo == 0){
                rootmetal.getChildren().remove(metal.soldado);                   
            }if(metal.contvidaini == 0){
                MFase1.stop();
                MFase2.play();
                primaryStage.setScene(deserto);
            }
            
            /**
             *  tela de game over com eventos das treclas ENTER e ESC.
             */
            over.setOnKeyPressed((KeyEvent event1) -> {
                if(event1.getCode().equals(KeyCode.ESCAPE)){
                    primaryStage.close();                 
                }if(event1.getCode().equals(KeyCode.ENTER)){
                    Gover.stop();
                    
                    primaryStage.setScene(menu);
                    metal.countvida = 140;
                    metal.lifeBarra.setWidth(250);                //colocando os dados iniciais de Tyra
                    metal.tyra.setX(posX);
                    metal.tyra.setY(posY);
                    
                    metal.soldado.setX(500);                      //colocando os dados iniciais do 1° Soldado
                    metal.countvidainimigo = 100;
                    metal.Barravidainimigo.setWidth(200);
                    rootmetal.getChildren().add(metal.soldado);
                    
                    metal.contvidaini = 100;                      //colocando os dados iniciais do 2° Soldado
                }                    
            });
          
            if(event.getCode().equals(KeyCode.RIGHT)) {
                metal.tyra.moverD();
                metal.soldado.moverD1();
            }
            if(event.getCode().equals(KeyCode.LEFT)) {
                metal.tyra.moverE();   
            }
            if(event.getCode().equals(KeyCode.UP)) {
                
                metal.tyra.Cima();
            }
            if(event.getCode().equals(KeyCode.DOWN)) { 
                metal.tyra.Baixo();
            }
            if(event.getCode().equals(KeyCode.ESCAPE)){
                primaryStage.setScene(menu);
            }if(event.getCode().equals(KeyCode.SPACE)){
                primaryStage.setScene(pause);  
            }if(event.getCode().equals(KeyCode.SHIFT)){
                System.out.println("wendel morreu!");
                metal.getTiro().atirar(metal.getSoldado().getX(), metal.getTyra().getX(), metal.getRoot2());
                
            }
            
        });
        /**
         *  tela de pause com eventos de tecla SPACE para pausar o jogo e da tecla S para fechar o jogo..
         */
        pause.setOnKeyPressed((KeyEvent event) -> {
              if(event.getCode().equals(KeyCode.SPACE)){
                 primaryStage.setScene(metal);
            }if(event.getCode().equals(KeyCode.S)){
                 primaryStage.close();
            }    
        });
        /**
         *  Tela de 2° fase com eventos de tecla de movimento e tela de Vitória.
         */
        deserto.setOnKeyPressed((KeyEvent event) -> {
            Gover.stop();
            deserto.Danotyra();
            deserto.countvida();
 
            if(deserto.countvida == 0){
                primaryStage.setScene(over);
                MFase2.stop();
                Gover.play();
            }if(deserto.countinimigo <= 0){
                MFase2.stop();
                primaryStage.setScene(Parabens);
            }
            if(event.getCode().equals(KeyCode.RIGHT)) {
                deserto.tyra.moverD();
            }
            if(event.getCode().equals(KeyCode.LEFT)) {
                deserto.tyra.moverE();   
            }
            if(event.getCode().equals(KeyCode.UP)) {
                
                deserto.tyra.Cima();
            }
            if(event.getCode().equals(KeyCode.DOWN)) { 
                deserto.tyra.Baixo();
            }if(event.getCode().equals(KeyCode.SHIFT)){
                System.out.println("wendel morreu!");
                metal.getTiro().atirar(deserto.getSoldado().getX(), deserto.getTyra().getX(), deserto.getRoot2());
                
            }
        });    
    }
    public static void main(String[] args) {
        launch(args);
    }    
}