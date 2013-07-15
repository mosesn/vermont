package com.mosesn.vermont

// upgrades should be injections
trait Upgrade[A, B] extends (A => B) {
  def from: Version[A]

  def to: Version[B]
}

// if there is a partial upgrade along an upgrade chain
// the entire upgrade is considered partial
trait PartialUpgrade[A, B] extends PartialFunction[A, B] with Upgrade[A, B]
