package de.kp.spark.rest
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

import akka.actor.{Actor,ActorLogging}

import de.kp.spark.rest.model._
import scala.concurrent.Future

abstract class BaseActor extends Actor with ActorLogging {

  implicit val ec = context.dispatcher
  
  protected def failure(req:ServiceRequest,message:String):ServiceResponse = {
    
    if (req == null) {
      val data = Map("message" -> message)
      new ServiceResponse("","",data,ResponseStatus.FAILURE)	
      
    } else {
      val data = Map("uid" -> req.data("uid"), "message" -> message)
      new ServiceResponse(req.service,req.task,data,ResponseStatus.FAILURE)	
    
    }
    
  }
  
  protected def getResponse(service:String,message:String):Future[String]

}