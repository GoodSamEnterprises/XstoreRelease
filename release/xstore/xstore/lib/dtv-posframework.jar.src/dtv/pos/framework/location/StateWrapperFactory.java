/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
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
/*    */ public class StateWrapperFactory
/*    */   implements IValueWrapperFactory
/*    */ {
/*    */   private String _countryCode;
/*    */   
/*    */   public StateWrapperFactory(String argCountryCode) {
/* 21 */     this._countryCode = argCountryCode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCountryCode() {
/* 28 */     return this._countryCode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCountryCode(String argCountryCode) {
/* 36 */     this._countryCode = argCountryCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object wrapValue(Object argObject) {
/* 42 */     StateValueWrapper wrapped = new StateValueWrapper(this._countryCode);
/* 43 */     wrapped.setActualValue(argObject);
/* 44 */     return wrapped;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StateWrapperFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */