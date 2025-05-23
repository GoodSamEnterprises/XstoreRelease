/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.event.KeyActionPair;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
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
/*    */ public class ScrollEventFormList2<T extends IFormModel>
/*    */   extends ScrollEventFormList<T>
/*    */ {
/*    */   protected Collection<? extends KeyActionPair> createScrollKeyActions() {
/* 27 */     return new ArrayList<>();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\ScrollEventFormList2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */