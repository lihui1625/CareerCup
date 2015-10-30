package career08.oop;

public class Exam_8_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Edge{
	static enum Type{
		inner, outer,flat;
	}
	Piece parent;
	Type type;
	int index;
	Edge attached_to;
	boolean fitsWith(Edge edge){  return false;}//todo 
	
}

class Piece{
	Edge[] edges;
	boolean isCorner(){ return false;} //todo 
}


class Puzzle{
	Piece[] pieces;
	Piece[] solution;
	Edge[] inners, outers,flats;
	Piece[] corners;
	void sort(){}
	void solve(){}
}