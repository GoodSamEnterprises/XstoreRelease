/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.util.crypto.DtvDecrypter;
/*    */ import dtv.util.crypto.DtvEncrypter;
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
/*    */ public abstract class AbstractDataModelImpl
/*    */   extends AbstractBaseDataModelImpl
/*    */ {
/*    */   private static final long serialVersionUID = 418385730493988677L;
/*    */   
/*    */   protected final String decryptField(String argEncryptionService, String value) {
/* 21 */     if (value == null) {
/* 22 */       return null;
/*    */     }
/* 24 */     return DtvDecrypter.getInstance(argEncryptionService).decryptIfEncrypted(value);
/*    */   }
/*    */   
/*    */   protected final String encryptField(String argEncryptionService, String value) {
/* 28 */     if (value == null) {
/* 29 */       return null;
/*    */     }
/* 31 */     return DtvEncrypter.getInstance(argEncryptionService).encrypt(value);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractDataModelImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */