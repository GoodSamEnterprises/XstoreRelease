package dtv.pos.iframework.ui.config;

import dtv.util.config.ICascadableConfig;
import dtv.util.config.ISavableConfig;
import java.awt.Font;

public interface IFontConfig extends ICascadableConfig, ISavableConfig {
  Font getFont();
  
  Font getFont(Font paramFont);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IFontConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */