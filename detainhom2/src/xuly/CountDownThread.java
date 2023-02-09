

package xuly;

import java.awt.Color;


import database.KetNoidata;

import gui.GuiGioiThieu;
import gui.GuiUser;

public class CountDownThread extends Thread {
	public void run() {
		int count = 3;
		KetNoidata.getin().getcon();
		GuiGioiThieu frmGioiThieu = new GuiGioiThieu();
		frmGioiThieu.setVisible(true);
		frmGioiThieu.setLocationRelativeTo(null);
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(1000);
				frmGioiThieu.progressBar.setValue(30);
				if(i==1)
					frmGioiThieu.progressBar.setValue(60);
				if(i==2)
					frmGioiThieu.progressBar.setValue(80);
				if(i==3)
					frmGioiThieu.progressBar.setValue(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		frmGioiThieu.setVisible(false);
		GuiUser frmDangNhap = new GuiUser();
		frmDangNhap.setVisible(true);
		frmDangNhap.setLocationRelativeTo(null);
	}
}
