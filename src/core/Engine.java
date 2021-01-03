package core;
import pieces.*;
import java.awt.event.*;
import javax.swing.*;
public class Engine implements ActionListener,Rules{
	public Board b;public boolean selecting;public Piece selected;
	public Engine(Board board){b=board;selecting=false;selected=new Piece();}
	public boolean verify(int x,int y){return x>=0&&x<8&&y>=0&&y<8;}
	public boolean valid(Piece init,Piece dest){
		if(init==dest)return false;
		if(dest.getType()==PieceType.EMPTY)return true;
		if(init.getType()==PieceType.NK||init.getType()==PieceType.SK)return true;
		if(init.getSide()==dest.getSide())return false;
		if(init.getType()==PieceType.NA&&dest.getType()==PieceType.SS)return false;
		if(init.getType()==PieceType.SF&&dest.getType()==PieceType.NC)return false;
		return true;
	}
	public void clear(){
		for(int i=0;i<8;i++)for(int j=0;j<8;j++)b.b[i][j].highlight(false);
		b.k[0].highlight(false);b.k[1].highlight(false);
		selecting=false;selected=new Piece();
	}
	public void victory(Side s){
		b.l.setText((s==Side.NORMAN?"Normans":"Saxons")+" win! GG!");
		JOptionPane.showMessageDialog(null,s==Side.NORMAN?"The Normans have conquered Britain.\nWell played!":"The Saxons have defended their homeland successfully.\nNice match!","Victory!",JOptionPane.PLAIN_MESSAGE);
	}
	public void move(Piece init,Piece dest){
		if(init.getType()==PieceType.NA&&dest.getSide()==Side.SAXON)dest.setType(PieceType.EMPTY);
		else if(init!=dest){dest.setType(init.getType());init.setType(PieceType.EMPTY);}
		b.turn=(b.turn==Side.NORMAN?Side.SAXON:Side.NORMAN);b.label(b.turn);
		clear();
	}
	public void select(int x,int y){
		if(y==-1){
			selected=b.k[0];
			b.k[0].highlight(true);
			for(int i=0;i<8;i++)if(b.k[0].getType()==PieceType.NK||b.k[0].getType()==PieceType.SK||b.k[0].getType()!=b.b[0][i].getType())b.b[0][i].highlight(true);
		}else if(y==8){
			selected=b.k[1];
			b.k[1].highlight(true);
			for(int i=0;i<8;i++)if(b.k[1].getType()==PieceType.NK||b.k[1].getType()==PieceType.SK||b.k[1].getType()!=b.b[7][i].getType())b.b[7][i].highlight(true);
		}else{
			selected=b.b[y][x];
			b.b[y][x].highlight(true);
			switch(b.b[y][x].getType()){
				case NK:case SK:
					for(int i=0;i<Klen;i++){
						if(verify(x+Kdx[i],y+Kdy[i])){if(valid(selected,b.b[y+Kdy[i]][x+Kdx[i]]))b.b[y+Kdy[i]][x+Kdx[i]].highlight(true);}
						else if(y+Kdy[i]==-1){if(valid(selected,b.k[0]))b.k[0].highlight(true);}
						else if(y+Kdy[i]==8){if(valid(selected,b.k[1]))b.k[1].highlight(true);}
					}break;
				case NF:case SF:case SS:
					for(int i=0;i<Flen;i++){
						if(verify(x+Fdx[i],y+Fdy[i])){if(valid(selected,b.b[y+Fdy[i]][x+Fdx[i]]))b.b[y+Fdy[i]][x+Fdx[i]].highlight(true);}
						else if(y+Fdy[i]==-1){if(valid(selected,b.k[0]))b.k[0].highlight(true);}
						else if(y+Fdy[i]==8){if(valid(selected,b.k[1]))b.k[1].highlight(true);}
					}break;
				case NC:
					for(int i=0;i<NClen;i++){
						if(verify(x+NCdx[i],y+NCdy[i])){if(valid(selected,b.b[y+NCdy[i]][x+NCdx[i]]))b.b[y+NCdy[i]][x+NCdx[i]].highlight(true);}
						else if(y+NCdy[i]==-1){if(valid(selected,b.k[0]))b.k[0].highlight(true);}
						else if(y+NCdy[i]==8){if(valid(selected,b.k[1]))b.k[1].highlight(true);}
					}break;
				case SH:
					for(int i=0;i<SHlen;i++){
						if(verify(x+SHdx[i],y+SHdy[i])){if(valid(selected,b.b[y+SHdy[i]][x+SHdx[i]]))b.b[y+SHdy[i]][x+SHdx[i]].highlight(true);}
						else if(y+SHdy[i]==-1){if(valid(selected,b.k[0]))b.k[0].highlight(true);}
						else if(y+SHdy[i]==8){if(valid(selected,b.k[1]))b.k[1].highlight(true);}
					}break;
				case NA:
					if(y==0){if(b.k[0].getSide()!=Side.NORMAN)b.k[0].highlight(true);}
					else{
						if(b.b[y-1][x].getType()==PieceType.EMPTY)b.b[y-1][x].highlight(true);
						for(int i=1;i<=NAdis&&b.b[y-i][x].getType()!=PieceType.SS;i++)if(b.b[y-i][x].getSide()==Side.SAXON)b.b[y-i][x].highlight(true);
					}
					break;
				default:break;
			}
		}
		selecting=true;
	}
	@Override public void actionPerformed(ActionEvent e){
		JButton s=(JButton)e.getSource();
		if(s==b.n){
			b.turn=Side.NORMAN;
			b.k[0].setType(PieceType.SK);b.k[1].setType(PieceType.NK);
			for(int i=0;i<8;i++){
				b.b[0][i].setType(PieceType.SH);
				b.b[1][i].setType(PieceType.SF);
				b.b[2][i].setType(PieceType.SS);
				b.b[3][i].setType(PieceType.EMPTY);
				b.b[4][i].setType(PieceType.EMPTY);
				b.b[5][i].setType(PieceType.NF);
				b.b[6][i].setType(PieceType.NA);
				b.b[7][i].setType(PieceType.NC);
			}
			b.label(Side.NORMAN);
		}
		if(s==b.q)System.exit(0);
		if(s==b.k[0].getButton()){
			if(selecting){if(valid(selected,b.k[0])&&b.k[0].getButton().getBackground()==Piece.highlightColour)move(selected,b.k[0]);else if(selected==b.k[0])clear();}
			else if(!selecting){if(b.turn==b.k[0].getSide())select(0,-1);}
		}
		if(s==b.k[1].getButton()){
			if(selecting){if(valid(selected,b.k[1])&&b.k[1].getButton().getBackground()==Piece.highlightColour)move(selected,b.k[1]);else if(selected==b.k[1])clear();}
			else if(!selecting){if(b.turn==b.k[1].getSide())select(0,8);}
		}
		for(int i=0;i<8;i++)for(int j=0;j<8;j++)if(s==b.b[i][j].getButton()){
			if(selecting){if(valid(selected,b.b[i][j])&&b.b[i][j].getButton().getBackground()==Piece.highlightColour)move(selected,b.b[i][j]);else if(selected==b.b[i][j])clear();}
			else if(!selecting){if(b.turn==b.b[i][j].getSide())select(j,i);}
			break;
		}
		if(b.k[0].getType()==PieceType.NF||b.k[0].getType()==PieceType.NA)b.k[0].setType(PieceType.NC);
		if(b.k[1].getType()==PieceType.SF||b.k[1].getType()==PieceType.SS)b.k[1].setType(PieceType.SH);
		boolean nk=true,sk=true;
		if(b.k[0].getType()==PieceType.NK)nk=false;if(b.k[0].getType()==PieceType.SK)sk=false;
		if(b.k[1].getType()==PieceType.NK)nk=false;if(b.k[1].getType()==PieceType.SK)sk=false;
		for(int i=0;i<8;i++)for(int j=0;j<8;j++){if(b.b[i][j].getType()==PieceType.NK)nk=false;if(b.b[i][j].getType()==PieceType.SK)sk=false;}
		if(nk)victory(Side.SAXON);if(sk)victory(Side.NORMAN);
	}
}