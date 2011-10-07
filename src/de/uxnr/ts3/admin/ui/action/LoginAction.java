package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TabItem;

import de.uxnr.ts3.admin.ui.MainWindow;
import de.uxnr.ts3.admin.ui.composite.ConnectionComposite;
import de.uxnr.ts3.admin.ui.dialog.LoginDialog;
import de.uxnr.ts3.admin.ui.resource.IconDescriptor;

public class LoginAction extends Action implements SelectionListener {
	private static LoginAction uniqueInstance = null;

	private LoginAction() {
		super("&Login", new IconDescriptor("lock_open"));
		this.setEnabled(false);
	}

	public static LoginAction getInstance() {
		if (LoginAction.uniqueInstance == null) {
			LoginAction.uniqueInstance = new LoginAction();
		}
		return LoginAction.uniqueInstance;
	}

	@Override
	public void run() {
		new LoginDialog(MainWindow.getInstance()).open();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		ConnectionComposite connection = (ConnectionComposite) ((TabItem) e.item).getControl();
		this.setEnabled(connection != null && !connection.isAuthorized());
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		this.widgetSelected(e);
	}
}
