/*     */ package dtv.pos.framework.event;
/*     */ 
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.swing.AbstractAction;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.KeyStroke;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class KeyActionOwnerMapping
/*     */ {
/*  22 */   private final Map<KeyStroke, LinkedList<WeakKeyActionOwnerBundle>> map_ = new HashMap<>();
/*     */   
/*  24 */   private final Object mutex_ = this.map_;
/*     */ 
/*     */ 
/*     */   
/*  28 */   private static final Action DUMMY_ACTION = new AbstractAction()
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */       
/*     */       public void actionPerformed(ActionEvent argEvent) {}
/*     */       
/*     */       public boolean isEnabled() {
/*  36 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<KeyActionPair> getBlockingKeyActions() {
/*  48 */     Collection<KeyActionPair> blockingKeyActions = null;
/*     */     
/*  50 */     synchronized (this.mutex_) {
/*  51 */       Set<KeyStroke> keyStrokes = this.map_.keySet();
/*  52 */       blockingKeyActions = new ArrayList<>(keyStrokes.size());
/*     */       
/*  54 */       for (KeyStroke stroke : keyStrokes) {
/*  55 */         blockingKeyActions.add(new KeyActionPair(stroke, DUMMY_ACTION));
/*     */       }
/*     */     } 
/*  58 */     return blockingKeyActions;
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
/*     */   public WeakKeyActionOwnerBundle getLastEnabledBundle(KeyStroke argKeyStroke) {
/*  70 */     synchronized (this.mutex_) {
/*  71 */       LinkedList<WeakKeyActionOwnerBundle> bundles = this.map_.get(argKeyStroke);
/*     */       
/*  73 */       if (bundles != null && !bundles.isEmpty())
/*     */       {
/*  75 */         for (WeakKeyActionOwnerBundle bundle : bundles) {
/*  76 */           if (bundle.getAction().isEnabled() && bundle.getActionOwner().isEnabled()) {
/*  77 */             return bundle;
/*     */           }
/*     */         } 
/*     */       }
/*  81 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void put(KeyStroke argKeyStroke, IActionOwner argOwner, Action argAction) {
/*  86 */     synchronized (this.mutex_) {
/*  87 */       LinkedList<WeakKeyActionOwnerBundle> stack = this.map_.get(argKeyStroke);
/*  88 */       if (stack == null) {
/*  89 */         stack = new WeakKeyActionOwnerBundleList();
/*  90 */         this.map_.put(argKeyStroke, stack);
/*     */       } 
/*  92 */       WeakKeyActionOwnerBundle newEntry = new WeakKeyActionOwnerBundle(argKeyStroke, argAction, argOwner);
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
/* 105 */       if (!stack.contains(newEntry)) {
/* 106 */         stack.addFirst(newEntry);
/*     */       }
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
/*     */   public void remove(KeyStroke argKeyStroke, IActionOwner argOwner) {
/* 121 */     synchronized (this.mutex_) {
/* 122 */       LinkedList<WeakKeyActionOwnerBundle> bundles = this.map_.get(argKeyStroke);
/* 123 */       if (bundles != null)
/* 124 */         for (Iterator<WeakKeyActionOwnerBundle> iter = bundles.iterator(); iter.hasNext(); ) {
/* 125 */           WeakKeyActionOwnerBundle bundle = iter.next();
/*     */           
/* 127 */           if (bundle.getActionOwner().equals(argOwner))
/* 128 */             iter.remove(); 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\KeyActionOwnerMapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */