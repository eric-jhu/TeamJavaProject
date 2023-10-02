package index;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class FunctionFormPage {

	JFrame functionformFrame = new JFrame("作品集大廳");// 版面

	Container functionCon = functionformFrame.getContentPane();// 小版面

	JLabel headLabel = new JLabel("歡迎來到作品集~~");// 大標題
	
	JButton button2048 = new JButton("2048");
	
	FunctionFormPage() {// 建構子
		setfunctionFormFrame();
	}

	private void setfunctionFormFrame() {// 視窗版面設定 用封裝不讓人動設定
		functionformFrame.setSize(1000, 1000);// 視窗大小
		functionformFrame.addWindowListener(new WindowAdapter() {//用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {//視窗關閉開啟主視窗
				functionformFrame.dispose();
				IndexPage i = new IndexPage();
				i.indexFrame.setVisible(true);
				}});
		functionCon.setLayout(null);// 無版面

		// 加到視窗
		functionCon.add(headLabel);
		functionCon.add(button2048);

		// 位置設定
		headLabel.setBounds(450, 50, 150, 30);
		button2048.setBounds(50, 100, 80, 30);
		
		
		// 按鈕事件設定
		button2048.addActionListener(new FunctionformListener() );

		// 視窗顯示設定
		functionformFrame.setVisible(true);

	}
	
	public class FunctionformListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			
		}
		
	}
	
}
