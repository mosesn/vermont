package com.mosesn.vermont

trait Version[-A] {
  def isValid(data: A): Boolean
}
