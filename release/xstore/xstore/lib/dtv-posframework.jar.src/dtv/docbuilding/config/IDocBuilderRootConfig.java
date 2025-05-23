package dtv.docbuilding.config;

import dtv.util.config.IConfigObject;

public interface IDocBuilderRootConfig extends IConfigObject {
  DocListConfig getDocListConfig();
  
  FormatterMapConfig getFormatterMapForConfig();
  
  DocBuilderSectionMapConfig getSectionsConfig();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\IDocBuilderRootConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */