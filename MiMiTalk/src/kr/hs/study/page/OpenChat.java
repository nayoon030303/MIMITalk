package kr.hs.study.page;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.hs.study.imply.ImfoImply;

public class OpenChat implements ImfoImply{
	
	private MainFrame frame = new MainFrame();
	private JPanel panel = new JPanel();
	
	private JLabel infolabel = new JLabel("ä�ù� ����");
	private JLabel iplabel = new JLabel("ip�� �Է����ּ���");
	private JLabel portlabel = new JLabel("port��ȣ�� �Է����ּ���");
	
	//font
	private Font titleFont = new Font("���� ����", Font.BOLD, 25);
	private Font subFont = new Font("�����ٸ�����", Font.PLAIN, 20);
	
	public OpenChat() {
		panel.setBackground(backgroundColor);
		panel.setLayout(null);
		
		infolabel.setFont(titleFont);
		infolabel.setBounds(20, 30, 300, 50);
		infolabel.setForeground(Color.DARK_GRAY);
		
		iplabel.setFont(subFont);
		iplabel.setBounds(30, 80, 300, 50);
		iplabel.setForeground(Color.DARK_GRAY);
		
		
		panel.add(infolabel);
		panel.add(iplabel);
		panel.add(portlabel);
		frame.add(panel);
	}
}