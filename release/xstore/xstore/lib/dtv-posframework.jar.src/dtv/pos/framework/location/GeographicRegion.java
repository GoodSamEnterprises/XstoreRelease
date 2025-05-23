/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.util.address.ICountry;
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
/*    */ public class GeographicRegion
/*    */   implements IRegion
/*    */ {
/*    */   private ICountry[] _countries;
/*    */   private IFormattable _name;
/*    */   private String _id;
/*    */   
/*    */   public ICountry[] getCountries() {
/* 28 */     return this._countries;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getId() {
/* 37 */     return this._id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getName() {
/* 46 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCountries(ICountry[] argCountries) {
/* 54 */     this._countries = argCountries;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setId(String argId) {
/* 62 */     this._id = argId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setName(IFormattable argName) {
/* 70 */     this._name = argName;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\GeographicRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */