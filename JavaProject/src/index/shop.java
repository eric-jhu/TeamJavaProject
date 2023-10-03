package index;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import index.GameFloor.GameFloorListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class shop {

	private JFrame frmShop;
	int Width = 400;
	int Height = 700;
	static int coin = 1000;//金幣
	
	//購買紐判定
	static boolean buy1 = true;
	static boolean buy2 = true;
	static boolean buy3 = true;
	static boolean buy4 = true;
	//離開按鈕
	JButton exitbutton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\exit.png"));// 離開按鈕
	
	public shop() {
		setshop();
		frmShop.setVisible(true);
	}

	private void setshop() {
		frmShop = new JFrame();
		frmShop.setIconImage(
				Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "\\image\\coin.jpg"));
		frmShop.setTitle("shop");
		frmShop.setBounds(100, 100, 400, 700);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShop.getContentPane().setLayout(null);

		frmShop.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				frmShop.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}
		});
		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - frmShop.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - frmShop.getHeight()) / 2);
		frmShop.setLocation(centerX, centerY);

		
		exitbutton.setBounds(10, 10, 60, 60);// 離開按鈕
		frmShop.getContentPane().add(exitbutton);
		
		// 1號劍士商品
		JButton s1Button = new JButton("");
		s1Button.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\axe.jpg"));
		s1Button.setBounds(50, 310, 100, 100);
		frmShop.getContentPane().add(s1Button);
		// 2號劍士商品
		JButton s2Button_1 = new JButton("");
		s2Button_1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\helmet.jpg"));
		s2Button_1.setBounds(50, 530, 100, 100);
		frmShop.getContentPane().add(s2Button_1);

		// 1號法師商品
		JButton m1Button = new JButton("");
		m1Button.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\bluemagicStick.jpg"));
		m1Button.setBounds(50, 200, 100, 100);
		frmShop.getContentPane().add(m1Button);
		// 2號法師商品
		JButton m2Button = new JButton("");
		m2Button.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\magichat.jpg"));
		m2Button.setBounds(50, 420, 100, 100);
		frmShop.getContentPane().add(m2Button);

		// 角色擁有1000金幣
		JLabel mycoinLabel = new JLabel(" my coin:"+coin);
		mycoinLabel.setForeground(Color.YELLOW);
		mycoinLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		mycoinLabel.setBackground(Color.WHITE);
		mycoinLabel.setBounds(160, 80, 162, 55);
		frmShop.getContentPane().add(mycoinLabel);

		JLabel coinLabel = new JLabel("");
		coinLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\coin.jpg"));
		coinLabel.setBounds(70, 60, 100, 100);
		frmShop.getContentPane().add(coinLabel);

		JButton m1buyButton = new JButton("<html>藍色魔杖<br>$100 buy</html>");// 1號法師商品購買紐
		m1buyButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		m1buyButton.setBounds(200, 230, 150, 50);
		frmShop.getContentPane().add(m1buyButton);
		
		JButton m2buyButton = new JButton("<html>魔法帽<br>$100 buy</html>");// 2號法師商品購買紐
		m2buyButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		m2buyButton.setBounds(200, 450, 150, 50);
		frmShop.getContentPane().add(m2buyButton);
		
		JButton s1buyButton = new JButton("<html>斧頭<br>$100 buy</html>");// 1號劍士商品購買紐
		s1buyButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		s1buyButton.setBounds(200, 340, 150, 50);
		frmShop.getContentPane().add(s1buyButton);

		JButton s2buyButton = new JButton("<html>青銅頭盔<br>$100 buy</html>");// 2號劍士商品購買紐
		s2buyButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		s2buyButton.setBounds(200, 560, 150, 50);
		frmShop.getContentPane().add(s2buyButton);
		
		JLabel shopLabel = new JLabel("");//商城背景
		shopLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\image\\shop.jpg"));
		shopLabel.setBounds(0, 0, 384, 661);
		frmShop.getContentPane().add(shopLabel);
		
		
		// 離開按鈕去除背景
				exitbutton.setOpaque(false);
				exitbutton.setBackground(new Color(0, 0, 0, 0));
				exitbutton.setBorder(null);
				exitbutton.setFocusPainted(false);
	
	// 添加所有購買按鈕事件
	ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == exitbutton) {// 離開按鈕事件
					frmShop.dispose();
					GameMainPage i = new GameMainPage();
					i.frame.setVisible(true);
				}
				else if (e.getSource() == m1buyButton) {// 1號法師商品按鈕事件
					coin-=100;
					mycoinLabel.setText("my coin: "+coin);
					m1buyButton.setEnabled(false);
					buy1 = false;
				}
				else if (e.getSource() == m2buyButton) {// 2號法師商品按鈕事件
					coin-=100;
					mycoinLabel.setText("my coin: "+coin);
					m2buyButton.setEnabled(false);
					buy2 = false;
				}
				else if (e.getSource() == s1buyButton) {// 1號劍士商品按鈕事件
					coin-=100;
					mycoinLabel.setText("my coin: "+coin);
					s1buyButton.setEnabled(false);
					buy3 = false;
				}
				else if (e.getSource() == s2buyButton) {// 2號劍士商品按鈕事件
					coin-=100;
					mycoinLabel.setText("my coin: "+coin);
					s2buyButton.setEnabled(false);
					buy4 = false;
				}

	}

	};
		// 加入按鈕事件
		exitbutton.addActionListener(actionListener);
		m1buyButton.addActionListener(actionListener);
		m2buyButton.addActionListener(actionListener);
		s1buyButton.addActionListener(actionListener);
		s2buyButton.addActionListener(actionListener);
		
		// 根據buy的值啟禁用按鈕
		m1buyButton.setEnabled(buy1); 
        m2buyButton.setEnabled(buy2);
        s1buyButton.setEnabled(buy3);
        s2buyButton.setEnabled(buy4);
		
	}
	
	}
