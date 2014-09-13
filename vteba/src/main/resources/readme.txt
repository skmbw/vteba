tomcat切换到jboss
1、修改web.xml,切换不同的spring主配置文件
2、修改WEB-INF/下的jboss-deployment-structure.xml（现在不需要改动）
3、去掉pom.xml中的CXF的依赖，JBoss提供了
4、去掉pom.xml中的hibernate-infinispan.jar依赖，或者加上<scope>provided</scope>
5、infinispan-configs.xml中的query-statement缓存，在JBoss中不需要指定transactionManagerLookup,去掉
6、修改jboss的配置，添加start="EAGER"/"LAZY",是否立即加载还是延迟加载,<cache-container name="hibernate" default-cache="local-query" module="org.jboss.as.jpa.hibernate:4" start="true">
如果jndi-name没有指定，默认是java:jboss/infinispan/container/container-name。具体请参考xml的xsd文档

7、如果切换回tomcat，还要将javasist的<scope>provided</scope>去掉
8、切换回tomcat，要把web.xml的resteasy，的注释去掉

A、META-INF/services/org.infinispan.commands.module.ModuleCommandExtensions暂时是不使用的。不过是正确的。
B、META-INF/MANIFEST.MF中配置的依赖是正确的，但是现在不使用。使用jboss-deployment-structure.xml