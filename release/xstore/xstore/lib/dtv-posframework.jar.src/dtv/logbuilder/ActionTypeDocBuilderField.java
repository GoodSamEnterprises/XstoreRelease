/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.docbuilding.AbstractDocBuilderField;
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.logbuilder.model.ILoggableModel;
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
/*    */ public class ActionTypeDocBuilderField
/*    */   extends AbstractDocBuilderField
/*    */ {
/*    */   public ActionTypeDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/* 38 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 44 */     String action = getAction(argSource);
/* 45 */     return (action == null) ? "" : getFormatter().format(action, argLocale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getAction(Object argSource) {
/* 55 */     if (argSource instanceof IDataModel) {
/* 56 */       IDataModel dao = (IDataModel)argSource;
/* 57 */       if (dao.isNew()) {
/* 58 */         return "Add";
/*    */       }
/* 60 */       return "Update";
/*    */     } 
/* 62 */     if (argSource instanceof ILoggableModel) {
/* 63 */       return ((ILoggableModel)argSource).getAction();
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\ActionTypeDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */