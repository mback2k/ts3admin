package de.uxnr.ts3.admin.ui.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.uxnr.ts3.admin.ui.MainWindow;

public class ConnectionDialog extends Dialog {
	private Label lbHostname;
	private Label lbPort;
	private Text tHostname;
	private Text tPort;
	private MainWindow window;
	
	public ConnectionDialog(MainWindow window) {
		super(window.getShell());
		this.window = window;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("New connection");
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		GridLayout gridLayout = new GridLayout(2, true);
		gridLayout.marginHeight = 7;
		gridLayout.marginLeft = 7;
		gridLayout.horizontalSpacing = 0;
		gridLayout.makeColumnsEqualWidth = true;
		composite.setLayout(gridLayout);
		
		this.lbHostname = new Label(composite, SWT.FLAT);
		this.lbHostname.setText("Hostname:");
		this.tHostname = new Text(composite, SWT.FLAT | SWT.BORDER);
		
		this.lbPort = new Label(composite, SWT.FLAT);
		this.lbPort.setText("Port:");
		this.tPort = new Text(composite, SWT.FLAT | SWT.BORDER);
		this.tPort.setText("10011");
		
		return composite;
	}
	
	protected void okPressed() {
		this.window.getScreen().createConnection(this.tHostname.getText(), Integer.parseInt(this.tPort.getText()));
		this.close();
	}
}
