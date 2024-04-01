import java.util.Enumeration;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;

public class Class247 extends Page {
   boolean Field779;
   public static String Field780 = null;
   private Button Field781;
   private Button Field782;
   private Class36 Field783;
   static String Field784;

   public Class247(boolean var1, Page var2) {
      super(Localized.GetString("title.filePicker"));
      this.Method361(var2);
      this.Field779 = var1;
      this.Method287(Localized.GetString(this.Field779 ? "title.chooseFolder" : "title.chooseFile"));
      this.Field783 = new Class36(Localized.GetString("general.actions"));
      this.Field783.AddElement((new Class119(this, Localized.GetString(this.Field779 ? "fm.chooseThisFolder" : "fm.chooseThisFile"))).SetRleIcon("new/paperclip.rle"));
      this.Field783.AddElement((new Class109(this, Localized.GetString("fm.createFolder"))).SetRleIcon("new/folder.rle"));
      this.Field783.AddElement((new Class111(this, Localized.GetString("fm.rename"))).SetRleIcon("new/pencil.rle"));
      this.Field783.AddElement((new Class112(this, Localized.GetString("fm.delete"))).SetRleIcon("new/delete.rle"));
      this.Field783.AddElement((new Class115(this, Localized.GetString("action.cancelChoosing"))).SetRleIcon("new/close.rle"));
      this.Method0();
   }

   public final String Method29() {
      return Class198.Instance._touchHud ? null : super.Method29();
   }

   public final void Method0() {
      if (Field784 != null && !Field784.equals("file://")) {
         this.Method235(Field784);
      } else {
         this.Method21();
      }
   }

   private void Method23() {
      Class36 var1 = new Class36();
      Button var2 = (Button)this.Method367();
      String var4 = var2.LableElement != null ? var2.LableElement.toString() : null;
      String var3 = "fm.deleteConfirm";
      var3 = Localized.Method398("fm.deleteConfirm", var4, null);
      TextBlock var10001 = new TextBlock(var3);
      boolean var6 = true;
      TextBlock var5 = var10001;
      var10001.IsBold = true;
      var6 = true;
      var5.SkipImage = var6;
      var1.AddElement(var5);
      var1.AddElement(new Class122(this, Localized.GetString("action.ok"), var2));
      var1.AddElement(new Class125(this, Localized.GetString("action.cancel")));
      Class198.Instance.Method481(var1);
      var1.Field814 = 2;
   }

   public final void Method20() {
      this.Field783.Field814 = 0;
      this.Field783.VerticalScroll = this.Field783.Field813 = 0;
      Class198.Instance.Method481(this.Field783);
   }

   public final void Method67(int var1) {
      if (var1 == 2) {
         if (this.Field781 != null) {
            this.Field781.CommandExecuted();
         } else {
            this.Method22();
         }
      } else if (var1 == 1000010) {
         if (this.Field814 == 0) {
            Class198.Instance.ShowError(Localized.GetString("fm.pleaseSelectFile"));
         } else {
            this.Method23();
         }
      } else {
         super.Method67(var1 == 5 ? 8 : var1);
      }
   }

   public void Method27(String var1) {
      this.Method22();
   }

   private void Method21() {
      this.Method287(Localized.GetString(this.Field779 ? "title.chooseFolder" : "title.chooseFile"));
      this.Field825 = null;
      Field784 = "file://";
      this.Clear();
      this.Field781 = null;
      this.Field782 = null;
      this.Field814 = 0;
      this.VerticalScroll = 0;
      this.Field813 = 0;
      Enumeration var1 = null;

      try {
         var1 = FileSystemRegistry.listRoots();
      } catch (Throwable var3) {
         Class198.Instance.ShowError(var3);
      }

      while(var1 != null && var1.hasMoreElements()) {
         String var2;
         if ((var2 = (String)var1.nextElement()) != null) {
            if (var2.endsWith("/") && !Field780.equals("/")) {
               Field780 = "/";
            }

            if (var2.endsWith("/") || var2.endsWith("\\")) {
               var2 = var2.substring(0, var2.length() - 1);
            }

            Button var4 = (new Class127(this, var2, (byte)2, var2)).SetSubtitle(Class198.Instance._touchHud ? Localized.GetString("general.root") : null).SetRleIcon("new/sd.rle");
            this.AddElement(var4);
         }
      }

   }

