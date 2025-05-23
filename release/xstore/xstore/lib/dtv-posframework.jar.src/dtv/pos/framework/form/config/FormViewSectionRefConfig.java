/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*    */ import dtv.pos.iframework.form.config.IFormViewSectionRefConfig;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.IXmlWriter;
/*    */ import java.io.IOException;
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
/*    */ public class FormViewSectionRefConfig
/*    */   extends AbstractFormComponentConfig
/*    */   implements IFormViewSectionRefConfig<IFormComponentConfig>
/*    */ {
/*    */   public static final String MAIN_TAG = "FormViewSectionRef";
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Integer getFieldWeight() {
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getResource() {
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getTextKey() {
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getType() {
/* 51 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getValue() {
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isAlwaysEnabled() {
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEquivalent(Object argO) {
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isReadOnly() {
/* 75 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isRequired() {
/* 81 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(IXmlWriter argWriter) throws IOException {
/* 89 */     StringBuilder attr = new StringBuilder();
/* 90 */     if (!StringUtils.isEmpty(getName())) {
/* 91 */       attr.append(" name=\"").append(getName()).append("\"");
/*    */     }
/* 93 */     argWriter.writeElement("FormViewSectionRef", attr.toString().trim());
/*    */     
/* 95 */     setClean();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewSectionRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */