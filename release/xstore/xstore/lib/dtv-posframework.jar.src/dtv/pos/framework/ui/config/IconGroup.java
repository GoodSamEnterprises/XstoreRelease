/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import com.micros.xstore.config.common.IconGroupType;
/*    */ import dtv.ui.IUIResourceManager;
/*    */ import dtv.ui.UIResourceManager;
/*    */ import javax.swing.Icon;
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
/*    */ public class IconGroup
/*    */ {
/* 23 */   private IUIResourceManager _uirm = UIResourceManager.getInstance();
/*    */   
/*    */   private Icon _icon;
/*    */   private Icon _rollIcon;
/*    */   private Icon _pressIcon;
/*    */   private Icon _disabledIcon;
/*    */   
/*    */   public IconGroup(IconGroupType argIconGroupConfig) {
/* 31 */     if (argIconGroupConfig != null) {
/* 32 */       this._icon = getIcon(argIconGroupConfig.getIcon());
/* 33 */       this._rollIcon = getIcon(argIconGroupConfig.getRollIcon());
/* 34 */       this._pressIcon = getIcon(argIconGroupConfig.getPressIcon());
/* 35 */       this._disabledIcon = getIcon(argIconGroupConfig.getDisabledIcon());
/*    */     } 
/*    */   }
/*    */   
/*    */   public Icon getDisabledIcon() {
/* 40 */     return this._disabledIcon;
/*    */   }
/*    */   
/*    */   public Icon getIcon() {
/* 44 */     return this._icon;
/*    */   }
/*    */   
/*    */   public Icon getPressIcon() {
/* 48 */     return this._pressIcon;
/*    */   }
/*    */   
/*    */   public Icon getRollIcon() {
/* 52 */     return this._rollIcon;
/*    */   }
/*    */   
/*    */   private Icon getIcon(String argImageKey) {
/* 56 */     Icon icon = null;
/*    */     
/* 58 */     if (argImageKey != null) {
/* 59 */       icon = this._uirm.getImageIcon(argImageKey);
/*    */     }
/*    */     
/* 62 */     return icon;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\IconGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */