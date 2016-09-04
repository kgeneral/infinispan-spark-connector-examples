package org.jbugkorea.spark.jdg.utils

import org.infinispan.client.hotrod.{RemoteCache, RemoteCacheManager}
import org.infinispan.spark.domain.User


object PopulateJDGCacheDataForDStream {

  def main(args: Array[String]): Unit = {
    // Obtain the remote cache
    val cacheManager = new RemoteCacheManager
//    val cache = cacheManager.getCache[Integer, User]()
//    cache.clear()
//    (1 to 20000).foreach { idx =>
//      cache.put(idx, new User(s"name$idx", idx))
//      println(idx)
//      Thread.sleep(1000)
//    }


    val cache = cacheManager.getCache[Int, String]("stream")
//    cache.clear()
    (1 to 20000).foreach { idx =>
      cache.put(idx, s"myValue$idx")
      println( s"key=$idx, value=myValue$idx")
      Thread.sleep(1000)
    }
  }
}
