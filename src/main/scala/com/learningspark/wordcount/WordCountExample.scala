package com.learningspark.wordcount
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCountExample{
  // We need to create a Spark context to access the cluster.
  // The 'local' would be replaced by the address to the cluster.
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Example Application")
    val sc = new SparkContext(conf)

    val inputFile = "/home/justin/spark/spark-3.0.1-bin-hadoop3.2/README.md"

    val input = sc.textFile(inputFile)

    // Split it on the spaces to get the words.
    // map is 1-1, while flatMap can have additional per input.
    val words = input.flatMap(line => line.split(" "))
    // This stores the word in a key, value pair with the number of occurances for
    // each one set to 1. Then we aggregate on each key / word and tell it to
    // sum the values for each word.
    val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}

    counts.foreach(println)
  }
}
