package de.uxnr.ts3.admin.ui.resource;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;

public class IconDescriptor extends ImageDescriptor {
  private String filename;

  public IconDescriptor(String filename) {
    this.filename = "icons/" + filename + ".png";
  }

  @Override
  public ImageData getImageData() {
    return ImageDescriptor.createFromFile(this.getClass(), this.filename).getImageData();
  }
}
