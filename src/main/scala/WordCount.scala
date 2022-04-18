import org.apache.spark._

import scala.util.Try

object WordCount {
  def main(args: Array[String]): Unit = {
    val inputPath: Option[String] = Try(args(0)).toOption
    val outputPath: Option[String] = Try(args(1)).toOption
    val conf: SparkConf = new SparkConf(true).setMaster("local").setAppName("word-count")
    val spark: SparkContext = SparkContext.getOrCreate(config = conf)

    spark.textFile(inputPath.getOrElse("hdfs://namenode1/usr/user/data/input"))
      .flatMap(line => line.split(" "))
      .map(word => (word.trim, 1))
      .reduceByKey(_ + _)
      .saveAsTextFile(outputPath.getOrElse("hdfs://namenode1/usr/user/data/output"))
  }
}
