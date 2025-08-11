# OOP with Java
## Preface
> This is my first time investing to write README for schoolwork project haha. Hope this helps!

My OOP original work written in Java. You should expect some brilliant blocks hiding in numerous pieces of s***. <br>
Refer to code.p*** system & OOP P**** curriculum.
## Setup
This is for VS Code lol you shouldnt use another IDE.
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

    *IMPORTANT*: **DO NOT** change any code in `FastScanner`, except when you really know what youre going to do.
