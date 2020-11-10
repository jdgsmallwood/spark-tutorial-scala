package com.learningspark.wordcount
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

class WordCountExample extends App {
  // We need to create a Spark context to access the cluster.
  // The 'local' would be replaced by the address to the cluster.
  val conf = new SparkConf().setMaster("local").setAppName("Example Application")
  val sc = new SparkContext(conf)

}
