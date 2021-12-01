import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * Write a description of class Beginning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beginning extends Actor
{
    /**
     * Act - do whatever the Beginning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }

    public Beginning(){
        makeStatement();
    }

    public void makeStatement(){
        GreenfootImage enter = new GreenfootImage(200,50);
        enter.setColor(new greenfoot.Color(0,0,0,160));
        enter.fillRect(0,0,200,50);
        enter.setColor(new greenfoot.Color(255,255,255,100));
        enter.fillRect(5,5,190,40);
        greenfoot.Font font = enter.getFont();
        font = font.deriveFont(18.0f);
        enter.setFont(font);
        enter.setColor(greenfoot.Color.WHITE);
        enter.drawString("Press ENTER to Start ",10,20);
        setImage(enter);
    }
}
