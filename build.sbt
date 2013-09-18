name := "storm-starter"

version := "1.0"

scalaVersion := "2.10.2"

unmanagedSourceDirectories in Compile <+= baseDirectory( _ / "src" / "jvm" )

unmanagedResourceDirectories in Compile <+= baseDirectory( _ / "multilang" )

unmanagedSourceDirectories in Test <+= baseDirectory( _ / "test" / "jvm" )

resolvers ++= Seq(
	"github-releases" at "http://oss.sonatype.org/content/repositories/github-releases/",
	"twitter4j" at "http://twitter4j.org/maven2",
	"clojars" at "http://clojars.org/repo/",
    "clojure-releases" at "http://build.clojure.org/releases"
)

libraryDependencies ++= Seq(
    "junit" % "junit" % "3.8.1" % "test",
    "org.testng" % "testng" % "6.8" % "test",
    "org.mockito" % "mockito-all" % "1.9.0" % "test",    
    "org.easytesting" % "fest-assert-core" % "2.0M8" % "test",
    "org.jmock" % "jmock" % "2.6.0" % "test",
    "storm" % "storm" % "0.8.2",
    "org.twitter4j" % "twitter4j-core" % "2.2.6-SNAPSHOT",
    "org.twitter4j" % "twitter4j-stream" % "2.2.6-SNAPSHOT",
    "com.googlecode.json-simple" % "json-simple" % "1.1",
    "com.google.guava" % "guava" % "13.0.1",
    "commons-collections" % "commons-collections" % "3.2.1",
    "org.scalatest" % "scalatest_2.10" % "2.0.M8" % "test"
)

