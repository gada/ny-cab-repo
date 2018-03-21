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
Medallion list chosen:D7D598CD99978BD012A87A76A7C891B7,9D6B9AF8662C429553CD572F4C7589A1
Medallion trip summary:name:D7D598CD99978BD012A87A76A7C891B7,tripCount:0
Medallion trip summary:name:9D6B9AF8662C429553CD572F4C7589A1,tripCount:24
Execution time :13281(ms).