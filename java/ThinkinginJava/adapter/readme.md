文件路徑
cd ./adapter

編譯指令
javac -d target -cp "src" src/*.java
javac -d target/ -classpath "src" src/Apply.java
javac -d target/ -classpath "src" src/FilterProcessor.java
javac -d target/ -classpath "src" src/Processor.java
javac -d target/ -classpath "src" src/StringProcessor.java

執行指令
java -cp "target" FilterProcessor
java -cp "target" StringProcessor

接口
-Apply.java
-Processor.java
-StringProcessor.java
-FilterProcessor.java