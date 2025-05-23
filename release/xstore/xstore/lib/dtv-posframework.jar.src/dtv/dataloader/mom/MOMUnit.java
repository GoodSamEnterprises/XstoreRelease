/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MOMUnit
/*    */ {
/*    */   private final List<MOMFileLine> _data;
/*    */   private final String _type;
/*    */   
/*    */   public MOMUnit(List<MOMFileLine> argData, String argType) {
/* 28 */     this._data = argData;
/* 29 */     this._type = argType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MOMUnit(MOMFileLine argData, String argType) {
/* 39 */     this._data = new ArrayList<>();
/* 40 */     this._data.add(argData);
/* 41 */     this._type = argType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<MOMFileLine> getData() {
/* 50 */     return this._data;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getType() {
/* 59 */     return this._type;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */