package com.github.sy3c4ll.ChessOfHastings.pieces;
public interface Rules{
	final int[]
			NCdx={-2,-1,0,0,0,0,0,1,2},NCdy={0,0,-2,-1,0,1,2,0,0},
			SHdx={-2,-1,-1,-1,0,0,0,0,0,1,1,1,2},SHdy= {0,-1,0,1,-2,-1,0,1,2,-1,0,1,0},
			Kdx={-1,-1,-1,0,0,0,1,1,1},Kdy={-1,0,1,-1,0,1,-1,0,1},
			Fdx={-1,0,0,0,1},Fdy={0,-1,0,1,0};
	final int
			NClen=9,SHlen=13,Klen=9,Flen=5,NAdis=3;
}
