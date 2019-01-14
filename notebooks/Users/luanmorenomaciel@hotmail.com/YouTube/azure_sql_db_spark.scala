// Databricks notebook source
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")

// COMMAND ----------

val jdbcHostname = "azowshq.database.windows.net"
val jdbcPort = 1433
val jdbcDatabase = "owshqbigdata"
val jdbcUsername = "luanmoreno"
val jdbcPassword = "qq11ww22!!@@"

// create the JDBC URL without passing in the user and password parameters.
val jdbcUrl = s"jdbc:sqlserver://${jdbcHostname}:${jdbcPort};database=${jdbcDatabase}"

// create a Properties() object to hold the parameters.
import java.util.Properties
val connectionProperties = new Properties()

connectionProperties.put("user", s"${jdbcUsername}")
connectionProperties.put("password", s"${jdbcPassword}")

// COMMAND ----------

val driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
connectionProperties.setProperty("Driver", driverClass)

// COMMAND ----------

val product_table = spark.read.jdbc(jdbcUrl, "SalesLT.product", connectionProperties)

// COMMAND ----------

display(product_table)

// COMMAND ----------

