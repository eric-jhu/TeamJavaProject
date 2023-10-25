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


public class LoginPage {
	
	JFrame loginFrame = new JFrame("登入視窗");//大視窗	
	//Container loginCon = loginFrame.getContentPane();
	
	//顯示文字
	JLabel loginHeadLabel = new JLabel("登入~~");
	JLabel usernameLabel = new JLabel("帳號:");
	JLabel passwordLabel = new JLabel("密碼:");
	JLabel errorLabel = new JLabel("帳號密碼輸入錯誤");
	//使用者輸入帳密
	JTextField usernameText = new JTextField();
	JPasswordField passwordText = new JPasswordField();
	//登入及重新輸入按鈕X返回主視窗
	JButton trueButton = new JButton("登入");
	JButton resubmitButton = new JButton("重新輸入");
	
	JLabel backgroundlabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\image\\framebackground.jpg"));// 大背景
	
	
	LoginPage(){//建構子
		setLoginFrame();
	}
	

	private void setLoginFrame() {//版面設定
		
		loginFrame.setSize(400, 700);// 視窗大小
		loginFrame.setResizable(false);
		loginFrame.addWindowListener(new WindowAdapter() {//用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {//視窗關閉開啟主視窗
				loginFrame.dispose();
				IndexPage i = new IndexPage();
				i.indexFrame.setVisible(true);
				}});
		loginFrame.setLayout(new BorderLayout());
		
		
		// 將 JFrame 設定為在視窗中央顯示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - loginFrame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - loginFrame.getHeight()) / 2);
        loginFrame.setLocation(centerX, centerY);
		
		loginFrame.add(backgroundlabel);// 背景圖加入佔住整個版面

		backgroundlabel.setLayout(null);

		// 加到視窗
		backgroundlabel.add(loginHeadLabel);
		backgroundlabel.add(usernameLabel);
		backgroundlabel.add(passwordLabel);
		backgroundlabel.add(usernameText);
		backgroundlabel.add(passwordText);
		backgroundlabel.add(errorLabel);
		errorLabel.setVisible(false);
		backgroundlabel.add(trueButton);
		backgroundlabel.add(resubmitButton);
		

		// 位置設定
		loginHeadLabel.setBounds(150, 100, 100, 30);
		loginHeadLabel.setForeground(Color.WHITE);
		loginHeadLabel.setFont(new Font("Serif", Font.BOLD, 25));
		usernameLabel.setBounds(70, 200, 50, 30);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
		passwordLabel.setBounds(70, 300, 50, 30);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Serif", Font.BOLD, 20));
		usernameText.setBounds(150, 200, 160, 30);
		usernameText.setFont(new Font("Serif", Font.BOLD, 20));
		passwordText.setBounds(150, 300, 160, 30);
		passwordText.setFont(new Font("Serif", Font.BOLD, 20));
		errorLabel.setBounds(70, 350, 200, 30);
		errorLabel.setForeground(Color.white);
		errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
		trueButton.setBounds(60, 400, 80, 30);
		trueButton.setForeground(Color.black);
		trueButton.setFont(new Font("Serif", Font.BOLD, 20));
		resubmitButton.setBounds(150, 400, 140, 30);
		resubmitButton.setForeground(Color.black);
		resubmitButton.setFont(new Font("Serif", Font.BOLD, 20));

		// 按鈕事件設定
		trueButton.addActionListener(new LoginListener());
		resubmitButton.addActionListener(new LoginListener());
		
		// 視窗顯示設定
		loginFrame.setVisible(true);
		
	}
	
	
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = usernameText.getText();
			String password = new String(passwordText.getPassword());
			boolean userIsTrue = false;
			
			if(e.getSource() == trueButton) {//按登入
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); // 連結 MySQL 驅動程式
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "javadb", "123456");
					Statement stmt = con.createStatement();// 產生 SQL 敘述物件
					ResultSet rs = stmt.executeQuery("select name,password from javadb.gameuser;");// 下達 SQL 命令
					
					
					while (rs.next()) { // 擷取下一筆紀錄
						
						if(rs.getString("name").equals(username) && rs.getString("password").equals(password)) {
							userIsTrue = true;
							loginFrame.dispose();//頁面先關閉在跳轉
							new GameMainPage();
							
							
							break;
						}
					}
					if(!userIsTrue) {//當使用者輸入錯誤清空資料並使其重新輸入
						usernameText.setText("");
						passwordText.setText("");
						errorLabel.setVisible(true);
					}
				
					con.close();
					
					

				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}else {//重新輸入
				usernameText.setText("");
				passwordText.setText("");
			}
		}//按鈕方法結束
	
	}//按鈕事件結束
}//登入視窗結束
