package ru.simplesys.meta.types

import java.io.InputStream

class EmptyInputStream extends InputStream{
    override def read(): Int = -1
}
