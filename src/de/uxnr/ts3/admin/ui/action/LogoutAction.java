package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TabItem;

import de.uxnr.ts3.admin.ui.composite.ConnectionComposite;
import de.uxnr.ts3.admin.ui.resource.IconDescriptor;

public class LogoutAction extends Action implements SelectionListener {
	private static LogoutAction uniqueInstance = null;

	private LogoutAction() {
		super("&Logout", new IconDescriptor("lock"));
		this.setEnabled(false);
	}

	public static LogoutAction getInstance() {
		if (LogoutAction.uniqueInstance == null) {
			LogoutAction.uniqueInstance = new LogoutAction();
		}
		return LogoutAction.uniqueInstance;
	}

	@Override
	public void run() {
		ConnectionComposite.getSelected().logout();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		ConnectionComposite connection = (ConnectionComposite) ((TabItem) e.item).getControl();
		this.setEnabled(connection != null && connection.isAuthorized());
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		this.widgetSelected(e);
	}
}
