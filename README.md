# SimPriv-API

 SimPriv-API a.k.a SimPriv is a REST based API for exchanging notes a.k.a snippet originally developed by Utsav Dhungel and Ayush Kohli.

## Introduction

SimPriv tries to fuse together PrivNote and Snapchat and allows users to exchange notes with one another in a secure manner.

##Features

SimPriv allows users to create an account with a username which returns a random generated password upon their signup. Users can look up other users and send a message to them. The message is encrypted with the receivers password.
Once the receiver authenticates themselves and tries to retrieve the snippet the snippet is decrypted, seen by the receiver and deleted forever.

##Security

SimPriv uses basic authentication to authenticate users on the create snippet and retrieve snippet features.
When a message is created it can only be decrypted by the authorized (receiver) user meaning unauthorized users will not be able to retrieve snippets they are not entitled to.

##Technical aspects

Java 8 and Spring Boot used for API development.
Spring Security is used in particular to handle the authentication.
SQL database is used to store user accounts and snippets. Currently, for development purposes H2 database is used.
