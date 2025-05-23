/*    */ package dtv.pos.framework.version;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
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
/*    */ public class VersionChecker
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 3273588308201564350L;
/* 23 */   private static final Logger _logger = Logger.getLogger(VersionChecker.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected static final String NO_PATCH = "0.0";
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean check(Map<File, Map<String, String>> argVersionData) {
/* 34 */     boolean results = true;
/*    */     
/* 36 */     if (argVersionData.size() > 1) {
/* 37 */       String version = null;
/* 38 */       int patches = 0;
/* 39 */       for (File file : argVersionData.keySet()) {
/* 40 */         Map<String, String> strings = argVersionData.get(file);
/* 41 */         String thisVersion = strings.get("CUSTOMER_VERSION");
/* 42 */         String thisPatch = strings.get("PATCH_VERSION");
/*    */ 
/*    */         
/* 45 */         if (version == null) {
/* 46 */           version = thisVersion;
/*    */         }
/* 48 */         else if (!version.equals(thisVersion)) {
/* 49 */           _logger.error("Customer versions do not match! [" + version + "],[" + thisVersion + "]");
/* 50 */           results = false;
/*    */           
/*    */           break;
/*    */         } 
/*    */         
/* 55 */         if (!"0.0".equals(thisPatch)) {
/* 56 */           patches++;
/*    */         }
/*    */       } 
/* 59 */       if (patches == 0) {
/* 60 */         _logger.info("Found zero patches: OK");
/*    */       }
/* 62 */       else if (patches == 1) {
/* 63 */         _logger.info("Found one patch: OK");
/*    */       }
/* 65 */       else if (patches > 1) {
/* 66 */         _logger.error("There are [" + patches + "] patches loaded! This is too many!");
/* 67 */         results = false;
/*    */       } else {
/*    */         
/* 70 */         _logger.fatal("Found a negative number [" + patches + "] of patches!");
/* 71 */         throw new IllegalStateException("Invalid number of patches");
/*    */       } 
/*    */     } 
/* 74 */     return results;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */