package kr.hs.study.page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.hs.study.imply.ImfoImply;
import kr.hs.study.page.OpenChat.clickEvent;

public class JoinChat implements ImfoImply {
	private MainFrame frame = new MainFrame("ä�ù� �����ϱ�");
	private JPanel panel = new JPanel();
	
	private JLabel infolabel = new JLabel("������ ä�ù� ����");
	private JLabel iplabel = new JLabel("ip");
	private JLabel portlabel = new JLabel("port��ȣ");
	private JLabel myinfolabel = new JLabel("�� ����");
	private JLabel myIPlabel = new JLabel("�� IP");;
	private JLabel namelabel = new JLabel("�̸��� �Է����ּ���");
	
	private JTextField inputIP = new JTextField();
	private JTextField inputPort = new JTextField();
	private JLabel inputMyIP = new JLabel();
	private JTextField inputName = new JTextField();
	private JButton startBtn = new JButton("ä�ù� �����ϱ�");
	
	public JoinChat() {
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
		
	
		//
		myinfolabel.setFont(titleFont);
		myinfolabel.setBounds(20, 300,  300, 50);
		myinfolabel.setForeground(Color.DARK_GRAY);
		
		namelabel.setFont(subFont);
		namelabel.setBounds(30, 350, 300, 50);
		namelabel.setForeground(Color.DARK_GRAY);
		
		inputName.setFont(inputFont);
		inputName.setBounds(30,400,300,35);
		
		myIPlabel.setFont(subFont);
		myIPlabel.setBounds(30, 450, 300, 50);
		myIPlabel.setForeground(Color.DARK_GRAY);
		
		inputMyIP.setFont(inputFont);
		inputMyIP.setBounds(30,500,300,35);
		
		
		startBtn.setFont(titleFont);
		startBtn.setOpaque(true);
		startBtn.setBackground(mainColor);
		startBtn.setForeground(Color.white);
		startBtn.setBounds(0,565,WIDTH,100);
		startBtn.setHorizontalAlignment(JLabel.CENTER);
		startBtn.setFocusPainted(false);
		startBtn.addActionListener(new clickEvent());
		
		panel.add(infolabel);
		panel.add(iplabel);
		panel.add(portlabel);
		panel.add(inputIP);
		panel.add(inputPort);
		panel.add(myinfolabel);
		panel.add(namelabel);
		panel.add(inputName);
		panel.add(startBtn);
		panel.add(myIPlabel);
		panel.add(inputMyIP);
		frame.add(panel);
		
		
		try {
			InetAddress myIP = InetAddress.getLocalHost();
			inputMyIP.setText(myIP.getHostAddress());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		
	}
	class clickEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String port = inputPort.getText();
			String ip = inputIP.getText();
			String name = inputName.getText();
			
			//null üũ
			if(port.length()==0 || name.length()==0) {
				System.out.println("�Է����ּ���");
			    JOptionPane.showMessageDialog(frame, "ip, port, �̸� ��/�� ��� �Է����ּ���");
			}else {
				new ClientChatting(ip, Integer.parseInt(port), name);
				frame.dispose();
			}
		}
	}
}
