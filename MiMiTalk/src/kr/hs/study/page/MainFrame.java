package kr.hs.study.page;

import javax.swing.JFrame;

import kr.hs.study.imply.ImfoImply;

public class MainFrame extends JFrame implements ImfoImply  {
	
	//size
	public static final int W = 500;
	public static final int H = 700;
	
	public MainFrame(String title) {
		super(title);
		setVisible(true);
		setResizable(false);
		setSize(W, H);
	}
}
