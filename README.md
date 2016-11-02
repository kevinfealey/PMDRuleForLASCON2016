# PMDRuleForLASCON2016
Example of a PMD Rule for my LASCON 2016 presentation

This PMD rule has been tested with PMD 5.4.0. 


This rule will look for any method called ```doPost(...)``` or ```doGet(...)``` that calls the other with parameters called ```request``` and ```response```. The rule does not verify the data type of the request and response variables, and does not confirm that doGet or doPost are part of a web application.

Using this rule will require maven and PMD.

To use this rule:
```
git clone https://github.com/kevinfealey/PMDRuleForLASCON2016.git
cd PMDRuleForLASCON2016
```
Update the pom.xml file by setting the two properties at the top of the file ```pathToPMD``` and ```PMD_Version```.

```
mvn clean install
```

This will package the rule file and also copy it to your PMD installation lib directory. 

To execute PMD with this rule:
```
pmd.bat -d <file_or_directory_to_test> -f <output_type - often html> -R <absolute_path_to_PostEqualsGetRule.xml>
```
PostEqualsGetRule.xml is in the src/main/resources dir of this project.
