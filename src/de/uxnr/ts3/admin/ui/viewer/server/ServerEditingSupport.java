package de.uxnr.ts3.admin.ui.viewer.server;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;


import de.uxnr.ts3.admin.ui.composite.ConnectionComposite;
import de.uxnr.ts3.admin.util.DialogHelper;
import de.uxnr.ts3.api.Server;
import de.uxnr.ts3.net.ServerQueryError;

public class ServerEditingSupport extends EditingSupport {
	private CellEditor editor;
	private int columnIndex;

	public ServerEditingSupport(ColumnViewer viewer, int columnIndex) {
		super(viewer);
		this.columnIndex = columnIndex;
		switch (this.columnIndex) {
			case 1:
				this.editor = new TextCellEditor(((TableViewer) viewer).getTable());
				break;
			case 7:
				this.editor = new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);
				break;
		}
	}

	@Override
	protected boolean canEdit(Object element) {
		if (ConnectionComposite.getSelected().isAuthorized()) {
			switch (this.columnIndex) {
				case 1:
					return true;
				case 7:
					return true;
			}
		}
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return this.editor;
	}

	@Override
	protected Object getValue(Object element) {
		Server server = (Server)element;
		switch (this.columnIndex) {
			case 1:
				return server.getName();
			case 7:
				return server.getAutostart();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		Server server = (Server)element;
		try {
			switch (this.columnIndex) {
				case 1:
					server.setName((String) value);
					break;
				case 7:
					server.setAutostart((Boolean) value);
					break;
			}
		} catch (ServerQueryError e) {
			DialogHelper.showWarning(this.getViewer().getControl().getShell(), e.getMessage());
		}
		this.getViewer().update(element, null);
	}
}
