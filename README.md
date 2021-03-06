


# JReplDB
The Most Light Weight, Powerful, Stable Libaray to interact with Replit.com / Repl.it Database using Java. Read about Replit DB https://docs.replit.com/misc/database. Java 8 Compatable. Easy to use and install on replit.com

### Version : 0.1

## Add to your projects
Easy to add in your projects using gradle, maven or jar

### Gradle
- Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
- Add the dependency (replace version with the version on top)
```gradle
dependencies {
	        implementation 'com.github.shivam1608:JReplDB:0.1'
	}
```

### Maven
- Add the repository in pom.xml file
```maven
      <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
- Add the dependency (replace version with the version on top)
```maven 
<dependency>
	    <groupId>com.github.shivam1608</groupId>
	    <artifactId>JReplDB</artifactId>
	    <version>0.1</version>
	</dependency>

```

### Jar 
Download the jar from this repo 
```
out/artifact/JReplDB_Jar
```

### On Replit
[How to install on Replit.com](#how-to-install-on-replit)

## How to get REPLIT_DB_URL ? 
- How does DB Url Look like ? (* x . is used to hide the real one)
```
https://kv.replit.com/v0/eyJhb***OiJI***UxMiIsInR5cxxxxxxxxxxxxxxxxxxxxxx..............xxxxxxxxxx.xxxxxxxxxxxxxxxxxx
```
- Go To A Repl, Paste and Run this Java Statement to print the DB Url
``` java
System.out.println(System.getenv("REPLIT_DB_URL")); // Prints the DB URL
```
Replit DB Url is a confidential detail and not to be shared! 
- Check RDBUtils Class at bottom to make it Easy

## Writing To Database
- Creating the instance
``` java
import me.shivzee.JReplDB;

JReplDB rdb = new JReplDB(REPLIT_DB_URL); 
```
- Using set()
``` java
boolean status = rdb.set("key" , "value"); //Takes 2 Arguments
```
## Reading From Database
- Using get(), returns the value of a key in UTF-8 Format
``` java
String utf8_String = rdb.get("key"); //Takes 1 Argument
```
- Throws InvalidKeyException When the key specified is Invalid or Does Not Exists

## Deleting From Database
- Using delete(), returns true/false according to the success code
``` java
boolean status = rdb.delete("key"); //Takes 1 Argument
```
## Searching/Listing Databases
- Given getList() overloaded function/method
- Get All Database Keys Using getList() , returns a string array of all keys
``` java
String allKeys[] = rdb.getList();
```
- OR
 
``` java
String allKeys[] = rdb.getAllKeys();
```
- Get a Specific Query Using getList(), returns a string array of specific keys
``` java
String specificKeys[] = rdb.getList("h") // All keys starting with 'h' will be returned
```

## Exceptions
- The exceptions details
``` json
InvalidDBUrlException : Thrown when the DB Url is Invalid
InvalidKeyException : Thrown when the key looking for is Invalid or Key is Not Found
```
Exmaple can be found in this repo itself in /example

## The RDBUtils Class 
There is a RDBUtils to Help with the Privacy of REPLIT_DB_URL and make is SAFE, Using Simple ENV
- Automatically Get The REPLIT_DB_URL (When using in REPLit IDE ONLY)
``` java
import me.shivzee.JReplDB;
import me.shivzee.utils.RDBUtils;

JReplDB rdb = new JReplDB(RDBUtils.fetchDBUrl());  // Works only in Replit IDE
```
- Access from .env File on LocalSystem or Server (Works EveryWhere)
``` java
JReplDB rdb = new JReplDB(RDBUtils.fetchDBUrl("KEY_HERE"));  // Works on any IDE (REQUIRED KEY_HERE) i.e the key for the DB Url saved in .env
```

## Credits
- shivzee/shivam1608 made the whole lib alone
- IDE used [IntelliJ](https://www.jetbrains.com/idea/)

## How to Install on Replit
Follow the steps to use it on Repl It 
- Create a pom.xml File in Your Repl
- Copy and paste this code in pom.xml file (Only For Replit IDE)
``` xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>mygroupid</groupId>
  <artifactId>myartifactid</artifactId>
  <version>0.0-SNAPSHOT</version>
  <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  <dependencies>
    	<dependency>
	    <groupId>com.github.shivam1608</groupId>
	    <artifactId>JReplDB</artifactId>
	    <version>0.1</version>
	</dependency>
  </dependencies>
  <build>
    
  </build>
</project>
```
Replace 0.1 with the version on TOP
