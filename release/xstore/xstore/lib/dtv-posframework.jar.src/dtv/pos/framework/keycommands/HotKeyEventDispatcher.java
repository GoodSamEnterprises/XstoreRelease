/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.hardware.keyboard.IPosKeyEventDispatcher;
/*    */ import java.awt.KeyEventDispatcher;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.inject.Inject;
/*    */ import javax.swing.KeyStroke;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HotKeyEventDispatcher
/*    */   implements KeyEventDispatcher
/*    */ {
/* 38 */   private final Map<KeyStroke, IHotKeyCommand> commandMap_ = new HashMap<>();
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private VersionDebugger _versionDebugger;
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private IPosKeyEventDispatcher _mainDispatcher;
/*    */ 
/*    */   
/*    */   public boolean dispatchKeyEvent(KeyEvent argEvent) {
/* 50 */     KeyStroke key = KeyStroke.getKeyStrokeForEvent(argEvent);
/* 51 */     IHotKeyCommand command = this.commandMap_.get(key);
/*    */     
/* 53 */     if (command != null) {
/* 54 */       command.execute();
/* 55 */       argEvent.consume();
/* 56 */       return true;
/*    */     } 
/*    */     
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {
/* 67 */     registerCommand(this._versionDebugger);
/*    */     
/* 69 */     this._mainDispatcher.addKeyEventDispatcher(this);
/*    */   }
/*    */ 
/*    */   
/*    */   private void registerCommand(IHotKeyCommand argCommand) {
/* 74 */     this.commandMap_.put(argCommand.getKeyStroke(), argCommand);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\HotKeyEventDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */