package de.uxnr.ts3.admin.ui.viewer.server;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uxnr.ts3.api.Connection;

public class ServerContentProvider implements IStructuredContentProvider {
  @Override
  public Object[] getElements(Object parent) {
    return ((Connection) parent).getServers().toArray();
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
    // TODO Auto-generated method stub

  }
}
