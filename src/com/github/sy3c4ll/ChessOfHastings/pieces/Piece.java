package com.github.sy3c4ll.ChessOfHastings.pieces;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
public class Piece{
	private JButton b;
	private PieceType t;
	private boolean defaultWhite;
	public static final Color highlightColour=new Color(255,215,0);
	public Piece(PieceType type,boolean white){b=new JButton();setType(type);defaultWhite=white;b.setBackground(defaultWhite?Color.WHITE:Color.BLACK);b.setBorderPainted(false);}
	public Piece(){this(PieceType.EMPTY,true);}
	public void highlight(boolean colour){b.setBackground(colour?highlightColour:(defaultWhite?Color.WHITE:Color.BLACK));}
	public PieceType getType(){return t;}
	public JButton getButton(){return b;}
	public Side getSide(){
		switch(t){
			case NK:case NC:case NA:case NF:return Side.NORMAN;
			case SK:case SH:case SF:case SS:return Side.SAXON;
			case EMPTY:return Side.NEUTRAL;
			default:return Side.NEUTRAL;
		}
	}
	public void setType(PieceType type){
		switch(t=type){
			case NK:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/nk.png")));break;
			case NC:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/nc.png")));break;
			case NA:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/na.png")));break;
			case NF:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/nf.png")));break;
			case SK:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/sk.png")));break;
			case SH:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/sh.png")));break;
			case SF:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/sf.png")));break;
			case SS:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/ss.png")));break;
			case EMPTY:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/empty.png")));break;
			default:b.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/empty.png")));break;
		}
	}
}
