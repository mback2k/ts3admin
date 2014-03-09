package de.uxnr.ts3.admin.ui.dialog;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.uxnr.ts3.admin.ui.MainWindow;

public class AboutDialog extends TitleAreaDialog {
  public AboutDialog(MainWindow window) {
    super(window.getShell());
  }

  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    shell.setText("TeamSpeak 3 Admin");
  }

  protected Control createDialogArea(Composite parent) {
    this.setTitle("TeamSpeak 3 Admin");
    this.setMessage("by Marc Hoersken");
    Composite composite = (Composite) super.createDialogArea(parent);
    Label label = new Label(composite, SWT.NONE);
    label.setText("Hello World!");
    return composite;
  }
}
