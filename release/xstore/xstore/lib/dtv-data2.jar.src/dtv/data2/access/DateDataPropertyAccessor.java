/*    */ package dtv.data2.access;
/*    */ 
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
/*    */ public class DateDataPropertyAccessor<T extends IHasDataProperty<? extends IDataProperty>>
/*    */   extends AbstractDataPropertyAccessor<T, Date>
/*    */ {
/*    */   public DateDataPropertyAccessor(Class<T> argParentType, String argKey) {
/* 22 */     super(argParentType, argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getValue(T argParent) {
/* 31 */     return getValue(argParent, (Date)null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Date getValue(T argParent, Date argDefault) {
/* 37 */     Date value = validParent(argParent).getDateProperty(getKey());
/* 38 */     if (value == null) {
/* 39 */       return argDefault;
/*    */     }
/* 41 */     return value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<Date> getValueType() {
/* 50 */     return Date.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(T argParent, Date argValue) {
/* 56 */     validParent(argParent).setDateProperty(getKey(), argValue);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DateDataPropertyAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */