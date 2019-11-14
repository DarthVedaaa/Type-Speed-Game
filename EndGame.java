import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File ;
import java.io.* ;


public class EndGame extends JFrame {
   	private Button btn1, btn2;
	public EndGame(int n){
	try {
    		final Image backgroundImage = javax.imageio.ImageIO.read(new File("new-game.jpg"));
    		setContentPane(new JPanel(new BorderLayout()) {
        	@Override public void paintComponent(Graphics g) {
            	g.drawImage(backgroundImage, 0, 0, null);
        	}
    	});
	} catch (IOException e) {
    		throw new RuntimeException(e);
	}
      	setLayout(new FlowLayout());
	JLabel scorelabel = new JLabel("Your Final Score : ");
	JTextField score = new JTextField(String.valueOf(n));
	btn1 = new Button("New Game");
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {   	
		try {
			TyperManPanel newgame = new TyperManPanel();
			setVisible(false);
			newgame.setVisible(true);
			dispose();
		}
		catch (FileNotFoundException E)
		{
			System.exit(0);
		}
	}
	}); //this refers to your current frame
	btn2 = new Button("Quit");
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
   			 System.exit(0);
  	}
	});
	add(btn1);
	add(btn2);
	setTitle("Game Over");
	setSize(400, 400);
	setVisible(true);
}
}
