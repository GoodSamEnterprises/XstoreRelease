package dtv.pos.framework.ui;

import dtv.pos.framework.ui.config.IRootComponentConfig;
import dtv.pos.iframework.ui.IComponentRegistry;
import dtv.pos.iframework.ui.config.IViewComponentConfig;
import javax.swing.JComponent;

public interface IComponentAssembler {
  JComponent assemble(IRootComponentConfig paramIRootComponentConfig);
  
  JComponent assemble(IRootComponentConfig paramIRootComponentConfig, IComponentRegistry paramIComponentRegistry);
  
  JComponent assemble(IViewComponentConfig paramIViewComponentConfig, IComponentRegistry paramIComponentRegistry);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\IComponentAssembler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */