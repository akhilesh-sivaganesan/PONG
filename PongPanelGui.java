import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class PongPanelGui implements Runnable {
	PongPanel panel;
	
	public PongPanelGui(PongPanel aPanel)
	{
		panel = aPanel;
	//	while(true)
		
	}
	public void run() {
		while(true)
			panel.updateBall();
	}
	

}