   private void Method235(String var1) {
      String var2;
      boolean var3 = (var2 = (var1 = (var1.startsWith("file://") ? "" : (var1.startsWith(Field780) ? "file://" : "file://" + Field780)) + var1 + (!var1.endsWith(Field780) ? Field780 : "")).substring(0, var1.length() - 1).substring(0, var1.substring(0, var1.length() - 1).lastIndexOf(Field780.charAt(0)))).equals("file://");
      this.Method287(var1.substring(7));
      this.Field825 = this.Field783;
      Field784 = var1;
      this.Clear();
      this.Field814 = 0;
      this.VerticalScroll = 0;
      this.Field813 = 0;
      this.Field781 = (new Class174(this, ".." + Field780, (byte)2, var3, var2, var1)).SetSubtitle(Class198.Instance._touchHud ? Localized.GetString("action.goUpwards") : null).SetRleIcon("new/chevron-up.rle");
      this.AddElement(this.Field781);

      try {
         int var10 = 1;
         FileConnection var4;
         if ((var4 = (FileConnection)Connector.open(var1, 1)).isDirectory()) {
            Enumeration var5 = var4.list();

            label91:
            while(true) {
               String var6;
               do {
                  if (!var5.hasMoreElements()) {
                     break label91;
                  }
               } while((var6 = (String)var5.nextElement()) == null);

               boolean var7 = var6.endsWith(Field780);
               String var8 = var6;
               if (var7) {
                  var8 = var6.substring(0, var6.length() - Field780.length());
               }

               Class173 var10000;
               String var10001;
               label88: {
                  var10000 = new Class173(this, var8, (byte)(var7 ? 2 : 0), var7, var1, var6);
                  if (Class198.Instance._touchHud) {
                     if ((var8 = Method236(var6)).equals("new/file.rle")) {
                        var10001 = Localized.GetString("file.file");
                        break label88;
                     }

                     if (var8.equals("new/music-note.rle")) {
                        var10001 = Localized.GetString("file.audio");
                        break label88;
                     }

                     if (var8.equals("new/image.rle")) {
                        var10001 = Localized.GetString("file.photo");
                        break label88;
                     }

                     if (var8.equals("new/filmstrip.rle")) {
                        var10001 = Localized.GetString("file.video");
                        break label88;
                     }

                     if (var8.equals("new/folder.rle")) {
                        var10001 = Localized.GetString("file.folder");
                        break label88;
                     }
                  }

                  var10001 = null;
               }

               Button var11 = var10000.SetSubtitle(var10001).SetRleIcon(Method236(var6));
               if (var7) {
                  this.Method293(var11, var10);
                  ++var10;
               } else {
                  this.AddElement(var11);
               }
            }
         }

         var4.close();
      } catch (Throwable var9) {
      }

      if (this.Field779) {
         this.Field782 = (new Class172(this, Localized.GetString("fm.chooseThisFolder"), var1)).SetSubtitle(Class198.Instance._touchHud ? var1.substring(var2.length() + 1) : null).SetRleIcon("new/folder-open.rle");
         this.Method293(this.Field782, 1);
      } else {
         this.Field782 = null;
      }
   }

   public final void Method139(String var1) {
      String var2 = var1;
      Class247 var5 = this;
      int var3 = 0;

      int var10000;
      while(true) {
         if (var3 >= var5.Count()) {
            var10000 = -1;
            break;
         }

         Class328 var4;
         if ((var4 = var5.ElementAt(var3)) instanceof Button && ((Button)var4).LableElement.equals(var2)) {
            var10000 = var3;
            break;
         }

         ++var3;
      }

      int var6 = var10000;
      if (var10000 != -1) {
         this.Method365(this.GetWidth(), var6 + 1);
         this.Method369(var6);
         this.VerticalScroll = this.Field813;
      }

   }

   private static String Method236(String var0) {
      if (var0 == null) {
         return "new/file.rle";
      } else if ((var0 = var0.toLowerCase()).endsWith(Field780)) {
         return "new/folder.rle";
      } else if (!var0.endsWith(".mp3") && !var0.endsWith(".aac") && !var0.endsWith(".ogg") && !var0.endsWith(".wav")) {
         if (var0.endsWith(".png") || var0.endsWith(".jpg") || var0.endsWith(".jpeg") || var0.endsWith(".bmp")) {
            return "new/image.rle";
         } else {
            return !var0.endsWith(".3gp") && !var0.endsWith(".avi") && !var0.endsWith(".mkv") && !var0.endsWith(".mp4") ? "new/file.rle" : "new/filmstrip.rle";
         }
      } else {
         return "new/music-note.rle";
      }
   }

   public static boolean Method237(Button var0) {
      return var0._photoUrl != null && var0._photoUrl.equals(Method236(Field780));
   }

   static void Method238(Class247 var0, String var1) {
      var0.Method27(var1);
   }

