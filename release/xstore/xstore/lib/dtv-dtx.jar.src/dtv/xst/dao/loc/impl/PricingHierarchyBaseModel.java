/*    */ package dtv.xst.dao.loc.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.loc.IPricingHierarchy;
/*    */ import dtv.xst.dao.loc.IPricingHierarchyProperty;
/*    */ import dtv.xst.daocommon.IHierarchyElement;
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
/*    */ public abstract class PricingHierarchyBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IPricingHierarchyProperty>
/*    */   implements IPricingHierarchy, IHierarchyElement
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public int getDepth() {
/* 28 */     return getLevelOrder();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\PricingHierarchyBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */