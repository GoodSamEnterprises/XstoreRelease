/*     */ package dtv.data2.dataloader.pluggable;
/*     */ 
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Properties;
/*     */ import org.springframework.beans.BeansException;
/*     */ import org.springframework.beans.factory.BeanFactory;
/*     */ import org.springframework.beans.factory.BeanFactoryAware;
/*     */ import org.springframework.beans.factory.FactoryBean;
/*     */ import org.springframework.beans.factory.InitializingBean;
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
/*     */ 
/*     */ 
/*     */ public class DataFileIteratorLocatorFactoryBean
/*     */   implements FactoryBean<Object>, BeanFactoryAware, InitializingBean
/*     */ {
/*     */   private Object _dataFileIteratorFactoryProxy;
/*  36 */   private Class<IDataFileIteratorFactory> _dataFileIteratorFactoryInterface = IDataFileIteratorFactory.class;
/*     */   
/*     */   private BeanFactory _beanFactory;
/*     */   
/*     */   private Properties _serviceMappings;
/*     */   
/*     */   public void afterPropertiesSet() {
/*  43 */     this._dataFileIteratorFactoryProxy = Proxy.newProxyInstance(this._dataFileIteratorFactoryInterface.getClassLoader(), new Class[] { this._dataFileIteratorFactoryInterface }, new DataFileIteratorFactoryHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject() {
/*  50 */     return this._dataFileIteratorFactoryProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getObjectType() {
/*  56 */     return this._dataFileIteratorFactoryInterface;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSingleton() {
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeanFactory(BeanFactory argBeanFactory) throws BeansException {
/*  69 */     this._beanFactory = argBeanFactory;
/*     */   }
/*     */   
/*     */   public void setServiceMappings(Properties argServiceMappings) {
/*  73 */     this._serviceMappings = argServiceMappings;
/*     */   }
/*     */ 
/*     */   
/*     */   private class DataFileIteratorFactoryHandler
/*     */     implements InvocationHandler
/*     */   {
/*     */     private DataFileIteratorFactoryHandler() {}
/*     */     
/*     */     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
/*     */       try {
/*  84 */         String beanName = getBeanName(args);
/*     */         
/*  86 */         return DataFileIteratorLocatorFactoryBean.this._beanFactory.getBean(beanName, new Object[] { args[0] });
/*     */       }
/*  88 */       catch (BeansException ex) {
/*  89 */         throw ex;
/*     */       } 
/*     */     }
/*     */     
/*     */     private String getBeanName(Object[] args) {
/*  94 */       String beanName = "";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       if (args[0] instanceof DataFileMetaData) {
/* 100 */         DataFileMetaData<?> md = (DataFileMetaData)args[0];
/* 101 */         beanName = md.getType();
/*     */ 
/*     */         
/* 104 */         if (DataFileIteratorLocatorFactoryBean.this._serviceMappings != null) {
/* 105 */           String mappedName = DataFileIteratorLocatorFactoryBean.this._serviceMappings.getProperty(beanName);
/*     */           
/* 107 */           if (mappedName != null) {
/* 108 */             beanName = mappedName;
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         
/* 113 */         throw new IllegalArgumentException("argument 0 is not a DataFileMetaData");
/*     */       } 
/*     */       
/* 116 */       return beanName;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\DataFileIteratorLocatorFactoryBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */