Testing a Plugin
=================

To run unit tests on the plugin, run mvn clean test. This will remove old class files, recompile the plugin and run unit tests.

    $ mvn clean test

Building a Plugin
=================

To build the plugin, run mvn install. This will create the file ./target/pluginname.hpi that can be deployed to jenkins.

    $ mvn install


Plugin Workspace Layout
=======================

The plugin workspace consists of the following major pieces:

    pom.xml

Maven uses it for building your plugin.

    src/main/java

Java source files of the plugin.

    src/main/resources

Jelly/Groovy views of the plugin. See this <a href="https://wiki.jenkins-ci.org/display/JENKINS/Architecture">document</a> for more about it.

    src/main/webapp

Static resources of the plugin, such as images and HTML files.


Debugging the Plugin
====================

Convenient:

    $ mvn -Ddebug hpi:run

Unix:

    $ export MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n"
    $ mvn hpi:run


Windows:

    > set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n
    > mvn hpi:run


If you open http://localhost:8080/ in your browser, you should see the Jenkins page running in Jetty. 

Changing port

If you need to launch the Jenkins on a different port than 8080, set the port through the system property jetty.port.

    $ mvn hpi:run -Djetty.port=8090

Distributing a Plugin
====================

To create a distribution image of your plugin, run the following Maven command:

    $ mvn package

This should create target/*.hpi file. Other users can use Jenkins' web UI to upload this plugin to Jenkins (or place it in $JENKINS_HOME/plugins.)


Notes:
==========================================

To get oauth token run the following:

    $ curl -u '<github username>' -d '{"scopes":["repo"],"note":"Help example"}' https://api.github.com/authorizations