/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import java.io.File;
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
/*    */ public class DAOGenConsole
/*    */ {
/*    */   public static void main(String[] args) throws Exception {
/* 18 */     File inDir = new File(".");
/* 19 */     File outDir = new File(".");
/* 20 */     File cleanbeanOutDir = new File(".");
/* 21 */     File sourcesDir = new File(".");
/* 22 */     File tempDir = new File(".");
/*    */ 
/*    */     
/* 25 */     for (int i = 0; i < args.length; i++) {
/* 26 */       if ("-dir".equals(args[i]) && ++i < args.length) {
/* 27 */         inDir = new File(args[i]);
/*    */       }
/* 29 */       else if ("-dest".equals(args[i]) && ++i < args.length) {
/* 30 */         outDir = new File(args[i]);
/*    */       }
/* 32 */       else if ("-cleanbeanDest".equals(args[i]) && ++i < args.length) {
/* 33 */         cleanbeanOutDir = new File(args[i]);
/*    */       }
/* 35 */       else if ("-cleanbeanDest".equals(args[i]) && ++i < args.length) {
/* 36 */         cleanbeanOutDir = new File(args[i]);
/*    */       }
/* 38 */       else if ("-sourcesDir".equals(args[i]) && ++i < args.length) {
/* 39 */         sourcesDir = new File(args[i]);
/*    */       }
/* 41 */       else if ("-tempDir".equals(args[i]) && ++i < args.length) {
/* 42 */         tempDir = new File(args[i]);
/*    */       } else {
/*    */         
/* 45 */         usageError();
/*    */       } 
/*    */     } 
/*    */     
/* 49 */     DAOGen main = new DAOGen(inDir, outDir, cleanbeanOutDir, sourcesDir, tempDir, false);
/* 50 */     main.call();
/*    */   }
/*    */   
/*    */   private static void usageError() {
/* 54 */     System.err
/* 55 */       .println("Usage: DAOGen [-dir <source directory>] [-dest <source directory>] [-modDir <modDir directory>]");
/* 56 */     System.err.println("\t-dir           Folder to search for .dtx files (default: .)");
/* 57 */     System.err.println("\t-dest          Folder to write DAO and or Model code (default: same as source)\n");
/* 58 */     System.err.println("\t-cleanbeanDest Folder to write Cleanbean code (default: same as source)\n");
/* 59 */     System.err.println("\t-modDir        Folder containing customized models");
/* 60 */     System.err.println("\t-sourcesDir    Folder containing sources that should be considered during model generation");
/* 61 */     System.err.println("\t-tempDir       Folder used as scratch space during generation");
/* 62 */     throw new RuntimeException("Invalid command line parameters.");
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DAOGenConsole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */