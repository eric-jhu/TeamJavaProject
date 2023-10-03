package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFloor {

	JFrame gamefloorFrame = new JFrame("");

	// 對話框區域
	Dialog nokeyDialog = new Dialog(gamefloorFrame, "沒有鑰匙");// 沒有鑰匙提示
	JLabel nokeyLabel = new JLabel("請先蒐集鑰匙");// 沒有鑰匙
	JButton okButton = new JButton("好的");// 沒有鑰匙按鈕

	JButton[][] surfacelayerfloor = new JButton[4][4];// 表層地板
	JButton[][] innerlayerfloor = new JButton[4][4];// 裏層地板
	Random ran = new Random();// 亂數產生器 產生不同地板

	JButton exitbutton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\exit.png"));// 離開按鈕

	// 魔法師
	ImageIcon Mage_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\mage.jpg");
	ImageIcon mage_icon = new ImageIcon(Mage_icon.getImage().getScaledInstance(80, 135, Image.SCALE_SMOOTH));
	// 劍士
	ImageIcon Swordsman_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\swordsman.jpg");
	ImageIcon swordsman_icon = new ImageIcon(Swordsman_icon.getImage().getScaledInstance(80, 135, Image.SCALE_SMOOTH));

	// 怪物1
	ImageIcon Monster01_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\monster01.jpg");
	ImageIcon monster01_icon = new ImageIcon(Monster01_icon.getImage().getScaledInstance(370, 370, Image.SCALE_SMOOTH));
	// 怪物2
	ImageIcon Monster02_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\monster02.jpg");
	ImageIcon monster02_icon = new ImageIcon(Monster02_icon.getImage().getScaledInstance(370, 370, Image.SCALE_SMOOTH));
	// 怪物3
	ImageIcon Monster03_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\monster03.jpg");
	ImageIcon monster03_icon = new ImageIcon(Monster03_icon.getImage().getScaledInstance(370, 370, Image.SCALE_SMOOTH));

	JButton rolebutton = new JButton();// 角色按鈕

	JButton battlebutton = new JButton();// 按倒怪物按鈕時,做戰鬥用

	// 物品背包按鈕圖片設定

	ImageIcon Itembackpack_icon = new ImageIcon(System.getProperty("user.dir") + "\\image\\bag.png");
	Image scaled_Itembackpack_icon = Itembackpack_icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
	ImageIcon itembackpack_icon = new ImageIcon(scaled_Itembackpack_icon);
	JButton itembackpackbutton = new JButton(itembackpack_icon);// 物品背包按鈕

	JButton magicbackpackbutton = new JButton(
			new ImageIcon(System.getProperty("user.dir") + "\\image\\magicbackpac.jpg"));// 魔法背包按鈕

	JLabel floorlabel = new JLabel();// 樓層
	static JLabel hplabel = new JLabel("90");// 生命值
	static JLabel attacklabel = new JLabel("50");// 攻擊力
	// JLabel magiclabel = new JLabel();// 魔力
	// JLabel magicalvaluelabel = new JLabel("第一層");// 魔法量
	JLabel backgroundlabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\image\\framebackground.jpg"));// 大背景
	// 在當前工作目錄下取得我資料夾的照片,方便之後資料夾移動

	// 圖庫陣列 每層隨機從裡面抽取放置
	String[][] innerlayersetting = {
			{ "innerlayerfloor.jpg", "innerlayerfloor.jpg", "innerlayerfloor.jpg", "innerlayerfloor.jpg" },
			{ "innerlayerfloor.jpg", "innerlayerfloor.jpg", "innerlayerfloor.jpg", "innerlayerfloor.jpg" },
			{ "door.jpg", "hpadd.jpg", "key.jpg", "innerlayerfloor.jpg" },
			{ "monster01.jpg", "monster02.jpg", "monster03.jpg", "monster03.jpg" } };

	static boolean havakey = false;// 是否持有鑰匙
	static int floor = 1;// 當前樓層

	GameFloor() {// 建構子
		setgamefloorFrame();
	}

	private void setgamefloorFrame() {// 版面設定 所有東西都放在背景圖片之上
		// frame大小設定
		gamefloorFrame.setSize(400, 700);
		gamefloorFrame.setVisible(true);
		gamefloorFrame.setResizable(false);
		gamefloorFrame.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				floor = 1;
				gamefloorFrame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}
		});

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - gamefloorFrame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - gamefloorFrame.getHeight()) / 2);
		gamefloorFrame.setLocation(centerX, centerY);

		gamefloorFrame.setLayout(new BorderLayout());
		gamefloorFrame.add(backgroundlabel);// 背景圖加入佔住整個版面

		backgroundlabel.setLayout(null);

		// 放在背景裡面
		backgroundlabel.add(floorlabel);
		backgroundlabel.add(exitbutton);
		backgroundlabel.add(rolebutton);
		backgroundlabel.add(itembackpackbutton);
		backgroundlabel.add(magicbackpackbutton);
		backgroundlabel.add(hplabel);
		backgroundlabel.add(attacklabel);
		backgroundlabel.add(battlebutton);
		battlebutton.setVisible(false);
		// backgroundlabel.add(magiclabel);
		// backgroundlabel.add(magicalvaluelabel);
		exitbutton.setOpaque(false);
		exitbutton.setBackground(new Color(0, 0, 0, 0));
		exitbutton.setBorder(null);
		exitbutton.setFocusPainted(false);

		// 加入表層按鈕
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				surfacelayerfloor[i][j] = new JButton(new ImageIcon(
						System.getProperty("user.dir") + "\\image\\surfacelayerfloor" + (ran.nextInt(3) + 1) + ".jpg"));
				backgroundlabel.add(surfacelayerfloor[i][j]);
			}
		}

		// 亂數交換樓層圖片 使每一層出現東西在不同位置
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = ran.nextInt(4);
				int y = ran.nextInt(4);
				String chang;
				chang = innerlayersetting[x][y];
				innerlayersetting[x][y] = innerlayersetting[j][y];
				innerlayersetting[j][y] = chang;
			}
		}

		// 加入裏層按鈕
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				innerlayerfloor[i][j] = new JButton(
						new ImageIcon(System.getProperty("user.dir") + "\\image\\" + innerlayersetting[i][j]));
				innerlayerfloor[i][j].setVisible(false);
				backgroundlabel.add(innerlayerfloor[i][j]);
			}
		}

		// 位置設定
		exitbutton.setBounds(10, 10, 60, 60);// 離開按鈕
		floorlabel.setBounds(160, 30, 80, 30);// 樓層
		floorlabel.setText("第" + floor + "層");
		floorlabel.setForeground(Color.WHITE);// 樓層顏色
		floorlabel.setFont(new Font("Serif", Font.BOLD, 25));// 樓層字形大小
		itembackpackbutton.setBounds(15, 575, 75, 75);// 物品背包
		magicbackpackbutton.setBounds(300, 575, 75, 75);// 魔法卷背包
		attacklabel.setBounds(118, 590, 50, 30);// 攻擊值
		attacklabel.setForeground(Color.WHITE);
		attacklabel.setFont(new Font("Serif", Font.BOLD, 20));
		hplabel.setBounds(118, 550, 50, 30);// hp值
		hplabel.setForeground(Color.RED);
		hplabel.setFont(new Font("Serif", Font.BOLD, 20));
		rolebutton.setBounds(150, 515, 80, 135);// 角色按鈕
		battlebutton.setBounds(8, 100, 370, 370);

		if (RolePage.gotowarrole().equals("mage_icon")) {
			rolebutton.setIcon(mage_icon);
		} else {
			rolebutton.setIcon(swordsman_icon);
		}

		// 表層按鈕設定
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				surfacelayerfloor[i][j].setBounds(8 + (j * 93), 100 + (i * 93), 91, 91);
			}
		}
		// 裏層按鈕設定
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				innerlayerfloor[i][j].setBounds(8 + (j * 93), 100 + (i * 93), 91, 91);
			}
		}

		// 按鈕事件設定
		battlebutton.addActionListener(new GameFloorListener());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				surfacelayerfloor[i][j].addActionListener(new GameFloorListener());
				innerlayerfloor[i][j].addActionListener(new GameFloorListener());
			}
		}

		exitbutton.addActionListener(new GameFloorListener());

	}// 設定版面結束

	private void setnokeyDialog() {// 沒有鑰匙提示

		nokeyDialog.setSize(300, 150);// 離開對話窗大小
		nokeyDialog.setLayout(null);// 不設版面
		nokeyDialog.setModal(true);

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - nokeyDialog.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - nokeyDialog.getHeight()) / 2);
		nokeyDialog.setLocation(centerX, centerY);

		// 加入到視窗
		nokeyDialog.add(nokeyLabel);
		nokeyDialog.add(okButton);

		// 位置大小設定
		nokeyLabel.setBounds(80, 50, 150, 30);
		nokeyLabel.setFont(new Font("Serif", Font.BOLD, 20));
		okButton.setBounds(80, 100, 150, 30);
		okButton.setFont(new Font("Serif", Font.BOLD, 20));

		// 按鈕事件
		okButton.addActionListener(new GameFloorListener());

		nokeyDialog.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將彈出視窗關閉
			public void windowClosing(WindowEvent event) {
				nokeyDialog.dispose();
			}
		});

		nokeyDialog.setVisible(true);// 呼叫顯示
	}

	// 按鈕事件設定
	class GameFloorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			Icon icontostr;
			String str;

			for (int i = 0; i < 4; i++) {// 表層按鈕事件
				for (int j = 0; j < 4; j++) {
					if (e.getSource() == surfacelayerfloor[i][j]) {// 看按哪個按鈕
						surfacelayerfloor[i][j].setVisible(false);
						innerlayerfloor[i][j].setVisible(true);
					}
				}
			}

			for (int i = 0; i < 4; i++) {// 裏層按鈕事件
				for (int j = 0; j < 4; j++) {

					icontostr = innerlayerfloor[i][j].getIcon();
					str = icontostr.toString();
					str = str.replaceAll(".*?image.?", "");
					System.out.println(str);
					if (e.getSource() == innerlayerfloor[i][j] && str.equals("door.jpg")) {// 按門按鈕
						if (havakey) {
							havakey = false;
							floor++;
							gamefloorFrame.dispose();
							new GameFloor();
						} else {
							setnokeyDialog();
						}
					}
					if (e.getSource() == innerlayerfloor[i][j] && str.equals("key.jpg")) {// 按鑰匙按鈕
						havakey = true;
						// 蒐集到鑰匙改變圖案
						innerlayerfloor[i][j].setIcon(
								new ImageIcon(System.getProperty("user.dir") + "\\image\\innerlayerfloor.jpg"));

					}

					if (e.getSource() == innerlayerfloor[i][j] && str.equals("hpadd.jpg")) {// 按血瓶

						int nowhp = Integer.parseInt(hplabel.getText());
						int newhp = nowhp + 10;
						hplabel.setText("" + newhp);

						// 按血瓶改變圖案
						innerlayerfloor[i][j].setIcon(
								new ImageIcon(System.getProperty("user.dir") + "\\image\\innerlayerfloor.jpg"));
					}
					if (e.getSource() == innerlayerfloor[i][j] && str.equals("monster01.jpg")) {// 按怪物1

						battlebutton.setVisible(true);
						battlebutton.setIcon(monster01_icon);

						// 按怪物改變圖案
						innerlayerfloor[i][j].setIcon(
								new ImageIcon(System.getProperty("user.dir") + "\\image\\innerlayerfloor.jpg"));
					}
					if (e.getSource() == innerlayerfloor[i][j] && str.equals("monster02.jpg")) {// 按怪物2

						battlebutton.setVisible(true);
						battlebutton.setIcon(monster02_icon);
						// 按怪物改變圖案
						innerlayerfloor[i][j].setIcon(
								new ImageIcon(System.getProperty("user.dir") + "\\image\\innerlayerfloor.jpg"));
					}
					if (e.getSource() == innerlayerfloor[i][j] && str.equals("monster03.jpg")) {// 按怪物3

						battlebutton.setVisible(true);
						battlebutton.setIcon(monster03_icon);
						// 按怪物改變圖案
						innerlayerfloor[i][j].setIcon(
								new ImageIcon(System.getProperty("user.dir") + "\\image\\innerlayerfloor.jpg"));
					}

				}
			} // 裏層按鈕事件

			if (e.getSource() == battlebutton) {// 戰鬥按鈕

				// 機率閃避
				int nowhp = Integer.parseInt(hplabel.getText());
				// 加入被動技能:20%機率閃避
				double dodge = Math.random();
				dodge *= 101;
				if (dodge > 80) {
					int newhp = nowhp;
					hplabel.setText("" + newhp);
				} else {
					int newhp = nowhp - 10;
					hplabel.setText("" + newhp);
				}
				
				battlebutton.setVisible(false);
			}

			if (e.getSource() == exitbutton) {// 離開按鈕事件
				floor = 1;
				gamefloorFrame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}

			if (e.getSource() == okButton) { // 未撿鑰匙確認鈕
				nokeyDialog.setVisible(false);
			}

		}

	}// 按鈕事件設定結束

}
