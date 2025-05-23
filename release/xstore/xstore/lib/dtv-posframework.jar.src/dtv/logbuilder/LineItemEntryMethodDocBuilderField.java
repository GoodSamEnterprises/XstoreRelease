/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.docbuilding.AbstractDocBuilderField;
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*    */ import dtv.xst.dao.trl.IVoucherSaleLineItem;
/*    */ import dtv.xst.dao.ttr.ICheckTenderLineItem;
/*    */ import dtv.xst.dao.ttr.ICreditDebitTenderLineItem;
/*    */ import dtv.xst.dao.ttr.IVoucherTenderLineItem;
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
/*    */ public class LineItemEntryMethodDocBuilderField
/*    */   extends AbstractDocBuilderField
/*    */ {
/*    */   public LineItemEntryMethodDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/* 38 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 44 */     String entryMethod = getEntryMethod(argSource);
/* 45 */     return (entryMethod == null) ? "" : getFormatter().format(entryMethod, argLocale);
/*    */   }
/*    */   
/*    */   private String getEntryMethod(Object argSource) {
/* 49 */     if (argSource instanceof ISaleReturnLineItem) {
/* 50 */       return ((ISaleReturnLineItem)argSource).getItemIdEntryMethodCode();
/*    */     }
/* 52 */     if (argSource instanceof IVoucherSaleLineItem) {
/* 53 */       return ((IVoucherSaleLineItem)argSource).getEntryMethodCode();
/*    */     }
/* 55 */     if (argSource instanceof IVoucherTenderLineItem) {
/* 56 */       return ((IVoucherTenderLineItem)argSource).getEntryMethodCode();
/*    */     }
/* 58 */     if (argSource instanceof ICheckTenderLineItem) {
/* 59 */       return ((ICheckTenderLineItem)argSource).getEntryMethodCode();
/*    */     }
/* 61 */     if (argSource instanceof ICreditDebitTenderLineItem) {
/* 62 */       return ((ICreditDebitTenderLineItem)argSource).getEntryMethodCode();
/*    */     }
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LineItemEntryMethodDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */