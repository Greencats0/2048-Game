import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;
/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    public static final int height = 200;
    public static final int width = 200;
    public static final float fontsize = 18.0f;
    public Scoreboard(){
    }
    public Scoreboard (String title)
    {
        createWinBoard(title);
    }
    public Scoreboard(String title, int score, int hiscore)
    {
        makeScore(title, "Your score:", score, hiscore);
    }
    
    public void createWinBoard(String title)
    {
        GreenfootImage end = new GreenfootImage(width, height); //begin "part 1"
        end.setColor(new greenfoot.Color(0,0,0,160));
        end.fillRect(0,0,width,height);
        end.setColor(new greenfoot.Color(255,255,255,100));
        end.fillRect(5,5,width-10,height-10);
        greenfoot.Font font = end.getFont();
        font = font.deriveFont(fontsize);
        end.setFont(font);
        end.setColor(greenfoot.Color.WHITE); //end "part 1"
        end.drawString(title,60,40);
        end.drawString("Press 3 to CONTINUE", 10, 80);

        setImage(end);
    }
    
    public void makeScore(String title, String header, int score, int hiscore)
    {
        GreenfootImage end = new GreenfootImage(width, height); //begin "part 1"
        end.setColor(new greenfoot.Color(0,0,0,160));
        end.fillRect(0,0,width,height);
        end.setColor(new greenfoot.Color(255,255,255,100));
        end.fillRect(5,5,width-10,height-10);
        greenfoot.Font font = end.getFont();
        font = font.deriveFont(fontsize);
        end.setFont(font);
        end.setColor(greenfoot.Color.WHITE); //end "part 1"
        end.drawString(title,60,30);
        end.drawString(header+score,25,60);
        end.drawString("Hi-score: " + hiscore,25,90);
        end.drawString("Press 1 to RESET", 25,120);
        end.drawString("or", 25,150);
        end.drawString("Press 2 for CREDITS",25,180);
        setImage(end);
    }
}
