package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPage {

	JFrame registerFrame = new JFrame("登入視窗");// 大視窗
	//Container registerCon = registerFrame.getContentPane();

	// 顯示文字
	JLabel registerHeadLabel = new JLabel("註冊~~");
	JLabel usernameLabel = new JLabel("帳號:");
	JLabel passwordLabel = new JLabel("密碼:");
	JLabel againpasswordLabel = new JLabel("再次輸入密碼:");
	JLabel errorLabel = new JLabel("帳號已註冊");
	// 使用者輸入帳密及再次確認
	JTextField usernameText = new JTextField();
	JPasswordField passwordText = new JPasswordField();
	JPasswordField againpasswordText = new JPasswordField();
	// 註冊及重新輸入按鈕X返回主視窗
	JButton trueButton = new JButton("註冊");
	JButton resubmitButton = new JButton("重新輸入");
	
	JLabel backgroundlabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\image\\framebackground.jpg"));// 大背景

	RegisterPage() {// 建構子
		setRegisterFrame();
	}

	private void setRegisterFrame() {// 版面設定

		registerFrame.setSize(400, 700);// 視窗大小
		registerFrame.setResizable(false);
		registerFrame.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				registerFrame.dispose();
				IndexPage i = new IndexPage();
				i.indexFrame.setVisible(true);
			}
		});
		registerFrame.setLayout(new BorderLayout());
		
		// 將 JFrame 設定為在視窗中央顯示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - registerFrame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - registerFrame.getHeight()) / 2);
        registerFrame.setLocation(centerX, centerY);
		
		registerFrame.add(backgroundlabel);// 背景圖加入佔住整個版面

		backgroundlabel.setLayout(null);

		// 加到視窗
		backgroundlabel.add(registerHeadLabel);
		backgroundlabel.add(usernameLabel);
		backgroundlabel.add(passwordLabel);
		backgroundlabel.add(againpasswordLabel);
		backgroundlabel.add(usernameText);
		backgroundlabel.add(passwordText);
		backgroundlabel.add(againpasswordText);
		backgroundlabel.add(errorLabel);
		errorLabel.setVisible(false);
		backgroundlabel.add(trueButton);
		backgroundlabel.add(resubmitButton);

		// 位置設定
		registerHeadLabel.setBounds(150, 100, 100, 30);
		registerHeadLabel.setForeground(Color.WHITE);
		registerHeadLabel.setFont(new Font("Serif", Font.BOLD, 20));
		usernameLabel.setBounds(80, 150, 50, 30);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
		passwordLabel.setBounds(80, 200, 50, 30);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Serif", Font.BOLD, 20));
		againpasswordLabel.setBounds(30, 250, 100, 30);
		againpasswordLabel.setForeground(Color.WHITE);
		againpasswordLabel.setFont(new Font("Serif", Font.BOLD, 15));
		usernameText.setBounds(150, 150, 160, 30);
		usernameText.setFont(new Font("Serif", Font.BOLD, 20));
		passwordText.setBounds(150, 200, 160, 30);
		passwordText.setFont(new Font("Serif", Font.BOLD, 20));
		againpasswordText.setBounds(150, 250, 160, 30);
		againpasswordText.setFont(new Font("Serif", Font.BOLD, 20));
		errorLabel.setBounds(70, 300, 250, 30);
		errorLabel.setForeground(Color.WHITE);
		errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
		trueButton.setBounds(60, 400, 80, 30);
		trueButton.setForeground(Color.black);
		trueButton.setFont(new Font("Serif", Font.BOLD, 20));
		resubmitButton.setBounds(150, 400, 130, 30);
		resubmitButton.setForeground(Color.black);
		resubmitButton.setFont(new Font("Serif", Font.BOLD, 20));

		// 按鈕事件設定
		trueButton.addActionListener(new RegisterListener());
		resubmitButton.addActionListener(new RegisterListener());

		// 視窗顯示設定
		registerFrame.setVisible(true);

	}

	class RegisterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = usernameText.getText();
			String password = new String(passwordText.getPassword());
			String againpassword = new String(againpasswordText.getPassword());

			if (e.getSource() == trueButton) {// 按註冊
				
				if (password.equals(againpassword)) {//判斷密碼跟再次輸入的是否一樣

					try {
						Class.forName("com.mysql.cj.jdbc.Driver"); // 連結 MySQL 驅動程式
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb",
								"javadb", "123456");
						Statement stmt = con.createStatement();// 產生 SQL 敘述物件
						ResultSet rs = stmt.executeQuery("select name,password from javadb.gameuser;");// 下達 SQL 命令
						boolean userIsTrue = true;

						while (rs.next()) { // 擷取下一筆紀錄

							if (rs.getString("name").equals(username)) {// 已註冊過使其重新輸入
								errorLabel.setVisible(true);
								errorLabel.setText("帳號已註冊");
								userIsTrue = false;
								break;
							}
						}
						if (userIsTrue) {// 使用者註冊輸入資料庫							
							stmt.executeUpdate("insert into javadb.gameuser(name,password) values ('" + username
									+ "','" + password + "')");
							registerFrame.dispose();//頁面先關閉在跳轉
							new GameMainPage();
							
						}

						con.close();

					} catch (Exception e1) {
						System.out.println(e1);
					}
					
					
				} else {
					errorLabel.setVisible(true);
					errorLabel.setText("再次輸入密碼錯誤");
				}

			} else {// 重新輸入
				usernameText.setText("");
				passwordText.setText("");
				againpasswordText.setText("");
			}
		}// 按鈕方法結束

	}// 按鈕事件結束

}// 註冊視窗結束
