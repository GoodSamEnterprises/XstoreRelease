/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.framework.ui.component.XstAnchor;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.util.MutableString;
/*    */ import java.awt.Font;
/*    */ import java.awt.font.TextAttribute;
/*    */ import java.util.Map;
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
/*    */ public class FormAnchor<T extends IFormModel>
/*    */   extends AbstractFormComponent<T>
/*    */ {
/*    */   protected XstAnchor _urlLink;
/*    */   private IFormattable _displayText;
/*    */   
/*    */   public FormAnchor() {
/* 34 */     this._urlLink = XstViewComponentFactory.getInstance().createAnchor();
/* 35 */     setComponent((IXstViewComponent)this._urlLink);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(ResolvedFieldConfig argFieldDef) {
/* 43 */     super.init(argFieldDef);
/*    */     
/* 45 */     Font font = getUrlLink().getDisplayComponent().getFont();
/* 46 */     getUrlLink().getAnchor().setForeground(UIRM.getRGBColor("_colorAnchor"));
/* 47 */     Map<TextAttribute, ?> attributes = font.getAttributes();
/* 48 */     attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/* 49 */     getUrlLink().getDisplayComponent().setFont(font.deriveFont((Map)attributes));
/*    */     
/* 51 */     if (argFieldDef.getParameter("displayText") != null) {
/* 52 */       this._displayText = FF.getSimpleFormattable(argFieldDef.getParameter("displayText"));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 59 */     return getUrlLink();
/*    */   }
/*    */   
/*    */   protected XstAnchor getUrlLink() {
/* 63 */     return this._urlLink;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setComponentValue(Object argValue) {
/* 69 */     if (argValue != null) {
/* 70 */       getUrlLink().setAnchorValue((String)argValue);
/* 71 */       if (this._displayText != null) {
/* 72 */         getUrlLink().getAnchor().setText(new MutableString(this._displayText.toString(OutputContextType.VIEW)));
/*    */       }
/*    */     } else {
/*    */       
/* 76 */       getUrlLink().getAnchor().setText(new MutableString(null));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormAnchor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */