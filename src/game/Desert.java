package game;

import game.BarradeVida;
import game.Menu;
import game.Personagem;
import game.Tangue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
/**
 *
 * @author Lucas Nunes GS
 */
/**
 * 
 * Classe da 2° fase. 
 */
public class Desert extends Scene {
    int countvida = 130;
    int countinimigo = 140;          //contadores de vida
    
    Tiro tiro = new Tiro();
    
    Label Vida = new Label();
    Label nomeF = new Label();
    Label nomei = new Label();      //Labels
    
    double Lvida = 250,Lini = 250;
    private final Image syberian = new Image("ima/original_1.png");         //Tela de fundo
   
    Personagem tyra = new Personagem(25,290,70, 70);
    Tangue soldado = new Tangue(25,290,70,70);
    
    Rectangle contornoinimigo = new Rectangle();
    Rectangle contornoLife = new Rectangle();
    Rectangle Bini = new Rectangle();
    BarradeVida life = new BarradeVida();
    /**
     * 
     * @param root Nó raiz.
     * @param width definido largura da tela de 2°fase.
     * @param height defindo altura da tela de 2°fase.
     */
    private Pane root;
    public Desert(Pane root, double width, double height) {
        super(root, width, height);
        this.root = root;
        ImageView fundo1 = new ImageView(syberian);
        fundo1.setScaleX(2);
        fundo1.setScaleY(1.22);
        
        Font vida = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 30);
        Vida = new Label("Life");
        Vida.setTextFill(Color.WHITE);
	Vida.setLayoutX(29);           
	Vida.setLayoutY(28);
	Vida.setFont(vida);  
        
        nomei = new Label("Inimigo");
        nomei.setTextFill(Color.WHITE);
	nomei.setLayoutX(500);             
	nomei.setLayoutY(28);
	nomei.setFont(vida);
        
        
        Bini.setX(500);
        Bini.setY(27.5);
        Bini.setWidth(200);
        Bini.setHeight(30.4);
        Bini.setFill(Color.RED);
        
        contornoinimigo.setX(496);
        contornoinimigo.setY(25);
        contornoinimigo.setWidth(210);
        contornoinimigo.setHeight(35);
        contornoinimigo.setFill(Color.WHITE);
       
        contornoLife.setX(24);
        contornoLife.setY(27.5);
        contornoLife.setWidth(255);
        contornoLife.setHeight(30.4);
        contornoLife.setFill(Color.WHITE);
        
        nomeF = new Label("DESERT");
        nomeF.setTextFill(Color.WHITE);
	nomeF.setLayoutX(26);             
	nomeF.setLayoutY(60);
	nomeF.setFont(vida);
       
        root.getChildren().addAll(fundo1,tyra,contornoLife,contornoinimigo,life,Bini,Vida,soldado,nomeF,nomei);
        if(countinimigo == 0){
           root.getChildren().remove(soldado);
        }   
            
    }
    /**
     * Método para contar tamanho da barra de vida do personagem e inimigo.
     */
    public void Danotyra(){
          boolean status = tyra.getBoundsInLocal().intersects(soldado.getBoundsInLocal());
          if(status == true){
            Lvida = Lvida - 5;
            life.setWidth(life.getWidth()-10);
            
            Lini = Lini - 15;
            Bini.setWidth(Bini.getWidth()-10);
    }
    }
    /**
     * Método para contador de vida do personagem e do inimigo.
     */
    public void countvida(){
        boolean status = tyra.getBoundsInLocal().intersects(soldado.getBoundsInLocal());
         if(status == true){
            countvida = countvida - 5;
            
            countinimigo = countinimigo - 7;
            }
            
    }
    public Personagem getTyra() {
        return tyra;
    }

    public Tangue getSoldado() {
        return soldado;
    }

    public Tiro getTiro() {
        return tiro;
    }

    public Pane getRoot2() {
        return root;
    }
    
}
