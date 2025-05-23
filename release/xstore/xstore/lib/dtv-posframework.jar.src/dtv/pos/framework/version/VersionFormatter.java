/*     */ package dtv.pos.framework.version;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Iterator;
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
/*     */ public class VersionFormatter
/*     */   implements IVersionFormatter
/*     */ {
/*     */   private static final String DEFAULT_ELEMENT_DELIMITER = ".";
/*     */   private static final String DEFAULT_LEVEL_DELIMITER = " - ";
/*     */   private static final String DEFAULT_UNKNOWN = "<unknown>";
/*  33 */   private static final IVersionFormatter _standardFormatter = new VersionFormatter(".", " - ", "<unknown>");
/*     */   
/*  35 */   private static final IVersionFormatter _packingFormatter = new VersionFormatter(null, null, null);
/*     */   
/*     */   private final String _elementDelimiter;
/*     */   
/*     */   private final String _levelDelimiter;
/*     */   
/*     */   private final String _unknown;
/*     */ 
/*     */   
/*     */   public static IVersionFormatter createPackingFormatter() {
/*  45 */     return _packingFormatter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IVersionFormatter createStandardFormatter() {
/*  55 */     return _standardFormatter;
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
/*     */   public VersionFormatter(String argElemDelim, String argLevelDelim) {
/*  69 */     this(argElemDelim, argLevelDelim, "<unknown>");
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
/*     */   public VersionFormatter(String argElemDelim, String argLevelDelim, String argUnknown) {
/*  82 */     this._elementDelimiter = StringUtils.nonNull(argElemDelim);
/*  83 */     this._levelDelimiter = StringUtils.nonNull(argLevelDelim);
/*  84 */     this._unknown = StringUtils.nonNull(argUnknown);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String format(UniversalVersion argVersion) {
/*  90 */     String toString = null;
/*     */     
/*  92 */     if (argVersion == null || argVersion.isUnknown()) {
/*     */       
/*  94 */       toString = this._unknown;
/*     */     } else {
/*     */       
/*  97 */       StringBuilder sb = new StringBuilder();
/*     */ 
/*     */       
/* 100 */       for (Iterator<UniversalVersion.IVersionLevel> levelIter = argVersion.iterator(); levelIter.hasNext(); ) {
/* 101 */         UniversalVersion.IVersionLevel level = levelIter.next();
/*     */ 
/*     */         
/* 104 */         for (Iterator<String> elemIter = level.iterator(); elemIter.hasNext(); ) {
/*     */           
/* 106 */           String element = elemIter.next();
/* 107 */           sb.append(element);
/*     */ 
/*     */ 
/*     */           
/* 111 */           if (elemIter.hasNext()) {
/* 112 */             sb.append(this._elementDelimiter);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 117 */         if (levelIter.hasNext()) {
/* 118 */           sb.append(this._levelDelimiter);
/*     */         }
/*     */       } 
/* 121 */       toString = sb.toString();
/*     */     } 
/* 123 */     return toString;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */