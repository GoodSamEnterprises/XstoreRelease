/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class DocBuilderCall
/*    */   extends DocBuilderIterator
/*    */ {
/*    */   protected void iterate(IPosDocument argDoc, IDocElementFactory argElementFactory, Object argObject) throws IOException {
/* 22 */     buildDocImpl(argDoc, argObject, getMembers(), argElementFactory);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderCall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */