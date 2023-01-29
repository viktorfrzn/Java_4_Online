#!/bin/sh

echo 'run simple'
cd ./simple
javac Hello.java
java Hello

cd../

echo 'run package'
cd ./package
javac ua/com/alevel/Hello.java
java ua.com.alevel.Hello

cd../

echo 'run separate_new_package'
cd. /separate_new_package
javac ua/com/alevel/Hello.java
java ua.com.alevel.Hello

cd../

echo 'run minimal proj'
cd. /minimal_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/Hello.java
java -cp build/classes ua.com.alevel.Hello

cd../

echo 'run med proj amd simple jar'
cd. /med_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/Hello.java
jar cvfm build/jar/Hello.jar resources/MANIFEST.MF -C build/classes .
java -jar build/jar/Hello.jar