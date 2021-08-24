package kr.hs.study.page;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.hs.study.imply.ImfoImply;
import kr.hs.study.page.ServerChatting.click;

public class ClientChatting implements ImfoImply{
	private MainFrame frame = new MainFrame("채팅방");
	private JPanel panel = new JPanel();
	private JButton exitBtn = new JButton("종료");
	private TextArea textArea = new TextArea("",10,7,TextArea.SCROLLBARS_VERTICAL_ONLY);
	private JTextField input = new JTextField("");
	private JButton send = new JButton("전송");
	private String ip;
	private int AREA_WIDTH = 450;
	private int AREA_HEIGHT = 450;
	private int port;
	private String name;
	
	public ClientChatting(String ip,int port, String name) {
		
		this.port = port;
		this.name = name;
		this.ip = ip;
		
		panel.setBackground(backgroundColor);
		panel.setLayout(null);
		
		panel.add(exitBtn);
		panel.add(textArea);
		panel.add(input);
		panel.add(send);
		frame.add(panel);
	
		exitBtn.setBounds(380,30,100,50);
		exitBtn.setBackground(mainColor);
		exitBtn.setForeground(Color.WHITE);
		exitBtn.setOpaque(true);
		exitBtn.setHorizontalAlignment(JLabel.CENTER);
		exitBtn.setFocusPainted(false);
		exitBtn.setFont(inputFont);
		exitBtn.addActionListener(new click());
		
		textArea.setBounds(WIDTH/2-AREA_WIDTH/2, 100, AREA_WIDTH, AREA_HEIGHT);
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setFont(inputFont);
		
		input.setBounds(WIDTH/2-AREA_WIDTH/2, 560, AREA_WIDTH-80, 50);
		input.setFont(inputFont);
		//input.setBackground(mainColor);
		
		send.setBounds(WIDTH/2-AREA_WIDTH/2+AREA_WIDTH-70, 560, 70, 50);
		send.setOpaque(true);
		send.setBackground(mainColor);
		send.setForeground(Color.WHITE);
		send.setHorizontalAlignment(JLabel.CENTER);
		send.setFocusPainted(false);
		send.setFont(inputFont);
		send.addActionListener(new click());
		
		
		
	}
	
	public void sendChat(String message) {
		try {
			message = "["+name+"]"+message;
			InputStream is = new ByteArrayInputStream(message.getBytes());
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String msg = in.readLine();
			DatagramPacket dp = new DatagramPacket(msg.getBytes(),
		        msg.getBytes().length, InetAddress.getByName(ip),port);
			DatagramSocket ds = new DatagramSocket();
			ds.send(dp);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	class click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == send) {
				String message = input.getText();
				System.out.println("click: "+message);
				//전송
				sendChat(message);
			}else if(e.getSource() == exitBtn) {
				new Title();
				frame.dispose();
			}
			
			
		}
		
	}
}
