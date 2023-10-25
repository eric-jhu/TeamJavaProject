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

public class RolePage {

	JFrame rolePageFrame = new JFrame("");
	int Width = 400;
	int Height = 700;

	// 法師背景
	ImageIcon Mage_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\mage.jpg");
	Image scaled_Mage_icon = Mage_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon mage_icon = new ImageIcon(scaled_Mage_icon);
	// 劍士背景
	ImageIcon Swordsman_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\swordsman.jpg");
	Image scaled_Swordsman_icon = Swordsman_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon swordsman_icon = new ImageIcon(scaled_Swordsman_icon);
	//劍士能力值
	ImageIcon swordsrole_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\role.jpg");
	Image scaled_swordsrole_icon = swordsrole_icon.getImage().getScaledInstance(200, 140, Image.SCALE_SMOOTH);
	//法師能力值
	ImageIcon magerole_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\magerole.jpg");
	Image scaled_magerole_icon = magerole_icon.getImage().getScaledInstance(200, 140, Image.SCALE_SMOOTH);
	
	JLabel backgroundlabel = new JLabel();// 大背景
	JLabel rolelabel = new JLabel();//角色能力值面板
	static String gotowarrole = "swordsman_icon";// 出戰角色
	static String nowroleimg = "";// 當前背景角色
	static String chanstr = "";// 交換字串用
	
	
	
	// JButton gotowarButton = new JButton("出戰");
	JButton gotowarButton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\fight_buttons.png"));
	JButton leftButton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\left_buttons.png"));
	JButton rightButton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\right_buttons.png"));
	JButton exitbutton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\exit.png"));// 離開按鈕
	
	RolePage() {// 建構子
		setrolePageFrame();
	}

	private void setrolePageFrame() {// 版面設定 所有東西都放在背景圖片之上
		// frame大小設定
		rolePageFrame.setSize(400, 700);
		rolePageFrame.setVisible(true);
		rolePageFrame.setResizable(false);
		rolePageFrame.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				rolePageFrame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}
		});

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - rolePageFrame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - rolePageFrame.getHeight()) / 2);
		rolePageFrame.setLocation(centerX, centerY);

		rolePageFrame.setLayout(new BorderLayout());
		rolePageFrame.add(backgroundlabel);// 背景圖加入佔住整個版面
		if (gotowarrole.equals("mage_icon")) {
			backgroundlabel.setIcon(mage_icon);
			rolelabel.setIcon(magerole_icon);
		} else {
			backgroundlabel.setIcon(swordsman_icon);
			rolelabel.setIcon(swordsrole_icon);
		}
		
		
		backgroundlabel.setLayout(null);

		// 放在背景裡面
		backgroundlabel.add(exitbutton);
		backgroundlabel.add(gotowarButton);
		backgroundlabel.add(rightButton);
		backgroundlabel.add(leftButton);
		backgroundlabel.add(rolelabel);
		
		
		
		// 位置設定
		exitbutton.setBounds(10, 10, 60, 60);// 離開按鈕
		gotowarButton.setBounds(150, 565, 90, 90);// 角色出戰按鈕
		gotowarButton.setEnabled(false);
		leftButton.setBounds(0, 285, 90, 90);// 左按鈕
		rightButton.setBounds(290, 285, 90, 90);// 右按鈕
		rolelabel.setBounds(240, 565, 130, 90);//能力值面板
		

		// 按鈕事件設定
		exitbutton.addActionListener(new RolePageFrameListener());
		gotowarButton.addActionListener(new RolePageFrameListener());
		leftButton.addActionListener(new RolePageFrameListener());
		rightButton.addActionListener(new RolePageFrameListener());
		
		// 出戰按鈕去除背景
		gotowarButton.setOpaque(false);
		gotowarButton.setBackground(new Color(0, 0, 0, 0));
		gotowarButton.setBorder(null);
		gotowarButton.setFocusPainted(false);
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
				rolePageFrame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}

			if (e.getSource() == leftButton) {// 左事件
				// 改變圖案及能力值面板
				backgroundlabel.setIcon(swordsman_icon);
				rolelabel.setIcon(swordsrole_icon);
				nowroleimg = "swordsman_icon";

				// 鎖定出戰角色按鈕
				if (gotowarrole == nowroleimg) {
					gotowarButton.setEnabled(false);

				} else {
					gotowarButton.setEnabled(true);
				}
			}
			if (e.getSource() == rightButton) {// 右事件
				// 改變圖案及能力值面板
				backgroundlabel.setIcon(mage_icon);
				rolelabel.setIcon(magerole_icon);
				nowroleimg = "mage_icon";

				// 鎖定出戰角色按鈕
				if (gotowarrole == nowroleimg) {

					gotowarButton.setEnabled(false);

				} else {
					gotowarButton.setEnabled(true);
				}
			}
			
			//傳遞出戰角色數值
			if (e.getSource() == gotowarButton) {
				gotowarButton.setEnabled(false);
				chanstr = gotowarrole;
				gotowarrole = nowroleimg;
				if(gotowarrole == "mage_icon") {
					GameFloor.hplabel.setText(""+hero.mage_hp);
					GameFloor.attacklabel.setText(""+hero.mage_attack);	
				}
				else {
					GameFloor.hplabel.setText(""+hero.swordsman_hp);
					GameFloor.attacklabel.setText(""+hero.swordsman_attack);
				}
				nowroleimg = chanstr;
			}
		}

	}// 按鈕事件設定結束

	// 傳遞出戰角色
	static String gotowarrole() {
		return gotowarrole;
	}

}
