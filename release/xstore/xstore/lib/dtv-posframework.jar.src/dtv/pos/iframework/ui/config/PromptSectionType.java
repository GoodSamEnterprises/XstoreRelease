/*    */ package dtv.pos.iframework.ui.config;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ public class PromptSectionType
/*    */ {
/* 17 */   public static final PromptSectionType TITLE = new PromptSectionType("Title");
/*    */ 
/*    */   
/* 20 */   public static final PromptSectionType MESSAGE = new PromptSectionType("Message");
/*    */ 
/*    */   
/* 23 */   public static final PromptSectionType SECONDARY_MESSAGE = new PromptSectionType("Secondary_Message");
/*    */   
/* 25 */   private static final Logger logger_ = Logger.getLogger(PromptSectionType.class);
/*    */ 
/*    */   
/*    */   private static Map<String, PromptSectionType> keyMap_;
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static PromptSectionType find(String name) {
/* 36 */     if (name == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     PromptSectionType foundType = keyMap_.get(name.trim().toUpperCase());
/*    */     
/* 41 */     if (foundType == null) {
/* 42 */       logger_.debug("Configuration setting [" + name + "] not supported!");
/*    */     }
/* 44 */     return foundType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private PromptSectionType(String argName) {
/* 54 */     this.name_ = argName;
/* 55 */     if (keyMap_ == null) {
/* 56 */       keyMap_ = new HashMap<>();
/*    */     }
/* 58 */     keyMap_.put(argName.trim().toUpperCase(), this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 66 */     return this.name_;
/*    */   }
/*    */   
/*    */   public boolean matches(String argName) {
/* 70 */     return getName().equalsIgnoreCase(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\PromptSectionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */