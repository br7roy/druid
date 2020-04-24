/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.druid.spark.utils

import org.apache.spark.sql.types.StructType
import org.joda.time.chrono.ISOChronology
import org.joda.time.{DateTime, Interval}

class DruidDataWriterConfig(
                             val dataSource: String,
                             val partitionId: Int,
                             val partitionsCount: Int,
                             val schema: StructType,
                             val dataSchemaSerialized: String,
                             val segmentInterval: Interval,
                             val shardSpecSerialized: String,
                             val rollup: Boolean,
                             val rowsPerPersist: Int,
                             val rowsPerSegment: Long,
                             val deepStorageType: String,
                             val deepStorageProperties: Map[String, AnyRef],
                             version: Option[String] = None,
                             val partitionDimensions: Option[List[String]] = None
                           ) extends Serializable {
  def getVersion: String = {
    version.getOrElse(DateTime.now(ISOChronology.getInstanceUTC).toString)
  }
}
