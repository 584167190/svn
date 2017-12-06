mall:
    功能：运营端，后台管理系统
商品管理:
    1 增删改查商品
        其中图片的上传和下载(){
            上传:Controller层用MultipartFile得到页面传来的图片信息
                    multipartfile是spring类型，代表HTML中form data方式上传的文件，包含二进制数据+文件名称。

                public String addComms(@RequestParam("f1") MultipartFile file,
                                       @RequestParam Map<String,String> map){
                         cs.addComms(file,map);
                         return "添加成功";
                }
            下载:file.transferTo(path); path作为图片的属性存数据库


        }
        问题：多文件上传？？？
        <input   name="f1" type="file" multiple="multiple" class="form-control"/>
    2 上架:生成静态页面(){
          1:导入依赖
              <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-freemarker</artifactId>
              </dependency>
          2:在resources/templates里创建模板(xxx.ftl文件)
          3:注入freemarker对象
              @Resource
              private FreeMarkerConfig freeMarkerConfig;
          4:创建模板对象
            Template template = freeMarkerConfig.getConfiguration().getTemplate("x.ftl");
          5:用模板对象创建静态页面
            Map<String,Object> map = new HashMap<>();
            map.put("key",12345);
            FileWriter out = new FileWriter("D:/image/a.html");
            //map是数据，out是静态页面的存储位置
            template.process(map,out);
          6:x.ftl中写${key},运行后会生成 a.html 里面key的位置变成 12345
      }
    sku:商品的身份证，唯一标识符
    上传图片：1 FTP  2 http

    使用了多线程
     时机:保存上传的图片
     原因: 保存文件是写硬盘，属于耗时操作，所以开子线程
     优化:使用线程池管线程

     上架:就是使用freemarker模板引擎生成该商品的详情的html页面;
         所有消费者查看消费详情时直接访问该页面即可。
    ---------------nginx--------------
    tomcat : http容器(简化的apache服务器)+servlet容器
    nginx:功能　是一个http服务器，一般提供静态页面服务
    使用步骤；1 启动：ginx
             2 修改 cconf/nginx.conf文件中root执行的物理路径
             3 从浏览器地址栏访问，默认端口是80


























