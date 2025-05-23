/*    */ package dtv.xst.pricing.refresh;
/*    */ 
/*    */ import dtv.pricing2.PricingDeal;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class PreloadedDealDefinitions
/*    */ {
/* 20 */   private static final Map<String, PricingDeal> _deals = new HashMap<>();
/*    */   
/*    */   public static PricingDeal get(String key) {
/* 23 */     return _deals.get(key);
/*    */   }
/*    */   
/*    */   public static void put(String key, PricingDeal value) {
/* 27 */     _deals.put(key, value);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\refresh\PreloadedDealDefinitions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */