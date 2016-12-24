package tradeLogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class TradeLogMenuBar extends JMenuBar {

	private static final long serialVersionUID = -6306334091879100171L;
	private ActionListener actionListener;
	
	TradeLogMenuBar(ActionListener actionListener) {
		this.actionListener = actionListener;
		
		// FILE MENU
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		add(fileMenu);
		
		fileMenu.add(menuItem(new JMenuItem(), "Import", KeyEvent.VK_I));
		fileMenu.add(menuItem(new JMenuItem(), "Exit", KeyEvent.VK_E));
	}
	
	/*
	 * PRIVATE METHODS
	 */

	private JMenuItem menuItem(JMenuItem menuItem, String cmd, int key) {
		menuItem.setText(cmd);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(key, ActionEvent.ALT_MASK));
		menuItem.setActionCommand(cmd);
		menuItem.addActionListener(actionListener);
		return menuItem;
	}

}
