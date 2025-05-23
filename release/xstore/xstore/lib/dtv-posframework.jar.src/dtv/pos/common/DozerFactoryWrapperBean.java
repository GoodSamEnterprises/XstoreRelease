/*    */ package dtv.pos.common;
/*    */ 
/*    */ import dtv.util.ClassPathUtils;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.dozer.DozerBeanMapper;
/*    */ import org.dozer.Mapper;
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
/*    */ public class DozerFactoryWrapperBean
/*    */ {
/*    */   private Mapper _mapper;
/* 24 */   private List<String> _mappingFiles = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Mapper getMapper() {
/* 31 */     return this._mapper;
/*    */   }
/*    */   
/*    */   public void init() {
/* 35 */     List<String> filesList = new ArrayList<>(this._mappingFiles.size());
/*    */     
/* 37 */     for (String mappingFile : this._mappingFiles) {
/* 38 */       int index = mappingFile.lastIndexOf(".");
/* 39 */       String fileName = mappingFile.substring(0, index);
/* 40 */       String extension = mappingFile.substring(index);
/* 41 */       URL[] urls = ClassPathUtils.getConfigUrlList(fileName, new String[] { extension });
/*    */       
/* 43 */       filesList.add(urls[urls.length - 1].toString());
/*    */     } 
/*    */     
/* 46 */     this._mapper = (Mapper)new DozerBeanMapper(filesList);
/*    */   }
/*    */   
/*    */   public void setMappingFiles(List<String> argMappingFiles) {
/* 50 */     this._mappingFiles = argMappingFiles;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\DozerFactoryWrapperBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */