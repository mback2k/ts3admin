package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;

import de.uxnr.ts3.admin.ui.MainWindow;
import de.uxnr.ts3.admin.ui.dialog.AboutDialog;

public class AboutAction extends Action {
  private static AboutAction uniqueInstance = null;

  private AboutAction() {
    super("&About Teamspeak 3 Admin");
  }

  public static AboutAction getInstance() {
    if (AboutAction.uniqueInstance == null) {
      AboutAction.uniqueInstance = new AboutAction();
    }
    return AboutAction.uniqueInstance;
  }

  public void run() {
    new AboutDialog(MainWindow.getInstance()).open();
  }
}
