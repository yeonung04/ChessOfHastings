package com.github.sy3c4ll.chessofhastings.pieces;
import com.github.sy3c4ll.chessofhastings.ChessOfHastings;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
public class Piece{
	private JButton b;
	private PieceType t;
	private boolean defaultWhite;
	public static final Color highlightColour=new Color(255,215,0);
	public static final ImageIcon
			NKIcon=readImage("res/nk.png"),
			NCIcon=readImage("res/nc.png"),
			NAIcon=readImage("res/na.png"),
			NFIcon=readImage("res/nf.png"),
			SKIcon=readImage("res/sk.png"),
			SHIcon=readImage("res/sh.png"),
			SFIcon=readImage("res/sf.png"),
			SSIcon=readImage("res/ss.png"),
			EmptyIcon=readImage("res/empty.png");
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
			case NK:b.setIcon(NKIcon);break;
			case NC:b.setIcon(NCIcon);break;
			case NA:b.setIcon(NAIcon);break;
			case NF:b.setIcon(NFIcon);break;
			case SK:b.setIcon(SKIcon);break;
			case SH:b.setIcon(SHIcon);break;
			case SF:b.setIcon(SFIcon);break;
			case SS:b.setIcon(SSIcon);break;
			case EMPTY:b.setIcon(EmptyIcon);break;
			default:b.setIcon(EmptyIcon);break;
		}
	}
	private static ImageIcon readImage(String path){
		try{return new ImageIcon(ImageIO.read(ChessOfHastings.class.getResourceAsStream(path)));}
		catch(Exception e){System.err.println("Failed to load resource: "+path);return null;}
	}
}
