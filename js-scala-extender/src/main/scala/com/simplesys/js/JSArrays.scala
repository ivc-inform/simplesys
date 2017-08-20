package com.simplesys.js

import virtualization.lms.common.Base

trait LiftArray {
  this: Base =>

  implicit def arrayToRepArray[T: Manifest](array: Array[T]) = unit(array)
}