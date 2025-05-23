/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.hardware.keyboard.IKeySentinalPair;
/*    */ import dtv.hardware.keyboard.SentinalMatchType;
/*    */ import java.awt.event.KeyEvent;
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
/*    */ public class KeyCommandSentinalPair
/*    */   implements IKeySentinalPair
/*    */ {
/*    */   private static final int CTRL_ALT_SHIFT_DOWN_MASK = 704;
/*    */   private final int startKeyCode_;
/*    */   private final int startKeyModifiers_;
/*    */   private boolean isKeyDown_ = false;
/*    */   
/*    */   public KeyCommandSentinalPair(int argStartKeyCode, int argStartKeyModifiers) {
/* 30 */     this.startKeyCode_ = argStartKeyCode;
/* 31 */     this.startKeyModifiers_ = argStartKeyModifiers;
/*    */   }
/*    */ 
/*    */   
/*    */   public SentinalMatchType checkMatchBegin(KeyEvent argKeyEvent) {
/* 36 */     switch (argKeyEvent.getID()) {
/*    */       
/*    */       case 401:
/*    */       case 402:
/* 40 */         if (argKeyEvent.getKeyCode() == this.startKeyCode_ && (0x2C0 & argKeyEvent
/* 41 */           .getModifiersEx()) == this.startKeyModifiers_) {
/*    */           
/* 43 */           if (argKeyEvent.getID() == 401) {
/* 44 */             this.isKeyDown_ = true;
/* 45 */             return SentinalMatchType.MATCH_CONTINUE;
/*    */           } 
/* 47 */           this.isKeyDown_ = false;
/* 48 */           return SentinalMatchType.MATCH_COMPLETE;
/*    */         }  break;
/*    */     } 
/* 51 */     if (this.isKeyDown_) {
/* 52 */       return SentinalMatchType.MATCH_CONTINUE;
/*    */     }
/*    */     
/* 55 */     return SentinalMatchType.NO_MATCH;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SentinalMatchType checkMatchEnd(KeyEvent argKeyEvent) {
/* 61 */     if (argKeyEvent.getID() == 401 && argKeyEvent.getKeyCode() == 10) {
/* 62 */       return SentinalMatchType.MATCH_COMPLETE;
/*    */     }
/*    */     
/* 65 */     return SentinalMatchType.NO_MATCH;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getBeginLength() {
/* 71 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getEndLength() {
/* 76 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 81 */     this.isKeyDown_ = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean usesKeyTyped() {
/* 86 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\KeyCommandSentinalPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */