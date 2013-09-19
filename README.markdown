# Example Storm Topologies

Learn to use Storm!

---

Table of Contents

* <a href="#getting-started">Getting started</a>
* <a href="#leiningen">Using storm-starter with Leiningen</a>
* <a href="#maven">Using storm-starter with Maven</a>
* <a href="#sbt">Using storm-starter with SBT (Scala)</a>

---


<a name="getting-started"></a>

# Getting started

## Prerequisites

First, you need `java` and `git` installed and in your user's `PATH`.  Also, two of the examples in storm-starter
require Python and Ruby.

Next, make sure you have the storm-starter code available on your machine.  Git/GitHub beginners may want to use the
following command to download the latest storm-starter code and change to the new directory that contains the downloaded
code.

    $ git clone git://github.com/nathanmarz/storm-starter.git && cd storm-starter


## storm-starter overview

storm-starter contains a variety of examples of using Storm.  If this is your first time working with Storm, check out
these topologies first:

1. [ExclamationTopology](src/jvm/storm/starter/ExclamationTopology.java):  Basic topology written in all Java
2. [WordCountTopology](src/jvm/storm/starter/WordCountTopology.java):  Basic topology that makes use of multilang by
   implementing one bolt in Python
3. [ReachTopology](src/jvm/storm/starter/ReachTopology.java): Example of complex DRPC on top of Storm

After you have familiarized yourself with these topologies, take a look at the other topopologies in
[src/jvm/storm/starter/](src/jvm/storm/starter/) such as [RollingTopWords](src/jvm/storm/starter/RollingTopWords.java)
for more advanced implementations.

If you want to learn more about how Storm works, please head over to the
[Storm project page](http://github.com/nathanmarz/storm).


<a name="leiningen"></a>

# Using storm-starter with Leiningen

## Install Leiningen

The storm-starter build uses [Leiningen](http://leiningen.org/) 2.0.  Install Leiningen by following the
[leiningen installation instructions](https://github.com/technomancy/leiningen).


## Running topologies with Leiningen

### To run a Java topology

    $ lein deps
    $ lein compile
    $ java -cp $(lein classpath) storm.starter.ExclamationTopology


### To run a Clojure topology:

    $ lein deps
    $ lein compile
    $ lein run -m storm.starter.clj.word-count


<a name="maven"></a>

# Using storm-starter with Maven

## Install Maven

[Maven](http://maven.apache.org/) is an alternative to Leiningen.  Install Maven (preferably version 3.x) by following
the [Maven installation instructions](http://maven.apache.org/download.cgi).


## Running topologies with Maven

storm-starter contains [m2-pom.xml](m2-pom.xml) which can be used with Maven using the `-f` option. For example, to
compile and run `WordCountTopology` in local mode, use the command:

    $ mvn -f m2-pom.xml compile exec:java -Dexec.classpathScope=compile -Dexec.mainClass=storm.starter.WordCountTopology


## Packaging storm-starter for use on a Storm cluster

You can package a jar suitable for submitting to a Storm cluster with the command:

    $ mvn -f m2-pom.xml package

This will package your code and all the non-Storm dependencies into a single "uberjar" at the path
`target/storm-starter-{version}-jar-with-dependencies.jar`.


## Running unit tests

Use the following Maven command to run the unit tests that ship with storm-starter.  Unfortunately `lein test` does not
yet run the included unit tests.

    $ mvn -f m2-pom.xml test

<a name="sbt"></a>

# Using storm-starter with SBT / Scala

## Install SBT

The storm-starter build uses [SBT](http://www.scala-sbt.org/) 0.13.0.  
Install SBT by following the
[SBT installation instructions](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html).


## Running topologies with SBT

### To run a Java / Scala topology

    $ sbt products
    $ sbt 'run-main storm.starter.ExclamationTopology'


### With SBT, you can list main classes and choose the one you wish to run:

    $ sbt products run
    
    [success] Total time: 2 s, completed Sep 19, 2013 3:41:24 PM
    Multiple main classes detected, select one to run:

     [1] storm.starter.ManualDRPC
     [2] storm.starter.trident.TridentReach
     [3] storm.starter.SingleJoinExample
     [4] my.play_with_scala.HelloWorld
     [5] storm.starter.RollingTopWords
     [6] storm.starter.WordCountTopology
     [7] storm.starter.trident.TridentWordCount
     [8] storm.starter.TransactionalWords
     [9] storm.starter.ExclamationTopology
     [10] storm.starter.BasicDRPCTopology
     [11] storm.sacla_starter.topology.ExclamationTology
     [12] storm.starter.TransactionalGlobalCount
     [13] storm.starter.ReachTopology

    Enter number:
