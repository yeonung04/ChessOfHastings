package com.github.sy3c4ll.chessofhastings;
import com.github.sy3c4ll.chessofhastings.core.Board;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Toolkit;
public class ChessOfHastings{
	public static void main(String[] args){
		JFrame f=new JFrame("Chess of Hastings");new Board(f.getContentPane());
		f.pack();f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);f.setVisible(true);
		f.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-f.getWidth())/2),(int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-f.getHeight())/2));
	}
}
