ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.11.12"

lazy val SparkVersion = "2.4.8"

lazy val root = (project in file("."))
  .settings(
    name := "spark-example",
    libraryDependencies ++= Seq(
      // Spark
      "org.apache.spark"           %% "spark-core"         % SparkVersion,
      "org.apache.spark"           %% "spark-sql"          % SparkVersion,
      "org.apache.spark"           %% "spark-hive"         % SparkVersion
    )
  )
