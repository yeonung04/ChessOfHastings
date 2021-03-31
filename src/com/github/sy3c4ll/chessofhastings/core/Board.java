package com.github.sy3c4ll.chessofhastings.core;
import com.github.sy3c4ll.chessofhastings.pieces.Piece;
import com.github.sy3c4ll.chessofhastings.pieces.PieceType;
import com.github.sy3c4ll.chessofhastings.pieces.Side;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class Board{
	public Side turn;public Piece[][] b;public Piece[] k;public JLabel l;public JButton n,q;public JPanel p1,p2,p3;public Container c;public Engine e;
	public Board(Container container){
		c=container;turn=Side.NORMAN;b=new Piece[8][8];k=new Piece[2];l=new JLabel("Normans' Turn!");n=new JButton("New Game");q=new JButton("Quit");p1=new JPanel();p2=new JPanel();p3=new JPanel();e=new Engine(this);
		for(int i=0;i<8;i++){
			b[0][i]=new Piece(PieceType.SH,i%2==1);
			b[1][i]=new Piece(PieceType.SF,(i+1)%2==1);
			b[2][i]=new Piece(PieceType.SS,(i+2)%2==1);
			b[3][i]=new Piece(PieceType.EMPTY,(i+3)%2==1);
			b[4][i]=new Piece(PieceType.EMPTY,(i+4)%2==1);
			b[5][i]=new Piece(PieceType.NF,(i+5)%2==1);
			b[6][i]=new Piece(PieceType.NA,(i+6)%2==1);
			b[7][i]=new Piece(PieceType.NC,(i+7)%2==1);
		}
		k[0]=new Piece(PieceType.SK,false);k[1]=new Piece(PieceType.NK,true);
		c.setLayout(new BorderLayout());p1.setLayout(new GridLayout(8,8));p2.setLayout(new BorderLayout());p3.setLayout(new GridLayout(1,2));
		for(int i=0;i<8;i++)for(int j=0;j<8;j++){p1.add(b[i][j].getButton());b[i][j].getButton().addActionListener(e);}
		k[0].getButton().addActionListener(e);k[1].getButton().addActionListener(e);n.addActionListener(e);q.addActionListener(e);
		p2.add(p1,"Center");p2.add(k[0].getButton(),"North");p2.add(k[1].getButton(),"South");
		p3.add(n);p3.add(q);
		c.add(p2,"Center");c.add(l,"North");c.add(p3,"South");
	}
}
