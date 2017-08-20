package com.simplesys.servlet

import com.simplesys.isc.foundation.ViewLoaderDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.{FileLoaderDyn, PageDyn, ServletActorDyn}
import com.simplesys.isc.templates.{IscHtmlDyn, _}
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}

class StartActor(val request: HttpServletRequest, val response: HttpServletResponse, val servletContext: ServletContext) extends ServletActorDyn with IscHtmlDyn {

    override def receive: Receive = {
        case GetData =>

            var page = IscEmptyPage(contextPath)

            page = page.addHeadScripts1(jsScripts: _*)
            page = page.addHeadStyles(ccsPaths: _*)
            page = page.addHeadVariables(jsLastVariables: _*)

            val viewLoaderC = new ViewLoaderDyn(useSelfName = true) {
                ViewURL = (contextPath + urlMainPage).url
                AutoDraw = true
                LoadingMessage = loadingMessage
                Width = "100".%
                Height = "100".%
                LoadingImageSize = 128
            }

            viewLoaderC.setViewURL()

            val fileLoader = new FileLoaderDyn
            fileLoader.loadSkin(skin = "simpleSyS.Skin", onLoad = _Isc.declareJSFunction(this, "",
                s"""{
                      | var localeFile = "${contextPath + localesDir}/frameworkMessages.properties";
                      |        if (isc.params.locale) {
                      |            if (isc.params.locale != "en")
                      |                localeFile = "${contextPath + localesDir}/frameworkMessages_" + isc.params.locale + ".properties";
                      |
                      |            isc.FileLoader.loadJSFiles(localeFile, function(){ simpleSyS.app.ViewLoaderC = ${viewLoaderC.toString};
                      |                 if (isc.RPCManagerSS.mainPageNotLogged != null)
                      |                     simpleSyS.app.ViewLoaderC.setViewURL(isc.RPCManagerSS.mainPageNotLogged);
                      |                 else
                      |                     simpleSyS.app.ViewLoaderC.setViewURL();
                      |            });
                      |        }
                    }""".stripMargin
            ))

            _Isc componentEnqueue PageDyn().setSkinDir(servletContext.ContextPath + isomorphicDir + "/skins/" + "simpleSyS.Skin" + "/load_skin.js")
            _Isc componentEnqueue fileLoader

            Out(logHtmlPageActor(page, _Isc.getCommandLine))

            selfStop()
    }
}