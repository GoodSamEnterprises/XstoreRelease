/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.util.ICodeInterface;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ public class CodeLocator
/*     */ {
/*  22 */   private static final Logger _logger = Logger.getLogger(CodeLocator.class);
/*  23 */   private static final String IMPL_KEY = ICodeLocator.class.getName();
/*     */   
/*  25 */   private static ICodeLocator _impl = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ICodeInterface getCode(IObjectId argObjectId) {
/*     */     try {
/*  36 */       return getImpl().getCode(argObjectId);
/*     */     }
/*  38 */     catch (ObjectNotFoundException ex) {
/*  39 */       _logger.debug(ex);
/*     */     }
/*  41 */     catch (Exception ex) {
/*  42 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*  44 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<? extends ICodeInterface> getCodes(Class<? extends IObjectId> argObjectIdClass) {
/*     */     try {
/*  56 */       return getImpl().getCodes(argObjectIdClass);
/*     */     }
/*  58 */     catch (ObjectNotFoundException ex) {
/*  59 */       _logger.debug(ex);
/*     */     }
/*  61 */     catch (Exception ex) {
/*  62 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*  64 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<String> getCodes(long argOrgId, String argCategory) {
/*  75 */     List<String> codes = new ArrayList<>();
/*  76 */     List<? extends ICodeValue> codeRecs = getCodeValues(argOrgId, argCategory);
/*     */     
/*  78 */     for (ICodeValue codeRec : codeRecs) {
/*  79 */       codes.add(codeRec.getCode());
/*     */     }
/*     */     
/*  82 */     return codes;
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
/*     */   public static ICodeValue getCodeValue(long argOrgId, String argCategory, String argCode) {
/*     */     try {
/*  96 */       return getImpl().getCodeValue(argOrgId, argCategory, argCode);
/*     */     }
/*  98 */     catch (ObjectNotFoundException ex) {
/*  99 */       _logger.debug(ex);
/*     */     }
/* 101 */     catch (Exception ex) {
/* 102 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 104 */     return null;
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
/*     */   public static List<? extends ICodeValue> getCodeValues(long argOrgId, String argCategory) {
/*     */     try {
/* 117 */       return new ArrayList<>(getImpl().getCodeValues(argOrgId, argCategory));
/*     */     }
/* 119 */     catch (ObjectNotFoundException ex) {
/* 120 */       _logger.debug(ex);
/*     */     }
/* 122 */     catch (Exception ex) {
/* 123 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 125 */     return Collections.emptyList();
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
/*     */   public static IReasonCode getReasonCode(long argOrgId, String argCategory, String argCode) {
/*     */     try {
/* 139 */       return getImpl().getReasonCode(argOrgId, argCategory, argCode);
/*     */     }
/* 141 */     catch (ObjectNotFoundException ex) {
/* 142 */       _logger.debug(ex);
/*     */     }
/* 144 */     catch (Exception ex) {
/* 145 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 147 */     return null;
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
/*     */   public static List<? extends IReasonCode> getReasonCodes(long argOrgId, String argCategory) {
/* 159 */     return getReasonCodes(argOrgId, argCategory, null);
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
/*     */   
/*     */   public static List<? extends IReasonCode> getReasonCodes(long argOrgId, String argCategory, String argParentCode) {
/*     */     try {
/* 176 */       return getImpl().getReasonCodes(argOrgId, argCategory, argParentCode);
/*     */     }
/* 178 */     catch (ObjectNotFoundException ex) {
/* 179 */       _logger.debug(ex);
/*     */     }
/* 181 */     catch (Exception ex) {
/* 182 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 184 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ICodeLocator getImpl() {
/* 192 */     if (_impl == null) {
/* 193 */       String className = System.getProperty(IMPL_KEY);
/*     */       try {
/* 195 */         _impl = (ICodeLocator)Class.forName(className).newInstance();
/*     */       }
/* 197 */       catch (Exception ex) {
/* 198 */         _impl = new CodeLocatorImpl();
/*     */       } 
/*     */     } 
/* 201 */     return _impl;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\CodeLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */