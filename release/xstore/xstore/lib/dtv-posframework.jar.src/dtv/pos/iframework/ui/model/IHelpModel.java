/*     */ package dtv.pos.iframework.ui.model;
/*     */ 
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstDataActionKey;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IHelpModel
/*     */   extends IUIModel
/*     */ {
/*     */   Collection<? extends IXstAction> getHelpActions();
/*     */   
/*     */   String getHelpContentType();
/*     */   
/*     */   String getHelpInstructions();
/*     */   
/*     */   String getHelpMessage();
/*     */   
/*     */   HelpState getHelpState();
/*     */   
/*     */   String getHelpTitle();
/*     */   
/*     */   void setHelpActions(Collection<? extends IXstAction> paramCollection);
/*     */   
/*     */   void setHelpContentType(String paramString);
/*     */   
/*     */   void setHelpInstructions(String paramString);
/*     */   
/*     */   void setHelpMessage(String paramString);
/*     */   
/*     */   void setHelpState(HelpState paramHelpState);
/*     */   
/*     */   void setHelpTitle(String paramString);
/*     */   
/*     */   public enum HelpState
/*     */   {
/*  94 */     ABOUT((String)XstDataActionKey.valueOf("ABOUT"), "_helpAbout")
/*     */     {
/*     */       public Set<HelpState> getTransitions() {
/*  97 */         return Collections.singleton(HELP);
/*     */       }
/*     */     },
/*     */     
/* 101 */     HELP((String)XstDataActionKey.valueOf("HELP"), "_help")
/*     */     {
/*     */       public Set<HelpState> getTransitions() {
/* 104 */         return Collections.singleton(ABOUT);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */     
/*     */     private IXstDataActionKey _actionKey;
/*     */     
/*     */     private String _name;
/*     */ 
/*     */     
/*     */     HelpState(IXstDataActionKey argActionKey, String argName) {
/* 116 */       this._actionKey = argActionKey;
/* 117 */       this._name = argName;
/*     */     }
/*     */ 
/*     */     
/*     */     public IXstDataActionKey getActionKey() {
/* 122 */       return this._actionKey;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/* 127 */       return this._name;
/*     */     }
/*     */     
/*     */     public abstract Set<HelpState> getTransitions();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IHelpModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */