/*    */ package dtv.pos.iframework.form.design.type;
/*    */ 
/*    */ import dtv.pos.iframework.form.FormLocationType;
/*    */ import java.awt.Dimension;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public final class FormPreviewType
/*    */ {
/* 21 */   private static final Logger logger_ = Logger.getLogger(FormPreviewType.class);
/*    */ 
/*    */   
/* 24 */   public static final FormPreviewType MULTI_PURPOSE_VIEW = new FormPreviewType(FormLocationType.MULTI_PURPOSE_VIEW, new Dimension(1004, 609));
/*    */ 
/*    */   
/* 27 */   public static final FormPreviewType POPUP_VIEW_PANEL = new FormPreviewType(FormLocationType.POPUP_VIEW_PANEL, new Dimension(388, 370));
/*    */ 
/*    */   
/* 30 */   public static final FormPreviewType TRANSACTION_LIST_AREA = new FormPreviewType(FormLocationType.TRANSACTION_LIST_AREA, new Dimension(472, 549));
/*    */ 
/*    */   
/* 33 */   public static final FormPreviewType MESSAGE_AREA = new FormPreviewType(FormLocationType.MESSAGE_AREA, new Dimension(383, 285));
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<FormLocationType, FormPreviewType> values_;
/*    */ 
/*    */   
/*    */   private final FormLocationType location_;
/*    */ 
/*    */   
/*    */   private final Dimension size_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static FormPreviewType forLocation(FormLocationType argType) {
/* 48 */     if (argType == null) {
/* 49 */       return null;
/*    */     }
/* 51 */     FormPreviewType found = values_.get(argType);
/* 52 */     if (found == null) {
/* 53 */       logger_.warn("There is no instance of [" + FormPreviewType.class
/* 54 */           .getName() + "] for [" + argType + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 57 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private FormPreviewType(FormLocationType argFormLocation, Dimension argSize) {
/* 66 */     this.location_ = argFormLocation;
/* 67 */     this.size_ = argSize;
/* 68 */     if (values_ == null) {
/* 69 */       values_ = new HashMap<>();
/*    */     }
/* 71 */     values_.put(argFormLocation, this);
/*    */   }
/*    */   
/*    */   public Dimension getSize() {
/* 75 */     return this.size_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 85 */     return this.location_.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\design\type\FormPreviewType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */