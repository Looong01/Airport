# Airport

#### 介绍
EBU6304-2021-Software-Engineering-Group-79

#### 软件架构
本项目使用Maven管理jar包。  
其中，使用了swing、awt进行GUI的设计和生成。  
使用junit进行测试。使用batik对图片进行处理。  
使用fastjson对json数据文件进行读写操作。  
使用commons-email生成和发送带有登录二维码的电子邮件。  
使用zxing以及opencv进行扫描二维码从而实现登录的操作。  

#### 运行环境
OpenJDK 17.0.3 参考链接：https://www.microsoft.com/openjdk  
Maven 3.8.5 参考链接：https://maven.apache.org/download.cgi  
硬件需求：摄像头  
软件需求：带有GUI的操作系统。如Windows、Macosx、带有图形界面的Linux或WSL2（WSLG）

#### 运行
对于发行版
Windows: PowerShell
```
在文件资源管理器中，在`Run.ps1`文件上右键点击，然后左键点击“使用PowerShell运行”。
```
Linux: Bash 或 Mac: Terminal
```
打开Bash或者Terminal，输入`sh ./Run.sh`，回车。
```

对于源代码，这里建议使用IDE（如Microsoft Visual Studio Code或者Jetbrains IntelliJ IDEA）进行编译运行

#### 打包
1. 可以使用IDE进行快捷打包
2. 进入项目目录后，输入`mvn package -f pom.xml`