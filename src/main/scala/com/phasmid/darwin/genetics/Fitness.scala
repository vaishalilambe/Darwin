/*
 * DARWIN Genetic Algorithms Framework Project.
 * Copyright (c) 2003, 2005, 2007, 2009, 2011, 2016, 2017. Phasmid Software
 *
 * Originally, developed in Java by Rubecula Software, LLC and hosted by SourceForge.
 * Converted to Scala by Phasmid Software and hosted by github at https://github.com/rchillyard/Darwin
 *
 *      This file is part of Darwin.
 *
 *      Darwin is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.phasmid.darwin.genetics

/**
  * Fitness is a measure of the viability of an organism's phenotype adapting to an environment.
  * It's a Double value and should be in the range 0..1
  *
  * Created by scalaprof on 5/5/16.
  */
case class Fitness(x: Double) {
  require(x >= 0.0 && x <= 1.0, s"invalid Fitness: $x must be in range 0..1")

  def *(other: Fitness): Fitness = Fitness(x * other.x)
}

/**
  * This case class defines a (T,X)=>Fitness function and a shape factor
  *
  * @param shape the shape of the function
  * @param f     the (T,X)=>Fitness
  * @tparam T the type of the first parameter to f
  * @tparam X the type of the second parameter to f
  */
case class FunctionShape[T, X](shape: String, f: (T, X) => Fitness)

object Fitness {
  val delta: FunctionShape[Double, Double] = FunctionShape[Double, Double]("delta", { (t, x) => if (t >= x) Fitness(1) else Fitness(0) })
  val inverseDelta: FunctionShape[Double, Double] = FunctionShape[Double, Double]("delta-inv", { (t, x) => if (t < x) Fitness(1) else Fitness(0) })
}