package kr.hs.study.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

import kr.hs.study.imply.ImfoImply;

public class Title implements ImfoImply{

	
	//font
	private Font titleFont = new Font("Consolas", Font.BOLD, 50);
	private Font subFont = new Font("맑은 고딕", Font.PLAIN, 20);
	//
	private MainFrame frame = new MainFrame("MiMiTalk");
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel("MiMiTalk");
	private JButton open_chat = new JButton("채팅방 열기");
	private JButton join_chat = new JButton("채팅방 들어가기");
	
	public Title() {
		super();
		panel.setBackground(backgroundColor);
		panel.setLayout(null);
		
		title.setFont(titleFont);
		title.setBounds(WIDTH/2- TITLE_WIDTH/2,100, TITLE_WIDTH, TITLE_HEIGHT);
		//title.setOpaque(true);
		title.setForeground(mainColor);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		
		open_chat.setFont(subFont);
		open_chat.setOpaque(true);
		open_chat.setBackground(mainColor);
		open_chat.setBounds(WIDTH/2-TITLE_BTN_WIDTH/2, 350, TITLE_BTN_WIDTH, TITL_BTN_HEIGHT);
		open_chat.setHorizontalAlignment(JLabel.CENTER);
		open_chat.setForeground(Color.WHITE);
		open_chat.setFocusPainted(false);
		open_chat.addActionListener(new clickEvent());

		join_chat.setFont(subFont);
		join_chat.setOpaque(true);
		join_chat.setBackground(mainColor);
		join_chat.setBounds(WIDTH/2-TITLE_BTN_WIDTH/2, 430, TITLE_BTN_WIDTH, TITL_BTN_HEIGHT);
		join_chat.setHorizontalAlignment(JLabel.CENTER);
		join_chat.setForeground(Color.WHITE);
		join_chat.setFocusPainted(false);
		join_chat.addActionListener(new clickEvent());
		
		panel.add(open_chat);
		panel.add(join_chat);
		panel.add(title);
		frame.add(panel);
		
	}
	
	class clickEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == open_chat) {
				new OpenChat();
				
				//System.out.println("p");
			}else if(e.getSource() == join_chat) {
				new JoinChat();
			}
			frame.dispose();
			
		}
		
	}
	
}
