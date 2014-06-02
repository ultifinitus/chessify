import java.awt.Point;

public abstract class Piece {
    
    protected Point pos;
    protected String team;

    public abstract boolean legalMove(Point delta, ChessBoard b);
    
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
    
    public void move(Point delta, ChessBoard b) {
	pos.translate(delta.x, delta.y);
    }
    
    /** 
     * pre: destination is on the same rank/file/diagonal line.
     *
     * post: return true if all spaces between this.pos and destination are open
     */
    public Boolean pathFree(Point delta, ChessBoard b) {
	Point dir = new Point(delta.x == 0 ? 0 : Math.abs(delta.x)/delta.x,
			      delta.y == 0 ? 0 : Math.abs(delta.y)/delta.y);
	
	Point path = new Point(pos);
	path.translate(dir.x, dir.y);
	
	Point dest = new Point(pos);
	dest.translate(delta.x, delta.y);
	
	while (!path.equals(dest)) {
	    if (!b.isEmpty(path)) return false;
	    path.translate(dir.x, dir.y);
	}
	
	return true;
    }
}
