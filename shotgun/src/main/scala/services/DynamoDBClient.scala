package services

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model._

import scala.concurrent.{ExecutionContext, Future}
import scala.collection.JavaConverters._
import scala.util.Try

class DynamoDBClient(region: Region = Region.US_EAST_1)(implicit ec: ExecutionContext) {

  // Create the base DynamoDB client
  private val dynamoDbClient = DynamoDbClient.builder()
    .region(region)
    .credentialsProvider(DefaultCredentialsProvider.create())
    .build()

  // Get an item using the standard client
  private def getItem(tableName: String, key: java.util.Map[String, AttributeValue]): Future[Option[java.util.Map[String, AttributeValue]]] = Future {
    val request = GetItemRequest.builder()
      .tableName(tableName)
      .key(key)
      .build()
      
    dynamoDbClient.getItem(request).item() match {
      case item if item.isEmpty => None
      case item => Some(item)
    }
  }
  
  // Get item with Scala Map instead of Java Map
  def getItem(tableName: String, key: Map[String, AttributeValue]): Future[Option[Map[String, AttributeValue]]] = {
    getItem(tableName, key.asJava).map { 
      _.map(_.asScala.toMap)
    }
  }
  
  // Put an item
  def putItem(tableName: String, item: Map[String, AttributeValue]): Future[PutItemResponse] = Future {
    val request = PutItemRequest.builder()
      .tableName(tableName)
      .item(item.asJava)
      .build()
      
    dynamoDbClient.putItem(request)
  }
  
  // Delete an item
  def deleteItem(tableName: String, key: Map[String, AttributeValue]): Future[DeleteItemResponse] = Future {
    val request = DeleteItemRequest.builder()
      .tableName(tableName)
      .key(key.asJava)
      .build()
      
    dynamoDbClient.deleteItem(request)
  }
  
  // Scan items
  def scanItems(tableName: String): Future[List[Map[String, AttributeValue]]] = Future {
    val request = ScanRequest.builder()
      .tableName(tableName)
      .build()
      
    dynamoDbClient.scan(request)
      .items()
      .asScala
      .map(_.asScala.toMap)
      .toList
  }

  // Close resources
  def close(): Unit = {
    dynamoDbClient.close()
  }
}
