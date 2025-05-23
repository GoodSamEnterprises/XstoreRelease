/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.docbuilding.AbstractDocBuilderField;
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.xst.dao.trl.ICorrectionModifier;
/*    */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*    */ import java.util.Locale;
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
/*    */ public class LogCustAcctActionTypeDocBuilderField
/*    */   extends AbstractDocBuilderField
/*    */ {
/*    */   public LogCustAcctActionTypeDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/* 37 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
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
/*    */   
/*    */   public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 50 */     if (argSource instanceof ISaleReturnLineItem) {
/* 51 */       String action = null;
/*    */       
/* 53 */       ICorrectionModifier mod = ((ISaleReturnLineItem)argSource).getCorrectionModifier();
/* 54 */       action = mod.getReasonCode();
/*    */       
/* 56 */       if (action != null) {
/* 57 */         return getFormatter().format(action, argLocale);
/*    */       }
/*    */     } 
/* 60 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LogCustAcctActionTypeDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */