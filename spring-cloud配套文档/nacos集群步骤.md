nacos集群步骤

1、修改 nacos 解压之后的conf 目录里面的application.properties

```properties
spring.datasource.platform=mysql   ##选择mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://192.168.152.131:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
db.user=用户名
db.password=密码
```

2、在conf目录下的cluster.conf文件添加其他节点的nacos地址(包含当前节点)

文件里面所有的内容：

```conf
#it is ip
#example   如果是其他服务器，改变ip即可
192.168.152.128:8848
192.168.152.129:8848
192.168.152.130:8848
```

3、在nginx下的配置文件nginx.conf文件中的http 模块里面

添加 

```
upstream cluster{
        #其他服务器，修改ip即可
		server 192.168.152.128:8848;
		server 192.168.152.129:8848;
		server 192.168.152.130:8848;
}
```

在 

```
server{
	location/{
		proxy_pass  http://cluster
     }
}
```

启动nginx即可