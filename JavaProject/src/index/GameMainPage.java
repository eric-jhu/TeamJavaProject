package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GameMainPage {
	JFrame frame = new JFrame("無盡之塔");

	public GameMainPage() {
		setGameMainPage();
	}// 建構子結束

	private void setGameMainPage() {

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 700);

		// 將 JFrame 設定為在視窗中央顯示
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
		int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(centerX, centerY);

		// 創建按鈕圖片
		int Width = 70;
		int Height = 100;
		ImageIcon Shop_icon = new ImageIcon("image/shop.png");
		Image scaled_Shop_icon = Shop_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
		ImageIcon shop_icon = new ImageIcon(scaled_Shop_icon);

		ImageIcon Character_icon = new ImageIcon("image/character.png");
		Image scaled_Character_icon = Character_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
		ImageIcon character_icon = new ImageIcon(scaled_Character_icon);

		ImageIcon Bag_icon = new ImageIcon("image/bag.png");
		Image scaled_Bag_icon = Bag_icon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
		ImageIcon bag_icon = new ImageIcon(scaled_Bag_icon);

		ImageIcon Stage_icon = new ImageIcon("image/stage.png");
		Image scaled_Stage_icon = Stage_icon.getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH);
		ImageIcon stage_icon = new ImageIcon(scaled_Stage_icon);

		// 創建按鈕並調整圖片位置
		JButton shop_button = new JButton("商店", shop_icon);
		shop_button.setVerticalTextPosition(SwingConstants.NORTH);
		shop_button.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton bag_button = new JButton("背包", bag_icon);
		bag_button.setVerticalTextPosition(SwingConstants.NORTH);
		bag_button.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton character_button = new JButton("角色", character_icon);
		character_button.setVerticalTextPosition(SwingConstants.NORTH);
		character_button.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton stage_button = new JButton("Stage", stage_icon);
		stage_button.setVerticalTextPosition(SwingConstants.HORIZONTAL);
		stage_button.setHorizontalTextPosition(SwingConstants.CENTER);
		
		// 添加所有按鈕事件
		ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (e.getSource() == bag_button) {
					frame.setVisible(false);
					Bag.getInstance();
				}
            	else if (e.getSource() == stage_button) {
					frame.setVisible(false);
					GameFloor i = new GameFloor();
					i.floor = 1;
				}
            	else if (e.getSource() == character_button) {
					frame.setVisible(false);
					 new RolePage();
				}
		else if (e.getSource() == shop_button) {
					frame.setVisible(false);
					 new shop();
				} 
            }
		};
		bag_button.addActionListener(actionListener);
		stage_button.addActionListener(actionListener); 
		character_button.addActionListener(actionListener);
		shop_button.addActionListener(actionListener);

		// 設定按鈕文字
		Font buttonFont = new Font("Microsoft YaHei", Font.BOLD, 20);
		shop_button.setFont(buttonFont);
		shop_button.setForeground(Color.WHITE);
		bag_button.setFont(buttonFont);
		bag_button.setForeground(Color.WHITE);
		character_button.setFont(buttonFont);
		character_button.setForeground(Color.WHITE);
		stage_button.setFont(new Font("Georgia", Font.HANGING_BASELINE + Font.BOLD, 30));
		stage_button.setForeground(Color.RED);

		// 設置滑鼠進入和離開效果
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
		shop_button.addMouseListener(mouseAdapter);
		bag_button.addMouseListener(mouseAdapter);
		character_button.addMouseListener(mouseAdapter);
		stage_button.addMouseListener(mouseAdapter);

		// 按鈕移除外框跟背景
		shop_button.setOpaque(false);
		shop_button.setBackground(new Color(0, 0, 0, 0));
		shop_button.setBorder(null);
		shop_button.setFocusPainted(false);

		character_button.setOpaque(false);
		character_button.setBackground(new Color(0, 0, 0, 0));
		character_button.setBorder(null);
		character_button.setFocusPainted(false);

		bag_button.setOpaque(false);
		bag_button.setBackground(new Color(0, 0, 0, 0));
		bag_button.setBorder(null);
		bag_button.setFocusPainted(false);

		stage_button.setOpaque(false);
		stage_button.setBackground(new Color(0, 0, 0, 0));
		stage_button.setBorder(null);
		stage_button.setFocusPainted(false);

		// 調整按鈕大小
		Dimension buttonSize = new Dimension(75, 150);
		shop_button.setPreferredSize(buttonSize);
		bag_button.setPreferredSize(buttonSize);
		character_button.setPreferredSize(buttonSize);
		stage_button.setPreferredSize(new Dimension(100, 200));

		// 擺放按鈕
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		innerPanel.add(bag_button);
		innerPanel.add(character_button);
		innerPanel.add(shop_button);

		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new BorderLayout());
		outerPanel.add(innerPanel, BorderLayout.SOUTH);

		JPanel stagePanel = new JPanel();
		stagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));
		stagePanel.add(stage_button);

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

		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(outerPanel, BorderLayout.SOUTH);
		backgroundPanel.add(stagePanel);

		// 移除容器背景
		outerPanel.setOpaque(false);
		outerPanel.setBackground(new Color(0, 0, 0, 0));
		innerPanel.setOpaque(false);
		innerPanel.setBackground(new Color(0, 0, 0, 0));
		stagePanel.setOpaque(false);
		stagePanel.setBackground(new Color(0, 0, 0, 0));

		frame.add(backgroundPanel);


		frame.setVisible(true);
	}

}
