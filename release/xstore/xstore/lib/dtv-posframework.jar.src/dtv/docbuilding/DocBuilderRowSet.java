/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderRowSet
/*    */   extends DocBuilderCall
/*    */   implements IDocBuilderIterator
/*    */ {
/* 41 */   private static final Logger _logger = Logger.getLogger(DocBuilderRowSet.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocBuilderRowSet() {
/* 47 */     this((List<IDocBuilderCondition>)null, (List<DocBuilderRow>)null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocBuilderRowSet(List<IDocBuilderCondition> argConditions, List<DocBuilderRow> argRows) {
/* 58 */     setConditions(argConditions);
/*    */     
/* 60 */     if (argRows != null) {
/* 61 */       for (DocBuilderRow row : argRows) {
/* 62 */         addMember(row);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) {
/*    */     try {
/* 71 */       if (!DocBuilderHelper.meetsConditions(argSource, getConditions())) {
/*    */         return;
/*    */       }
/*    */       
/* 75 */       for (IDocBuilderSectionMember row : getMembers()) {
/* 76 */         row.buildDoc(argDoc, argSource, argElementFactory);
/*    */       }
/*    */     }
/* 79 */     catch (Exception ex) {
/* 80 */       _logger.warn("CAUGHT EXCEPTION building RowSet @@ [" + getSourceDescription() + "]", ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderRowSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */