import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class36 extends Page {
   private int Field60;
   int Field61;
   public boolean Field62;
   public boolean Field63;
   public boolean Field64;
   private boolean Field65;
   private boolean Field66;
   private boolean Field67;
   public static int Field68;
   public static Image Field69;

   public Class36(String var1) {
      super(var1);
      this.Field63 = true;
   }

   public Class36() {
      this(null);
   }

   public void Method83(int var1, int var2, int var3) {
      this.Field60 = var1;
      this.Field61 = var2;
      var1 = Class198.Instance.Field677;
      var2 = this.Method5();
      if ((var3 & 1) == 1) {
         this.Field60 -= var1 / 2;
      } else if ((var3 & 8) == 8) {
         this.Field60 -= var1;
      }

      if ((var3 & 2) == 2) {
         this.Field61 -= var2 / 2;
      } else if ((var3 & 32) == 32) {
         this.Field61 -= var2;
      }

      Class36 var10000;
      boolean var10001;
      label34: {
         this.Field60 = Math.min(Math.max(0, this.Field60), Class198.Instance.getWidth() - var1);
         this.Field61 = Math.min(Math.max(0, this.Field61), Class198.Instance.getHeight() - var2);
         this.VerticalScroll = this.Field813 = 0;
         this.Field814 = 0;
         if (!this.Field62 && this.Field63) {
            var10000 = this;
            if (!this.IsEmpty()) {
               var10001 = true;
               break label34;
            }
         } else {
            var10000 = this;
         }

         var10001 = false;
      }

      var10000.Field62 = var10001;
      this.Field64 = this.Field62;
      this.Field67 = false;
   }

   public final int Method5() {
      if (this.ScrollableHeight == 0) {
         this.Method365(Class198.Instance.Field677, this.Count());
      }

      return Math.min(this.ScrollableHeight + Field68 + Field68, Class198.Instance.getHeight());
   }

   private int Method454() {
      if (this.ScrollableHeight == 0) {
         this.Method365(Class198.Instance.Field677, this.Count());
      }

      return Math.min(this.ScrollableHeight, Class198.Instance.getHeight() - Field68 - Field68);
   }

   public final int GetWidth() {
      return Class198.Instance.Field677;
   }

   public final void Method292(Graphics var1, int var2) {
      if (this.Field62 && !this.IsEmpty()) {
         var1.setColor(Class6.ColorsInstanse.Field361);
         if (this.Field64) {
            Class252.Method331(var1, this.Field60, this.Field61, Class198.Instance.Field677, this.Method5());
            if (Field69 != null) {
               var1.fillRect(this.Field60 + Field68, this.Field61, Class198.Instance.Field677 - Field68 - Field68, Field68);
               var1.fillRect(this.Field60 + Field68, this.Field61 + this.Method5() - Field68, Class198.Instance.Field677 - Field68 - Field68, Field68);
               var1.drawImage(Field69, this.Field60, this.Field61, 20);
               var1.drawRegion(Field69, 0, 0, Field68, Field68, 5, this.Field60 + Class198.Instance.Field677 - Field68, this.Field61, 0);
               var1.drawRegion(Field69, 0, 0, Field68, Field68, 3, this.Field60 + Class198.Instance.Field677 - Field68, this.Field61 + this.Method5() - Field68, 0);
               var1.drawRegion(Field69, 0, 0, Field68, Field68, 6, this.Field60, this.Field61 + this.Method5() - Field68, 0);
            } else {
               var1.fillRect(this.Field60, this.Field61, Class198.Instance.Field677, Field68);
               var1.fillRect(this.Field60, this.Field61 + this.Method5() - Field68, Class198.Instance.Field677, Field68);
            }

            this.Field64 = false;
         }

         var1.fillRect(this.Field60, this.Field61 + Field68, Class198.Instance.Field677, this.Method5() - Field68 - Field68);
         this.Method61(var1, this.Field60, this.Field61 + Field68, Class198.Instance.Field677, this.Method454(), this.Method454(), false);
      }
   }

   public final void Method67(int var1) {
      super.Method67(var1);
      this.Field62 = var1 == 6 || var1 == 1 || var1 == 1000011 || var1 == 8 || var1 == 56 || var1 == 50 || (var1 == 2 || var1 == 5) && this.Method367() instanceof Class466;
   }

   private boolean Method455(int var1, int var2) {
      return var2 >= this.Field61 && var1 >= this.Field60 && var2 < this.Field61 + this.Method5() && var1 < this.Field60 + Class198.Instance.Field677;
   }

   public final void Method62(int var1, int var2) {
      this.Field67 = true;
      this.Field65 = this.Method455(var1, var2);
      this.Field66 = var2 >= this.Field61 + Class198.Instance._fontBold.getHeight() / 2 && var1 >= this.Field60 && var2 < this.Field61 + Class198.Instance._fontBold.getHeight() / 2 + this.Method454() && var1 < this.Field60 + Class198.Instance.Field677;
      if (this.Field66) {
         super.Method62(var1 - this.Field60, var2 + Class198.Instance.HeaderHeight - this.Field61 - Class198.Instance._fontBold.getHeight() / 2);
      }

   }

   public final void Method63(int var1, int var2) throws Exception {
      if (this.Field67) {
         this.Field67 = false;
         if (this.Field66) {
            super.Method63(var1 - this.Field60, var2 + Class198.Instance.HeaderHeight - this.Field61 - Class198.Instance._fontBold.getHeight() / 2);
         } else {
            if (!this.Method455(var1, var2) && !this.Field65) {
               this.Field62 = false;
            }

         }
      }
   }

   public final void Method64(int var1, int var2) {
      if (this.Field66) {
         super.Method64(var1 - this.Field60, var2 + Class198.Instance.HeaderHeight - this.Field61 - Class198.Instance._fontBold.getHeight() / 2);
      }

   }
}
