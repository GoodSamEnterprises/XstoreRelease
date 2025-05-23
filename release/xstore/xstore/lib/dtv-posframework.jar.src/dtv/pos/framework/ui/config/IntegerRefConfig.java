/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.ui.UIResourceManager;
/*    */ import dtv.util.config.IntegerConfig;
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
/*    */ public class IntegerRefConfig
/*    */   extends IntegerConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getConfigDataType() {
/* 24 */     return "IntegerRef";
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setValueImpl(String value) {
/* 29 */     super.setValueImpl(UIResourceManager.getInstance().getInt(value) + "");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\IntegerRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */