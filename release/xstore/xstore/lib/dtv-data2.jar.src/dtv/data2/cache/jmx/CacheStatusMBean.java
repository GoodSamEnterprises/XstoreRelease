/*    */ package dtv.data2.cache.jmx;
/*    */ 
/*    */ import dtv.data2.cache.CacheManager;
/*    */ import dtv.data2.cache.ICache;
/*    */ import dtv.data2.cache.config.CacheConfigHelper;
/*    */ import dtv.jmx.AbstractDtvMBean;
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
/*    */ public class CacheStatusMBean
/*    */   extends AbstractDtvMBean
/*    */ {
/*    */   public String clearCaches() {
/* 23 */     CacheManager.getInstance().clear();
/* 24 */     return "Clear request made to CacheManager.";
/*    */   }
/*    */   
/*    */   public String getCacheStatus() {
/* 28 */     List<ICache> caches = CacheManager.getInstance().getManagedCaches();
/*    */ 
/*    */ 
/*    */     
/* 32 */     StringBuilder buff = new StringBuilder(1024);
/* 33 */     tableHeader(buff);
/*    */     
/* 35 */     for (ICache cache : caches) {
/* 36 */       row(buff, cache);
/*    */     }
/*    */     
/* 39 */     tableFooter(buff);
/*    */     
/* 41 */     return buff.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void startMBean() {}
/*    */ 
/*    */ 
/*    */   
/*    */   private String bold(String argElement) {
/* 51 */     return "<strong>" + argElement + "</strong>";
/*    */   }
/*    */   
/*    */   private String font(String argElement) {
/* 55 */     return "<font face=\"Arial,  Helvetica,  sans-serif\">" + argElement + "</font>";
/*    */   }
/*    */   
/*    */   private void row(StringBuilder argBuff, ICache argCache) {
/* 59 */     argBuff.append("<tr><td>").append(bold(argCache.getCacheId())).append("</td><td>")
/* 60 */       .append(argCache.getStatusReport()).append("</td><td>")
/* 61 */       .append(CacheConfigHelper.getCacheDefConfig(argCache.getCacheId()).getSourceDescription())
/* 62 */       .append("</td></tr>");
/*    */   }
/*    */   
/*    */   private void tableFooter(StringBuilder argDoc) {
/* 66 */     argDoc.append("  </table>");
/*    */   }
/*    */   
/*    */   private void tableHeader(StringBuilder argDoc) {
/* 70 */     argDoc.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\">");
/* 71 */     argDoc.append("  <tr bgcolor=\"#CCCCCC\"> ");
/* 72 */     argDoc.append("    <td>").append(font(bold("Cache Id"))).append("</td>");
/* 73 */     argDoc.append("    <td>").append(font(bold("Status"))).append("</td>");
/* 74 */     argDoc.append("    <td>").append(font(bold("Config"))).append("</td>");
/* 75 */     argDoc.append("  </tr>");
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\cache\jmx\CacheStatusMBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */