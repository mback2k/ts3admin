package de.uxnr.ts3.admin.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class DialogHelper {
	public static void showWarning(Shell parent, String message) {
		MessageBox messageBox = new MessageBox(parent, SWT.OK | SWT.ICON_WARNING);
		messageBox.setText("Warning");
		messageBox.setMessage("Warning: "+message);
		messageBox.open();
	}
}
