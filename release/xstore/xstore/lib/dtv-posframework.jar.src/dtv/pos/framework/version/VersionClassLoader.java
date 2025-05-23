/*    */ package dtv.pos.framework.version;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.jar.JarFile;
/*    */ import java.util.zip.ZipEntry;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class VersionClassLoader
/*    */   extends ClassLoader
/*    */ {
/* 30 */   private static final Logger _logger = Logger.getLogger(VersionClassLoader.class);
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
/*    */   public Map<String, String> getStrings(File argJar, String argClassName) throws IOException {
/* 44 */     Map<String, String> results = new HashMap<>();
/* 45 */     String filename = argClassName.replace('.', '/') + ".class";
/* 46 */     _logger.debug("Reading class file [" + filename + "] in jar [" + argJar + "]");
/*    */     
/* 48 */     JarFile jar = new JarFile(argJar);
/* 49 */     ZipEntry entry = jar.getEntry(filename);
/* 50 */     InputStream in = jar.getInputStream(entry);
/* 51 */     jar.close();
/*    */     
/* 53 */     byte[] buffer = new byte[(int)entry.getSize()];
/* 54 */     in.read(buffer);
/*    */     
/* 56 */     Class<?> clazz = defineClass(argClassName, buffer, 0, buffer.length);
/* 57 */     _logger.debug("Successfully read class [" + clazz.getName() + "]");
/*    */     
/* 59 */     for (Field field : clazz.getDeclaredFields()) {
/* 60 */       if (Modifier.isStatic(field.getModifiers()) && String.class == field.getType()) {
/* 61 */         field.setAccessible(true);
/*    */         
/*    */         try {
/* 64 */           String key = field.getName();
/* 65 */           String value = (String)field.get((Object)null);
/* 66 */           _logger.debug("Adding field [" + key + "=" + value + "]");
/*    */           
/* 68 */           results.put(key, value);
/*    */         }
/* 70 */         catch (Exception ex) {
/* 71 */           _logger.error("CAUGHT_EXCEPTION", ex);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 76 */     return results;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionClassLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */