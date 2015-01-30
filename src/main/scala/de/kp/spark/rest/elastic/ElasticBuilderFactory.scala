package de.kp.spark.rest.elastic
/* Copyright (c) 2014 Dr. Krusche & Partner PartG
* 
* This file is part of the Spark-REST project
* (https://github.com/skrusche63/spark-rest).
* 
* Spark-REST is free software: you can redistribute it and/or modify it under the
* terms of the GNU General Public License as published by the Free Software
* Foundation, either version 3 of the License, or (at your option) any later
* version.
* 
* Spark-REST is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
* A PARTICULAR PURPOSE. See the GNU General Public License for more details.
* You should have received a copy of the GNU General Public License along with
* Spark-REST. 
* 
* If not, see <http://www.gnu.org/licenses/>.
*/

import org.elasticsearch.common.xcontent.XContentBuilder

object ElasticBuilderFactory {

  def getBuilder(builder:String,mapping:String,names:List[String]=List.empty[String],types:List[String]=List.empty[String]):XContentBuilder = {
    
    builder match {

      case "event" => new ElasticEventBuilder().createBuilder(mapping)
      case "item"  => new ElasticItemBuilder().createBuilder(mapping)

      case "feature" => new ElasticFeatureBuilder().createBuilder(mapping,names,types)
      case "product" => new ElasticProductBuilder().createBuilder(mapping)

      case "rule"     => new ElasticRuleBuilder().createBuilder(mapping)
      case "sequence" => new ElasticSequenceBuilder().createBuilder(mapping)

      case "state"  => new ElasticStateBuilder().createBuilder(mapping)

      case "point"  => new ElasticPointBuilder().createBuilder(mapping)
      case "vector" => new ElasticVectorBuilder().createBuilder(mapping)
      
      case _ => null
      
    }
  
  }

}