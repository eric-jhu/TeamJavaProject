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

public class game_rule {

	JFrame ruleFrame = new JFrame("");
	int Width = 400;
	int Height = 700;

	// 文字規則背景
	ImageIcon Rule2_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\rule2.jpg");
	Image scaled_Rule2_icon = Rule2_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon rule2_icon = new ImageIcon(scaled_Rule2_icon);
	// 圖片規則背景
	ImageIcon Rule1_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\rule1.jpg");
	Image scaled_Rule1_icon = Rule1_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon rule1_icon = new ImageIcon(scaled_Rule1_icon);
	
	
	JLabel backgroundlabel = new JLabel();// 大背景
	
	static String gotowarrole = "rule1_icon";
	static String nowroleimg = "";// 當前背景
	static String chanstr = "";// 交換字串用
	
	
	
	
	
	JButton leftButton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\left_buttons.png"));
	JButton rightButton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\right_buttons.png"));
	JButton exitbutton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\exit.png"));// 離開按鈕
	
	game_rule() {// 建構子
		setrule();
	}

	private void setrule() {// 版面設定 所有東西都放在背景圖片之上
		// frame大小設定
		ruleFrame.setSize(400, 700);
		ruleFrame.setVisible(true);
		ruleFrame.setResizable(false);
		ruleFrame.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				ruleFrame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}
		});

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - ruleFrame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - ruleFrame.getHeight()) / 2);
		ruleFrame.setLocation(centerX, centerY);

		ruleFrame.setLayout(new BorderLayout());
		ruleFrame.add(backgroundlabel);// 背景圖加入佔住整個版面
		if (gotowarrole.equals("Rule2_icon")) {
			backgroundlabel.setIcon(rule2_icon);
		} else {
			backgroundlabel.setIcon(rule1_icon);
		}
		
		
		backgroundlabel.setLayout(null);

		// 放在背景裡面
		backgroundlabel.add(exitbutton);

		backgroundlabel.add(rightButton);
		backgroundlabel.add(leftButton);

		
		
		
		// 位置設定
		exitbutton.setBounds(10, 10, 60, 60);// 離開按鈕

		leftButton.setBounds(0,580, 80, 80);// 左按鈕
		rightButton.setBounds(300, 575, 80, 84);// 右按鈕

		

		// 按鈕事件設定
		exitbutton.addActionListener(new RolePageFrameListener());
		leftButton.addActionListener(new RolePageFrameListener());
		rightButton.addActionListener(new RolePageFrameListener());
		
	
		// 右按鈕去除背景
		rightButton.setOpaque(false);
		rightButton.setBackground(new Color(0, 0, 0, 0));
		rightButton.setBorder(null);
		rightButton.setFocusPainted(false);
		// 左按鈕去除背景
		leftButton.setOpaque(false);
		leftButton.setBackground(new Color(0, 0, 0, 0));
		leftButton.setBorder(null);
		leftButton.setFocusPainted(false);
		// 離開按鈕去除背景
		exitbutton.setOpaque(false);
		exitbutton.setBackground(new Color(0, 0, 0, 0));
		exitbutton.setBorder(null);
		exitbutton.setFocusPainted(false);
		
	}// 版面設定結束

	// 按鈕事件設定
	class RolePageFrameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == exitbutton) {// 離開按鈕事件
				ruleFrame.dispose();
				GameFloor i = new GameFloor();
				i.gamefloorFrame.setVisible(true);
			}

			if (e.getSource() == leftButton) {// 左事件
				// 改變規則背景
				backgroundlabel.setIcon(rule1_icon);
				

				
			}
			if (e.getSource() == rightButton) {// 右事件
				// 改變規則背景
				backgroundlabel.setIcon(rule2_icon);
				

				
			}
		
		}

	}// 按鈕事件設定結束

	

}
