/*    */ package dtv.data2.access;
/*    */ 
/*    */ import java.math.BigDecimal;
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
/*    */ public class DecimalDataPropertyAccessor<T extends IHasDataProperty<? extends IDataProperty>>
/*    */   extends AbstractDataPropertyAccessor<T, BigDecimal>
/*    */ {
/*    */   public DecimalDataPropertyAccessor(Class<T> argParentType, String argKey) {
/* 22 */     super(argParentType, argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getValue(T argParent) {
/* 31 */     return getValue(argParent, BigDecimal.ZERO);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BigDecimal getValue(T argParent, BigDecimal argDefault) {
/* 37 */     BigDecimal value = validParent(argParent).getDecimalProperty(getKey());
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
/*    */   public Class<BigDecimal> getValueType() {
/* 50 */     return BigDecimal.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(T argParent, BigDecimal argValue) {
/* 56 */     validParent(argParent).setDecimalProperty(getKey(), argValue);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DecimalDataPropertyAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */