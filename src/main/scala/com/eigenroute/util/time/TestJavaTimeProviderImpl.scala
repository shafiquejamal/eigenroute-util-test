package com.eigenroute.util.time

import java.time.OffsetDateTime

import com.google.inject.Singleton

@Singleton
class TestJavaTimeProviderImpl extends JavaTimeProvider {
  
  private var fakeNow =
    OffsetDateTime.now().withYear(2016).withMonth(12).withDayOfMonth(30).withHour(13).withMinute(14).withSecond(15)
        .withNano(0)
  
  def setNow(newFakeNow: OffsetDateTime): OffsetDateTime = {
    fakeNow = newFakeNow
    fakeNow
  }
  
  override def now(): OffsetDateTime = fakeNow

}

object TestJavaTimeProviderImpl {
  
  def apply: TestJavaTimeProviderImpl = new TestJavaTimeProviderImpl()
  
}