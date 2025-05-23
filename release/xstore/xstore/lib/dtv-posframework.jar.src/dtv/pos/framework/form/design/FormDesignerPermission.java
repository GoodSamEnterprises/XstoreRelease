/*    */ package dtv.pos.framework.form.design;
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
/*    */ public class FormDesignerPermission
/*    */ {
/* 15 */   public static final FormDesignerPermission EXIT = new FormDesignerPermission("EXIT");
/* 16 */   public static final FormDesignerPermission ALLOW_SAVE = new FormDesignerPermission("ALLOW_SAVE");
/* 17 */   public static final FormDesignerPermission ALLOW_NEW = new FormDesignerPermission("ALLOW_NEW");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private FormDesignerPermission(String argName) {
/* 30 */     this.name = argName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 40 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\FormDesignerPermission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */