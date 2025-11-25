# OOP with Java
## Preface
> This is my first time investing to write README for schoolwork project haha. Hope this helps!

My OOP original work written in Java. You should expect some brilliant blocks hiding in numerous pieces of s***. <br>
Refer to code.p*** system & OOP P**** curriculum.
## Setup
This is for VS Code lol you shouldnt use another IDE.<br>
> ***UPDATE***: 
> - Use the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) to run Java code in VS Code. Just install it and you are good to go.
> - New ~~snippet~~ template for Java coding in **Apache Netbeans**. Check the `snippet-netbeans.java` file & walkthrough below.

### VS Code Setup
- Copy `snippet.json` to your own snippet file (do it your own lol you a cs student)<br>
*Note*: Change the file names in the snipp to your corresponding ones.
- Install extension [Code Runner](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner)
- Navigate to the extension setting, find the `Code-runner: Executor Map` section, go to the `settings.json` file, find this part and edit:
    ```json
    "code-runner.executorMap": {
        "javascript": "cd $dir && nodemon $fileName",
        "java": "cd $dir && javac $fileName && java $fileNameWithoutExt && del *.class",
    }
    ```
    What this does:
    - Go to current file directory
    - Compile the code in current file (assuming its a `.java` file). This will create some goofy `.class` file, dont care (not yet)
    - Run the class having the same name with `.java` file (for compiling, stupid Java requires the filename to match the `public class` name)
    - Delete `.class` files, because who cares.
- Now you should start coding Java haha. Remember to name the `public class` to have the same name with current file. Focus on coding in the `main` func, but also review the input helper funcs to make your life easier.<br>

### Apache Netbeans Setup
> For this course, I recommend creating `Java with Ant` project in Netbeans. Its lightweight and simple to use. Assuming you have created a project before follow these steps.
- Open Apache Netbeans IDE
- Go to `Tools` -> `Templates` -> `Java` -> `Java Class` -> `Open in Editor`
- Replace the code with the content of `snippet-netbeans.java` file, then save and close the editor
- Now when you want to create a new Java file, choose `Java` -> `Java Class`, name your file and click `Finish`

Congrats! Now you should see a template code with some helper functions for input handling and OOP. Focus on coding in the `main` func.<br>
