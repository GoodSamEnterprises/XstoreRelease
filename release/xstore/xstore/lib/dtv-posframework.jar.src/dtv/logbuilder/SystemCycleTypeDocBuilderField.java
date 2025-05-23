/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.docbuilding.AbstractDocBuilderField;
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
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
/*    */ public class SystemCycleTypeDocBuilderField
/*    */   extends AbstractDocBuilderField
/*    */ {
/*    */   public SystemCycleTypeDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/* 36 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 42 */     IPosTransaction tran = (IPosTransaction)argSource;
/* 43 */     String code = tran.getTransactionTypeCode();
/* 44 */     return getFormatter().format(code, argLocale);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\SystemCycleTypeDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */