package com.simplesys.annotation

import scala.annotation.StaticAnnotation

/**
 * RS (сокр. от англ. Representational State Transfer — «передача репрезентативного состояния») —
 * метод взаимодействия компонентов распределённого приложения в сети Интернет, при котором вызов удаленной процедуры представляет собой обычный
 * HTTP-запрос (обычно GET или POST; такой запрос называют REST-запрос), а необходимые данные передаются в качестве параметров запроса.
 */
case class RSTransfer(urlPattern: String) extends StaticAnnotation

case class SseTransfer(urlPattern: String/*, connectionTTL: Int = 30000*/) extends StaticAnnotation