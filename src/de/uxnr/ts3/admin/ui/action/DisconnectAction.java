package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TabItem;

import de.uxnr.ts3.admin.ui.composite.ConnectionComposite;
import de.uxnr.ts3.admin.ui.resource.IconDescriptor;

public class DisconnectAction extends Action implements SelectionListener {
  private static DisconnectAction uniqueInstance = null;

  private DisconnectAction() {
    super("&Disconnect", new IconDescriptor("disconnect"));
    this.setEnabled(false);
  }

  public static DisconnectAction getInstance() {
    if (DisconnectAction.uniqueInstance == null) {
      DisconnectAction.uniqueInstance = new DisconnectAction();
    }
    return DisconnectAction.uniqueInstance;
  }

  @Override
  public void run() {
    ConnectionComposite.getSelected().disconnect();
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    ConnectionComposite connection = (ConnectionComposite) ((TabItem) e.item).getControl();
    this.setEnabled(connection != null);
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {
    this.widgetSelected(e);
  }
}
