package com.simplesys.components.Gen

import java.io.File

import com.simplesys.components._


class CreateStatics(val path: File, val withBeautifiler: Boolean) extends PublicStatic {

    private[this] def createScripts {
        printFiles()
    }

    createScripts
}

