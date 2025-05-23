/*     */ package dtv.logbuilder.routing;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ public class RoutingRule
/*     */   implements IRoutingRule
/*     */ {
/*  22 */   private static final Logger logger_ = Logger.getLogger(RoutingRule.class);
/*     */   
/*  24 */   private String documentId_ = null;
/*  25 */   private String fileId_ = null;
/*  26 */   private String sourceDescription_ = null;
/*     */   
/*  28 */   private final List<IDocBuilderCondition> conditions_ = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private String toString_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCondition(IDocBuilderCondition argCondition) {
/*  38 */     this.conditions_.add(argCondition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesRuleApply(Object argSource) {
/*     */     try {
/*  47 */       boolean debugEnabled = logger_.isDebugEnabled();
/*  48 */       if (debugEnabled) {
/*  49 */         logger_.debug("checking " + toString() + "::" + getSourceDescription());
/*     */       }
/*  51 */       for (IDocBuilderCondition c : this.conditions_) {
/*  52 */         if (!c.conditionMet(argSource)) {
/*  53 */           if (debugEnabled) {
/*  54 */             logger_.debug("condition not met " + c + "::" + c.getSourceDescription());
/*     */           }
/*  56 */           return false;
/*     */         } 
/*     */       } 
/*  59 */       if (debugEnabled) {
/*  60 */         logger_.debug("rule applies");
/*     */       }
/*  62 */       return true;
/*     */     }
/*  64 */     catch (Exception ex) {
/*  65 */       logger_.error("CAUGHT EXCEPTION with " + toString(), ex);
/*  66 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getDocumentId() {
/*  75 */     return this.documentId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getFileId() {
/*  83 */     return this.fileId_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/*  89 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setDocumentId(String argDocumentId) {
/*  99 */     this.documentId_ = argDocumentId;
/* 100 */     this.toString_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFileId(String newValue) {
/* 108 */     this.fileId_ = newValue;
/* 109 */     this.toString_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, Object argValue) {
/* 117 */     logger_.warn(("rule [" + getClass().getName() + "] does not support paramter named [" + argName + "] of type [" + argValue == null) ? null : (argValue
/* 118 */         .getClass().getName() + "]"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argValue) {
/* 124 */     this.sourceDescription_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     if (this.toString_ == null) {
/* 135 */       StringBuffer sb = new StringBuffer();
/* 136 */       sb.append("RoutingRule[");
/* 137 */       sb.append(this.documentId_);
/* 138 */       sb.append("-->");
/* 139 */       sb.append(this.fileId_);
/* 140 */       sb.append("]");
/* 141 */       this.toString_ = sb.toString();
/*     */     } 
/* 143 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\routing\RoutingRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */