package de.uxnr.ts3.admin.ui.viewer.server;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


import de.uxnr.ts3.admin.ui.resource.IconDescriptor;
import de.uxnr.ts3.api.Server;
import de.uxnr.ts3.util.StringHelper;

public class ServerLabelProvider extends LabelProvider implements ITableLabelProvider {
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		Server server = (Server)element;
		switch (columnIndex) {
			case 3:
				return new IconDescriptor(server.getStatus().equals("online") ? "server_go" : "server").createImage();
			case 7:
				return new IconDescriptor(server.getAutostart() ? "tick" : "cross").createImage();
		 }
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Server server = (Server)element;
		switch (columnIndex) {
			case 0:
				return String.valueOf(server.getID());
			case 1:
				return server.getName();
			case 2:
				return String.valueOf(server.getPort());
			case 3:
				return server.getStatus();
			case 4:
				return String.valueOf(server.getClientsOnline())+" / "+String.valueOf(server.getMaxClients());
			case 5:
				return String.valueOf(server.getQueryClientsOnline());
			case 6:
				return StringHelper.formatTimespan(server.getUptime());
			case 7:
				return server.getAutostart() ? "Yes" : "No";
		 }
		return "";
	}

	@Override
	public void addListener(ILabelProviderListener labelProviderListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener labelProviderListener) {
		// TODO Auto-generated method stub

	}
}
