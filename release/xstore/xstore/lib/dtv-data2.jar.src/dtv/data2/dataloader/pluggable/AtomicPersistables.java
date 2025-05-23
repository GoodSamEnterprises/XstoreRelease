/*    */ package dtv.data2.dataloader.pluggable;
/*    */ 
/*    */ import dtv.data2.access.IPersistable;
/*    */ import dtv.data2.dataloader.fileprocessing.IHasSourceData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AtomicPersistables
/*    */   implements IHasSourceData
/*    */ {
/*    */   private List<IPersistable> _persistables;
/* 21 */   private List<String> _originalSourceLines = new ArrayList<>();
/*    */   
/*    */   public AtomicPersistables(List<IPersistable> argPersistables) {
/* 24 */     this._persistables = argPersistables;
/*    */   }
/*    */   
/*    */   public AtomicPersistables(List<IPersistable> argPersistables, List<String> argSourceLines) {
/* 28 */     this._persistables = argPersistables;
/* 29 */     this._originalSourceLines = argSourceLines;
/*    */   }
/*    */   
/*    */   public AtomicPersistables(List<IPersistable> argPersistables, String argOriginalSourceLine) {
/* 33 */     this(argPersistables, Arrays.asList(new String[] { argOriginalSourceLine }));
/*    */   }
/*    */   
/*    */   public List<IPersistable> getPersistables() {
/* 37 */     return this._persistables;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getSourceData() {
/* 42 */     return this._originalSourceLines;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\AtomicPersistables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */