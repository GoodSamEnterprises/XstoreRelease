/*     */ package dtv.docbuilding.types;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderAlignmentType
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7450985582796257034L;
/*  22 */   private static final Logger logger_ = Logger.getLogger(DocBuilderAlignmentType.class);
/*     */ 
/*     */   
/*  25 */   public static final DocBuilderAlignmentType DEFAULT = make(new String[] { "DEFAULT" });
/*  26 */   public static final DocBuilderAlignmentType LEFT = make(new String[] { "LEFT", "L" });
/*  27 */   public static final DocBuilderAlignmentType RIGHT = make(new String[] { "RIGHT", "R" });
/*  28 */   public static final DocBuilderAlignmentType CENTERED = make(new String[] { "CENTERED", "C" });
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, DocBuilderAlignmentType> values_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static DocBuilderAlignmentType forName(String argName) {
/*  40 */     if (argName == null) {
/*  41 */       return null;
/*     */     }
/*  43 */     DocBuilderAlignmentType found = values_.get(argName.trim().toUpperCase());
/*  44 */     if (found == null) {
/*  45 */       found = LEFT;
/*  46 */       logger_.warn("There is no instance of [" + DocBuilderAlignmentType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     } 
/*     */     
/*  49 */     return found;
/*     */   }
/*     */   
/*     */   public static DocBuilderAlignmentType make(String... argNames) {
/*  53 */     DocBuilderAlignmentType instance = null;
/*     */     
/*  55 */     for (String name : argNames) {
/*  56 */       if (instance == null) {
/*  57 */         instance = new DocBuilderAlignmentType(name);
/*     */       } else {
/*     */         
/*  60 */         values_.put(name.trim().toUpperCase(), instance);
/*     */       } 
/*     */     } 
/*  63 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocBuilderAlignmentType(String argName) {
/*  75 */     this.name_ = argName.trim().toUpperCase();
/*  76 */     if (values_ == null) {
/*  77 */       values_ = new HashMap<>();
/*     */     }
/*  79 */     values_.put(this.name_, this);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  83 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object readResolve() {
/* 102 */     Object found = values_.get(this.name_);
/* 103 */     if (found == null) {
/* 104 */       return this;
/*     */     }
/*     */     
/* 107 */     return found;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\types\DocBuilderAlignmentType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */