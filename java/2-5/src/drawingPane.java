import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class drawingPane extends JPanel implements ActionListener {

	public drawingPane(CustomFrame frame){
		this.frame = frame;
		cr1 = new Circle(50, 50, 25);
		cr2 = new Circle(100, 100, 20);
		this.dx = 10;
		this.dy = 10;
		this.intersect = false;
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (intersect) {
			g2d.setColor(Color.RED);
		}
		else{
			g2d.setColor(Color.GREEN);
		}
		fillCircle(g2d, cr1.getX(),	cr1.getY(), cr1.getR());
		fillCircle(g2d, cr2.getX(),	cr2.getY(), cr2.getR());

	}
	
	public void fillCircle(Graphics2D cg, int xCenter, int yCenter, int r) {
		cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.frame.btnL){
			this.cr1.setX(cr1.getX() - this.dx);
		}
		if(e.getSource() == this.frame.btnR){
			this.cr1.setX(cr1.getX() + this.dx);
		}
		if(e.getSource() == this.frame.btnU){
			this.cr1.setY(cr1.getY() - this.dy);
		}
		if(e.getSource() == this.frame.btnD){
			this.cr1.setY(cr1.getY() + this.dy);
		}
		frame.repaint();
		this.intersect = cr1.isIntersecting(cr2);
	}
	public Circle cr1;
	public Circle cr2;
	public int dx;
	public int dy;
	private boolean intersect;
	
	private CustomFrame frame;
}