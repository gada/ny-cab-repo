Instructions:
-------------
Assume MVN is installed
Assume MYSQL database is up and running:

To create database instance:
------------------
From MYSQL command line shell enter the following command:create database nycab


To make sure you use nycab database:
-----------------------------------
From MYSQL command line shell enter the following command:use nycab


To run the SQL script on nycab database:
----------------------------------------
From MYSQL command line shell enter the following command:source ny_cab_data_cab_trip_data_full.sql
(Here probably better to set AUTOCOMMIT to 0 before and than at the end issue a commit)


To run server:
--------------
From SHELL command line enter: mvn spring-boot:run
(Use simple-cab-client to issue API calls)

