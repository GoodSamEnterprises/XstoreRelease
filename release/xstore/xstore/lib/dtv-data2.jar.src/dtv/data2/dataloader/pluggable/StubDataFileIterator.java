/*    */ package dtv.data2.dataloader.pluggable;
/*    */ 
/*    */ import java.util.NoSuchElementException;
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
/*    */ public class StubDataFileIterator
/*    */   implements IDataFileIterator
/*    */ {
/*    */   public void close() {}
/*    */   
/*    */   public DataFileMetaData<?> getMetaData() {
/* 22 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AtomicPersistables next() throws DataFileException {
/* 35 */     throw new NoSuchElementException();
/*    */   }
/*    */   
/*    */   public void remove() {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\StubDataFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */