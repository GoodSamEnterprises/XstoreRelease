/*    */ package dtv.pos;
/*    */ 
/*    */ import dtv.util.StringUtils;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class LocationIdentification
/*    */ {
/* 22 */   private static final Logger logger_ = Logger.getLogger(LocationIdentification.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/*    */     try {
/* 32 */       String separator = StringUtils.NEW_LINE + StringUtils.fill("*", 20) + StringUtils.NEW_LINE;
/*    */       
/* 34 */       StringBuilder builder = new StringBuilder();
/* 35 */       builder.append(separator);
/* 36 */       builder.append("LOCATION INFORMATION");
/* 37 */       builder.append(separator);
/* 38 */       builder.append(StringUtils.NEW_LINE);
/* 39 */       builder.append(String.format("dtv.CustomerId: %1$s" + StringUtils.NEW_LINE + "OrganizationId: %2$s" + StringUtils.NEW_LINE + "RetailLocationId: %3$s" + StringUtils.NEW_LINE + "WorkstationId: %4$s" + StringUtils.NEW_LINE, new Object[] {
/*    */ 
/*    */ 
/*    */               
/* 43 */               getCustomerId(), getOrganizationId(), getRetailLocationId(), getWorkstationId() }));
/* 44 */       return builder.toString();
/*    */     }
/* 46 */     catch (Throwable ex) {
/* 47 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 48 */       return "";
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 59 */     return getDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String getCustomerId() {
/* 68 */     return System.getProperty("dtv.CustomerId", "");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String getOrganizationId() {
/* 77 */     return System.getProperty("dtv.loc.organizationId", System.getProperty("dtv.location.organizationId", ""));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String getRetailLocationId() {
/* 86 */     return System.getProperty("dtv.loc.storeNumber", System.getProperty("dtv.location.storeNumber", ""));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String getWorkstationId() {
/* 95 */     return System.getProperty("dtv.loc.terminalId", System.getProperty("dtv.location.terminalNumber", ""));
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\LocationIdentification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */