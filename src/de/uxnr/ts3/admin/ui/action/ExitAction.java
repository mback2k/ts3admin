package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;

import de.uxnr.ts3.admin.ui.MainWindow;

public class ExitAction extends Action {
  private static ExitAction uniqueInstance = null;

  private ExitAction() {
    super("E&xit");
  }

  public static ExitAction getInstance() {
    if (ExitAction.uniqueInstance == null) {
      ExitAction.uniqueInstance = new ExitAction();
    }
    return ExitAction.uniqueInstance;
  }

  public void run() {
    MainWindow.getInstance().close();
  }
}