   static void Method239(Class247 var0) {
      Class36 var1;
      Class36 var10000 = var1 = new Class36();
      TextBlock var10001 = new TextBlock(Localized.GetString("fm.enterFolderName"));
      boolean var3 = true;
      TextBlock var2 = var10001;
      var10001.IsBold = true;
      var3 = true;
      var2.SkipImage = var3;
      var10000.AddElement(var2);
      TextBox2 var4 = new TextBox2(var0.Field819 != null ? var0.Field819.toString() : null, Localized.GetString("fm.newFolder"));
      var1.AddElement(var4);
      var1.AddElement(new Class100(var0, Localized.GetString("action.ok"), var4));
      var1.AddElement(new Class105(var0, Localized.GetString("action.cancel")));
      Class198.Instance.Method481(var1);
      var1.Field814 = 1;
   }

   static void Method240(Class247 var0) {
      Class36 var1 = new Class36();
      Button var2 = (Button)var0.Method367();
      String var5 = var2.LableElement != null ? var2.LableElement.toString() : null;
      String var4 = "fm.enterNewName";
      String var3 = Localized.Method398("fm.enterNewName", var5, null);
      TextBlock var10001 = new TextBlock(var3);
      boolean var8 = true;
      TextBlock var7 = var10001;
      var10001.IsBold = true;
      var8 = true;
      var7.SkipImage = var8;
      var1.AddElement(var7);
      TextBox2 var6 = new TextBox2(var3, var2.LableElement != null ? var2.LableElement.toString() : null);
      var1.AddElement(var6);
      var1.AddElement(new Class106(var0, Localized.GetString("action.ok"), var6, var2));
      var1.AddElement(new Class108(var0, Localized.GetString("action.cancel")));
      Class198.Instance.Method481(var1);
      var1.Field814 = 1;
   }

   static void Method241(Class247 var0) {
      var0.Method23();
   }

   static void Method242(Class247 var0, String var1) {
      var1 = var1;
      var0 = var0;

      try {
         FileConnection var2 = null;

         try {
            if ((var2 = (FileConnection)Connector.open(var1)).exists()) {
               throw new Exception(Localized.GetString("fm.folderExists"));
            }

            var2.mkdir();
            var2.close();
            Class198.Instance.Method487();
            var0.Method235(Field784);
            var0.Method139(var1.substring(Field784.length(), var1.length() - Field780.length()));
         } catch (Exception var4) {
            try {
               if (var2 != null) {
                  var2.close();
               }
            } catch (Exception var3) {
            }

            Class198.Instance.ShowError(var4);
            return;
         }
      } catch (Throwable var5) {
         Class198.Instance.ShowError(var5);
      }

   }

   static void Method243(Class247 var0, String var1, String var2) {
      var2 = var2;
      var1 = var1;
      var0 = var0;

      try {
         FileConnection var3 = null;

         try {
            (var3 = (FileConnection)Connector.open(var2)).rename(var1);
            var3.close();
            Class198.Instance.Method487();
            var0.Method235(Field784);
            var0.Method139(var1);
         } catch (Exception var5) {
            try {
               if (var3 != null) {
                  var3.close();
               }
            } catch (Exception var4) {
            }

            Class198.Instance.ShowError(var5);
            return;
         }
      } catch (Throwable var6) {
         Class198.Instance.ShowError(var6);
      }

   }

   static void Method244(Class247 var0, String var1) {
      var1 = var1;
      var0 = var0;

      try {
         FileConnection var2 = null;

         try {
            (var2 = (FileConnection)Connector.open(var1)).delete();
            var2.close();
            Class198.Instance.Method487();
            int var6 = var0.Field814;
            var0.Method235(Field784);
            var0.Field814 = var6;
            if (var0.Field814 >= var0.Count()) {
               var0.Field814 = var0.Count() - 1;
            }

            var0.Method365(var0.GetWidth(), var0.Field814 + 1);
            var0.Method369(var0.Field814);
            var0.VerticalScroll = var0.Field813;
         } catch (Exception var4) {
            try {
               if (var2 != null) {
                  var2.close();
               }
            } catch (Exception var3) {
            }

            Class198.Instance.ShowError(var4);
            return;
         }
      } catch (Throwable var5) {
         Class198.Instance.ShowError(var5);
      }

   }

   static void Method245(Class247 var0, String var1) {
      var0.Method235(var1);
   }

   static void Method246(Class247 var0) {
      var0.Method21();
   }

   static {
      if ((Field780 = System.getProperty("file.separator")) == null) {
         Field780 = "/";
      }

   }
}
