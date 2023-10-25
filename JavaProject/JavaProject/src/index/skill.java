package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import index.GameFloor.GameFloorListener;
import index.game_rule.RolePageFrameListener;

public class skill {

	
	JFrame frame = new JFrame();
	JButton exitbutton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\exit.png"));// 離開按鈕
	JButton btnNewButton_1 = new JButton("New button");
	JButton btnNewButton_2 = new JButton("New button");
	JButton btnNewButton_3 = new JButton("New button");
	JButton btnNewButton_4 = new JButton("New button");
	JLabel lblNewLabel_4 = new JLabel("");
	/**
	 * Launch the application.
	 */
	

	
	public skill() {
		initialize();
	}

	
	private void initialize() {
		
		frame.setBounds(100, 100, 400, 700);
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				frame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}
		});

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(centerX, centerY);

		frame.setLayout(new BorderLayout());
		
		
		exitbutton.setBounds(10, 10, 60, 60);// 離開按鈕
		lblNewLabel_4.add(exitbutton);
		
		
		btnNewButton_1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\01.png"));
		btnNewButton_1.setBounds(167, 29, 80, 80);
		frame.getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_2.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\02.png"));
		btnNewButton_2.setBounds(167, 190, 80, 80);
		frame.getContentPane().add(btnNewButton_2);
		
		
		btnNewButton_3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\03.png"));
		btnNewButton_3.setBounds(167, 311, 80, 80);
		frame.getContentPane().add(btnNewButton_3);
		
		
		btnNewButton_4.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\04.png"));
		btnNewButton_4.setBounds(167, 478, 80, 80);
		frame.getContentPane().add(btnNewButton_4);
		
		
		
		
		lblNewLabel_4.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\skill.jpg"));
		lblNewLabel_4.setBounds(0,2,400, 658);
		frame.getContentPane().add(lblNewLabel_4);
		
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setFocusPainted(false);
		exitbutton.setOpaque(false);
		exitbutton.setBackground(new Color(0, 0, 0, 0));
		exitbutton.setBorder(null);
		exitbutton.setFocusPainted(false);
		
		exitbutton.addActionListener(new skillFrameListener());}
		
	class skillFrameListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (e.getSource() == exitbutton) {// 離開按鈕事件
					frame.dispose();
					GameFloor i = new GameFloor();
					i.gamefloorFrame.setVisible(true);
				}
			}
		
	}

	
	

	}
