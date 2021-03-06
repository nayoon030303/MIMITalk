package kr.hs.study.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.hs.study.imply.ImfoImply;

public class OpenChat implements ImfoImply{
	
	private MainFrame frame = new MainFrame("채팅방 만들기");
	private JPanel panel = new JPanel();
	
	private JLabel infolabel = new JLabel("생성할 채팅방 정보");
	private JLabel iplabel = new JLabel("ip");
	private JLabel portlabel = new JLabel("port번호");
	private JLabel myinfolabel = new JLabel("내 정보");
	private JLabel namelabel = new JLabel("이름을 입력해주세요");;
	
	private JLabel inputIP = new JLabel("10.96");
	private JTextField inputPort = new JTextField();
	private JTextField inputName = new JTextField();
	private JButton startBtn = new JButton("채팅방 열기");
	
	
	
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
		
	
		//
		myinfolabel.setFont(titleFont);
		myinfolabel.setBounds(20, 300,  300, 50);
		myinfolabel.setForeground(Color.DARK_GRAY);
		
		namelabel.setFont(subFont);
		namelabel.setBounds(30, 350, 300, 50);
		namelabel.setForeground(Color.DARK_GRAY);
		
		inputName.setFont(inputFont);
		inputName.setBounds(30,400,300,35);
		
		
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
		frame.add(panel);
		
		
		try {
			InetAddress local = InetAddress.getLocalHost();
			inputIP.setText(local.getHostAddress());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		
	}
	
	public boolean availablePort(String host, int port){
		boolean result = false;
		 
		try {
		    (new Socket(host, port)).close();
		 
		    result = true;
		}
		catch(Exception e) {
		    
		}
		    return result;
	}
	
	
	class clickEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String port = inputPort.getText();
			String name = inputName.getText();
			
			//null 체크
			if(port.length()==0 || name.length()==0) {
				System.out.println("입력해주세요");
			    JOptionPane.showMessageDialog(frame, "port와 이름을 모두 입력해주세요");
			}else {
				//port이용가능 체크
				boolean portCheck = availablePort(inputIP.getText(),Integer.parseInt(port));
				 
				if(portCheck){
				    System.out.println("이미 사용중입니다.");
				    JOptionPane.showMessageDialog(frame, "이미 사용중인 port번호 입니다");
				}else {
					//채팅시작
					//openServer(Integer.parseInt(port));
					new ServerChatting(Integer.parseInt(port),name);
					frame.dispose();
				}
			}
		}
	}
}
