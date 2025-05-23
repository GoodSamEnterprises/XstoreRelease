/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderPageBreakConfig
/*    */   extends AbstractParentConfig
/*    */   implements ISectionMemberConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 26 */     warnUnsupported(argKey, argValue);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderPageBreakConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */