import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Actor
{
    public static final int height = 200;
    public static final int width = 200;
    public static final float fontsize = 18.0f;
    public Credits()
    {    
    }

    public boolean showCredits(boolean check)
    {
        if(check)
        {
            getWorld().removeObject(this);
            return false;
        }
        else
        {
            GreenfootImage end = new GreenfootImage(width, height); //begin "part 1"
            end.setColor(new Color(0,0,0,160));
            end.fillRect(0,0,width,height);
            end.setColor(new Color(255,255,255,100));
            end.fillRect(5,5,width-10,height-10);
            Font font = end.getFont();
            font = font.deriveFont(fontsize);
            end.setFont(font);
            end.setColor(Color.WHITE);
            end.drawString("CREDITS ",60,40);
            end.drawString("Created by: ",25,70);
            end.drawString("Gen Akamatsu", 25, 100);
            end.drawString("Kevin Iwamoto", 20, 130);
            end.drawString("Marjorie Wang", 25, 160);
            setImage(end);
            return true;
        }
    }
}
