import java.awt.Point;

public abstract class Piece {

    protected Point pos; ///Must be protected in order for derived classes to access
    protected String team;

    public abstract Boolean legalMove(Point delta, ChessBoard b);

    public abstract String toString();

    public Piece(Point inpos, String inteam) {
		pos = new Point(inpos);
		team = new String(inteam);
    }
	public Piece(){
		pos=new Point();
		team=new String();
	}

    public String getTeam() {
		return team;
    }
	
    public Point getPosition() {
		return pos;
    }

    public Boolean move(Point delta, ChessBoard b) {
		if (legalMove(delta,b)) {
			pos.translate(delta.x, delta.y);
			return true;
		} else {
			return false;
		}
    }
}
