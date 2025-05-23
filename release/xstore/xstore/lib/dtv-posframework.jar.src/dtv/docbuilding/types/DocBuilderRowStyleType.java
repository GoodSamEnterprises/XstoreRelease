/*    */ package dtv.docbuilding.types;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ public class DocBuilderRowStyleType
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 7402936224761917603L;
/* 21 */   private static final Logger logger_ = Logger.getLogger(DocBuilderRowStyleType.class);
/*    */ 
/*    */   
/* 24 */   public static final DocBuilderRowStyleType REVERSE = new DocBuilderRowStyleType("REVERSE");
/* 25 */   public static final DocBuilderRowStyleType UNDERLINE = new DocBuilderRowStyleType("UNDERLINE");
/* 26 */   public static final DocBuilderRowStyleType STRONGUNDERLINE = new DocBuilderRowStyleType("STRONGUNDERLINE");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, DocBuilderRowStyleType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DocBuilderRowStyleType forName(String argName) {
/* 40 */     if (argName == null) {
/* 41 */       return null;
/*    */     }
/* 43 */     DocBuilderRowStyleType found = values_.get(argName.trim().toUpperCase());
/* 44 */     if (found == null) {
/* 45 */       logger_.warn("There is no instance of [" + DocBuilderRowStyleType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 48 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private DocBuilderRowStyleType(String argName) {
/* 60 */     this.name_ = argName.trim().toUpperCase();
/* 61 */     if (values_ == null) {
/* 62 */       values_ = new HashMap<>();
/*    */     }
/* 64 */     values_.put(this.name_, this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   Object readResolve() {
/* 83 */     Object found = values_.get(this.name_);
/* 84 */     if (found == null) {
/* 85 */       return this;
/*    */     }
/*    */     
/* 88 */     return found;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\types\DocBuilderRowStyleType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */