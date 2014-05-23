public class Bishop extends Piece {

    public String toString() {
	return "B";
    }

    public boolean legalMove(Point delta) {
	return Math.abs(delta.x) == Math.abs(delta.y) &&
	    !delta.equals(new Point(0,0));
    }
}
