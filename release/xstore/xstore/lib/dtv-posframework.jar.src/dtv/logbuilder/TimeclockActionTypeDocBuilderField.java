/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.xst.dao.thr.ITimecardEntry;
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
/*    */ public class TimeclockActionTypeDocBuilderField
/*    */   extends ActionTypeDocBuilderField
/*    */ {
/*    */   public TimeclockActionTypeDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/* 33 */     super(argContents, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getAction(Object argSource) {
/* 39 */     if (argSource instanceof ITimecardEntry && (
/* 40 */       (ITimecardEntry)argSource).getDelete()) {
/* 41 */       return "Delete";
/*    */     }
/*    */     
/* 44 */     if (argSource instanceof IDataModel) {
/* 45 */       IDataModel dao = (IDataModel)argSource;
/* 46 */       if (dao.isNew()) {
/* 47 */         return "Add";
/*    */       }
/* 49 */       return "Update";
/*    */     } 
/* 51 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\TimeclockActionTypeDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */