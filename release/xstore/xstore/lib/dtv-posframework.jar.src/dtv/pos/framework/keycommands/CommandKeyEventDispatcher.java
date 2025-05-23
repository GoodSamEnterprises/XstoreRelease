/*     */ package dtv.pos.framework.keycommands;
/*     */ 
/*     */ import dtv.hardware.keyboard.IKeySentinalPair;
/*     */ import dtv.hardware.keyboard.IKeyStreamHandler;
/*     */ import dtv.hardware.keyboard.IPosKeyEventDispatcher;
/*     */ import java.awt.KeyEventDispatcher;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
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
/*     */ public class CommandKeyEventDispatcher
/*     */   implements KeyEventDispatcher, IKeyStreamHandler
/*     */ {
/*     */   private static final int CTRL_ALT_SHIFT_DOWN_MASK = 704;
/*  32 */   protected static final Logger logger_ = Logger.getLogger(CommandKeyEventDispatcher.class);
/*     */   
/*     */   protected final Map<String, IKeyCommand> commandMap_;
/*     */   
/*  36 */   private final IKeySentinalPair sentinals = new KeyCommandSentinalPair(115, 512);
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IPosKeyEventDispatcher _mainDispatcher;
/*     */ 
/*     */ 
/*     */   
/*     */   private CommandKeyEventDispatcher(List<IKeyCommand> argCommands) {
/*  46 */     this.commandMap_ = new HashMap<>();
/*     */     
/*  48 */     for (IKeyCommand command : argCommands) {
/*  49 */       registerKeyCommand(command);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dispatchKeyEvent(KeyEvent e) {
/*  55 */     if (e.getKeyCode() == 115) {
/*  56 */       int modifiers = e.getModifiersEx();
/*     */       
/*  58 */       if ((modifiers & 0x2C0) == 512) {
/*     */         
/*  60 */         e.consume();
/*  61 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public IKeySentinalPair getSentinals() {
/*  70 */     return this.sentinals;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStreamTimeout() {
/*  75 */     return 10000;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleKeys(KeyEvent[] argKeys) {
/*  80 */     StringBuffer sb = new StringBuffer();
/*     */     
/*  82 */     for (KeyEvent argKey : argKeys) {
/*  83 */       char c1 = argKey.getKeyChar();
/*  84 */       if (Character.isLetterOrDigit(c1)) {
/*  85 */         sb.append(c1);
/*     */       }
/*     */     } 
/*     */     
/*  89 */     String commandKey = sb.toString().trim().toLowerCase();
/*  90 */     IKeyCommand c = this.commandMap_.get(commandKey);
/*     */     
/*  92 */     if (c != null) {
/*  93 */       if (logger_.isDebugEnabled()) {
/*  94 */         logger_.debug("*************handling command '" + commandKey + "'");
/*     */       }
/*     */       
/*     */       try {
/*  98 */         c.execute();
/*     */       }
/* 100 */       catch (Exception ex) {
/* 101 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     } else {
/*     */       
/* 105 */       logger_.warn("***********ignoring command '" + commandKey + "'");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 115 */     this._mainDispatcher.addKeyEventDispatcher(this);
/* 116 */     this._mainDispatcher.addKeyStreamHandler(this);
/*     */   }
/*     */   
/*     */   private void registerKeyCommand(IKeyCommand c) {
/* 120 */     this.commandMap_.put(c.getCommand().toLowerCase(), c);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\CommandKeyEventDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */