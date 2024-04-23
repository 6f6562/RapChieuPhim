package ĐN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
	 test cv;
	
	public Listener(test cv) {
		this.cv = cv;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String respond = e.getActionCommand();
		
		if(respond.equals("Đăng nhập")) {
			this.cv.dangnhap();
		}
		if(respond.equals("Hủy")) {
			this.cv.huy();
		}
		
		
	}

}