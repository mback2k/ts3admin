package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;

import de.uxnr.ts3.admin.ui.MainWindow;
import de.uxnr.ts3.admin.ui.dialog.ConnectionDialog;
import de.uxnr.ts3.admin.ui.resource.IconDescriptor;

public class ConnectAction extends Action {
  private static ConnectAction uniqueInstance = null;

  private ConnectAction() {
    super("&Connect", new IconDescriptor("server_connect"));
  }

  public static ConnectAction getInstance() {
    if (ConnectAction.uniqueInstance == null) {
      ConnectAction.uniqueInstance = new ConnectAction();
    }
    return ConnectAction.uniqueInstance;
  }

  public void run() {
    new ConnectionDialog(MainWindow.getInstance()).open();
  }
}
