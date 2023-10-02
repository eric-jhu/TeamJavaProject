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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

// 背包背景
class bagBackground extends JPanel {
	public bagBackground() {
        setOpaque(false); // 設定為透明
//        setPreferredSize(new Dimension(400, 700));
    }
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(105, 105, 105, 125)); // 設定透明背景顏色
        g.fillRect(0, 100, getWidth(), 480); // 填充整個面板
    }
}

public class Bag{
	JFrame bagFrame = new JFrame("Bag");
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
	int Width = 100;
	int Height = 100;
	
	// 斧頭
	ImageIcon Axe_icon = new ImageIcon("image/items/axe.png");
	Image scaled_Axe_icon = Axe_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon axe_icon = new ImageIcon(scaled_Axe_icon);
	
	// 藍色魔杖
	ImageIcon BlueMagicStick_icon = new ImageIcon("image/items/bluemagicStick.png");
	Image scaled_BlueMagicStick_icon = BlueMagicStick_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon blueMagicStick_icon = new ImageIcon(scaled_BlueMagicStick_icon);
	
	// 魔法書
	ImageIcon MagicBook_icon = new ImageIcon("image/items/magicBook.png");
	Image scaled_MagicBook_icon = MagicBook_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon magicBook_icon = new ImageIcon(scaled_MagicBook_icon);
	
	// 魔法杖
	ImageIcon MagicStick_icon = new ImageIcon("image/items/magicStick.png");
	Image scaled_MagicStick_icon = MagicStick_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon magicStick_icon = new ImageIcon(scaled_MagicStick_icon);
	
	// 紫劍
	ImageIcon PurpleSword_icon = new ImageIcon("image/items/purpleSword.png");
	Image scaled_PurpleSword_icon = PurpleSword_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon purpleSword_icon = new ImageIcon(scaled_PurpleSword_icon);
	
	// 劍
	ImageIcon Sword_icon = new ImageIcon("image/items/sword.png");
	Image scaled_Sword_icon = Sword_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
	ImageIcon sword_icon = new ImageIcon(scaled_Sword_icon);
	
	// 創建裝備按鈕
	JButton Axe_button = new JButton("斧頭", axe_icon);
	JButton BlueMagicStick_button = new JButton("藍色魔杖", blueMagicStick_icon);
	JButton MagicBook_button = new JButton("魔法書", magicBook_icon);
	JButton MagicStick_button = new JButton("魔法杖", magicStick_icon);
	JButton PurpleSword_button = new JButton("紫劍", purpleSword_icon);
	JButton Sword_button = new JButton("劍", sword_icon);
	
	JButton[] buttons = {Axe_button, BlueMagicStick_button, MagicBook_button, 
			MagicStick_button, PurpleSword_button, Sword_button};
	
	
	
	public Bag() {
		setBag();
	}

