/*    */ package dtv.data2.access;
/*    */ 
/*    */ import dtv.util.NumberUtils;
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
/*    */ 
/*    */ public class BooleanDataPropertyAccessor<T extends IHasDataProperty<? extends IDataProperty>>
/*    */   extends AbstractDataPropertyAccessor<T, Boolean>
/*    */ {
/*    */   public BooleanDataPropertyAccessor(Class<T> argParentType, String argKey) {
/* 24 */     super(argParentType, argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean getValue(T argParent) {
/* 33 */     return getValue(argParent, Boolean.valueOf(false));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean getValue(T argParent, Boolean argDefault) {
/* 42 */     Boolean def = Boolean.valueOf(argDefault.booleanValue());
/* 43 */     Boolean value = getValueObject(argParent, def);
/* 44 */     return Boolean.valueOf(value.booleanValue());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean getValueObject(T argParent) {
/* 53 */     return getValueObject(argParent, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean getValueObject(T argParent, Boolean argDefault) {
/* 63 */     BigDecimal value = argParent.getDecimalProperty(getKey());
/* 64 */     if (value == null) {
/* 65 */       return argDefault;
/*    */     }
/* 67 */     return Boolean.valueOf(!NumberUtils.isZero(value));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<Boolean> getValueType() {
/* 76 */     return Boolean.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(T argParent, Boolean argValue) {
/* 82 */     argParent.setDecimalProperty(getKey(), argValue.booleanValue() ? BigDecimal.ONE : BigDecimal.ZERO);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\BooleanDataPropertyAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */