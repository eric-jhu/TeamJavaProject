package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class IndexPage {// 首頁版面

	JFrame indexFrame = new JFrame("無盡之塔");// 版面

	JLabel headLabel = new JLabel();// 大標題
	// logo
	ImageIcon Logo_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\logo.png");
	ImageIcon logo_icon = new ImageIcon(Logo_icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH));
	
	

	JButton loginButton = new JButton("登入");// 登入紐
	JButton registerButton = new JButton("註冊");// 註冊紐
	JButton exitButton = new JButton("離開");// 離開紐

	Dialog exitDialog = new Dialog(indexFrame, "離開系統");// 離開系統跳出對話窗防呆用
	JLabel exitLabel = new JLabel("確定要離開嗎?");// 離開確認標題
	JButton trueExitButton = new JButton("離開");// 離開對話窗離開紐
	JButton falseExitButton = new JButton("取消");// 離開對話窗取消紐

	JLabel backgroundlabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\image\\framebackground.jpg"));// 大背景

	IndexPage() {// 建構子
		setindexFrame();
	}

	private void setindexFrame() {// 視窗版面設定 用封裝不讓人動設定
		indexFrame.setSize(400, 700);// 視窗大小
		indexFrame.setResizable(false);
		indexFrame.setDefaultCloseOperation(indexFrame.EXIT_ON_CLOSE);
		indexFrame.setLayout(new BorderLayout());

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - indexFrame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - indexFrame.getHeight()) / 2);
		indexFrame.setLocation(centerX, centerY);

		indexFrame.add(backgroundlabel);// 背景圖加入佔住整個版面

		backgroundlabel.setLayout(null);

		// 加到視窗
		backgroundlabel.add(headLabel);
		backgroundlabel.add(loginButton);
		backgroundlabel.add(registerButton);
		backgroundlabel.add(exitButton);

		// 位置設定
		headLabel.setBounds(40, 30, 300, 200);
		headLabel.setIcon(logo_icon);
//		headLabel.setForeground(Color.WHITE);
//		headLabel.setFont(new Font("Serif", Font.BOLD, 20));
		loginButton.setBounds(150, 200, 80, 30);
		loginButton.setForeground(Color.black);
		loginButton.setFont(new Font("Serif", Font.BOLD, 20));
		registerButton.setBounds(150, 300, 80, 30);
		registerButton.setForeground(Color.black);
		registerButton.setFont(new Font("Serif", Font.BOLD, 20));
		exitButton.setBounds(150, 400, 80, 30);
		exitButton.setForeground(Color.black);
		exitButton.setFont(new Font("Serif", Font.BOLD, 20));

		// 按鈕事件設定
		loginButton.addActionListener(new IndexListener());
		registerButton.addActionListener(new IndexListener());
		exitButton.addActionListener(new IndexListener());

		// 視窗顯示設定
		indexFrame.setVisible(true);

	}

	private void setexitDialog() {// 離開對話窗設定

		exitDialog.setSize(300, 200);// 離開對話窗大小
		exitDialog.setLayout(null);// 不設版面
		exitDialog.setModal(true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - exitDialog.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - exitDialog.getHeight()) / 2);
		exitDialog.setLocation(centerX, centerY);

		// 加入到視窗
		exitDialog.add(exitLabel);
		exitDialog.add(trueExitButton);
		exitDialog.add(falseExitButton);

		// 位置大小設定
		exitLabel.setBounds(50, 50, 150, 30);
		exitLabel.setFont(new Font("Serif", Font.BOLD, 20));
		trueExitButton.setBounds(70, 120, 80, 30);
		trueExitButton.setFont(new Font("Serif", Font.BOLD, 20));
		falseExitButton.setBounds(180, 120, 80, 30);
		falseExitButton.setFont(new Font("Serif", Font.BOLD, 20));

		// 按鈕事件
		trueExitButton.addActionListener(new IndexListener());
		falseExitButton.addActionListener(new IndexListener());

		exitDialog.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將彈出視窗關閉
			public void windowClosing(WindowEvent event) {
				exitDialog.dispose();
			}
		});

		exitDialog.setVisible(true);// 呼叫顯示
	}

	class IndexListener implements ActionListener {// 按鈕事件

		@Override
		public void actionPerformed(ActionEvent e) {// 按鈕方法設定
			// TODO Auto-generated method stub

			if (e.getSource() == loginButton) {
				LoginPage login = new LoginPage();
				indexFrame.setVisible(false);// 隱藏首頁

			} else if (e.getSource() == registerButton) {
				RegisterPage register = new RegisterPage();
				indexFrame.setVisible(false);// 隱藏首頁

			} else if (e.getSource() == exitButton) {
				setexitDialog();// 呼叫對話視窗
				// exitDialog.setVisible(true);

			} else if (e.getSource() == trueExitButton) {
				System.exit(0);// 按結束關閉視窗
			} else {
				exitDialog.setVisible(false);
			}

		}// 按鈕方法設定結束

	}// 按鈕事件結束

}// 首頁版面結束
