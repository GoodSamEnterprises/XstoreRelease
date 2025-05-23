/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import dtv.hardware.rcptbuilding.IRcpt;
/*    */ import dtv.util.StringUtils;
/*    */ import java.util.Locale;
/*    */ import org.apache.commons.lang3.LocaleUtils;
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
/*    */ public abstract class AbstractDocBuilderSectionMember
/*    */   implements IDocBuilderSectionMember
/*    */ {
/*    */   private String sourceDescription_;
/*    */   
/*    */   public String getSourceDescription() {
/* 26 */     return this.sourceDescription_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setSourceDescription(String argValue) {
/* 31 */     this.sourceDescription_ = argValue;
/*    */   }
/*    */   
/*    */   protected final void ensureNonNull(Object o, String argMessage) {
/* 35 */     if (o == null) {
/* 36 */       throw new NullPointerException(argMessage);
/*    */     }
/*    */   }
/*    */   
/*    */   protected final Locale getDocumentLocale(IPosDocument argDoc) {
/* 41 */     if (argDoc instanceof IRcpt) {
/* 42 */       String locale = ((IRcpt)argDoc).getLocale();
/* 43 */       if (!StringUtils.isEmpty(locale)) {
/*    */         try {
/* 45 */           return LocaleUtils.toLocale(locale);
/*    */         }
/* 47 */         catch (Throwable throwable) {}
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\AbstractDocBuilderSectionMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */