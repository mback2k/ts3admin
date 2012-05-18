package de.uxnr.ts3.admin.ui.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import de.uxnr.ts3.admin.ui.MainWindow;
import de.uxnr.ts3.admin.ui.action.DisconnectAction;
import de.uxnr.ts3.admin.ui.action.LoginAction;
import de.uxnr.ts3.admin.ui.action.LogoutAction;
import de.uxnr.ts3.admin.ui.action.RefreshAction;
import de.uxnr.ts3.admin.util.DialogHelper;
import de.uxnr.ts3.net.ServerQueryError;

public class ScreenComposite extends Composite {
	private final TabFolder tabFolder;

	public static ScreenComposite getSelected() {
		return MainWindow.getInstance().getScreen();
	}

	public ScreenComposite(Composite parent, int style) {
		super(parent, style);

		this.tabFolder = new TabFolder(this, SWT.NONE);
		this.setLayout(new FillLayout());

		this.tabFolder.addSelectionListener(DisconnectAction.getInstance());
		this.tabFolder.addSelectionListener(RefreshAction.getInstance());
		this.tabFolder.addSelectionListener(LoginAction.getInstance());
		this.tabFolder.addSelectionListener(LogoutAction.getInstance());
	}

	public ConnectionComposite createConnection(String hostname, int port) {
		try {
			return new ConnectionComposite(this.tabFolder, SWT.BORDER, hostname, port);
		} catch (ServerQueryError e) {
			DialogHelper.showWarning(this.getShell(), e.getMessage());
		}
		return null;
	}

	public ConnectionComposite getConnection() {
		TabItem[] tabItems = this.tabFolder.getItems();
		int tabIndex = this.tabFolder.getSelectionIndex();
		if (tabIndex >= 0 && tabIndex < tabItems.length) {
			return (ConnectionComposite) (tabItems[tabIndex].getControl());
		}
		return null;
	}

	public void refreshConnections() {
		for (Control control : this.tabFolder.getChildren()) {
			((ConnectionComposite) control).refresh();
		}
	}

	public boolean hasConnections() {
		return this.tabFolder.getItemCount() > 0;
	}
}
