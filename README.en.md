# Airport

#### Description
EBU6304-2021-Software-Engineering-Group-79

#### Software Architecture
This project uses Maven to manage jar packages.  
Use Swing and AWT for GUI design and generation.  
Use Junit to test. 
Use Batik to process with images.  
Use Fastjson to read and write json data files.  
Use Commons-email to generate and send emails with a login QR code.  
Use Zxing and OpenCV to scan the QR code to achieve login operation.  

#### Environment
OpenJDK 17.0.3 Reference URL: https://www.microsoft.com/openjdk  
Maven 3.8.5 Reference URL: https://maven.apache.org/download.cgi  
Hardware Requirements: Camera Software Requirements: Operating system with GUI. Such as Windows, Macosx, Linux with GUI (Ubuntu with GNome) or WSL2 (WSLG)

#### Run the project 
For the Release version:  
  
Windows: PowerShell
```
In the File explorer, right click on `Run.ps1`, and left click on `Running in PowerShell`.
```
Linux: Bash or Mac: Terminal
```
Open the bash or terminal, then input `sh ./Run.sh`, and Enter it.
```
  
For source code:  
Firstly, change the dependency configurations of OpenCV and OpenBlas for the corresponding system platform in the Maven configuration file, pom.xml.
we recommended to compile and run using an IDE (such as Microsoft Visual Studio Code or Jetbrains IntelliJ IDEA)

#### Packaging
1. Firstly, change the dependency configurations of OpenCV and OpenBlas for the corresponding system platform in the Maven configuration file, pom.xml.
2. You can use the IDE for quick packaging.
3. Once in the project directory, enter `mvn package -f pom.xml`.