	void setBag() {
		bagFrame.setResizable(false);
		bagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bagFrame.setSize(400, 700);
		bagFrame.setVisible(true);
		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - bagFrame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - bagFrame.getHeight()) / 2);
		bagFrame.setLocation(centerX, centerY);
	
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
        
		bag_backgroundPanel.add(Axe_button, gbc1);
		bag_backgroundPanel.add(BlueMagicStick_button, gbc2);
		bag_backgroundPanel.add(MagicBook_button, gbc3);
		bag_backgroundPanel.add(MagicStick_button, gbc4);
		bag_backgroundPanel.add(PurpleSword_button, gbc5);
		bag_backgroundPanel.add(Sword_button, gbc6);
		
		// 添加所有裝備按鈕事件
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JDialog customDialog = new JDialog(bagFrame, "", true);
            	
            	// 創建裝備按鈕的圖片
            	ImageIcon Equip_icon = new ImageIcon("image/items/gameButton.jpg");
            	Image scaled_equip_icon = Equip_icon.getImage().getScaledInstance(75, 25, Image.SCALE_SMOOTH);
            	ImageIcon equip_icon = new ImageIcon(scaled_equip_icon);
            	      	
            	// 是否裝備按鈕
            	JButton equipButton = new JButton("裝備", equip_icon); 
            	JButton cancelButton = new JButton("取消", equip_icon);
            	
            	// 設定按鈕文字
        		Font buttonFont = new Font("Microsoft YaHei", Font.BOLD, 15);
        		equipButton.setFont(buttonFont);
        		equipButton.setForeground(Color.WHITE);
        		cancelButton.setFont(buttonFont);
        		cancelButton.setForeground(Color.WHITE);
            	
            	// 按鈕背景移除
            	equipButton.setOpaque(false);
            	equipButton.setBackground(new Color(0, 0, 0, 0));
            	equipButton.setBorder(null);
            	equipButton.setFocusPainted(false);
            	cancelButton.setOpaque(false);
            	cancelButton.setBackground(new Color(0, 0, 0, 0));
            	cancelButton.setBorder(null);
            	cancelButton.setFocusPainted(false);
            	
            	// 設定文字在圖片的前面
            	equipButton.setVerticalTextPosition(SwingConstants.CENTER);
            	equipButton.setHorizontalTextPosition(SwingConstants.CENTER);
            	cancelButton.setVerticalTextPosition(SwingConstants.CENTER);
            	cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
            	
            	JPanel dialogPanel = new JPanel();
            	dialogPanel.setLayout(new GridBagLayout());
            	GridBagConstraints gbc1 = new GridBagConstraints();
        		gbc1.insets = new Insets(0, 0, 10, 0);
                gbc1.gridx = 0;
                gbc1.gridy = 1;
                gbc2.insets = new Insets(0, 0, 10, 0);
                gbc2.gridx = 1;
                gbc2.gridy = 1;
                gbc3.insets = new Insets(10, 0, 10, 0);
                gbc3.gridx = 0;
                gbc3.gridy = 0;
                
                // 裝備或取消按紐
                dialogPanel.add(equipButton, gbc1);
                dialogPanel.add(cancelButton, gbc2);
                
                equipButton.addActionListener(closeEvent -> {
                	// 這邊添加裝備後的程式碼. 角色加成攻擊力. 顯示按鈕已裝備
                    customDialog.dispose(); // 關閉對話框
                });
                
                cancelButton.addActionListener(closeEvent -> {
                    customDialog.dispose(); // 關閉對話框
                });
        		
                if (e.getSource() == exitbutton) { //回到遊戲主頁面
    				bagFrame.dispose();
    				GameMainPage Mainpage = new GameMainPage();
    				Mainpage.frame.setVisible(true);
    			}
                         
                else if (e.getSource() == Axe_button) {
                	JLabel axeLabel = new JLabel(axe_icon);
                	dialogPanel.add(axeLabel, gbc3);        		
                }
                else if (e.getSource() == BlueMagicStick_button) {
                	JLabel axeLabel = new JLabel(blueMagicStick_icon);
                	dialogPanel.add(axeLabel, gbc3);        		
                }
                else if (e.getSource() == MagicBook_button) {
                	JLabel axeLabel = new JLabel(magicBook_icon);
                	dialogPanel.add(axeLabel, gbc3);        		
                }
                else if (e.getSource() == MagicStick_button) {
                	JLabel axeLabel = new JLabel(magicStick_icon);
                	dialogPanel.add(axeLabel, gbc3);        		
                }
                else if (e.getSource() == PurpleSword_button) {
                	JLabel axeLabel = new JLabel(purpleSword_icon);
                	dialogPanel.add(axeLabel, gbc3);        		
                }
                else if (e.getSource() == Sword_button) {
                	JLabel axeLabel = new JLabel(sword_icon);
                	dialogPanel.add(axeLabel, gbc3);        		
                }
                
                for (JButton button:buttons) {
                    if (e.getSource() == button) {
                    	int x = bagFrame.getX() + (bagFrame.getWidth() - customDialog.getWidth()-200) / 2;
                        int y = bagFrame.getY() + (bagFrame.getHeight() - customDialog.getHeight()-200) / 2;
                        customDialog.setLocation(x, y);
                    	customDialog.setSize(200, 200);
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
		for (JButton button:buttons) {
			
			// 加入滑鼠效果
			button.addMouseListener(mouseAdapter);
			
			// 調整裝備按鈕圖片位置
			button.setVerticalTextPosition(SwingConstants.NORTH);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setBackground(Color.white);
			button.setBorder(null);
			button.setFocusPainted(false);
			
			// 加入按鈕事件
			button.addActionListener(actionListener);
		}	
		
		bag_label.setBounds(200, 0, 150, 150);		
		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(exitbutton);
		backgroundPanel.add(bag_label);
		backgroundPanel.add(bag_backgroundPanel);				
		bagFrame.add(backgroundPanel);
	}
}
