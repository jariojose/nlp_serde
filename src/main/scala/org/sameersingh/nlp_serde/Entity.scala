package org.sameersingh.nlp_serde

import scala.collection.mutable
import org.sameersingh.nlp_serde.Util.Attr

/**
 * @author sameer
 * @since 9/1/14.
 */
class Entity extends Attr {
  // 1-indexed
  var id: Int = _
  // 1-indexed
  var representativeMId: Int = _
  var representativeString: String = _
  var mids: mutable.Set[Int] = new mutable.HashSet
  var freebaseIds: mutable.Set[String] = new mutable.HashSet
  var ner: Option[String] = None

  def this(d: immutable.Entity) = {
    this()
    id = d.id
    representativeMId = d.representativeMId
    mids ++= d.mids
    freebaseIds ++= d.freebaseIds
    ner = d.ner
    attrs ++= d.attrs
  }

  def toCase = immutable.Entity(id, representativeMId, representativeString, mids.toSet, freebaseIds.toSet, ner, attrs.toMap)
}