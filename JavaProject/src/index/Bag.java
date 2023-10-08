package index;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

// 背包背景
class bagBackground extends JPanel {
	public bagBackground() {
        setOpaque(false); // 設定為透明
    }
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(105, 105, 105, 125)); // 設定透明背景顏色
        g.fillRect(0, 100, getWidth(), 480); // 填充整個面板
    }
}

public class Bag{
// 定義並初始化變數
	private static JFrame bagFrame;
	
	private static Bag instance;
	
	private Bag() {
		setBag();
		bagFrame.setVisible(true);
	}
	
	public static Bag getInstance() {
        if (instance == null) {
            instance = new Bag();
        }
        else {
        	bagFrame.setVisible(true);
        }
        return instance;
    }
	

	JButton exitbutton = new JButton(new ImageIcon(System.getProperty("user.dir") + "\\image\\exit.png"));// 離開按鈕
	// 添加背景
	ImageIcon originalBackgroundImageIcon = new ImageIcon("image/background.jpg");
	Image Background_icon = originalBackgroundImageIcon.getImage().getScaledInstance(400, 700, Image.SCALE_SMOOTH);
	JPanel backgroundPanel = new JPanel() {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (Background_icon != null) {
				g.drawImage(Background_icon, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
	};
	
	// 創建背包背景
	bagBackground bag_backgroundPanel = new bagBackground();
	
	
	// 背包圖示
	ImageIcon Bag_icon = new ImageIcon("image/mybag.png");
	Image scaled_Bag_icon = Bag_icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
	ImageIcon bag_icon = new ImageIcon(scaled_Bag_icon);
	JLabel bag_label = new JLabel(bag_icon);
	
	// 創建裝備圖片
	static int Width = 100;
	static int Height = 100;
	
	// 斧頭
	static ImageIcon Axe_icon = new ImageIcon("image/items/axe.jpg");
	static Image scaled_Axe_icon = Axe_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	static ImageIcon axe_icon = new ImageIcon(scaled_Axe_icon);
	
	// 藍色魔杖
	static ImageIcon BlueMagicStick_icon = new ImageIcon("image/items/bluemagicStick.jpg");
	static Image scaled_BlueMagicStick_icon = BlueMagicStick_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	static ImageIcon blueMagicStick_icon = new ImageIcon(scaled_BlueMagicStick_icon);
	
	// 魔法書
	static ImageIcon MagicBook_icon = new ImageIcon("image/items/magicBook.jpg");
	static Image scaled_MagicBook_icon = MagicBook_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	static ImageIcon magicBook_icon = new ImageIcon(scaled_MagicBook_icon);
	
	// 魔法杖
	static ImageIcon MagicStick_icon = new ImageIcon("image/items/magicStick.jpg");
	static Image scaled_MagicStick_icon = MagicStick_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	static ImageIcon magicStick_icon = new ImageIcon(scaled_MagicStick_icon);
	
	// 紫劍
	static ImageIcon PurpleSword_icon = new ImageIcon("image/items/purpleSword.jpg");
	static Image scaled_PurpleSword_icon = PurpleSword_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	static ImageIcon purpleSword_icon = new ImageIcon(scaled_PurpleSword_icon);
	
	// 劍
	static ImageIcon Sword_icon = new ImageIcon("image/items/sword.jpg");
	static Image scaled_Sword_icon = Sword_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	static ImageIcon sword_icon = new ImageIcon(scaled_Sword_icon);
	
	// 創建裝備按鈕
	static JButton Axe_button = new JButton(axe_icon);
	static JButton BlueMagicStick_button = new JButton(blueMagicStick_icon);
	static JButton MagicBook_button = new JButton(magicBook_icon);
	static JButton MagicStick_button = new JButton(magicStick_icon);
	static JButton PurpleSword_button = new JButton(purpleSword_icon);
	static JButton Sword_button = new JButton(sword_icon);
	
	JButton[] buttons = {Axe_button, BlueMagicStick_button, MagicBook_button, 
			MagicStick_button, PurpleSword_button, Sword_button};
	
	// 定義並初始化字體
	Font buttonFont = new Font("Microsoft YaHei", Font.BOLD, 15);
	Font itemFont = new Font("STXinwei", Font.BOLD | Font.ITALIC, 20);
		
	// 創建裝備按鈕的圖片
	ImageIcon Equip_icon = new ImageIcon("image/items/gameButton.png");
	Image scaled_equip_icon = Equip_icon.getImage().getScaledInstance(75, 25, Image.SCALE_SMOOTH);
	ImageIcon equip_icon = new ImageIcon(scaled_equip_icon);
	
	// 定義並初始化AtomicInteger作為計數器, 判斷哪個道具被點選裝備
	final AtomicInteger button_num = new AtomicInteger(0); 
	
	// 定義並初始化按鈕
	JButton[] equipButtons = new JButton[6];
	JButton[] removeButtons = new JButton[6];
	
	// 定義並初始化道具是否已被裝備的變數
	AtomicBoolean[] isEquippedBooleans = new AtomicBoolean[6];
	AtomicBoolean[] removeBooleans = new AtomicBoolean[6];
	
	void setEquipButtonsEnableFalse() {
		equipButtons[0].setEnabled(false);
		equipButtons[1].setEnabled(false);
		equipButtons[2].setEnabled(false);
		equipButtons[3].setEnabled(false);
		equipButtons[4].setEnabled(false);
		equipButtons[5].setEnabled(false);
	}
	
	void setEquipButtonsEnableTrue() {
		equipButtons[0].setEnabled(true);
		equipButtons[1].setEnabled(true);
		equipButtons[2].setEnabled(true);
		equipButtons[3].setEnabled(true);
		equipButtons[4].setEnabled(true);
		equipButtons[5].setEnabled(true);
	}
	
	public void setBag() {
// 初始化並設置
		// 設置bagFrame
		bagFrame = new JFrame();
		bagFrame.setResizable(false);
		bagFrame.setSize(400, 700);
		bagFrame.add(backgroundPanel);
		
		// 設置backgroundPanel
		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(exitbutton);
		backgroundPanel.add(bag_label);
		backgroundPanel.add(bag_backgroundPanel);
		
		// 設置背包頁面上方顯示的背包圖案label
		bag_label.setBounds(200, 25, 100, 100);

		
		
		// 初始化裝備, 卸下, 替換按鈕, 還有是否裝備的boolean
		for (int i = 0; i < 6; i++) {
			equipButtons[i] = new JButton("裝備", equip_icon);
			removeButtons[i] = new JButton("卸下", equip_icon);

			// 設定裝備按鈕字體及顏色        		
			equipButtons[i].setFont(buttonFont);
			equipButtons[i].setForeground(Color.WHITE);
			removeButtons[i].setFont(buttonFont);
			removeButtons[i].setForeground(Color.WHITE);
	    	
			// 設定裝備按鈕背景移除
			equipButtons[i].setOpaque(false);
			equipButtons[i].setBackground(new Color(0, 0, 0, 0));
			equipButtons[i].setBorder(null);
			equipButtons[i].setFocusPainted(false);
			removeButtons[i].setOpaque(false);
			removeButtons[i].setBackground(new Color(0, 0, 0, 0));
			removeButtons[i].setBorder(null);
			removeButtons[i].setFocusPainted(false);
	    	
	    	// 設定裝備按鈕的文字在圖片的前面
			equipButtons[i].setVerticalTextPosition(SwingConstants.CENTER);
			equipButtons[i].setHorizontalTextPosition(SwingConstants.CENTER);
	    	removeButtons[i].setVerticalTextPosition(SwingConstants.CENTER);
	    	removeButtons[i].setHorizontalTextPosition(SwingConstants.CENTER);
	    	
	    	// 設置是否裝備boolean
	    	isEquippedBooleans[i] = new AtomicBoolean(true);
	    	removeBooleans[i] = new AtomicBoolean(true);
		}
		
		// 首頁按鈕外觀設置
		exitbutton.setBounds(10, 10, 60, 60);
		exitbutton.setOpaque(false);
		exitbutton.setBackground(new Color(0, 0, 0, 0));
		exitbutton.setBorder(null);
		exitbutton.setFocusPainted(false);
		
		// bag_backgroundPanel的按鈕佈局
		bag_backgroundPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(0, 10, 100, 10);
        gbc1.gridx = 0;
        gbc1.gridy = 0;      
        
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.insets = new Insets(0, 10, 100, 10);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
		
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(0, 10, 100, 10);
        gbc3.gridx = 2;
        gbc3.gridy = 0;
        
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 1;
        
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 1;
        gbc5.gridy = 1;
        
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 2;
        gbc6.gridy = 1;
        
        // 將按鈕加入bag_backgroundPanel
		bag_backgroundPanel.add(Axe_button, gbc1);
		bag_backgroundPanel.add(BlueMagicStick_button, gbc2);
		bag_backgroundPanel.add(MagicBook_button, gbc3);
		bag_backgroundPanel.add(MagicStick_button, gbc4);
		bag_backgroundPanel.add(PurpleSword_button, gbc5);
		bag_backgroundPanel.add(Sword_button, gbc6);
		
			
		
		
		// 滑鼠進入離開效果
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JButton sourceButton = (JButton) e.getSource();
				sourceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton sourceButton = (JButton) e.getSource();
				sourceButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		};
			
		// 添加所有裝備按鈕事件
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 創建JDialog
				JDialog customDialog = new JDialog(bagFrame, "", true);
				customDialog.setResizable(false);
				
				// 定義並初始化dialog被創建的位置
				int x = bagFrame.getX() + (bagFrame.getWidth() - customDialog.getWidth() - 200) / 2;
				int y = bagFrame.getY() + (bagFrame.getHeight() - customDialog.getHeight() - 200) / 2;

				JPanel dialogPanel = new JPanel();
				dialogPanel.setLayout(new GridBagLayout());
				GridBagConstraints gbc1 = new GridBagConstraints();
				gbc1.insets = new Insets(10, 0, 10, 0);
				gbc1.gridx = 0;
				gbc1.gridy = 1;
				gbc2.insets = new Insets(10, 0, 10, 0);
				gbc2.gridx = 1;
				gbc2.gridy = 1;
				gbc3.insets = new Insets(10, 0, 10, 0);
				gbc3.gridx = 0;
				gbc3.gridy = 0;
				gbc4.insets = new Insets(0, 10, 10, 0);
				gbc4.gridx = 1;
				gbc4.gridy = 0;
				
// 設定裝備頁按鈕活動
			// 設置每個道具顯示的dialog
				ImageIcon itemIcon = null;
				String itemNameString = "";
				String itemStatusString = "";

				// 所有道具按鈕事件判斷 // 想辦法在這邊寫 每個按鈕加的裝備按鈕不一樣
				if (e.getSource() == exitbutton) {
					bagFrame.dispose();
					GameMainPage Mainpage = new GameMainPage();
					Mainpage.frame.setVisible(true);
				} else if (e.getSource() == Axe_button) {
					itemIcon = axe_icon;
					itemNameString = "屠戮之斧";
					itemStatusString = "ATTACK +10";
					dialogPanel.add(equipButtons[0], gbc1);
					dialogPanel.add(removeButtons[0], gbc2);
					button_num.set(1);
				} else if (e.getSource() == BlueMagicStick_button) {
					itemIcon = blueMagicStick_icon;
					itemNameString = "幽冥法杖";
					itemStatusString = "ATTACK +10";
					dialogPanel.add(equipButtons[1], gbc1);
					dialogPanel.add(removeButtons[1], gbc2);
					button_num.set(2);
				} else if (e.getSource() == MagicBook_button) {
					itemIcon = magicBook_icon;
					itemNameString = "秘咒之典";
					itemStatusString = "ATTACK +10";
					dialogPanel.add(equipButtons[2], gbc1);
					dialogPanel.add(removeButtons[2], gbc2);
					button_num.set(3);
				} else if (e.getSource() == MagicStick_button) {
					itemIcon = magicStick_icon;
					itemNameString = "日炬之杖";
					itemStatusString = "ATTACK +10";
					dialogPanel.add(equipButtons[3], gbc1);
					dialogPanel.add(removeButtons[3], gbc2);
					button_num.set(4);
				} else if (e.getSource() == PurpleSword_button) {
					itemIcon = purpleSword_icon;
					itemNameString = "碎魂之刃";
					itemStatusString = "ATTACK +10";
					dialogPanel.add(equipButtons[4], gbc1);
					dialogPanel.add(removeButtons[4], gbc2);
					button_num.set(5);
				} else if (e.getSource() == Sword_button) {
					itemIcon = sword_icon;
					itemNameString = "焰心之刃";
					itemStatusString = "ATTACK +10";
					dialogPanel.add(equipButtons[5], gbc1);
					dialogPanel.add(removeButtons[5], gbc2);
					button_num.set(6);
				}

				if (itemIcon != null) {
					JLabel itemIconLabel = new JLabel(itemIcon);

					JLabel itemNameLabel = new JLabel(itemNameString);
					itemNameLabel.setFont(itemFont);
					itemNameLabel.setForeground(new Color(0x03D79));

					JLabel itemStatusLabel = new JLabel(itemStatusString);
					itemStatusLabel.setFont(buttonFont);
					itemStatusLabel.setForeground(Color.RED);

					JPanel LabelPanel = new JPanel();
					LabelPanel.setLayout(new BoxLayout(LabelPanel, BoxLayout.Y_AXIS));
					
					LabelPanel.add(itemNameLabel);
					LabelPanel.add(Box.createVerticalStrut(20));
					LabelPanel.add(itemStatusLabel);
					dialogPanel.add(itemIconLabel, gbc3);
					dialogPanel.add(LabelPanel, gbc4);			
				}
				final AtomicInteger i;
				final AtomicInteger z;
				
				// 所有裝備卸下按鈕事件判斷
				for (i = new AtomicInteger(0); i.get() < 6; i.incrementAndGet()) {
					equipButtons[i.get()].addActionListener(closeEvent -> {
						customDialog.dispose();
						switch (button_num.get()) {

						case 1:
							Axe_button.setText("已裝備");
							hero.swordsman_attack += 10;
							GameFloor.attacklabel.setText("" + hero.swordsman_attack);
							setEquipButtonsEnableFalse();
							break;
						case 2:
							BlueMagicStick_button.setText("已裝備");
							hero.mage_attack += 10;
							GameFloor.attacklabel.setText("" + hero.mage_attack);
							setEquipButtonsEnableFalse();
							break;
						case 3:
							MagicBook_button.setText("已裝備");
							hero.mage_attack += 10;
							GameFloor.attacklabel.setText("" + hero.mage_attack);
							setEquipButtonsEnableFalse();
							break;
						case 4:
							MagicStick_button.setText("已裝備");
							hero.mage_attack += 10;
							GameFloor.attacklabel.setText("" + hero.mage_attack);
							setEquipButtonsEnableFalse();
							break;
						case 5:
							PurpleSword_button.setText("已裝備");
							hero.swordsman_attack += 10;
							GameFloor.attacklabel.setText("" + hero.swordsman_attack);
							setEquipButtonsEnableFalse();
							break;
						case 6:
							Sword_button.setText("已裝備");
							hero.swordsman_attack += 10;
							GameFloor.attacklabel.setText("" + hero.swordsman_attack);
							setEquipButtonsEnableFalse();
							break;
						}
					});
					removeButtons[i.get()].setEnabled(false); // 把每個卸下按鈕都設定為無法被按
				}
				
				// 將已裝備的道具的卸下按鈕設為Enable
				for (int h = 0; h <6; h++) {
					if (buttons[h].getText() == "已裝備") {
						removeButtons[h].setEnabled(true);
					}
				}
				
				for (z = new AtomicInteger(0); z.get() < 6; z.incrementAndGet()) {
					removeButtons[z.get()].addActionListener(closeEvent -> {
						switch (button_num.get()) {
						case 1:
							Axe_button.setText("");
							hero.swordsman_attack = 50;
							hero.mage_attack = 80;
							setEquipButtonsEnableTrue();
							break;
						case 2:
							BlueMagicStick_button.setText("");
							hero.swordsman_attack = 50;
							hero.mage_attack = 80;
							setEquipButtonsEnableTrue();
							break;
						case 3:
							MagicBook_button.setText("");
							hero.swordsman_attack = 50;
							hero.mage_attack = 80;
							setEquipButtonsEnableTrue();
							break;
						case 4:
							MagicStick_button.setText("");
							hero.swordsman_attack = 50;
							hero.mage_attack = 80;
							setEquipButtonsEnableTrue();
							break;
						case 5:
							PurpleSword_button.setText("");
							hero.swordsman_attack = 50;
							hero.mage_attack = 80;
							setEquipButtonsEnableTrue();
							break;
						case 6:
							Sword_button.setText("");
							hero.swordsman_attack = 50;
							hero.mage_attack = 80;
							setEquipButtonsEnableTrue();
							break;
						}
					
						button_num.set(0); //每次點選按鈕都會重置數字為0, 解決裝備按鈕點擊取消後再點擊其他裝備按鈕裝備，所有按鈕都會被標示已裝備。
						customDialog.dispose(); // 關閉對話框
					});
				}
				
				
				
				
				
				for (JButton button : buttons) {
					if (e.getSource() == button) {
						customDialog.setLocation(x, y);
						customDialog.setSize(250, 225);
						customDialog.setIconImage(scaled_Axe_icon);
						customDialog.add(dialogPanel);
						customDialog.setVisible(true); // 顯示對話框
						break;

					}

				}

			}
		};
		exitbutton.addActionListener(actionListener);

		// 所有裝備按鈕的共同設置
		for (JButton button : buttons) {

			// 加入滑鼠效果
			button.addMouseListener(mouseAdapter);

			// 調整裝備按鈕圖片位置
			button.setFont(buttonFont);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setBackground(Color.white);
			button.setBorder(null);
			button.setFocusPainted(false);

			// 加入按鈕事件
			button.addActionListener(actionListener);
		}

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - bagFrame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - bagFrame.getHeight()) / 2);
		bagFrame.setLocation(centerX, centerY);

		bagFrame.addWindowListener(new WindowAdapter() {// 用匿名類別設定window事件將視窗關閉
			public void windowClosing(WindowEvent event) {// 視窗關閉開啟主視窗
				bagFrame.dispose();
				GameMainPage i = new GameMainPage();
				i.frame.setVisible(true);
			}
		});
	}
}
