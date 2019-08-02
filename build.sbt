organization := "com.nilan3.flink-scala-pipelines"

name := "flink-scala-pipelines"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

val flinkVersion = "1.8.1"

val snakeYaml = "1.23"

val scalaTestVersion = "3.0.1"

resolvers  += "MavenRepository" at "http://central.maven.org/maven2"

resolvers  +="Sbt plugins" at "https://dl.bintray.com/sbt/sbt-plugin-releases"

fork in Test := false

parallelExecution in Test := false

testForkedParallel in Test := false

lazy val excludeJars = ExclusionRule(organization = "net.jpountz.lz4", name = "lz4")

libraryDependencies ++= Seq(
  "org.elasticsearch" %% "elasticsearch-spark-20" % "7.2.0",
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
  "org.apache.flink" %% "flink-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % "provided"
)

libraryDependencies ++= Seq(
  "org.yaml" % "snakeyaml" % snakeYaml,
  "joda-time" % "joda-time" % "2.9.9",
  "org.slf4j" % "slf4j-api" % "1.7.25"
)