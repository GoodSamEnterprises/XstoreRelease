/*    */ package dtv.pos.framework.biometric.fingerprint.digitalpersona;
/*    */ 
/*    */ import com.digitalpersona.onetouch.DPFPTemplate;
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
/*    */ public class DpPopulation
/*    */ {
/*    */   DPFPTemplate[] templates;
/*    */   boolean dontPreSort = true;
/*    */   
/*    */   public DPFPTemplate[] getTemplates() {
/* 24 */     return this.templates;
/*    */   }
/*    */   
/*    */   public boolean isDontPreSort() {
/* 28 */     return this.dontPreSort;
/*    */   }
/*    */   
/*    */   public void setDontPreSort(boolean newValue) {
/* 32 */     this.dontPreSort = newValue;
/*    */   }
/*    */   
/*    */   public void setTemplates(DPFPTemplate[] newValue) {
/* 36 */     this.templates = newValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\biometric\fingerprint\digitalpersona\DpPopulation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */