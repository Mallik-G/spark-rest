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

import org.elasticsearch.common.xcontent.{XContentBuilder,XContentFactory}

class ElasticRuleBuilder {
  
  def createBuilder(mapping:String):XContentBuilder = {
    /*
     * Define mapping schema for index 'index' and 'type'
     */
    val builder = XContentFactory.jsonBuilder()
                      .startObject()
                      .startObject(mapping)
                        .startObject("properties")

                          /* uid */
                          .startObject("uid")
                            .field("type", "string")
                            .field("index", "not_analyzed")
                          .endObject()

                          /* timestamp */
                          .startObject("timestamp")
                            .field("type", "long")
                          .endObject()

                          /* antecedent */
                          .startObject("antecedent")
                            .field("type", "integer")
                          .endObject()//

                          /* consequent */
                          .startObject("consequent")
                            .field("type", "integer")
                          .endObject()//

                          /* support */
                          .startObject("support")
                            .field("type", "integer")
                          .endObject()
                          
                          /* total */
                          .startObject("total")
                            .field("type", "long")
                          .endObject()

                          /* confidence */
                          .startObject("confidence")
                            .field("type", "double")
                          .endObject()

                        .endObject() // properties
                      .endObject()   // mapping
                    .endObject()
                    
    builder

  }

}