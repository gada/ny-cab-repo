Instructions:
-------------
Assume MVN is installed
Assume Simple cab Server is running

From SHELL command line enter: mvn spring-boot:run


You will be prompts with those input questions :
----------------------------------------------

Choose option:
--------------
(1)-Empty Cache
(2)-Get number of trips
(3)-Quit

When choosing (2):
------------------
Ignore cache ? yes/no
no
Ignore cache option chosen:no
Enter pick up date:(Format:YYYY-MM-DD)
2013-12-31
Pick up date chosen:2013-12-31
Enter medallions list (comma separated)
D7D598CD99978BD012A87A76A7C891B7,9D6B9AF8662C429553CD572F4C7589A1

Output Example:
--------------
 Medallion trip summary:name:D7D598CD99978BD012A87A76A7C891B7,tripCount:0
2018-03-19 01:42:18.087  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:9D6B9AF8662C429553CD572F4C7589A1,tripCount:24
2018-03-19 01:42:18.088  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:5AAD9B9972472BB8D128D70544B96AB9,tripCount:25
2018-03-19 01:42:18.089  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:1B96632294C366D4BDF08099BCAA6E39,tripCount:1
2018-03-19 01:42:18.090  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:6F677A97E18970FC39C8C51A2E229BAE,tripCount:0
2018-03-19 01:42:18.090  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:3425B0AE345C5731E66164898A2D9B08,tripCount:3
2018-03-19 01:42:18.091  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:67ECEA008EF4B5C5C023B2D41FADDA6B,tripCount:9
2018-03-19 01:42:18.092  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:6C9DEFE28A38A0F393D66C7FCB7EFB3C,tripCount:7
2018-03-19 01:42:18.093  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:A4A67C92A97EC87CD321E87BF7357930,tripCount:11
2018-03-19 01:42:18.094  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:88ECD363B8EEAAC5891E079984B98D16,tripCount:15
2018-03-19 01:42:18.094  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:1636FA083146AF6AE18DBD059D04CA76,tripCount:28
2018-03-19 01:42:18.095  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Medallion trip summary:name:0E482CF539D1571777148E02C4B116C0,tripCount:2
2018-03-19 01:42:18.101  INFO 14592 --- [           main] c.d.simplecab.SimpleCabServiceImpl       : Execution time :2307(ms).