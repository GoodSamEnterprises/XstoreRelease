/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections.map.CaseInsensitiveMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocSectionParamMap
/*     */ {
/*  37 */   public static final DocSectionParamMap DUMMY = new DocSectionParamMap()
/*     */     {
/*     */       public void endParamScope() {}
/*     */ 
/*     */       
/*     */       public String makeParamName(String argExpr) {
/*  43 */         return argExpr;
/*     */       }
/*     */ 
/*     */       
/*     */       public String resolveParamValue(String argExpr) {
/*  48 */         return argExpr;
/*     */       }
/*     */ 
/*     */       
/*     */       public void setParamValue(String argName, String argValue) {}
/*     */ 
/*     */       
/*     */       public void setParamValues(Map<String, String> argValues) {}
/*     */ 
/*     */       
/*     */       public void startParamScope() {}
/*     */ 
/*     */       
/*     */       public void startParamScope(Map<String, String> argParams) {}
/*     */     };
/*     */ 
/*     */   
/*     */   public static final String DEFAULT_PREFIX = "@";
/*     */   
/*  67 */   private final Deque<Map<String, String>> _scopes = new ArrayDeque<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void endParamScope() {
/*  74 */     this._scopes.poll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String makeParamName(String argExpr) {
/*  85 */     return isParamName(argExpr) ? argExpr : (getParamPrefix() + argExpr);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String resolveParamValue(String argExpr) {
/* 100 */     String value = argExpr;
/*     */     
/* 102 */     if (isParamName(argExpr)) {
/* 103 */       String paramName = getParamName(argExpr);
/*     */ 
/*     */ 
/*     */       
/* 107 */       value = null;
/*     */ 
/*     */ 
/*     */       
/* 111 */       for (Map<String, String> params : this._scopes) {
/* 112 */         if (params.containsKey(paramName)) {
/* 113 */           value = params.get(paramName);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 118 */     return StringUtils.nonNull(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParamValue(String argName, String argValue) {
/* 129 */     if (argName != null && !this._scopes.isEmpty()) {
/* 130 */       ((Map<String, String>)this._scopes.peek()).put(argName, argValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParamValues(Map<String, String> argValues) {
/* 141 */     if (argValues != null && !this._scopes.isEmpty()) {
/* 142 */       ((Map<String, String>)this._scopes.peek()).putAll(argValues);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startParamScope() {
/* 150 */     startParamScope(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startParamScope(Map<String, String> argParams) {
/* 161 */     this._scopes.push(new CaseInsensitiveMap());
/* 162 */     setParamValues(argParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getParamName(String argExpr) {
/* 173 */     String prefix = getParamPrefix();
/* 174 */     return argExpr.startsWith(prefix) ? argExpr.substring(prefix.length()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getParamPrefix() {
/* 182 */     return "@";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isParamName(String argExpr) {
/* 193 */     return (getParamName(argExpr) != null);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocSectionParamMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */