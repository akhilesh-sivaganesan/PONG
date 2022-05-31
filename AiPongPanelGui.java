import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class AiPongPanelGui implements Runnable {
	AiPongPanel panel;
	
	public AiPongPanelGui(AiPongPanel aPanel)
	{
		panel = aPanel;
	//	while(true)
		
	}
	public void run() {
		while(true)
			panel.updateBall();
	}
	

}