package de.uxnr.ts3.admin.ui.viewer.server;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import de.uxnr.ts3.api.Connection;

public class ServerViewer extends TableViewer {
  public ServerViewer(Composite parent, int style) {
    super(parent, style);

    Table table = this.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    this.createColumn(0, "ID", 50);
    this.createColumn(1, "Servername", 200);
    this.createColumn(2, "Port", 50);
    this.createColumn(3, "Status", 100);
    this.createColumn(4, "Clients", 100);
    this.createColumn(5, "Query Clients", 100);
    this.createColumn(6, "Uptime", 150);
    this.createColumn(7, "Autostart", 100);

    this.setContentProvider(new ServerContentProvider());
    this.setLabelProvider(new ServerLabelProvider());
  }

  private TableViewerColumn createColumn(int index, String caption, int size) {
    TableViewerColumn column = new TableViewerColumn(this, SWT.LEFT, index);
    column.setEditingSupport(new ServerEditingSupport(this, index));
    column.getColumn().setText(caption);
    column.getColumn().setWidth(size);
    column.getColumn().setResizable(true);

    return column;
  }

  public void setConnection(Connection connection) {
    this.setInput(connection);
  }
}
