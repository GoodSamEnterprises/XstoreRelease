/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.pos.framework.action.access.AbstractVisibilityRule;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.util.address.ICountry;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
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
/*    */ public class ChangeCountryVisibilityRule
/*    */   extends AbstractVisibilityRule
/*    */ {
/*    */   protected IAccessLevel checkVisibilityImpl() {
/* 29 */     Collection<IRegion> regions = StoreLocationHelper.getInstance().getRegions();
/* 30 */     List<ICountry> countries = new ArrayList<>();
/*    */     
/* 32 */     for (IRegion region : regions) {
/* 33 */       countries.addAll(Arrays.asList(region.getCountries()));
/*    */     }
/*    */     
/* 36 */     return (countries.isEmpty() || countries.size() == 1) ? (IAccessLevel)AccessLevel.DENIED : (IAccessLevel)AccessLevel.GRANTED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\ChangeCountryVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */