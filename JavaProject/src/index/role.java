package index;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
public class role extends Canvas{
	
	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		
		Image i=t.getImage(System.getProperty("user.dir") + "\\image\\swordsman.jpg");
		g.drawImage(i, 50,100,this);
		Image i1=t.getImage(System.getProperty("user.dir") + "\\image\\mage.jpg");
		g.drawImage(i1, 50,400,this);
			
			
	}
		public static void main(String[] args) {
		role m=new role();
		JFrame f=new JFrame("職業選項");
		JLabel l1,l2,l3,l4;
		JButton b=new JButton("切換");  
	    b.setBounds(220,130,100,50);
	    b.setFont(new Font("標楷體", Font.BOLD, 16));
	    JButton c=new JButton("切換");  
	    c.setBounds(220,430,100,50);
	    c.setFont(new Font("標楷體", Font.BOLD, 16));
		l1=new JLabel("職業:劍士");
		l1.setFont(new Font("標楷體", Font.BOLD, 20));
		l2=new JLabel("職業:法師");
		l2.setFont(new Font("標楷體", Font.BOLD, 20));
		l3=new JLabel("Hp=100 Power=20");
		l3.setFont(new Font("Arial", Font.BOLD, 16));
		l4=new JLabel("Hp=70 Power=40");
		l4.setFont(new Font("Arial", Font.BOLD, 16));
		l1.setBounds(55,60, 100,30);
		l2.setBounds(55,360, 100,30);
		l3.setBounds(50,220, 150,30);
		l4.setBounds(50,520, 150,30);
		f.add(b);
		f.add(c);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(m);
		
		f.setSize(400,700);
		//f.setLayout(null);
		f.setVisible(true);
	}

}

	
