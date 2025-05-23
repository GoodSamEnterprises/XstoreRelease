/*    */ package dtv.data2.access;
/*    */ 
/*    */ import dtv.util.ArrayUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChainedRelationshipSetProducer
/*    */   implements IRelationshipSetProducer
/*    */ {
/*    */   private final IRelationshipSetProducer[] _producers;
/*    */   
/*    */   public ChainedRelationshipSetProducer(IRelationshipSetProducer... argRelationshipSetProducers) {
/* 19 */     this._producers = argRelationshipSetProducers;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IDataModelRelationship[] getRelationshipSet() {
/* 25 */     IDataModelRelationship[] relationships = null;
/* 26 */     for (IRelationshipSetProducer producer : this._producers) {
/* 27 */       if (relationships == null) {
/* 28 */         relationships = producer.getRelationshipSet();
/*    */       } else {
/*    */         
/* 31 */         relationships = (IDataModelRelationship[])ArrayUtils.combine((Object[])relationships, (Object[])producer.getRelationshipSet());
/*    */       } 
/*    */     } 
/* 34 */     return (relationships != null) ? relationships : new IDataModelRelationship[0];
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\ChainedRelationshipSetProducer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */