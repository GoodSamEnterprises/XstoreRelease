/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.ui.UIResourceManager;
/*    */ import dtv.util.config.IconConfig;
/*    */ import javax.swing.ImageIcon;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IconRefConfig
/*    */   extends IconConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public IconRefConfig() {}
/*    */   
/*    */   public IconRefConfig(String key) {
/* 37 */     super(key);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigDataType() {
/* 47 */     return "IconRef";
/*    */   }
/*    */ 
/*    */   
/*    */   protected ImageIcon acquireIcon(String argIconPath) {
/* 52 */     return UIResourceManager.getInstance().getImageIcon(argIconPath);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\IconRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */