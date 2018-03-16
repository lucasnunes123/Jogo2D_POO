package game;

import game.BarradeVida;
import game.BarradeVida;
import game.Inimigo;
import game.Inimigo;
import game.Menu;
import game.Menu;
import game.Personagem;
import game.Personagem;
import game.Tiro;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
/**
 * 
 * @author Lucas Nunes GS
 */
/**
 * 
 * Classe 1°fase.
 */
public class syberian1 extends Scene{
    /**
     *  Variáveis para contar vida do personagem e dos soldados
    */
    int countvida = 140;
    int countvidainimigo = 100;
    int contvidaini = 100;
    /**
     *  Labels "Syberian","Life","Inimigo".
     */
    Label Vida = new Label();
    Label LabelFase = new Label();
    Label nomei = new Label();
    
    double LarguraBvida = 250,LarguraBinimigo = 250;
    
    Tiro tiro = new Tiro();
    
    
    private final Image syberian = new Image("ima/Syberian.png");   
    private final Image bala = new Image("ima/tiro.gif");
    
    
    Personagem tyra = new Personagem(25,290,70, 70);
    Inimigo soldado = new Inimigo(25,290,70,70);          //instânciando personagens
    Inimigo soldado2 = new Inimigo(25,290,70,70);
    
    Rectangle contornoinimigo = new Rectangle(); // contorno barra vida inimigo
    Rectangle contornoLife = new Rectangle();//contorno barra vida Tyra
    Rectangle Barravidainimigo = new Rectangle();//Barra inimigo
    BarradeVida lifeBarra = new BarradeVida();//Barra vida Tyra
    /**
     * 
     * @param root Nó raiz de tela. 
     * @param width definindo largura da tela de 1°fase.
     * @param height definindo altura da tela de 1°fase.
     */
    private Pane root;
    public syberian1(Pane root, double width, double height) {
        super(root, width, height);
        this.root = root;
        ImageView fundo1 = new ImageView(syberian);
        fundo1.setScaleX(2);                                 //Configurações da imagem de fundo
        fundo1.setScaleY(1.22);
        
        Font vida = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 30);
        Vida = new Label("Life");
        Vida.setTextFill(Color.WHITE);
	Vida.setLayoutX(29);                 //configurações Label "Life"  
	Vida.setLayoutY(28);
	Vida.setFont(vida);  
        
        
        nomei = new Label("Inimigo");
        nomei.setTextFill(Color.WHITE);
	nomei.setLayoutX(500);               //configurações Label "Inimigo"    
	nomei.setLayoutY(28);
	nomei.setFont(vida);
        
        Barravidainimigo.setX(500);
        Barravidainimigo.setY(27.5);
        Barravidainimigo.setWidth(200);     //Config. Barra Inimigo
        Barravidainimigo.setHeight(30.4);
        Barravidainimigo.setFill(Color.RED);
        
        contornoinimigo.setX(496);
        contornoinimigo.setY(25);
        contornoinimigo.setWidth(210);   // Config. contorno barra inimigo
        contornoinimigo.setHeight(35);
        contornoinimigo.setFill(Color.WHITE);
       
        contornoLife.setX(24);
        contornoLife.setY(27.5);
        contornoLife.setWidth(255);
        contornoLife.setHeight(30.4);     //Config. contorno barra Life
        contornoLife.setFill(Color.WHITE);
        
        LabelFase = new Label("SYBERIAN");
        LabelFase.setTextFill(Color.WHITE);
	LabelFase.setLayoutX(26);             //Config.Label Fase
	LabelFase.setLayoutY(60);              
	LabelFase.setFont(vida);
       
        root.getChildren().addAll(fundo1,tyra,contornoLife,contornoinimigo,lifeBarra,Barravidainimigo,Vida,soldado,LabelFase,nomei,soldado2);
                      
    }
    /**
     *  Método para a largura da barra de vida do personagem e do inimigo.
     */
    public void Danotyra(){
          boolean status = tyra.getBoundsInLocal().intersects(soldado.getBoundsInLocal());
          if(status == true){
            LarguraBvida = LarguraBvida - 5;
            lifeBarra.setWidth(lifeBarra.getWidth()-10);  //diminuindo barra ao receber dano
            
            LarguraBinimigo = LarguraBinimigo - 15;
            Barravidainimigo.setWidth(Barravidainimigo.getWidth()-20); //diminuindo vida
    }
    }
    /**
     *  Método para contar a vida do personagem.
     */
    public void countvida(){
        boolean status = tyra.getBoundsInLocal().intersects(soldado.getBoundsInLocal());
         if(status == true){
            countvida = countvida - 5;
            
            countvidainimigo = countvidainimigo - 10;
     }       
    }
    /**
     * Método para contar vida do inimigo.
     */
    public void Danoslo2(){
        boolean status = tyra.getBoundsInLocal().intersects(soldado2.getBoundsInLocal());
        if(status == true){
           countvida = countvida - 6;
            
           contvidaini = contvidaini - 10; 
        }
    }
    public void danoInimigo(){
        countvidainimigo -= 10;
        Barravidainimigo.setWidth(Barravidainimigo.getWidth()-20);
    }

    public Personagem getTyra() {
        return tyra;
    }

    public Inimigo getSoldado() {
        return soldado;
    }

    public Tiro getTiro() {
        return tiro;
    }

    public Pane getRoot2() {
        return root;
    }
     
    }
