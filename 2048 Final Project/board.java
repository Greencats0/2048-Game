import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;
/**
 * Write a description of class board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class board extends World
{
    public int[][]gameboard=new int[4][4];
    public boolean hasStarted=false;
    public boolean hasMoved=false;
    public boolean gamedone=false;
    public boolean hasContinued = false;
    public boolean haveReachedEnd=false;
    boolean creditsHaveAppeared=false;
    Greenfoot thing=new Greenfoot();
    Credits credits=new Credits();
    Counter score=new Counter("Score:");
    Counter highscore=new Counter("Hi-Score:");
    public int numCombo=0;
    public int highestBlock=0;
    /**
     * Constructor for objects of class board.
     * 
     */
    public board() //creates the grid
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(275, 330, 1);
        createWorld();
    }
    
    public void start()
    {
        if(thing.isKeyDown("enter")){        //if(thing.isKeyDown("enter"))
            removeObjects(getObjects(Beginning.class));
            initialPopulate();
            hasStarted=true;
        }
    }
    public void createWorld(){
        addObject(score,163,248);
        addObject(highscore,163,303);
        addObject(new Beginning(),getWidth()/2,getHeight()/2);
    }
    public void initialPopulate()
    {
        randomSpawn();
        randomSpawn();

    }

    public void act(){
        if(thing.isKeyDown("1")){
            reset();
        }
        if(thing.isKeyDown("2")){
            creditsHaveAppeared=credits.showCredits(creditsHaveAppeared);
            if(creditsHaveAppeared){
                addObject(credits, getWidth()/2,getHeight()/2);
            }
            thing.delay(20);
        }
        if(!hasStarted){
            start();
        }
        else if(!gamedone && !creditsHaveAppeared&&!haveReachedEnd){
            if(hasMoved)
            {
                randomSpawn();
            }
            else{
                if(thing.isKeyDown("left")&&!hasMoved){
                    moveLeft();
                    thing.delay(10);
                }
                if(thing.isKeyDown("right")&&!hasMoved){
                    moveRight();
                    thing.delay(10);
                }
                if(thing.isKeyDown("up")&&!hasMoved){
                    moveUp();
                    thing.delay(10);
                }
                if(thing.isKeyDown("down")&&!hasMoved){
                    moveDown();
                    thing.delay(10);
                }

            }

        }
        else{
            gameOver();
        }
    }

    public int blockGenerator(){
        int blockNum=(int)(Math.random()*1);
        if(blockNum==0){
            return 1;
        }
        else{
            return 2;
        }
    }

    public void moveLeft(){
        if(checkLeft())
        {
            for(int r=0; r<4; r++)
            {
                for(int c=0; c<3; c++)
                {
                    int k=c+1;
                    while(k != 4)
                    {
                        if(gameboard[c][r]==0 && gameboard[k][r] != 0)
                        {
                            gameboard[c][r] = gameboard[k][r];
                            gameboard[k][r] = 0;
                            c++;
                        }
                        k++;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=0; c<3; c++)
                {
                    if(gameboard[c][r]==gameboard[c+1][r] && gameboard[c][r]!=0)
                    {
                        gameboard[c][r]++;
                        gameboard[c+1][r]=0;
                        c++;
                        numCombo++;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=0; c<3; c++)
                {
                    int k=c+1;
                    while(k != 4)
                    {
                        if(gameboard[c][r]==0 && gameboard[k][r] != 0)
                        {
                            gameboard[c][r] = gameboard[k][r];
                            gameboard[k][r] = 0;
                            c++;
                        }
                        k++;
                    }
                }
                hasMoved=true;
            }
        }
    }

    public void moveRight(){
        if(checkRight())
        {
            for(int r=0; r<4; r++)
            {
                for(int c=3; c>0; c--)
                {
                    int k=c-1;
                    while(k != -1)
                    {
                        if(gameboard[c][r]==0 && gameboard[k][r] != 0)
                        {
                            gameboard[c][r] = gameboard[k][r];
                            gameboard[k][r] = 0;
                            c--;
                        }
                        k--;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=3; c>0; c--)
                {
                    if(gameboard[c][r]==gameboard[c-1][r] && gameboard[c][r]!=0)
                    {
                        gameboard[c][r]++;
                        gameboard[c-1][r]=0;
                        c--;
                        numCombo++;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=3; c>0; c--)
                {
                    int k=c-1;
                    while(k != -1)
                    {
                        if(gameboard[c][r]==0 && gameboard[k][r] != 0)
                        {
                            gameboard[c][r] = gameboard[k][r];
                            gameboard[k][r] = 0;
                            c--;
                        }
                        k--;
                    }
                }
                hasMoved=true;
            }
        }
    }

    public void moveDown(){
        if(checkDown())
        {
            for(int r=0; r<4; r++)
            {
                for(int c=3; c>0; c--)
                {
                    int k=c-1;
                    while(k != -1)
                    {
                        if(gameboard[r][c]==0 && gameboard[r][k] != 0)
                        {
                            gameboard[r][c] = gameboard[r][k];
                            gameboard[r][k] = 0;
                            c--;
                        }
                        k--;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=3; c>0; c--)
                {
                    if(gameboard[r][c]==gameboard[r][c-1] && gameboard[r][c]!=0)
                    {
                        gameboard[r][c]++;
                        gameboard[r][c-1]=0;
                        c--;
                        numCombo++;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=3; c>0; c--)
                {
                    int k=c-1;
                    while(k != -1)
                    {
                        if(gameboard[r][c]==0 && gameboard[r][k] != 0)
                        {
                            gameboard[r][c] = gameboard[r][k];
                            gameboard[r][k] = 0;
                            c--;
                        }
                        k--;
                    }
                }
                hasMoved=true;
            }
        }
    }

    public void moveUp(){
        if(checkUp())
        {
            for(int r=0; r<4; r++)
            {
                for(int c=0; c<3; c++)
                {
                    int k=c+1;
                    while(k != 4)
                    {
                        if(gameboard[r][c]==0 && gameboard[r][k] != 0)
                        {
                            gameboard[r][c] = gameboard[r][k];
                            gameboard[r][k] = 0;
                            c++;
                        }
                        k++;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=0; c<3; c++)
                {
                    if(gameboard[r][c]==gameboard[r][c+1] && gameboard[r][c]!=0)
                    {
                        gameboard[r][c]++;
                        gameboard[r][c+1]=0;
                        c++;
                        numCombo++;
                    }
                }
            }
            for(int r=0; r<4; r++)
            {
                for(int c=0; c<3; c++)
                {
                    int k=c+1;
                    while(k != 4)
                    {
                        if(gameboard[r][c]==0 && gameboard[r][k] != 0)
                        {
                            gameboard[r][c] = gameboard[r][k];
                            gameboard[r][k] = 0;
                            c++;
                        }
                        k++;
                    }
                }
                hasMoved=true;
            }
        }
    }

    public void randomSpawn(){

        int c = (int)(Math.random()*4); //random num between 0 and 3
        int r = (int)(Math.random()*4); //random num between 0 and 3
        while(gameboard[r][c]!=0){
            c=(int)(Math.random()*4);
            r = (int)(Math.random()*4);
        }
        int next=blockGenerator();
        gameboard[r][c]=next;
        hasMoved=false;
        redraw();
        scoreUpdatetor();
        if(!isMovePossible()){
            gameOver();
        }
    }
    public void scoreUpdatetor(){
        if(numCombo==0){
            score.add((int)Math.pow(2,highestBlock));
        }
        else if(numCombo==1){
            score.add((int)Math.pow(2,highestBlock)*2);
        }
        else if(numCombo==2){
            score.add((int)Math.pow(2,highestBlock)*3);
        }
        else if(numCombo==3){
            score.add((int)Math.pow(2,highestBlock)*4);
        }
        else if(numCombo==4){
            score.add((int)Math.pow(2,highestBlock)*5);
        }
        else if(numCombo==5){
            score.add((int)Math.pow(2,highestBlock)*6);
        }
        else if(numCombo==6){
            score.add((int)Math.pow(2,highestBlock)*7);
        }
        else if(numCombo==7){
            score.add((int)Math.pow(2,highestBlock)*8);
        }
        else if(numCombo==8){
            score.add((int)Math.pow(2,highestBlock)*9);
        }
        if(score.getValue()>highscore.getValue()){
            highscore.setValue(score.getValue());
        }
        numCombo=0;
    }
    public void redraw()
    {
        removeObjects(getObjects(box.class));
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                if(gameboard[i][j]==1){
                    addObject(new box2(),i*55+28,j*55+28);
                    if(highestBlock<1){
                        highestBlock=1;
                    }
                }
                else if(gameboard[i][j]==2){
                    addObject(new box4(),i*55+28,j*55+28);
                    if(highestBlock<2){
                        highestBlock=2;
                    }
                
                }
                else if(gameboard[i][j]==3){
                    addObject(new box8(),i*55+28,j*55+28);
                    if(highestBlock<3){
                        highestBlock=3;
                    }
                
                }
                else if(gameboard[i][j]==4){
                    addObject(new box16(),i*55+28,j*55+28);
                    if(highestBlock<4){
                        highestBlock=4;
                    }
                }
                else if(gameboard[i][j]==5){
                    addObject(new box32(),i*55+28,j*55+28);
                    if(highestBlock<5){
                        highestBlock=5;
                    }
                }
                else if(gameboard[i][j]==6){
                    addObject(new box64(),i*55+28,j*55+28);
                    if(highestBlock<6){
                        highestBlock=6;
                    }
                }
                else if(gameboard[i][j]==7){
                    addObject(new box128(),i*55+28,j*55+28);
                    if(highestBlock<7){
                        highestBlock=7;
                    }
                }
                else if(gameboard[i][j]==8){
                    addObject(new box256(),i*55+28,j*55+28);
                    if(highestBlock<8){
                        highestBlock=8;
                    }
                }
                else if(gameboard[i][j]==9){
                    addObject(new box512(),i*55+28,j*55+28);
                    if(highestBlock<9){
                        highestBlock=9;
                    }
                }
                else if(gameboard[i][j]==10){
                    addObject(new box1024(),i*55+28,j*55+28);
                    if(highestBlock<10){
                        highestBlock=10;
                    }
                }
                else if(gameboard[i][j]==11){
                    addObject(new box2048(),i*55+28,j*55+28);
                    if(highestBlock<11){
                        highestBlock=11;
                    }
                     if(!hasContinued)
                    {
                        youWin();
                    }
                }
                else if(gameboard[i][j]==12){
                    addObject(new box4096(), i*55+28, j*55+28);
                    
                }
                else if(gameboard[i][j]==13){
                    addObject(new End(),getWidth()/2,getHeight()/2);
                }
            }
        }
    }

    public void youWin()
    {    
        Scoreboard winner = new Scoreboard ("You Win!");
        gamedone = true;
        addObject(winner, getWidth()/2,getHeight()/2);
        if(thing.isKeyDown("3"))
        {
            removeObject(winner);
            gamedone=false;
            hasContinued = true;
        }
        //setBackground("win.bmp");
    }

    public boolean isMovePossible(){
        if(checkLeft()||checkRight()||checkDown()||checkUp()){
            return true;
        }
        return false;
    }

    public boolean checkLeft(){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                
                for(int k=j+1;k<4;k++){
                    if(gameboard[j][i]==0&&gameboard[k][i]==0){
                        if(j!=2){
                            j++;
                        }
                        else{
                            break;
                        }
                    }
                    else if(gameboard[j][i]==0&& gameboard[k][i]!=0){
                        return true;
                    }
                    else if(gameboard[j][i]!=0&&gameboard[k][i]==0){
                        while(k!=4 && gameboard[k][i]==0){
                            k++;
                        }
                        if(k!=4){
                            return true;
                        }
                    }
                    else if(gameboard[j][i]==gameboard[j+1][i]&& gameboard[j][i]!=0){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean checkRight(){
        for(int i=0;i<4;i++){
            for(int j=3;j>0;j--){
                for(int k=j-1;k>=0;k--){
                    if(gameboard[j][i]==0&&gameboard[k][i]==0){
                        if(j!=1){
                            j--;
                        }
                        else{
                            break;
                        }
                    }
                    else if(gameboard[j][i]==0&& gameboard[k][i]!=0){
                        return true;
                    }
                    else if(gameboard[j][i]!=0&&gameboard[k][i]==0){
                        while(k!=-1 && gameboard[k][i]==0){
                            k--;
                        }
                        if(k!=-1){
                            return true;
                        }
                    }
                    else if(gameboard[j][i]==gameboard[j-1][i]&& gameboard[j][i]!=0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkDown(){
        for(int j=0;j<4;j++){
            for(int i=3;i>0;i--){
                
                for(int k=i-1;k>=0;k--){
                    if(gameboard[j][i]==0&&gameboard[j][k]==0){
                        if(i!=1){
                            i--;
                        }
                        else{
                            break;
                        }
                    }
                    else if(gameboard[j][i]==0&& gameboard[j][k]!=0){
                        return true;
                    }
                    else if(gameboard[j][i]!=0&&gameboard[j][k]==0){
                        while(k!=-1 && gameboard[j][k]==0){
                            k--;
                        }
                        if(k!=-1){
                            return true;
                        }
                    }
                    else if(gameboard[j][i]==gameboard[j][i-1]&& gameboard[j][i]!=0){
                        return true;
                    }
                }

            }
        }

        return false;
    }

    public boolean checkUp(){
        for(int j=0;j<4;j++){
            for(int i=0;i<3;i++){
                
                for(int k=i+1;k<4;k++){
                    if(gameboard[j][i]==0&&gameboard[j][k]==0){
                        if(i!=2){
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    else if(gameboard[j][i]==0&& gameboard[j][k]!=0){
                        return true;
                    }
                    else if(gameboard[j][i]!=0&&gameboard[j][k]==0){
                        while(k!=4 && gameboard[j][k]==0){
                            k++;
                        }
                        if(k!=4){
                            return true;
                        }
                    }
                    else if(gameboard[j][i]==gameboard[j][i+1]&& gameboard[j][i]!=0){
                        return true;
                    }
                }

            }
        }

        return false;
    }

    public void gameOver(){
        addObject(new Scoreboard("Game Over",score.getValue(),highscore.getValue()),getWidth()/2,getHeight()/2);
        gamedone=true;
    }

    public void reset(){
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                gameboard[i][j]=0;
            }
        }
        removeObjects(getObjects(null));
        score.setValue(0);
        createWorld();
        hasStarted=false;
        haveReachedEnd=false;
    }

}
