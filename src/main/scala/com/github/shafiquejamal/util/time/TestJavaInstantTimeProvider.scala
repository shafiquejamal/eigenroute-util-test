package com.github.shafiquejamal.util.time

import java.time.{Instant, OffsetDateTime}

import com.google.inject.Singleton

@Singleton
class TestJavaInstantTimeProvider extends JavaInstantTimeProvider {
  
  private var fakeNow: Instant =
    OffsetDateTime.now().withYear(2016).withMonth(12).withDayOfMonth(30).withHour(13).withMinute(14).withSecond(15)
    .withNano(0).toInstant
  
  override def now(): Instant = fakeNow
  
  def setNow(newFakeNow: Instant): Instant = {
    fakeNow = newFakeNow
    fakeNow
  }
}
