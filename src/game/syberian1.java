package game;

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

public class syberian1 extends Scene{
    int countvida = 140;
    int countvidainimigo = 100;         //Contadores de vida
    int contvidaini = 100;
    
    Label Vida = new Label();
    Label nomeF = new Label();   //Labal "Life","nome da Fase","nome inimigo"
    Label nomei = new Label();
    
    double LarguraBvida = 250,LarguraBinimigo = 250; //Larguras das barras de vida
    
    private final Image syberian = new Image("ima/Syberian.png");   
    private final Image bala = new Image("ima/tiro.gif");
    
    ImageView tiro = new ImageView(bala);
    TranslateTransition fire = new TranslateTransition(Duration.millis(1700),tiro);
    
    
    Personagem tyra = new Personagem(25,290,70, 70);
    Inimigo soldado = new Inimigo(25,290,70,70);          //instânciando personagens
    Inimigo soldado2 = new Inimigo(25,290,70,70);
    
    Rectangle contornoinimigo = new Rectangle(); // contorno barra vida inimigo
    Rectangle contornoLife = new Rectangle();//contorno barra vida Tyra
    Rectangle Barravidainimigo = new Rectangle();//Barra inimigo
    BarradeVida lifeBarra = new BarradeVida();//Barra vida Tyra
    
    public syberian1(Pane root, double width, double height) {
        super(root, width, height);
        ImageView fundo1 = new ImageView(syberian);
        fundo1.setScaleX(2);                                 //Configurações da imagem de fundo
        fundo1.setScaleY(1.22);
        
        Font vida = Font.loadFont(Menu.class.getResource("/ima/upheavtt.ttf").toExternalForm(), 30);
        Vida = new Label("Life");
        Vida.setTextFill(Color.WHITE);
	Vida.setLayoutX(29);                 //configurações Label "Life"  
	Vida.setLayoutY(28);
	Vida.setFont(vida);  
        
        tiro.setX(25);
        tiro.setY(320);
        tiro.setFitHeight(4);
        tiro.setFitWidth(30);
        tiro.setImage(bala);
        
        fire.setByX(25);
        fire.setByX(1000);
        fire.setCycleCount((int) 6f);
        fire.setAutoReverse(true);
        
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
        
        nomeF = new Label("SYBERIAN");
        nomeF.setTextFill(Color.WHITE);
	nomeF.setLayoutX(26);             //Config.Label Fase
	nomeF.setLayoutY(60);              
	nomeF.setFont(vida);
       
        root.getChildren().addAll(fundo1,tyra,contornoLife,contornoinimigo,lifeBarra,Barravidainimigo,Vida,soldado,nomeF,nomei,soldado2);
                      
    }
    public void Danotyra(){
          boolean status = tyra.getBoundsInLocal().intersects(soldado.getBoundsInLocal());
          if(status == true){
            LarguraBvida = LarguraBvida - 5;
            lifeBarra.setWidth(lifeBarra.getWidth()-10);  //diminuindo barra ao receber dano
            
            LarguraBinimigo = LarguraBinimigo - 15;
            Barravidainimigo.setWidth(Barravidainimigo.getWidth()-20); //diminuindo vida
    }
    }public void countvida(){
        boolean status = tyra.getBoundsInLocal().intersects(soldado.getBoundsInLocal());
         if(status == true){
            countvida = countvida - 5;
            
            countvidainimigo = countvidainimigo - 10;
     }       
    }public void Danoslo2(){
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
    }
