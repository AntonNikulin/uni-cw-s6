
public class Circle {
/*
 * Helper class for 4.6 task
 */
	public Circle(int x, int y, int r){
		this.setX(x);
		this.setY(y);
		this.setR(r);
	}
	
	public void moveCircle(int dx, int dy){
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}
	
	public boolean isIntersecting(Circle c2) {
	    double distance = distanceTo(c2);
	    if (Math.abs((r - c2.getR())) <= distance && distance <= (r + c2.getR())) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
    public boolean isCircleInside(Circle c2) {
        return distanceTo(c2) + r <= c2.getR();
    }

	
	public double distanceTo(Circle c2){
		return  Math.sqrt((x - c2.getX()) * (x - c2.getX()) + (y - c2.getY()) * (y - c2.getY()));
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	private int x;
	private int y;
	private int r;
}

