/*    */ package dtv.pos.framework.ui.context;
/*    */ 
/*    */ import dtv.util.config.AbstractSetConfig;
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
/*    */ public class ContextSetConfig
/*    */   extends AbstractSetConfig<ContextConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "ContextSet";
/*    */   
/*    */   public String getChildTag() {
/* 22 */     return "Context";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\context\ContextSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */