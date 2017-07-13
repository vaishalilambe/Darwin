/*
 * Darwin Evolutionary Computation Project
 * Originally, developed in Java by Rubecula Software, LLC and hosted by SourceForge.
 * Converted to Scala by Phasmid Software.
 * Copyright (c) 2003, 2005, 2007, 2009, 2011, 2016, 2017. Phasmid Software
 */

package com.phasmid.darwin.evolution

import com.phasmid.laScala.{RNG, Shuffle}

/**
  * Created by scalaprof on 7/13/17.
  *
  * This trait defines the concept of a collection which can be permuted (shuffled).
  */
trait Permutable[X] extends Iterable[X] {

  /**
    * Method to permute the members of this collection and return as an iterator.
    *
    * @param r (implicit) random number generator of Longs
    * @return an iterator on this collection but in random order
    */
  def permute(implicit r: RNG[Long]): Iterator[X] = Shuffle(r())(iterator.toSeq).toIterator
}