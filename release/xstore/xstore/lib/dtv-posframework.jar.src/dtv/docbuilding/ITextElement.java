package dtv.docbuilding;

public interface ITextElement extends IDocElement {
  IConfigurableTextInfo getConfigurableTextInfo();
  
  boolean isTextAppendable();
  
  boolean isTextConfigurable();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\ITextElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */