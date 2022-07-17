## 西林20计科web程序设计课程期末实习

### 效果展示：

![image-20220717105458715](https://cdn.jsdelivr.net/gh/ZhangTainan/Drawing-bed/imgs/image-20220717105458715.png)

![image-20220717105538660](https://cdn.jsdelivr.net/gh/ZhangTainan/Drawing-bed/imgs/image-20220717105538660.png)

![image-20220717105611643](https://cdn.jsdelivr.net/gh/ZhangTainan/Drawing-bed/imgs/image-20220717105611643.png)

### 成品预览地址：http://120.25.123.183:5000/#/

### 接口文档地址：http://120.25.123.183:8080/swagger-ui.html#/

### 要求如下：

![task01.png](https://github.com/ZhangTainan/Drawing-bed/blob/main/imgs/task01.png?raw=true)

### 后续要求改为：

![image-20220717103003817](https://cdn.jsdelivr.net/gh/ZhangTainan/Drawing-bed/imgs/image-20220717103003817.png)

### $\textcolor{orange}{最后的时候你做成什么样都给过，沾点边就行。} $

### 教程可参考我在B站发布的视频：

### https://www.bilibili.com/video/BV1NY411g7cf?spm_id_from=333.999.0.0&vd_source=61d825380c75566634f8d615d9d06947

### 这个教程致力于零基础的同学，通过两三个小时的学习，就能自己做出一个简易版的学生管理系统，应付期末考试实习不成问题。

### 技术栈：

- #### 前端

  - ##### vue2

  - ##### element-ui

  - ##### bootstrap5

  - ##### echarts

  - ##### axios

  - ##### vue-router

  - ##### js-md5

  - ##### pubsub-js

- #### 后端

  - ##### springboot2

  - ##### lombok

  - ##### Gson

  - ##### jwt

  - ##### swagger-ui

- #### 数据库

  - ##### mysql

### 这个资料的使用：

##### 前端

1. ###### 用vue脚手架创建一个vue2的项目，脚手架版本推荐4.5.x的版本

2. ###### 将这个目录的front中的文件替换你创建出来的vue文件

3. ###### 执行npm i 安装一下依赖库。

4. ###### npm run serve运行前端项目（可以用npm run serve -- --port 5000 将前端服务启动在5000端口上防止与后端端口冲突）

##### 后端

1. ###### 直接用idea打开back目录中的student_manage_system

2. ###### 修改数据库配置信息，将resources目录下的application.yaml文件中的数据库配置信息中的用户名、密码、数据库名配置成你自己的

3. ###### 运行Application启动类即可

##### 数据库

###### 	1.创建一个名为student_system的数据库并use该数据库（这里数据库名要与后端配置的数据库名一样）

```mysql
drop database if exits student_system;
create database student_system;
use student_system;
```

###### 	2.将目录中的两个sql文件（两张数据表）导入到第一步创建出的数据库

## $\textcolor{orange}{最后送给大家一句话:} $

## $\textcolor{green}{When\ you\ belive\ in\ what \ you've\ got,} $

## $\textcolor{green}{you\ know\ you're\ perfect\ just\  be\ who\ you\ are。} $

### 

### 









