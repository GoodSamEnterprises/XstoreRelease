/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
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
/*    */ public class MOMDataFileIterator
/*    */   extends AbstractMOMDataFileIterator
/*    */ {
/* 23 */   private static final Logger _logger = Logger.getLogger(MOMDataFileIterator.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MOMDataFileIterator(DataFileMetaData<MOMFileConfiguration> argMetaData) {
/* 31 */     super(argMetaData);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected MOMUnit getCompletedUnit(MOMFileLine argLine) {
/* 39 */     MOMUnit unit = new MOMUnit(argLine, argLine.getRecordType());
/* 40 */     return unit;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMDataFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */