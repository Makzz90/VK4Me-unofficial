import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class75 extends Page implements Class80, Class463 {
   public static Class75 Field206 = new Class75();
   private AttachmentItemUC Field207;
   private Image Field208;
   VKPhoto Field209;
   private int Field210;
   private String Field211;
   private String Field212;
   private int Field213;
   private int Field214;
   private int Field215;
   private int Field216;
   private float Field217 = 0.0F;
   private float Field218 = 0.0F;
   private float Field219 = 0.0F;
   private float Field220 = 0.0F;
   private Class28 Field221 = null;

   public Class75() {
      super(Localized.GetString("title.imageViewer"));
      this.Field825 = new Class441(this, Localized.GetString("general.actions"));
      this.Field221 = (Class28)(new Class440(this, Localized.GetString("action.switchResolution"))).SetRleIcon("new/refresh.rle");
      this.Field825.AddElement((new Class439(this, Localized.GetString("action.downloadImage"))).SetRleIcon("new/cloud-download.rle"));
   }

   public final Class75 Method60(VKPhoto var1, AttachmentItemUC var2, ImageElement var3) {
      this.Field209 = var1;
      this.Field207 = var2;
      this.Field208 = null;
      this.Field210 = 0;
      this.Field211 = null;
      VKImageWithSize var4 = var1 != null ? var1.Method310(Integer.MAX_VALUE, true) : null;
      this.Field212 = var4 != null ? var4.type : null;
      this.Field213 = this.Field214 = 0;
      this.Field215 = this.Field216 = 0;
      this.Width = this.Height = 0;
      this.Field217 = 0.0F;
      this.Field218 = 0.0F;
      return this;
   }

   public final void Method61(Graphics var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.Width = var4;
      this.Height = var5;
      if (var7) {
         var1.setColor(Class6.ColorsInstanse.Field291);
         var1.fillRect(var2, var3, var4, var5);
      }

      if (this.Field209 != null && this.Field208 == null) {
         VKImageWithSize var8;
         if (this.Field211 == null && (var8 = this.Field209.Method310(var4, true)) != null) {
            this.Field211 = var8.type;
            this.Field215 = var8.height;
            this.Field216 = var8.width;
            this.Method21();
            this.Field217 = this.Field218 = 0.0F;
         }

         Class198.Instance.Method496(this, 0);
      }

      boolean var9 = false;
      if (this.Field217 != 0.0F) {
         this.Field217 *= Class198.Instance.Field635 ? 0.5F : 0.96F;
         if (!(this.Field217 > 1.0F) && !(this.Field217 < -1.0F)) {
            this.Field217 = 0.0F;
         } else {
            this.Field213 = (int)((float)this.Field213 + this.Field217);
            this.Method20();
         }

         var9 = true;
      }

      if (this.Field218 != 0.0F) {
         this.Field218 *= Class198.Instance.Field635 ? 0.5F : 0.96F;
         if (!(this.Field218 > 1.0F) && !(this.Field218 < -1.0F)) {
            this.Field218 = 0.0F;
         } else {
            this.Field214 = (int)((float)this.Field214 + this.Field218);
            this.Method23();
         }

         var9 = true;
      }

      if (this.Field208 != null) {
         var1.drawImage(this.Field208, var2 + this.Field213, var3 + this.Field214, 20);
      } else if (this.Field216 > 0 && this.Field215 > 0) {
         var1.setColor(Class6.ColorsInstanse.Field328);
         var1.fillRect(var2 + this.Field213, var3 + this.Field214, this.Field216, this.Field215);
      }

      if (var9) {
         Class198.Instance.Repaint();
      }

   }

   private void Method20() {
      if (this.Field216 > this.Width) {
         this.Field213 = Math.max(Math.min(this.Field213, 0), this.Width - this.Field216);
      } else {
         this.Field213 = (this.Width - this.Field216) / 2;
      }
   }

   private void Method23() {
      if (this.Field215 > this.Height) {
         this.Field214 = Math.max(Math.min(this.Field214, 0), this.Height - this.Field215);
      } else {
         this.Field214 = (this.Height - this.Field215) / 2;
      }
   }

   private void Method21() {
      this.Field213 = (this.Width - this.Field216) / 2;
      this.Field214 = (this.Height - this.Field215) / 2;
   }

   public final void Method62(int var1, int var2) {
      this.Field219 = this.Field220 = 0.0F;
   }

   public final void Method63(int var1, int var2) {
      this.Field217 += this.Field219;
      this.Field218 += this.Field220;
      this.Field219 = this.Field220 = 0.0F;
   }

   public final void Method64(int var1, int var2) {
      this.Field219 = (float)(Class198.Instance.Field631 - Class198.Instance.Field633);
      this.Field220 = (float)(Class198.Instance.Field632 - Class198.Instance.Field634);
      this.Field213 = (int)((float)this.Field213 + this.Field219);
      this.Field214 = (int)((float)this.Field214 + this.Field220);
      this.Method20();
      this.Method23();
   }

   public final void Method65(int var1) {
      switch(var1) {
      case 1:
         this.Field214 += Class198.Instance._height / 10;
         this.Method23();
         return;
      case 2:
         this.Field213 += Class198.Instance._width / 10;
         this.Method20();
         return;
      case 5:
         this.Field213 -= Class198.Instance._width / 10;
         this.Method20();
         return;
      case 6:
         this.Field214 -= Class198.Instance._height / 10;
         this.Method23();
      case 3:
      case 4:
      default:
      }
   }

   public final void ButtonPressed(int var1) {
   }

   public final void Method67(int var1) {
      switch(var1) {
      case 1:
         this.Field214 += Class198.Instance._height / 10;
         this.Method23();
         return;
      case 2:
         this.Field213 += Class198.Instance._width / 10;
         this.Method20();
         return;
      case 5:
         this.Field213 -= Class198.Instance._width / 10;
         this.Method20();
         return;
      case 6:
         this.Field214 -= Class198.Instance._height / 10;
         this.Method23();
         return;
      case 8:
      case 1000011:
         if (this.Method68()) {
            this.Method69();
         }
      default:
      }
   }

   private boolean Method68() {
      if (this.Field212 != null && !this.Field212.equals(this.Field211)) {
         return true;
      } else {
         VKImageWithSize var1;
         return this.Field209 != null && (var1 = this.Field209.Method310(this.Width, true)) != null && this.Field212 != null && this.Field212.equals(this.Field211) && !this.Field212.equals(var1.type);
      }
   }

   private void Method69() {
      VKImageWithSize var1;
      if (this.Field209 != null && (var1 = this.Field209.Method310(this.Field211 != null && !this.Field211.equals(this.Field212) ? Integer.MAX_VALUE : this.Width, true)) != null) {
         if (var1.type.equals(this.Field211)) {
            return;
         }

         this.Field211 = var1.type;
         this.Field208 = null;
         this.Field210 = 0;
         if (this.Field216 != 0 && this.Field215 != 0) {
            this.Field213 = (this.Field213 - this.Width / 2) * var1.width / this.Field216 + this.Width / 2;
            this.Field214 = (this.Field214 - this.Height / 2) * var1.height / this.Field215 + this.Height / 2;
         } else {
            this.Method21();
         }

         this.Field217 = this.Field218 = 0.0F;
         this.Field216 = var1.width;
         this.Field215 = var1.height;
         this.Method20();
         this.Method23();
      }

   }

   public final boolean Method11(int var1) {
      return false;
   }

   public final String GetUrl(int var1) {
      VKPhoto var10000;
      if (this.Field209 != null && this.Field211 != null) {
         var10000 = this.Field209;
         String var2 = this.Field211;
         VKPhoto var5 = var10000;
         if (var10000.ImageSizes == null) {
            var10000 = null;
         } else {
            VKImageWithSize var8;
            label35: {
               var2 = var2;
               Class280 var6 = var5.ImageSizes;
               if (var2 != null) {
                  for(int i = 0; i < var6.sizes.length; i++) {
                     VKImageWithSize var4;
                     if ((var4 = var6.sizes[i]) != null && var4.type != null && var4.type.equals(var2)) {
                        var8 = var4;
                        break label35;
                     }
                  }
               }

               var8 = var6.GetAppropriateForScaleFactor(Integer.MAX_VALUE, true);
            }

            VKImageWithSize var7 = var8;
            if (var8 != null) {
               return var7.url;
            }

            var10000 = null;
         }
      } else {
         var10000 = null;
      }

      return var10000.toString();//todo: toString()??
   }

   public final void SetImage(int var1, Image var2) {
      if (var2 != null) {
         this.Field208 = var2;
         this.Field216 = var2.getWidth();
         this.Field215 = var2.getHeight();
      }
   }

   public final int Method5() {
      return this.Field210;
   }

   public final void Method6() {
      if (this.Field210 <= 5) {
         ++this.Field210;
      }
   }

   public final int Count() {
      return 1;
   }

   public final void Error(Throwable var1) {
      Class198.Instance.ShowError("Image viewer: " + var1 != null ? var1.getMessage() : "Unknown error");
   }

   public final void Method70(Class184 var1, String var2) {
      if (var1 != null && var2 != null) {
         switch(Settings.Instance.DownloadMode) {
         case 0:
            Class36 var3;
            (var3 = new Class36()).AddElement((new Class438(this, Localized.GetString("settings.downloadFile"), var1, var2)).SetRleIcon("new/cloud-download.rle"));
            var3.AddElement((new Class437(this, Localized.GetString("settings.openBrowser"), var1, var2)).SetRleIcon("new/web.rle"));
            Class198.Instance.Method481(var3);
            return;
         case 1:
         case 2:
            this.Method71(Settings.Instance.DownloadMode == 2, var2);
         default:
         }
      }
   }

   public final void Method71(boolean var1, String var2) {
      VKPhoto var3 = this.Field209;
      if (var1) {
         Midlet.Method445(var2);
      } else {
         Class198.Instance.NavigateForward(new Class436(this, true, this, var3, var2));
      }
   }

   public final void Method1(long var1) {
      if (this.Field207 != null) {
         this.Field207.Method1(var1);
      }

   }

   public final void Method27(String var1) {
      if (this.Field207 != null) {
         this.Field207.Method27(var1);
      } else {
         Class198.Instance.ShowError("Image viewer:" + var1);
      }
   }

   public final void Method72() {
      if (this.Field207 != null) {
         this.Field207.Method72();
      }

   }

   public final String Method73() {
      return this.Field209 == null ? null : this.Field209.toString();
   }

   static Class28 Method74(Class75 var0) {
      return var0.Field221;
   }

   static boolean Method75(Class75 var0) {
      return var0.Method68();
   }

   static void Method76(Class75 var0) {
      var0.Method69();
   }
}
