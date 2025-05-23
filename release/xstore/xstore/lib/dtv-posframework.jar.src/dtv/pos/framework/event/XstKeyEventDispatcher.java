/*     */ package dtv.pos.framework.event;
/*     */ 
/*     */ import dtv.hardware.keyboard.IBlockingKeyEventDispatcher;
/*     */ import dtv.hardware.keyboard.IPosKeyEventDispatcher;
/*     */ import dtv.pos.framework.logging.ProcessLogger;
/*     */ import dtv.pos.iframework.action.IActionOwner;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.ui.action.IDtvAction;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.KeyEventDispatcher;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.KeyStroke;
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
/*     */ public final class XstKeyEventDispatcher
/*     */   implements IBlockingKeyEventDispatcher
/*     */ {
/*  34 */   private static final Logger _logger = Logger.getLogger(XstKeyEventDispatcher.class);
/*     */   @Inject
/*     */   private ProcessLogger _flowLogger;
/*     */   @Inject
/*     */   private IPosKeyEventDispatcher _mainDispatcher;
/*     */   
/*     */   private static WeakKeyActionOwnerBundleList convertPairsToBundles(IActionOwner argOwner, Collection<? extends KeyActionPair> argPairs) {
/*  41 */     WeakKeyActionOwnerBundleList bundles = new WeakKeyActionOwnerBundleList();
/*  42 */     for (KeyActionPair pair : argPairs) {
/*  43 */       bundles.add(WeakKeyActionOwnerBundle.valueOf(pair, argOwner));
/*     */     }
/*  45 */     return bundles;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private final IActionOwner keyBlocker_ = new IActionOwner()
/*     */     {
/*     */       public boolean isEnabled()
/*     */       {
/*  59 */         return XstKeyEventDispatcher.this.keyBlockerEnabled_;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public String toString() {
/*  65 */         return "<BLOCKER>";
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final KeyActionOwnerMapping keyToActionMap_;
/*     */   
/*     */   private final Map<IActionOwner, WeakKeyActionOwnerBundleList> ownerToActionMap_;
/*     */   
/*     */   boolean keyBlockerEnabled_ = false;
/*     */   
/*  76 */   private char typedKeyToIgnore_ = Character.MAX_VALUE;
/*     */ 
/*     */   
/*     */   private Collection<? extends KeyActionPair> currentMappings_;
/*     */ 
/*     */ 
/*     */   
/*     */   public XstKeyEventDispatcher() {
/*  84 */     this.keyToActionMap_ = new KeyActionOwnerMapping();
/*  85 */     this.ownerToActionMap_ = new HashMap<>();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void blockKeyMappings() {
/* 104 */     _logger.debug("Blocking existing keystroke mappings.");
/*     */     
/* 106 */     setKeyMappings(this.keyBlocker_, this.keyToActionMap_.getBlockingKeyActions(), true);
/* 107 */     this.keyBlockerEnabled_ = true;
/*     */   }
/*     */   public boolean dispatchKeyEvent(KeyEvent argEvent) {
/*     */     char typedKeyToIgnore;
/*     */     KeyStroke keyStroke;
/*     */     WeakKeyActionOwnerBundle lastBundle;
/* 113 */     boolean handled = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     switch (argEvent.getID()) {
/*     */       case 400:
/* 122 */         typedKeyToIgnore = this.typedKeyToIgnore_;
/* 123 */         this.typedKeyToIgnore_ = Character.MAX_VALUE;
/*     */         
/* 125 */         if (argEvent.getKeyChar() == typedKeyToIgnore) {
/* 126 */           argEvent.consume();
/* 127 */           return true;
/*     */         } 
/* 129 */         return false;
/*     */       
/*     */       case 401:
/*     */       case 402:
/* 133 */         keyStroke = KeyStroke.getKeyStrokeForEvent(argEvent);
/*     */ 
/*     */         
/* 136 */         lastBundle = this.keyToActionMap_.getLastEnabledBundle(keyStroke);
/*     */         
/* 138 */         if (lastBundle != null) {
/* 139 */           Action last = lastBundle.getAction();
/*     */           
/* 141 */           if (_logger.isDebugEnabled()) {
/* 142 */             _logger.debug("Performing action [" + last + "] owned by " + lastBundle.getActionOwner() + " as the result of key " + keyStroke);
/*     */           }
/*     */           
/* 145 */           if (last instanceof IXstAction && !StringUtils.isEmpty(((IXstAction)last).getName())) {
/* 146 */             this._flowLogger.info("Action", keyStroke, null, null, " -> " + ((IXstAction)last).getName());
/*     */           }
/* 148 */           last.actionPerformed(new ActionEvent(this, 1, getClass().getName()));
/*     */ 
/*     */           
/* 151 */           this.typedKeyToIgnore_ = argEvent.getKeyChar();
/*     */           
/* 153 */           argEvent.consume();
/* 154 */           handled = true; break;
/*     */         } 
/* 156 */         if (_logger.isDebugEnabled())
/* 157 */           _logger.debug(keyStroke + ": No enabled action/owner currently mapped."); 
/*     */         break;
/*     */     } 
/* 160 */     return handled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<? extends KeyActionPair> getCurrentMappings() {
/* 168 */     return this.currentMappings_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 175 */     this._mainDispatcher.addKeyEventDispatcher((KeyEventDispatcher)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeKeyMappings(IActionOwner argOwner) {
/* 185 */     WeakKeyActionOwnerBundleList mappings = this.ownerToActionMap_.get(argOwner);
/*     */     
/* 187 */     if (_logger.isDebugEnabled()) {
/* 188 */       _logger.debug("[" + argOwner + "] Removing key mappings: [" + mappings + "].");
/*     */     }
/*     */     
/* 191 */     if (mappings != null) {
/* 192 */       synchronized (this.keyToActionMap_) {
/* 193 */         for (WeakKeyActionOwnerBundle bundle : mappings) {
/* 194 */           if (_logger.isDebugEnabled()) {
/* 195 */             _logger.debug("[" + argOwner + "] Removing mappings for: [" + bundle.getKeyStroke() + "].");
/*     */           }
/*     */ 
/*     */           
/* 199 */           this.keyToActionMap_.remove(bundle.getKeyStroke(), argOwner);
/*     */         } 
/*     */       } 
/*     */     }
/* 203 */     this.ownerToActionMap_.remove(argOwner);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionMappings(IActionOwner argOwner, Collection<? extends IDtvAction> argActions, boolean argReplaceExistingMappings) {
/* 220 */     Collection<KeyActionPair> keyActions = new ArrayList<>();
/* 221 */     if (argActions != null) {
/* 222 */       for (IDtvAction action : argActions) {
/* 223 */         KeyStroke[] strokes = (action == null) ? null : action.getKeyStrokes();
/*     */         
/* 225 */         if (strokes != null) {
/* 226 */           for (KeyStroke stroke : strokes) {
/* 227 */             keyActions.add(new KeyActionPair(stroke, (Action)action));
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/* 232 */     setKeyMappings(argOwner, keyActions, argReplaceExistingMappings);
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
/*     */ 
/*     */   
/*     */   public void setKeyMappings(IActionOwner argOwner, Collection<? extends KeyActionPair> argMappings, boolean argReplaceExistingMappings) {
/* 248 */     if (argOwner != null && argMappings != null) {
/* 249 */       if (_logger.isDebugEnabled()) {
/* 250 */         _logger.debug("[" + argOwner + "] Adding key mappings: [" + argMappings + "].");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 256 */       if (!(argOwner instanceof dtv.pos.framework.ui.view.AbstractKeypad)) {
/* 257 */         if (_logger.isDebugEnabled()) {
/* 258 */           for (KeyActionPair pair : argMappings) {
/* 259 */             _logger.debug("Keystroke: [" + pair
/* 260 */                 .getKeyStroke() + "] Adding key mappings: [" + pair.getAction() + "].");
/*     */           }
/*     */         }
/*     */         
/* 264 */         this.currentMappings_ = argMappings;
/*     */       } 
/*     */       
/* 267 */       WeakKeyActionOwnerBundleList bundles = convertPairsToBundles(argOwner, argMappings);
/*     */       
/* 269 */       WeakKeyActionOwnerBundleList actualBundles = argReplaceExistingMappings ? bundles : getCombinedMappings(argOwner, bundles);
/*     */ 
/*     */       
/* 272 */       actualBundles.expungeStaleEntries();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 277 */       removeKeyMappings(argOwner);
/* 278 */       this.ownerToActionMap_.put(argOwner, actualBundles);
/*     */       
/* 280 */       synchronized (this.keyToActionMap_) {
/* 281 */         for (WeakKeyActionOwnerBundle bundle : actualBundles) {
/* 282 */           if (bundle.getAction() != null) {
/* 283 */             this.keyToActionMap_.put(bundle.getKeyStroke(), argOwner, bundle.getAction());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unblockKeyMappings() {
/* 295 */     _logger.debug("Unblocking existing keystroke mappings.");
/* 296 */     this.keyBlockerEnabled_ = false;
/* 297 */     removeKeyMappings(this.keyBlocker_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WeakKeyActionOwnerBundleList getCombinedMappings(IActionOwner argOwner, WeakKeyActionOwnerBundleList argNewMappings) {
/* 304 */     WeakKeyActionOwnerBundleList totalMappings = null;
/* 305 */     if (argNewMappings != null) {
/* 306 */       totalMappings = argNewMappings;
/*     */       
/* 308 */       WeakKeyActionOwnerBundleList existingMappings = this.ownerToActionMap_.get(argOwner);
/* 309 */       if (existingMappings != null) {
/* 310 */         totalMappings.addAll(existingMappings);
/*     */       }
/*     */     } 
/* 313 */     return totalMappings;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\XstKeyEventDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */