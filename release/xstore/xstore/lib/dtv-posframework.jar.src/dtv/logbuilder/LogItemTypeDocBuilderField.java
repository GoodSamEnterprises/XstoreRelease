/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.docbuilding.AbstractDocBuilderField;
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.xst.dao.itm.IItem;
/*    */ import dtv.xst.dao.itm.INonPhysicalItem;
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
/*    */ 
/*    */ public class LogItemTypeDocBuilderField
/*    */   extends AbstractDocBuilderField
/*    */ {
/*    */   public LogItemTypeDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/* 39 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
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
/* 52 */     if (argSource instanceof ISaleReturnLineItem) {
/* 53 */       String itemType = null;
/*    */       
/* 55 */       IItem item = ((ISaleReturnLineItem)argSource).getItem();
/* 56 */       if (item instanceof INonPhysicalItem) {
/* 57 */         itemType = ((INonPhysicalItem)item).getNonPhysicalItemTypeCode();
/*    */       } else {
/*    */         
/* 60 */         itemType = (item == null) ? null : item.getItemTypeCode();
/*    */       } 
/*    */       
/* 63 */       if (itemType != null) {
/* 64 */         return getFormatter().format(itemType, argLocale);
/*    */       }
/*    */     } 
/* 67 */     return "Stock";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LogItemTypeDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */