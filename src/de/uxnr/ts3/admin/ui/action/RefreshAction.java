package de.uxnr.ts3.admin.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TabItem;

import de.uxnr.ts3.admin.ui.composite.ConnectionComposite;
import de.uxnr.ts3.admin.ui.composite.ScreenComposite;
import de.uxnr.ts3.admin.ui.resource.IconDescriptor;

public class RefreshAction extends Action implements SelectionListener {
  private static RefreshAction uniqueInstance = null;

  private RefreshAction() {
    super("&Refresh", new IconDescriptor("arrow_refresh"));
    this.setEnabled(false);
  }

  public static RefreshAction getInstance() {
    if (RefreshAction.uniqueInstance == null) {
      RefreshAction.uniqueInstance = new RefreshAction();
    }
    return RefreshAction.uniqueInstance;
  }

  @Override
  public void run() {
    ScreenComposite.getSelected().refreshConnections();
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
