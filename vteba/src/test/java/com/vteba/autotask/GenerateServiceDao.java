package com.vteba.autotask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * 产生Dao和Service的代码引擎。
 * @author yinlei
 * date 2013-8-31 上午12:38:09
 */
public class GenerateServiceDao {
	static VelocityEngine velocityEngine;
	static {
		String templateBasePath = "/home/yinlei/downloads/vteba/template";
		Properties properties = new Properties();
		properties.setProperty(Velocity.RESOURCE_LOADER, "file");
		properties.setProperty("file.resource.loader.description", "Velocity File Resource Loader");
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, templateBasePath);
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
		properties.setProperty("file.resource.loader.modificationCheckInterval", "30");
		properties.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
		properties.setProperty("runtime.log.logsystem.log4j.logger", "org.apache.velocity");
		properties.setProperty("directive.set.null.allowed", "true");
		velocityEngine = new VelocityEngine();
		velocityEngine.init(properties);
	}
	
	/**
	 * @param args
	 * @author yinlei
	 * date 2013-8-30 下午11:52:37
	 */
	public static void main(String[] args) {
		String schema = "skmbw";//数据库schema
		String className = "Men";//实体类，类名
		String tableName = "男装商品";//实体类对应的表的注释名
		String pk = "Long";//String Long Integer，主键类型
		String module = "product.men";//模块名
		
		
		VelocityContext context = new VelocityContext();
		context.put("schema", schema);
		context.put("className", className);
		context.put("tableName", tableName);
		context.put("pk", pk);
		
		String smallClassName = StringUtils.uncapitalize(className);
		context.put("smallClassName", smallClassName);
		
		String packages = module;
		String pgk = packages.replace(".", "/") + "/";

		context.put("packages", packages);
		context.put("currentDate", DateFormat.getDateTimeInstance().format(new Date()));

		String rootPath = "/home/yinlei/downloads/vteba/";
		
		String srcPath = "src/main/java/";
		
		String parentPackagePath = "com/vteba/";
		
		String actionTemplateName = "Action.java";
		String daoTemplateName = "Dao.java";
		String daoImplTemplateName = "DaoImpl.java";
		String serviceTemplateName = "Service.java";
		String serviceImplTemplateName = "ServiceImpl.java";
		
		String targetJavaFile = rootPath + srcPath + parentPackagePath + pgk;
		
		generateFile(context, actionTemplateName, targetJavaFile + "action/" + className);
		generateFile(context, daoTemplateName, targetJavaFile + "dao/spi/" + className);
		generateFile(context, daoImplTemplateName, targetJavaFile + "dao/impl/" + className);
		generateFile(context, serviceTemplateName, targetJavaFile + "service/spi/" + className);
		generateFile(context, serviceImplTemplateName, targetJavaFile + "service/impl/" + className);
	}

	/**
	 * 产生java文件
	 * @param context VelocityContext
	 * @param templateName 模版文件名
	 * @param baseJavaFilePath 要产生的java文件路径
	 * @author yinlei
	 * date 2013-8-31 上午12:35:21
	 */
	public static void generateFile(VelocityContext context, String templateName,
			String baseJavaFilePath) {
		try {
			File file = new File(baseJavaFilePath + templateName);
			if (!file.exists()) {
				new File(file.getParent()).mkdirs();
			} else {
				
			}

			Template template = velocityEngine.getTemplate(templateName, "UTF-8");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			template.merge(context, writer);
			writer.flush();
			writer.close();
			fos.close();
		} catch (Exception e) {
			
		}
	}
	
}
