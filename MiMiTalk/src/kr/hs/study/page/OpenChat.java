package kr.hs.study.page;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.hs.study.imply.ImfoImply;

public class OpenChat implements ImfoImply{
	
	private MainFrame frame = new MainFrame();
	private JPanel panel = new JPanel();
	
	private JLabel infolabel = new JLabel("ä�ù� ����");
	private JLabel iplabel = new JLabel("ip�� �Է����ּ���");
	private JLabel portlabel = new JLabel("port��ȣ�� �Է����ּ���");
	private JLabel namelabel = new JLabel("�� ����");
	private JTextField inputIP = new JTextField();
	private JTextField inputPort = new JTextField();
	private JTextField inputName = new JTextField();
	
	//font
	private Font titleFont = new Font("���� ����", Font.BOLD, 25);
	private Font subFont = new Font("���� ����", Font.PLAIN, 20);
	private Font inputFont = new Font("���� ����", Font.PLAIN, 18);
	
	public OpenChat() {
		panel.setBackground(backgroundColor);
		panel.setLayout(null);
		
		infolabel.setFont(titleFont);
		infolabel.setBounds(20, 30, 300, 50);
		infolabel.setForeground(Color.DARK_GRAY);
		
		iplabel.setFont(subFont);
		iplabel.setBounds(30, 80, 300, 50);
		iplabel.setForeground(Color.DARK_GRAY);
		
		inputIP.setFont(inputFont);
		inputIP.setBounds(30,130,300,35);
		
		portlabel.setFont(subFont);
		portlabel.setBounds(30, 180, 300, 50);
		portlabel.setForeground(Color.DARK_GRAY);
		
		inputPort.setFont(inputFont);
		inputPort.setBounds(30,230,300,35);
		
		namelabel.setFont(titleFont);
		namelabel.setBounds(20, 280,  300, 50);
		namelabel.setForeground(Color.DARK_GRAY);
		
		
		panel.add(infolabel);
		panel.add(iplabel);
		panel.add(portlabel);
		panel.add(inputIP);
		panel.add(inputPort);
		panel.add(namelabel);
		frame.add(panel);
	}
}
