/*    */ package dtv.data2.access;
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
/*    */ public class StringDataPropertyAccessor<T extends IHasDataProperty<? extends IDataProperty>>
/*    */   extends AbstractDataPropertyAccessor<T, String>
/*    */ {
/*    */   public StringDataPropertyAccessor(Class<T> argParentType, String argKey) {
/* 20 */     super(argParentType, argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue(T argParent) {
/* 29 */     return getValue(argParent, "");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue(T argParent, String argDefault) {
/* 35 */     String value = validParent(argParent).getStringProperty(getKey());
/* 36 */     if (value == null) {
/* 37 */       return argDefault;
/*    */     }
/* 39 */     return value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<String> getValueType() {
/* 48 */     return String.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(T argParent, String argValue) {
/* 54 */     validParent(argParent).setStringProperty(getKey(), argValue);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\StringDataPropertyAccessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */