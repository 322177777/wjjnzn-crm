# CRM客户管理系统

## 运行环境的配置

​	根据项目原型创建SpringBoot项目，选择JDK14、web依赖、mybatis起步依赖、thymeleaf依赖、MySQL驱动依赖、Apache poi依赖。

​	static文件下，放image、css、jquery和bootstrap等静态资源。

​	resources文件下，新建mapper目录放置mapper.xml文件。

​	在application.properties文件中配置运行时端口号（默认8080），访问应用的上下文路径，指定使用的编码格式（默认utf-8）并将请求和响应信息都使用此编码（true），另外，还可以设置让系统的过滤器生效或者自定义过滤器。

​	配置连接MySQL数据库的驱动、url（需要加8小时才是中国时区或者设置时区为中国上海）、username、password。

​	导入crm.sql文件到本地自己的MySQL数据库。

​	配置mybatis的指定mapper文件的位置、控制台mybatis日志开启。

​	配置thymeleaf的参数，开发阶段,关闭模板缓存,让修改立即生效;项目上线设为true,效率更高。编码格式（utf-8）、文件的路径前缀、后缀、类型（HTML）。

## Mybatis的逆向工程

​	在该项目下创建新的模块，模块名：项目名-mybatis-generator。

​	在resources下，放逆向工程连接MySQL的配置文件properties和逆向工程的配置文件xml。

properties文件：

![image-20230331171407495](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230331171407495.png)

xml文件：

![image-20230331171627891](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230331171627891.png)

![image-20230331171646010](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230331171646010.png)

## 登录模块

![image-20230330211643147](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230330211643147.png)



编码顺序：

模块分析-->持久层-->业务层-->控制层-->视图层

![image-20230401234257288](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230401234257288.png)

![image-20230401234325616](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230401234325616.png)

![image-20230401173605827](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230401173605827.png)

技术要点：

1、使用字符集Filter解决请求中的乱码问题；

2、使用自定义拦截器判断session对用户是否登录进行验证；

3、使用cookie实现记住密码和安全退出功能；

4、使用RESTful的接口架构风格，使用Postman工具测试接口请求是否成功；

5、使用Thymeleaf标签实现动态数据的交互；

6、使用SpringMVC的MultipartFile对象实现文件上传；

7、使用POI框架处理市场活动信息的Excel文件，使用InputStream和OutputStream实现文件不入磁盘的导入和导出；

8、使用动态SQL对查询条件进行过滤；

9、使用ResourceBundle类来解析.properties文件；

10、使用Mybatis逆向工程生成实体类和持久层代码。

11、将项目打成Jar包，并使用Docker容器化部署到Linux上，本地进行访问服务。

项目要点概述：

在线索模块，转换线索时，要将有关公司的信息转换到客户表中，将有关个人的信息转换到联系人表中，将线索下所有的备注转换到客户备注表里和联系人备注表中；将关联关系转换入联系人和市场活动的关联关系表；如果在转换时创建交易，向交易表添加记录，并把该线索下所有的备注转换到交易备注表里；最后删除线索下的所有备注、线索和市场活动的关联关系、该线索。

交易阶段，可以修改阶段信息，在详细信息中可以看见阶段修改历史信息。

## 打包jar部署在Docker上

新建docker目录:

Dockerfile:

![image-20230407111014656](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230407111014656.png)

run.sh:

![image-20230406003302410](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230406003302410.png)

CentOS:

![image-20230406163015772](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230406163015772.png)

![image-20230406163001200](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230406163001200.png)

![image-20230406163203423](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230406163203423.png)

![image-20230407011501660](C:\Users\33796\AppData\Roaming\Typora\typora-user-images\image-20230407011501660.png)

**JDK部署环境一定要和开发环境一致**

**部署环境一定要和开发环境一致**

总结:

将项目打包成jar包,编写自定义镜像文件Dockerfile文件和运行的Shell脚本文件,在Linux中启动docker服务,运行脚本,得到项目镜像,运行命令：

```
./run.sh
```

```
docker images
```

```
docker run --name crm-server -p 9090:9090 -d crm-server:1.0
```

```
docker ps
```

```
docker stop crm-server
//容器删除
docker rm crm-server
//镜像删除
docker rmi crm-server:1.0
```

```
//查看服务运行日志 行数100
docker logs -f -t --tail 100 crm-server
```

得到项目运行的容器,启动其他依赖的部署容器,如(mysql、redis、Ngnix等)，即可在本地进行访问crm-server。

