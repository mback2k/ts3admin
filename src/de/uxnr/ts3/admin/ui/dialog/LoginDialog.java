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

public class LoginDialog extends Dialog {
  private Label lbUsername;
  private Label lbPassword;
  private Text tUsername;
  private Text tPassword;
  private MainWindow window;

  public LoginDialog(MainWindow window) {
    super(window.getShell());
    this.window = window;
  }

  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    shell.setText("Login " + this.window.getScreen().getConnection().getText());
  }

  protected Control createDialogArea(Composite parent) {
    Composite composite = (Composite) super.createDialogArea(parent);
    GridLayout gridLayout = new GridLayout(2, true);
    gridLayout.marginHeight = 7;
    gridLayout.marginLeft = 7;
    composite.setLayout(gridLayout);

    this.lbUsername = new Label(composite, SWT.FLAT);
    this.lbUsername.setText("Username:");
    this.tUsername = new Text(composite, SWT.FLAT | SWT.BORDER);

    this.lbPassword = new Label(composite, SWT.FLAT);
    this.lbPassword.setText("Password:");
    this.tPassword = new Text(composite, SWT.FLAT | SWT.BORDER | SWT.PASSWORD);

    return composite;
  }

  protected void okPressed() {
    this.window.getScreen().getConnection()
        .login(this.tUsername.getText(), this.tPassword.getText());
    this.close();
  }
}
