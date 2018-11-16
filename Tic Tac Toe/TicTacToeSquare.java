

import java.awt.*;
public class TicTacToeSquare extends Rectangle
{
  
  
  String mark ;
  int xPos,yPos,width,height;

  public TicTacToeSquare(int x,int y,int w,int h) 
  {
    super(x,y,w,h);
    mark = "";
    xPos = x;
    yPos = y;
    width = w;
    height = h;
  }
    
  public void drawTic(Graphics g)
  {
  	Expo.setFont(g,"Arial",Font.BOLD,50);
  	Expo.setColor(g,Expo.white);
    Expo.fillRectangle(g,x,y,x+width,y+height);
    Expo.setColor(g,Expo.black);
    Expo.drawString(g,mark,x+25,y+65);
  }
    

  
  public String toString()
  {
    return mark;
  }
   
    
  public int x(){return xPos;}
  public int y(){return yPos;}
  public int w(){return width;}
  public int h(){return height;}
  public String mark(){return mark;}
  public void setMark(String m){mark = m;}
    
    
}