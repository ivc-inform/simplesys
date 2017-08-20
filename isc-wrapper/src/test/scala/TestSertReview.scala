import com.simplesys.isc.control.menu.MenuItemDyn
import com.simplesys.isc.control.{IconMenuButtonDyn, IconButtonDyn, MenuDyn}
import com.simplesys.isc.forms.formItems.SpacerItemDyn
import com.simplesys.isc.layout.{RibbonBarDyn, RibbonGroupDyn}
import com.simplesys.isc.system.global._
import com.simplesys.isc.system.{ArrayDyn, PageDyn, IscDyn}
import com.simplesys.isc.system.ClassDyn._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.templates.IscHtmlDyn
import com.simplesys.json.JsonList
import com.simplesys.log.Logging
import com.simplesys.servlet.ServletContext
import org.scalatest.FunSuite
import com.simplesys.isc.system.misc._
import com.simplesys.common.Strings._

class TestSertReview extends FunSuite with Logging {


  test("1") {
    val _Isc = IscDyn()
    ModeNames = PortalMode

    _Isc componentEnqueue new PageDyn {
      setAppImgDir("/isomorphic/images/")
    }

    val typeMenu = new MenuDyn {
      //ID = "typeMenu"
      AutoDraw = false
      ShowShadow = true
      ShadowDepth = 10
      Data = ArrayDyn(
        new MenuItemDyn {
          Title = "Документ"
          KeyTitle = "Ctrl+D"
          Icon = "icons/16/document_plain_new.png"
          Click = "isc.say(this.title + ' clicked');".strMt
        },
        new MenuItemDyn {
          Title = "Изображение"
          KeyTitle = "Ctrl+P"
          Icon = "icons/16/folder_out.png"
          Click = "isc.say(this.title + ' clicked');".strMt
        },
        new MenuItemDyn {
          Title = "Мыло".quoted
          KeyTitle = "Ctrl+P"
          Icon = "icons/16/disk_blue.png"
          Click = "isc.say(this.title + ' clicked');".strMt
          Submenu = ArrayDyn(
            new MenuItemDyn(useSelfName = true) {
              Title = "Изображение Sum"
              KeyTitle = "Ctrl+P"
              Icon = "icons/16/folder_out.png"
              Click = "isc.say(this.title + ' clicked');".strMt
            },
            new MenuItemDyn {
              Title = "Изображение Sum2"
              KeyTitle = "Ctrl+P"
              Icon = "icons/16/folder_out.png"
              Click = "isc.say(this.title + ' clicked');".strMt
            })
        }
      )
    }

    _Isc componentEnqueue(typeMenu, ("typeMenu", false))

    def getIconButton(btn: IconButtonDyn => Unit) = {
      val res = new IconButtonDyn(useSelfName = true) {
        Icon = "pieces/16/cube_blue.png"
        LargeIcon = "pieces/48/cube_blue.png"
        IconClick = "isc.say(this.title + ' icon clicked');".strMt
        Click = "isc.say(this.title + ' clicked');".strMt
      }
      btn(res)
      res
    }

    def getIconMenuButton(btn: IconMenuButtonDyn => Unit) = {
      val res = new IconMenuButtonDyn(useSelfName = true) {
        Icon = "pieces/16/piece_blue.png"
        LargeIcon = "pieces/48/piece_blue.png"
        IconClick = "isc.say(this.title + ' icon clicked');".strMt
        MenuAnimationEffect = mnuAnimEffctFade
      }
      btn(res)
      res
    }

    val fileGroup = new RibbonGroupDyn(useSelfName = true) {
      Align = AlCenter
      Identifier = "fileGroup"
      Title = "Файл".ellps
      NumRows = 3
      ColWidths = JsonList(3, "*")
      TitleAlign = AlLeft
      BodyConstructor = "5454"
      Controls = ArrayDyn(
        getIconMenuButton {
          button =>
            button.Title = "Новый"
            button.Orientation = icbtnOrntVertical
            button.Menu = typeMenu
            button.ShowMenuIconOver = true
        },
        getIconButton {
          button =>
            button.Title = "Открыть".ellps
            button.Orientation = icbtnOrntVertical
            button.LargeIcon = "pieces/48/cube_green.png"
        },
        getIconButton {
          button =>
            button.Title = "Сохранить"
            button.Orientation = icbtnOrntVertical
            button.LargeIcon = "pieces/48/star_yellow.png"
        },
        getIconMenuButton {
          button =>
            button.Title = "Сохранить как".ellps
            button.Orientation = icbtnOrntVertical
            button.Menu = typeMenu
            button.ShowMenuIconOver = true
            button.LargeIcon = "pieces/48/pawn_red.png"
        }
      )
      AutoDraw = false
      Vertical = true
    }

    _Isc componentEnqueue fileGroup

    val editGroup = new RibbonGroupDyn(useSelfName = true) {
      Identifier = "editGroup"
      Title = "Редактирование".ellps
      NumRows = 3
      RowHeight = 26
      ColWidths = JsonList(40, "*")
      Controls = ArrayDyn(
        getIconButton {
          button =>
            button.Title = "Изменить".ellps
            button.Icon = "pieces/16/star_yellow.png"
        },
        getIconButton {
          button =>
            button.Title = "Копировать".ellps
            button.Icon = "pieces/16/pawn_white.png"
        },
        getIconButton {
          button =>
            button.Title = "Вставить".ellps
        },
        getIconMenuButton {
          button =>
            button.Title = "Отменить"
            button.Menu = typeMenu
            button.ShowMenuIconOver = true
            button.Icon = "pieces/16/star_grey.png"
        },
        getIconMenuButton {
          button =>
            button.Title = "Применить"
            button.Menu = typeMenu
            button.Icon = "pieces/16/piece_green.png"
        }
      )
      AutoDraw = false
    }

    _Isc componentEnqueue editGroup

    val insertGroup = new RibbonGroupDyn(useSelfName = true) {
      Identifier = "inserGroup"
      Title = "Вставка".ellps
      NumRows = 3
      RowHeight = 26
      ColWidths = JsonList(40, "*")
      Controls = ArrayDyn(
        getIconMenuButton {
          button =>
            button.Title = "Картинка".ellps
            button.Orientation = icbtnOrntVertical
            button.Menu = typeMenu
            button.LargeIcon = "pieces/48/cube_blue.png"
        },
        getIconButton {
          button =>
            button.Title = "Соеденить".ellps
            button.Icon = "pieces/16/piece_red.png"
        },
        getIconButton {
          button =>
            button.Title = "Документ".ellps
            button.Icon = "pieces/16/star_blue.png"
        },
        getIconButton {
          button =>
            button.Title = "Видео".ellps
            button.Icon = "pieces/16/pawn_yellow.png"
        }
      )
      AutoDraw = false
    }

    _Isc componentEnqueue(insertGroup, ("IG", false))

    val ribbonBar = new RibbonBarDyn {
      Identifier = "mainMenuBar"
      GroupTitleAlign = AlCenter
      GroupTitleOrientation = ValTop
      MembersMargin = 3
      LayoutMargin = 3
      Height = "100".%
      Members = ArrayDyn(
        fileGroup,
        editGroup,
        insertGroup
      )
    }

    ribbonBar.addGroup(fileGroup, 0)
    ribbonBar.addGroup(editGroup, 1)
    ribbonBar.addMember(new SpacerItemDyn(useSelfName = true) {
      Width = "*"
    })
    ribbonBar.addGroup(insertGroup, 2)

    _Isc componentEnqueue(ribbonBar, ("ribbonBar", false))

    _Isc logCommandLine()
  }
}