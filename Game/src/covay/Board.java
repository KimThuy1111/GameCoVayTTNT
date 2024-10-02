package covay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel{
	private int size = 9;
	private Image imgDen;
	private Image imgTrang;
	private Cell[][] matrix = new Cell[size][size];
	private String currentPlayer = Cell.BLACK_VALUE;
	public Board() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Cell cell = new Cell();
				matrix[i][j] = cell;
			}
		}
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				int x = e.getX();
				int y = e.getY();
				
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						Cell cell = matrix[i][j];
						int cX = cell.getX();
						int cY = cell.getY();
						int eX = cX+cell.getW()/2;
						int eY = cY+cell.getH()/2;

						if(x>=cX && x<=eX && y>=cY && y<=eY) {
							if(cell.getValue().equals(Cell.EMTY_VALUE)) {
								cell.setValue(currentPlayer);
								currentPlayer = currentPlayer.equals(Cell.BLACK_VALUE) ? Cell.WHITE_VALUE : Cell.BLACK_VALUE;
								repaint();
							}
						}
					}
				}
			}
		});
		try {
			imgDen = ImageIO.read(getClass().getResource("den.png"));
			imgTrang = ImageIO.read(getClass().getResource("trang.png"));
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		int w = 300/size;
		int h = 300/size;
		Graphics2D gra = (Graphics2D) g;
	    gra.setColor(new Color(139, 69, 19)); // RGB for brown
	    gra.fillRect(0, 0, getWidth(), getHeight());
	    for (int i = 0; i < size; i++) {
			gra.setColor(Color.BLACK);
			gra.drawLine(i * w+20, 20, i * w+20, 283);
			gra.drawLine(20, i * w+20, 284, i * w+20);
		}
		int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int x = j*w-w/2+20;
				int y = i*h-h/2+20;
				Cell cell = matrix[i][j];
				cell.setX(x);
				cell.setY(y);
				cell.setW(w);
				cell.setH(h);
				if(cell.getValue().equals(Cell.BLACK_VALUE)) {
					gra.drawImage(imgDen, x,y,w,h,this);
				}else if(cell.getValue().equals(Cell.WHITE_VALUE)) {
					gra.drawImage(imgTrang, x,y,w,h,this);
				}

			}
		}
		setSize(320,320);
		
	}

	

}
