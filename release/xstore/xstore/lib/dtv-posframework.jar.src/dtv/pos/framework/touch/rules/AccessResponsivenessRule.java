/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.util.ArrayList;
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
/*    */ public class AccessResponsivenessRule
/*    */   extends AbstractTouchResponsivenessRule
/*    */ {
/* 25 */   private static final Logger _logger = Logger.getLogger(AccessResponsivenessRule.class); private IVisibilityRule visibilityRule_;
/*    */   
/*    */   public static ITouchResponsivenessRule getRule(IVisibilityRule rule) {
/* 28 */     return new AccessResponsivenessRule(rule);
/*    */   }
/*    */   private boolean privileged_;
/*    */   public static List<ITouchResponsivenessRule> getRules(List<IVisibilityRule> visibilityRules) {
/* 32 */     List<ITouchResponsivenessRule> rules = new ArrayList<>();
/*    */     
/* 34 */     for (IVisibilityRule vRule : visibilityRules) {
/* 35 */       rules.add(getRule(vRule));
/*    */     }
/*    */     
/* 38 */     return rules;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AccessResponsivenessRule(IVisibilityRule vRule) {
/* 45 */     this.visibilityRule_ = vRule;
/*    */   }
/*    */   
/*    */   public boolean isPrivileged() {
/* 49 */     return this.privileged_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isResponsiveImpl(MouseEvent argE) {
/* 54 */     IAccessLevel level = null;
/*    */     
/* 56 */     if (this.visibilityRule_ != null) {
/*    */       try {
/* 58 */         level = this.visibilityRule_.checkVisibility();
/*    */         
/* 60 */         if (level.getLevel() == Integer.MAX_VALUE) {
/* 61 */           this.privileged_ = level.isPrivilegeBased();
/* 62 */           return true;
/*    */         }
/*    */       
/* 65 */       } catch (Exception ex) {
/* 66 */         _logger.warn("Could not process visibility rule " + this.visibilityRule_.toString(), ex);
/*    */       } 
/*    */     }
/*    */     
/* 70 */     return (level == AccessLevel.DENIED_OVERRIDABLE);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\AccessResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */