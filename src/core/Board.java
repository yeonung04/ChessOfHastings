package core;
import pieces.*;
import javax.swing.*;
import java.awt.*;
public class Board{
	public Side turn;public Piece[][] b;public Piece[] k;public JLabel l;public JButton n,q;public JPanel p1,p2,p3;public Container c;public Engine e=new Engine(this);
	public Board(Container container){c=container;build();}
	public void build(){
		turn=Side.NORMAN;b=new Piece[8][8];k=new Piece[2];l=new JLabel("Normans' Turn!");n=new JButton("New Game");q=new JButton("Quit");p1=new JPanel();p2=new JPanel();p3=new JPanel();
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
	public void label(Side s){l.setText(s==Side.NORMAN?"Normans' Turn!":"Saxons' Turn!");}
	public static void main(String[] args){
		JFrame f=new JFrame("Chess of Hastings");new Board(f.getContentPane());
		f.pack();f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);f.setVisible(true);
		f.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-f.getWidth())/2),(int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-f.getHeight())/2));
	}
}