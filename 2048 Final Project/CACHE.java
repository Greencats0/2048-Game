//this class does nothing
/*



Store all methods here in case of future use and stuff.


[BOARD CLASS]
    public void moveLeft(){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                int k=j+1;
                while(k!=4 && gameboard[i][k]==0){
                    k++;
                }
                if(k!=4){
                    gameboard[i][j]=gameboard[i][k];
                    gameboard[i][k]=0;
                }
                j=k;
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(gameboard[i][j]==gameboard[i][j+1]&&gameboard[i][j]!=0){
                    gameboard[i][j]++;
                    gameboard[i][j+1]=0;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                int k=j+1;
                while(k!=4 && gameboard[i][k]==0){
                    k++;
                }
                if(k!=4){
                    gameboard[i][j]=gameboard[i][k];
                    gameboard[i][k]=0;
                }
                j=k;
            }
        }
        hasMoved=true;
    }
    
    public int setCoord1R() //sets row coordinate for first initial tile
    {
    int coord1R = (int)(Math.random()*3); //random num between 0 and 3
    return coord1R;
    }
    public int setCoord1C() //sets column coordinate for first initial tile
    {
    int coord1C = (int)(Math.random()*3); //random num between 0 and 3
    return coord1C;
    }
    public int setCoord2R() //sets row coordinate for second initial tile
    {
    int coord2R = (int)(Math.random()*3); //random num between 0 and 3
    return coord2R;
    }
    public int setCoord2C() //sets column coordinate for second initial tile
    {
    int coord2C = (int)(Math.random()*3); //random num between 0 and 3

    return coord2C;
    }
    
    
    
    
    
    
    
    */