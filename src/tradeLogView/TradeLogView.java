package tradeLogView;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class TradeLogView {
	
	private JFrame frame;
	private ActionListener actionListener;
	private JMenuBar menuBar;
	
	public TradeLogView() {
		frame = new JFrame("TradeLog");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		frame.setJMenuBar(new TradeLogMenuBar(actionListener));
	}
	
	/*
	 * POP UP WINDOW TO ASK ARE YOU SURE
	 */
	public boolean sure(String msg) {
		int reply = JOptionPane.showConfirmDialog(null, "Are you sure?", msg, JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_NO_OPTION)	return true;
		return false;
	}
	
	/*
	 * POP UP WINDOW TO DISPLAY A MESSAGE
	 */
	public void message(String string) {
		JOptionPane.showMessageDialog(frame, string);
	}
}
