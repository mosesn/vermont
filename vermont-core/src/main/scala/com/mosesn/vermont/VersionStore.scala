package com.mosesn.vermont

import scala.collection.mutable.{HashMap, MultiMap}

trait VersionStore {
  def upgrade[A, B](from: Version[A], to: Version[B]): Option[Upgrade[A, B]]

  def isUpgradeable[A, B](from: Version[A], to: Version[B]): Boolean
}

// this is a graph, where upgrades represent edges
// versions represent vertices
abstract class GraphVersionStore(versions: Traversable[Version[_]], upgrades: Traversable[Upgrade[_, _]]) extends VersionStore {
  val graph: Map[Version[_], Traversable[Version[_]]] = tupleGroupBy(upgrades.map(upgrade => upgrade.from -> upgrade.to))

  private[this] def tupleGroupBy(tuples: Traversable[(Version[_], Version[_])]): Map[Version[_], Traversable[Version[_]]] =
    tuples.groupBy(_._1).mapValues(set => set.map(_._2))

  private[this] def search[A, B](from: Version[A], to: Version[B]): Option[Traversable[Upgrade[_, _]]] = {
    ???
  }

  override def upgrade[A, B](from: Version[A], to: Version[B]) = ???
  // TODO MN:
//  override def upgrade[A, B](from: Version[A], to: Version[B]) = search(from, to) map { upgrades => upgrades.reduce[Upgrade[_, _]](_ compose _).asInstanceOf[Upgrade[A, B]]
//  }

  override def isUpgradeable[A, B](from: Version[A], to: Version[B]) = search(from, to).isDefined

}
