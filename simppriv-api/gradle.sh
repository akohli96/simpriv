#!/bin/sh
cd $SimPriv-API/simppriv-api
sbt ++$TRAVIS_SCALA_VERSION package

language: java
