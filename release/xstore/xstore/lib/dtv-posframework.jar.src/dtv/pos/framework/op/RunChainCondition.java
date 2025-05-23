package dtv.pos.framework.op;

public interface RunChainCondition {
  public static final String PARAM_INVERT = "Invert";
  
  void setParameter(String paramString1, String paramString2);
  
  boolean shouldRun();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\RunChainCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */