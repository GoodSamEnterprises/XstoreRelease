/*     */ package dtv.pos.framework.action.access;
/*     */ 
/*     */ import dtv.pos.iframework.action.IAccessEvaluator;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.security.ISecureAction;
/*     */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.security.ISecured;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AccessEvaluators
/*     */ {
/*     */   public static IAccessEvaluator getEvaluator(IXstAction argAction) {
/*  40 */     IAccessEvaluator evaluator = null;
/*  41 */     List<? extends IVisibilityRule> rules = argAction.getVisibilityRules();
/*     */     
/*  43 */     if (rules.isEmpty()) {
/*  44 */       evaluator = NoRuleEvaluator.getInstance();
/*     */     }
/*  46 */     else if (rules.size() == 1) {
/*  47 */       evaluator = new SingleRuleEvaluator();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  52 */       boolean singleGroup = true;
/*  53 */       int group = ((IVisibilityRule)rules.get(0)).getGroup();
/*     */       
/*  55 */       for (int i = 1, n = rules.size(); i < n; i++) {
/*  56 */         if (((IVisibilityRule)rules.get(i)).getGroup() != group) {
/*  57 */           singleGroup = false;
/*     */           break;
/*     */         } 
/*     */       } 
/*  61 */       evaluator = singleGroup ? new SingleGroupEvaluator() : new MultiGroupEvaluator(rules);
/*     */     } 
/*  63 */     return evaluator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IAccessEvaluator getNoRulesEvaluator() {
/*  72 */     return NoRuleEvaluator.getInstance();
/*     */   }
/*     */   
/*  75 */   static final Logger logger_ = Logger.getLogger(AccessEvaluators.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class AbstractRuleEvaluator
/*     */     implements IAccessEvaluator
/*     */   {
/*     */     protected IXstAction action_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected List<? extends IVisibilityRule> rules_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean forceAccessGranted_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final IAccessLevel evaluateAccess(IXstAction argAction) {
/*     */       try {
/* 105 */         this.action_ = argAction;
/* 106 */         this.rules_ = argAction.getVisibilityRules();
/* 107 */         this.forceAccessGranted_ = false;
/* 108 */         if (this.action_ instanceof ISecureAction) {
/* 109 */           ((ISecureAction)this.action_).clearPrivilege();
/*     */         }
/* 111 */         IAccessLevel retVal = evaluateAccessibilityImpl();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 116 */         if (retVal == null) {
/* 117 */           IAccessLevel currentLevel = argAction.getVisibility();
/* 118 */           retVal = (currentLevel == null) ? (IAccessLevel)AccessLevel.GRANTED : currentLevel;
/*     */         } 
/* 120 */         return retVal;
/*     */       }
/* 122 */       catch (Exception ex) {
/* 123 */         AccessEvaluators.logger_.error("CAUGHT EXCEPTION", ex);
/* 124 */         return (IAccessLevel)AccessLevel.DENIED;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract IAccessLevel evaluateAccessibilityImpl() throws Exception;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected IAccessLevel evaluateRule(IVisibilityRule argRule, boolean argSecure) {
/*     */       AccessLevel accessLevel;
/* 147 */       IAccessLevel retVal = null;
/* 148 */       boolean secure = argSecure;
/*     */       
/*     */       try {
/* 151 */         retVal = argRule.checkVisibility();
/*     */         
/* 153 */         if (retVal != null) {
/* 154 */           if (retVal.isGranted() && argRule.isGranter()) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 159 */             this.forceAccessGranted_ = true;
/* 160 */             secure = true;
/* 161 */             if (this.action_ instanceof ISecureAction) {
/* 162 */               ((ISecureAction)this.action_).clearPrivilege();
/*     */             }
/*     */           } 
/*     */           
/* 166 */           if (secure && this.action_ instanceof ISecureAction && argRule instanceof ISecured && retVal
/* 167 */             .isPrivilegeBased())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 174 */             ((ISecureAction)this.action_).addPrivilege(((ISecured)argRule).getPrivilege());
/*     */           }
/*     */         }
/*     */       
/* 178 */       } catch (Exception ex) {
/* 179 */         AccessEvaluators.logger_.error("CAUGHT EXCEPTION", ex);
/* 180 */         accessLevel = AccessLevel.DENIED;
/*     */       } 
/*     */       
/* 183 */       return (IAccessLevel)accessLevel;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected IAccessLevel evaluateRuleGroup(int argStartIdx, int argEndIdx, boolean argSecure) {
/* 201 */       IAccessLevel retVal = null;
/* 202 */       Set<IAccessLevel> accessLevels = new HashSet<>(3);
/* 203 */       int ruleIdx = argStartIdx;
/*     */       
/* 205 */       while (ruleIdx < argEndIdx && !this.forceAccessGranted_) {
/* 206 */         retVal = evaluateRule(this.rules_.get(ruleIdx), argSecure);
/* 207 */         if (retVal != null && !this.forceAccessGranted_) {
/* 208 */           accessLevels.add(retVal);
/*     */         }
/* 210 */         ruleIdx++;
/*     */       } 
/*     */       
/* 213 */       if (!this.forceAccessGranted_ && !accessLevels.isEmpty() && 
/* 214 */         accessLevels.size() > 1) {
/*     */ 
/*     */ 
/*     */         
/* 218 */         List<IAccessLevel> levels = new ArrayList<>(accessLevels);
/* 219 */         Collections.sort(levels);
/* 220 */         retVal = levels.get(0);
/*     */       } 
/*     */       
/* 223 */       return retVal;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class MultiGroupEvaluator
/*     */     extends AbstractRuleEvaluator
/*     */   {
/*     */     MultiGroupEvaluator(List<? extends IVisibilityRule> argRules) {
/* 235 */       Collections.sort(argRules);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected IAccessLevel evaluateAccessibilityImpl() throws Exception {
/* 243 */       IAccessLevel retVal = null;
/* 244 */       Set<AccessElement> accessLevels = new HashSet<>(3);
/* 245 */       AccessElement winner = null;
/*     */       
/* 247 */       int currentGroup = ((IVisibilityRule)this.rules_.get(0)).getGroup();
/* 248 */       int groupStartIdx = 0;
/* 249 */       int ruleIdx = 0;
/* 250 */       int ruleCount = this.rules_.size();
/*     */       
/* 252 */       while (ruleIdx <= ruleCount && !this.forceAccessGranted_) {
/* 253 */         if (ruleIdx == ruleCount || ((IVisibilityRule)this.rules_.get(ruleIdx)).getGroup() != currentGroup) {
/* 254 */           if (ruleIdx < ruleCount) {
/* 255 */             currentGroup = ((IVisibilityRule)this.rules_.get(ruleIdx)).getGroup();
/*     */           }
/*     */ 
/*     */           
/* 259 */           retVal = evaluateRuleGroup(groupStartIdx, ruleIdx, false);
/* 260 */           if (retVal != null && !this.forceAccessGranted_) {
/* 261 */             winner = new AccessElement(retVal, currentGroup);
/* 262 */             accessLevels.add(winner);
/*     */           } 
/* 264 */           groupStartIdx = ruleIdx;
/* 265 */           ruleIdx++;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 271 */       if (!this.forceAccessGranted_ && !accessLevels.isEmpty()) {
/* 272 */         if (accessLevels.size() > 1) {
/* 273 */           List<AccessElement> levels = new ArrayList<>(accessLevels);
/* 274 */           Collections.sort(levels);
/* 275 */           winner = levels.get(levels.size() - 1);
/*     */         } 
/* 277 */         retVal = winner.accessLevel_;
/*     */         
/* 279 */         if (this instanceof ISecureAction) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 284 */           int winningGroup = winner.ruleGroup_;
/* 285 */           for (IVisibilityRule rule : this.rules_) {
/* 286 */             if (rule instanceof ISecured && rule.getGroup() == winningGroup) {
/* 287 */               ((ISecureAction)this).addPrivilege(((ISecured)rule).getPrivilege());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 292 */       return retVal;
/*     */     }
/*     */ 
/*     */     
/*     */     private static class AccessElement
/*     */       implements Comparable<AccessElement>
/*     */     {
/*     */       final IAccessLevel accessLevel_;
/*     */       
/*     */       final int ruleGroup_;
/*     */ 
/*     */       
/*     */       AccessElement(IAccessLevel argAccessLevel, int argRuleGroup) {
/* 305 */         this.accessLevel_ = argAccessLevel;
/* 306 */         this.ruleGroup_ = argRuleGroup;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int compareTo(AccessElement argOther) {
/* 312 */         return this.accessLevel_.compareTo(argOther.accessLevel_);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class NoRuleEvaluator
/*     */     implements IAccessEvaluator
/*     */   {
/*     */     public static IAccessEvaluator getInstance() {
/* 326 */       if (instance_ == null) {
/* 327 */         instance_ = new NoRuleEvaluator();
/*     */       }
/* 329 */       return instance_;
/*     */     }
/*     */     
/* 332 */     private static IAccessEvaluator instance_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IAccessLevel evaluateAccess(IXstAction argAction) {
/* 340 */       return (IAccessLevel)AccessLevel.GRANTED;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SingleGroupEvaluator
/*     */     extends AbstractRuleEvaluator
/*     */   {
/*     */     protected IAccessLevel evaluateAccessibilityImpl() {
/* 355 */       return evaluateRuleGroup(0, this.rules_.size(), true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SingleRuleEvaluator
/*     */     extends AbstractRuleEvaluator
/*     */   {
/*     */     protected IAccessLevel evaluateAccessibilityImpl() throws Exception {
/* 373 */       return evaluateRule(this.rules_.get(0), true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\AccessEvaluators.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */