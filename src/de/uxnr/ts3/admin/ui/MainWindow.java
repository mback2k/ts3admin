package de.uxnr.ts3.admin.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uxnr.ts3.admin.ui.action.AboutAction;
import de.uxnr.ts3.admin.ui.action.ConnectAction;
import de.uxnr.ts3.admin.ui.action.DisconnectAction;
import de.uxnr.ts3.admin.ui.action.ExitAction;
import de.uxnr.ts3.admin.ui.action.LoginAction;
import de.uxnr.ts3.admin.ui.action.LogoutAction;
import de.uxnr.ts3.admin.ui.action.RefreshAction;
import de.uxnr.ts3.admin.ui.composite.ScreenComposite;

/**
 * 
 * 
 * @author Marc Hoersken <info@marc-hoersken.de>
 */
public class MainWindow extends ApplicationWindow {
  private static MainWindow uniqueInstance = null;
  private ScreenComposite screen;

  /**
   * Private constructor for the main window of the application.
   * 
   * @param Shell parentShell
   */
  private MainWindow(Shell parentShell) {
    super(parentShell);
    this.addMenuBar();
    this.addToolBar(SWT.FLAT | SWT.WRAP);
    this.addStatusLine();
  }

  /**
   * Singleton instance getter.
   * 
   * @return MainWindow
   */
  public static MainWindow getInstance() {
    if (MainWindow.uniqueInstance == null) {
      MainWindow.uniqueInstance = new MainWindow(null);
    }
    return MainWindow.uniqueInstance;
  }

  /**
   * Configuration of the main window. Called from the super class ApplicationWindow.
   * 
   * @param Shell newShell
   */
  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("TeamSpeak 3 Admin");
  }

  /**
   * Create the controls of the main window. Called from the super class ApplicationWindow.
   * 
   * @param Comosite parent
   * @return Control
   */
  @Override
  protected Control createContents(Composite parent) {
    this.screen = new ScreenComposite(parent, SWT.BORDER);
    return parent;
  }

  @Override
  protected MenuManager createMenuManager() {
    MenuManager menuManager = new MenuManager();
    MenuManager connectionMenu = new MenuManager("&Connection");
    MenuManager helpMenu = new MenuManager("&Help");

    connectionMenu.add(ConnectAction.getInstance());
    connectionMenu.add(new Separator());
    connectionMenu.add(ExitAction.getInstance());
    menuManager.add(connectionMenu);

    helpMenu.add(AboutAction.getInstance());
    menuManager.add(helpMenu);

    return menuManager;
  }

  @Override
  protected ToolBarManager createToolBarManager(int style) {
    ToolBarManager toolBarManager = new ToolBarManager(style);
    toolBarManager.add(ConnectAction.getInstance());
    toolBarManager.add(DisconnectAction.getInstance());
    toolBarManager.add(new Separator());
    toolBarManager.add(RefreshAction.getInstance());
    toolBarManager.add(new Separator());
    toolBarManager.add(LoginAction.getInstance());
    toolBarManager.add(LogoutAction.getInstance());

    return toolBarManager;
  }

  @Override
  protected StatusLineManager createStatusLineManager() {
    StatusLineManager statusLineManager = new StatusLineManager();

    return statusLineManager;
  }

  public ScreenComposite getScreen() {
    return this.screen;
  }

  static public void main(String[] args) {
    MainWindow window = MainWindow.getInstance();
    window.setBlockOnOpen(true);
    window.open();
    Display.getCurrent().dispose();
  }
}
