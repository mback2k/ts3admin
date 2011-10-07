package de.uxnr.ts3.admin.ui.composite;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import de.uxnr.ts3.admin.ui.MainWindow;
import de.uxnr.ts3.admin.ui.action.DisconnectAction;
import de.uxnr.ts3.admin.ui.action.LoginAction;
import de.uxnr.ts3.admin.ui.action.LogoutAction;
import de.uxnr.ts3.admin.ui.action.RefreshAction;
import de.uxnr.ts3.admin.ui.viewer.channel.ChannelViewer;
import de.uxnr.ts3.admin.ui.viewer.server.ServerViewer;
import de.uxnr.ts3.api.Connection;

public class ConnectionComposite extends Composite {
	private final SashForm sashFormH;
	private final SashForm sashFormV;
	private final TabItem tabItem;
	private final ServerViewer serverViewer;
	private final ChannelViewer channelViewer;
	private final ListViewer list;
	private final Connection connection;
	private boolean isAuthorized;

	public static ConnectionComposite getSelected() {
		return MainWindow.getInstance().getScreen().getConnection();
	}

	public ConnectionComposite(TabFolder tabFolder, int style, String hostname, int port) {
		super(tabFolder, style);
		this.setLayout(new FillLayout());

		this.connection = new Connection(hostname, port);

		this.sashFormV = new SashForm(this, SWT.VERTICAL);

		this.serverViewer = new ServerViewer(this.sashFormV, SWT.BORDER | SWT.FULL_SELECTION);
		this.serverViewer.setConnection(this.connection);

		this.sashFormH = new SashForm(this.sashFormV, SWT.HORIZONTAL);

		this.channelViewer = new ChannelViewer(this.sashFormH, SWT.BORDER);
		this.list = new ListViewer(this.sashFormH, SWT.BORDER);

		this.tabItem = new TabItem(tabFolder, style);
		this.tabItem.setControl(this);
		this.tabItem.setText(hostname+":"+port);

		DisconnectAction.getInstance().setEnabled(true);
		RefreshAction.getInstance().setEnabled(true);
		LoginAction.getInstance().setEnabled(true);
		LogoutAction.getInstance().setEnabled(false);
	}

	public String getText() {
		return this.tabItem.getText();
	}

	public void disconnect() {
		this.tabItem.dispose();
	}

	public void refresh() {
		this.serverViewer.refresh();
		this.channelViewer.refresh();
		this.list.refresh();
	}

	public void login(String username, String password) {
		this.connection.performLogin(username, password);
		this.isAuthorized = this.connection.isAuthorized();

		if (this.isAuthorized) {
			LoginAction.getInstance().setEnabled(false);
			LogoutAction.getInstance().setEnabled(true);
		}
	}

	public void logout() {
		this.connection.performLogout();
		this.isAuthorized = this.connection.isAuthorized();

		if (!this.isAuthorized) {
			LoginAction.getInstance().setEnabled(true);
			LogoutAction.getInstance().setEnabled(false);
		}
	}

	public boolean isAuthorized() {
		return this.isAuthorized;
	}
}
