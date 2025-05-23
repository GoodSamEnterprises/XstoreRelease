/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.itm.IItemRestriction;
/*    */ import dtv.xst.dao.itm.IItemRestrictionModel;
/*    */ import dtv.xst.dao.itm.IItemRestrictionProperty;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
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
/*    */ public abstract class ItemRestrictionBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IItemRestrictionProperty>
/*    */   implements IItemRestriction, IItemRestrictionModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient Object value_;
/*    */   
/*    */   public Object getRestrictionValue() {
/* 31 */     ItemRestrictionDAO dao = getDAO_();
/*    */     
/* 33 */     if (this.value_ == null) {
/* 34 */       this.value_ = dao.getDecimalValue();
/*    */       
/* 36 */       if (this.value_ == null) {
/* 37 */         this.value_ = dao.getStringValue();
/*    */         
/* 39 */         if (this.value_ == null) {
/* 40 */           this.value_ = dao.getDateValue();
/*    */           
/* 42 */           if (this.value_ == null) {
/* 43 */             this.value_ = dao.getBooleanValue();
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 49 */     return this.value_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRestrictionValue(Object argValue) {
/* 55 */     ItemRestrictionDAO dao = getDAO_();
/*    */     
/* 57 */     if (argValue == null) {
/*    */       
/* 59 */       if (dao.getDecimalValue() != null) {
/* 60 */         dao.setDecimalValue(null);
/*    */       }
/* 62 */       else if (dao.getStringValue() != null) {
/* 63 */         dao.setStringValue(null);
/*    */       }
/* 65 */       else if (dao.getDateValue() != null) {
/* 66 */         dao.setDateValue(null);
/*    */       }
/* 68 */       else if (getDAO_().getBooleanValue().booleanValue()) {
/* 69 */         dao.setBooleanValue(Boolean.valueOf(false));
/*    */       
/*    */       }
/*    */     
/*    */     }
/* 74 */     else if (argValue instanceof Number) {
/* 75 */       dao.setDecimalValue(BigDecimal.valueOf(((Number)argValue).doubleValue()));
/*    */     }
/* 77 */     else if (argValue instanceof String) {
/* 78 */       dao.setStringValue((String)argValue);
/*    */     }
/* 80 */     else if (argValue instanceof Date) {
/* 81 */       dao.setDateValue((Date)argValue);
/*    */     }
/* 83 */     else if (argValue instanceof Boolean) {
/* 84 */       dao.setBooleanValue(Boolean.valueOf(((Boolean)argValue).booleanValue()));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private ItemRestrictionDAO getDAO_() {
/* 90 */     return (ItemRestrictionDAO)this._daoImpl;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */