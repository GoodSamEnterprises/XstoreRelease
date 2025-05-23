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
/*    */ public class IntDataPropertyAccessor<T extends IHasDataProperty<? extends IDataProperty>>
/*    */   extends AbstractDataPropertyAccessor<T, Integer>
/*    */ {
/*    */   public IntDataPropertyAccessor(Class<T> argParentType, String argKey) {
/* 22 */     super(argParentType, argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getValue(T argParent) {
/* 31 */     return getValue(argParent, Integer.valueOf(0));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getValue(T argParent, Integer argDefault) {
/* 40 */     Integer def = Integer.valueOf(argDefault.intValue());
/* 41 */     return getValueObject(argParent, def);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getValueObject(T argParent) {
/* 50 */     return getValueObject(argParent, (Integer)null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getValueObject(T argParent, Integer argDefault) {
/* 60 */     BigDecimal value = validParent(argParent).getDecimalProperty(getKey());
/* 61 */     if (value == null) {
/* 62 */       return argDefault;
/*    */     }
/* 64 */     return Integer.valueOf(value.intValue());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<Integer> getValueType() {
/* 73 */     return Integer.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(T argParent, Integer argValue) {
/* 79 */     validParent(argParent).setDecimalProperty(getKey(), BigDecimal.valueOf(argValue.intValue()));
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IntDataPropertyAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */