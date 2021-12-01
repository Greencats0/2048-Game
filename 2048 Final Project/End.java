import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends Actor
{
    /**
     * Act - do whatever the End wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public End(){
        spawnResetBoard();
    }
    public void spawnResetBoard(){
        GreenfootImage reset = new GreenfootImage(200,50);
        reset.setColor(new greenfoot.Color(0,0,0,160));
        reset.fillRect(0,0,200,50);
        reset.setColor(new greenfoot.Color(255,255,255,100));
        reset.fillRect(5,5,190,40);
        greenfoot.Font font = reset.getFont();
        font = font.deriveFont(18.0f);
        reset.setFont(font);
        reset.setColor(greenfoot.Color.WHITE);
        reset.drawString("Press 1 to RESET ",10,20);
        setImage(reset);
    }
}
