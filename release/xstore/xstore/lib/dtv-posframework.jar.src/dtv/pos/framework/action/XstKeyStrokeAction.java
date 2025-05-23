/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.action.type.XstKeyStrokeActionType;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.action.IXstKeyStroke;
/*     */ import dtv.pos.iframework.action.IXstKeyStrokeAction;
/*     */ import java.awt.Component;
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.JComponent;
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
/*     */ 
/*     */ 
/*     */ public class XstKeyStrokeAction
/*     */   extends XstDefaultAction
/*     */   implements IXstKeyStrokeAction
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  37 */   private static final Logger logger_ = Logger.getLogger(XstKeyStrokeAction.class);
/*     */   
/*     */   private final String actionCode_;
/*     */   private Collection<Component> keyStrokeTargets_;
/*     */   
/*     */   public XstKeyStrokeAction(XstKeyStrokeActionType argType, IXstKeyStroke argKey) {
/*  43 */     super((IXstActionType)argType, (IXstActionKey)argKey);
/*  44 */     this.actionCode_ = null;
/*     */     
/*  46 */     if (argKey != null) {
/*  47 */       setKeyStroke(argKey.getKeyStroke());
/*     */     }
/*     */   }
/*     */   
/*     */   public XstKeyStrokeAction(XstKeyStrokeActionType argType, String argActionCode) {
/*  52 */     super((IXstActionType)argType, (IXstActionKey)null);
/*  53 */     this.actionCode_ = argActionCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Component> getKeyStrokeTargets() {
/*  58 */     if (this.keyStrokeTargets_ == null || this.keyStrokeTargets_.isEmpty()) {
/*  59 */       logger_.debug("No keystroke targets assigned; defaulting to current focus owner.");
/*  60 */       return Arrays.asList(new Component[] { KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() });
/*     */     } 
/*  62 */     return this.keyStrokeTargets_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKeyStrokeTargets(Collection<Component> argKeyStrokeTargets) {
/*  67 */     this.keyStrokeTargets_ = argKeyStrokeTargets;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformedImpl(ActionEvent event) {
/*  72 */     super.actionPerformedImpl(event);
/*     */     
/*  74 */     if (this.actionCode_ == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  81 */       KeyStroke keyStroke = ((XstKeyStroke)getActionKey()).getKeyStroke();
/*  82 */       dispatchKeyStroke(keyStroke);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  88 */       dispatchActionCode(this.actionCode_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dispatchActionCode(String actionCode) {
/*  93 */     logger_.debug("Dispatching UI action code [" + actionCode + "].");
/*     */     
/*  95 */     Collection<Component> targets = getKeyStrokeTargets();
/*  96 */     if (targets == null || targets.isEmpty()) {
/*  97 */       logger_.debug("No components interested in this keystroke event.");
/*     */       
/*     */       return;
/*     */     } 
/* 101 */     for (Component c : targets) {
/* 102 */       if (c instanceof JComponent) {
/* 103 */         dispatchActionCode(actionCode, (JComponent)c);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dispatchActionCode(String actionCode, JComponent target) {
/* 111 */     for (ActionMap am = target.getActionMap(); am != null; am = am.getParent()) {
/* 112 */       Action action = am.get(actionCode);
/* 113 */       if (action != null && action.isEnabled()) {
/* 114 */         action.actionPerformed(new ActionEvent(target, -1, ""));
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dispatchKeyStroke(KeyStroke keyStroke) {
/* 121 */     logger_.debug("Dispatching UI keystroke [" + keyStroke + "].");
/* 122 */     if (keyStroke == null) {
/*     */       return;
/*     */     }
/* 125 */     Collection<Component> targets = getKeyStrokeTargets();
/*     */     
/* 127 */     if (targets == null || targets.isEmpty()) {
/* 128 */       logger_.debug("No components interested in this keystroke event.");
/*     */       return;
/*     */     } 
/* 131 */     KeyboardFocusManager focusMgr = KeyboardFocusManager.getCurrentKeyboardFocusManager();
/*     */ 
/*     */ 
/*     */     
/* 135 */     for (Component component : targets) {
/* 136 */       Component firstEnabled = getFirstEnabled(component);
/*     */       
/* 138 */       if (firstEnabled != null) {
/*     */ 
/*     */         
/* 141 */         KeyEvent keyEvent = new KeyEvent(firstEnabled, keyStroke.getKeyEventType(), System.currentTimeMillis(), keyStroke.getModifiers(), keyStroke.getKeyCode(), keyStroke.getKeyChar());
/*     */         
/* 143 */         focusMgr.dispatchKeyEvent(keyEvent);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Component getFirstEnabled(Component target) {
/* 149 */     for (Component c = target; c != null; c = c.getParent()) {
/* 150 */       if (c.isEnabled()) {
/* 151 */         return c;
/*     */       }
/*     */     } 
/* 154 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstKeyStrokeAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */