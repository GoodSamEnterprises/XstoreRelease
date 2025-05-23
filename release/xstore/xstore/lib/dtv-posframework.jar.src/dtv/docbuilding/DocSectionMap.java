/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections.map.CaseInsensitiveMap;
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
/*    */ public class DocSectionMap
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(DocSectionMap.class);
/*    */   
/* 20 */   private final Map<String, DocBuilderSection> map_ = (Map<String, DocBuilderSection>)new CaseInsensitiveMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addSection(DocBuilderSection section) {
/* 28 */     String key = section.getName();
/* 29 */     if (this.map_.containsKey(key)) {
/* 30 */       logger_.info("Section " + key + " is defined more than once!");
/*    */     }
/* 32 */     this.map_.put(key, section);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocBuilderSection getSection(String sectionName) {
/* 42 */     DocBuilderSection section = this.map_.get(sectionName);
/* 43 */     if (section == null) {
/* 44 */       StringBuffer sb = new StringBuffer();
/* 45 */       sb.append("Section [").append(sectionName).append("] not found.  Valid sections are:");
/*    */       
/* 47 */       for (DocBuilderSection item : this.map_.values()) {
/* 48 */         sb.append("\n  ");
/* 49 */         sb.append(((DocBuilderSection)item).getName());
/*    */       } 
/* 51 */       logger_.warn(sb.toString());
/*    */     } 
/* 53 */     return section;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocSectionMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */