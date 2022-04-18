import org.apache.spark._

object WordCount {
  val conf: SparkConf = new SparkConf(true).setMaster("local").setAppName("word-count")
  val spark: SparkContext = SparkContext.getOrCreate(config = conf)

  spark.textFile("hdfs://namenode1/usr/user/data/input")
    .flatMap(line => line.split(" "))
    .map(word => (word.trim, 1))
    .reduceByKey(_ + _)
    .saveAsTextFile("hdfs://namenode1/usr/user/data/output")
}
