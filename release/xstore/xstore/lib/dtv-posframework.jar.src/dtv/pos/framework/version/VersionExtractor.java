/*     */ package dtv.pos.framework.version;
/*     */ 
/*     */ import dtv.util.JarFileFilter;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.jar.JarFile;
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
/*     */ 
/*     */ 
/*     */ public class VersionExtractor
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3717238206189722220L;
/*     */   
/*     */   public Map<File, Map<String, String>> getVersionStrings(File argRootDir) throws IOException {
/*  38 */     return getVersionStrings(argRootDir, System.getProperty("dtv.CustomerId"));
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
/*     */   public Map<File, Map<String, String>> getVersionStrings(File argFile1, File argFile2, String argCustomerId) throws IOException {
/*  56 */     Map<File, Map<String, String>> results = new HashMap<>();
/*  57 */     Collection<File> jarFiles = Arrays.asList(new File[] { argFile1, argFile2 });
/*  58 */     String className = argCustomerId.toLowerCase() + ".pos.Version";
/*     */     
/*  60 */     for (File jarFile : jarFiles) {
/*     */       
/*  62 */       VersionClassLoader vcl = new VersionClassLoader();
/*  63 */       results.put(jarFile, vcl.getStrings(jarFile, className));
/*     */     } 
/*  65 */     return results;
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
/*     */   public Map<File, Map<String, String>> getVersionStrings(File argRootDir, String argCustomer) throws IOException {
/*  83 */     Map<File, Map<String, String>> results = new HashMap<>();
/*  84 */     Collection<File> jarFiles = getJarFiles(argRootDir, makeFileFilter());
/*  85 */     String className = argCustomer.toLowerCase() + ".pos.Version";
/*  86 */     String fileName = convertClassNameToFileName(className);
/*     */     
/*  88 */     jarFiles = filterJars(jarFiles, fileName);
/*  89 */     for (File jarFile : jarFiles) {
/*     */       
/*  91 */       VersionClassLoader vcl = new VersionClassLoader();
/*  92 */       results.put(jarFile, vcl.getStrings(jarFile, className));
/*     */     } 
/*  94 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String convertClassNameToFileName(String argClassName) {
/* 104 */     return argClassName.replace('.', '/') + ".class";
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
/*     */   protected Collection<File> filterJars(Collection<File> argJarFiles, String argClassName) throws IOException {
/* 118 */     Collection<File> results = new HashSet<>();
/* 119 */     for (File file : argJarFiles) {
/* 120 */       try (JarFile jarFile = new JarFile(file)) {
/* 121 */         if (jarFile.getEntry(argClassName) != null) {
/* 122 */           results.add(file);
/*     */         }
/*     */       } 
/*     */     } 
/* 126 */     return results;
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
/*     */   protected Collection<File> getJarFiles(File argFile, FileFilter argFileFilter) {
/* 141 */     Collection<File> results = new HashSet<>();
/*     */     
/* 143 */     if (argFile.isDirectory()) {
/* 144 */       if (!argFile.getPath().contains("..")) {
/* 145 */         File[] files = argFile.listFiles();
/*     */         
/* 147 */         if (files != null) {
/* 148 */           for (File file : files) {
/* 149 */             results.addAll(getJarFiles(file, argFileFilter));
/*     */           }
/*     */         }
/*     */       }
/*     */     
/* 154 */     } else if (argFileFilter.accept(argFile)) {
/* 155 */       results.add(argFile);
/*     */     } 
/* 157 */     return results;
/*     */   }
/*     */   
/*     */   protected FileFilter makeFileFilter() {
/* 161 */     return (FileFilter)new JarFileFilter();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionExtractor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */