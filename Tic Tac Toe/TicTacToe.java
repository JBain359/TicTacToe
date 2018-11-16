import java.applet.Applet;
import java.awt.*;

public class TicTacToe extends Applet {
  
  TicTacToeSquare [] hashtag = new TicTacToeSquare[9];
  int boxClicked;
  int turn;
  String XO;
  int tied;
  String winner;
  int movedX ;
  int movedY;
  int debug  ;
  public void init()
  {
    movedX = 0;
    movedY = 0;
    winner = "";
    XO = "";
    turn = 1;
    boxClicked=0;
    tied = 0;
    for(int i = 0; i<hashtag.length; i++)
    {
      int xPos = (i%3);
      int yPos = i/3;
      hashtag[i] = new TicTacToeSquare(xPos*100,yPos*100,90,90);
      
    }
  }
    
  public void paint(Graphics g) 
  {
    Expo.setColor(g,Expo.black);
    Expo.fillRectangle(g,0,0,280,280);
    
    for(int i = 0; i<hashtag.length; i++)
    {
      
      
      hashtag[i].drawTic(g);
    }
    
    
    
    
    
    if(!winner.equals(""))
    {
      Expo.setFont(g,"Arial",Font.BOLD,20);
      Expo.drawString(g,"Winner is: "+winner,0,400);
      Expo.drawString(g,"click twice to play again ",0,500); 
    }
    else
    {
	    	if(turn == 1)
	    {
	    	Expo.setFont(g,"Arial",Font.BOLD,20);
	    	Expo.drawString(g,"Player O's turn",0,350);
	    }
	    else
	    {
	    	Expo.setFont(g,"Arial",Font.BOLD,20);
	    	Expo.drawString(g,"Player X's turn",0,350);
	    }
    }
    
    if(tied==9 && winner.equals(""))
    {
      Expo.setFont(g,"Arial",Font.BOLD,20);
      Expo.drawString(g,"STALEMATE",0,400);
      Expo.drawString(g,"click twice to play again ",0,500);
    }
    
    
  }
    
    
    
  public boolean mouseDown(Event e, int x, int y)
  {
    
    if(!winner.equals("")||tied==9)
    {
      init();
    }
    else 
    { 
      boxClicked=0;
      for(int c = 0; c<hashtag.length; c++)
      {
        
        if(hashtag[c].inside(x,y))
        {
          boxClicked = c+1;
          
          if(hashtag[c].mark=="")
          {
            turn *= -1 ;
            if(turn == 1){XO="X";}
            if(turn == -1){XO="O";}
            hashtag[c].setMark(XO);
          }
        }

      }
      checkAdjacent(hashtag) ;
      repaint();
    }
    return true;
  }
    
  public void checkAdjacent(TicTacToeSquare [] T)
  {
    tied = 0;
    for(int i = 0;i<T.length;i++)
    {
      if(!T[i].mark.equals(""))
      {
        tied++;
      }
    }
    for(int i =0; i<9;i++)
    {
      if(!T[i].mark.equals(""))
      {
        
        switch(i)
        {
          case 0:
            if((T[i].mark.equals(T[i+1].mark) && T[i].mark.equals(T[i+2].mark)) || (T[i].mark.equals(T[i+3].mark) && T[i].mark.equals(T[i+6].mark)))
            {
              winner = T[i].mark;
            }
            break;
          case 3: case 6:
            if(T[i].mark.equals(T[i+1].mark) && T[i].mark.equals(T[i+2].mark))
            {
              winner = T[i].mark;
            }
            break;
          case 1: case 2:
            if(T[i].mark.equals(T[i+3].mark) && T[i].mark.equals(T[i+6].mark))
            {
              winner = T[i].mark;
            }
            break;
          case 4:
            if( (T[i].mark.equals(T[0].mark) && T[i].mark.equals(T[8].mark)) || (T[i].mark.equals(T[2].mark) && T[i].mark.equals(T[6].mark)))
            {
              winner = T[i].mark;
            }
            break;
        }
      }
    }
  }
    
}                