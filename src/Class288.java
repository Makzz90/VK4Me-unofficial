import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class288 extends Class368 implements Class466 {
   public static int Field899;
   public static Image Field900;
   public static Image Field901;
   public static Image Field902;
   public static Image Field903;
   private int Field904;
   private int Field905;

   public void Method1(long var1) {
   }

   public Class288(int var1) {
      this.Field959 = true;
      this.Height = Class198.Instance._font.getHeight();
      this.Field904 = this.Height / 4;
      this.Height += Class198.Instance.CharSpaceWidth << 1;
      long var3 = 100L;
      super.Field1074 = var3;
      this.Field1073 = (long)var1;
   }

   public Class288() {
      this(0);
   }

   public final Class328 Method163(int var1, int var2, int var3) {
      if (this.Field958) {
         this.Field1073 = Class198.Method491((double)(var1 - this.Field956 - Field899 / 2) * (double)this.Field1074 / (double)(this.Field954 - 1 - Field899));
         this.Method0();
      }

      return this;
   }

   public final Class368 Method247(long var1) {
      this.Field1073 = var1;
      this.Method1(this.Field1073);
      return this;
   }

   public final Class328 Method114(int var1, int var2, int var3) throws Exception {
      if (this.Field958) {
         this.Field1073 = Class198.Method491((double)(var1 - this.Field956 - Field899 / 2) * (double)this.Field1074 / (double)(this.Field954 - 1 - Field899));
         this.Method0();
         this.Method1(this.Field1073);
      }

      super.Method114(var1, var2, var3);
      return this;
   }

   public final Class328 Method159(int var1) {
      this.Field905 = 0;
      switch(var1) {
      case 2:
         this.Field1073 -= Math.max(1L, this.Field1074 / 20L);
         this.Method0();
         this.Method1(this.Field1073);
         break;
      case 5:
         this.Field1073 += Math.max(1L, this.Field1074 / 20L);
         this.Method0();
         this.Method1(this.Field1073);
      }

      return this;
   }

   public final Class328 Method161(int var1, int var2) {
      ++this.Field905;
      switch(var1) {
      case 2:
         this.Field1073 -= Math.max(1L, this.Field1074 * (long)this.Field905 * 3L / 40L);
         this.Method0();
         break;
      case 5:
         this.Field1073 += Math.max(1L, this.Field1074 * (long)this.Field905 * 3L / 40L);
         this.Method0();
      }

      return this;
   }

   public final Class328 KeyPressed(int var1) {
      if (this.Field905 > 0) {
         this.Method1(this.Field1073);
      }

      this.Field905 = 0;
      return this;
   }

   public final Class328 Method162(int var1, int var2, int var3) {
      super.Method162(var1, var2, var3);
      return this;
   }

   public final void Method9(Graphics g, int var2, int var3) {
      var2 += Class198.Instance.CharSpaceWidth;
      int var4 = (int)((long)(this.Field954 - Field899) * Math.min(this.Field1073, this.Field1074) / this.Field1074) + Field899 / 2;
      var2 = this.VerticalPosition + var2 + (this.Height - (Class198.Instance.CharSpaceWidth << 1) - this.Field904) / 2;
      Class252.Method328(g, this.Field956 + var3 + var4, var2, this.Field954 - var4, this.Field904, Class6.ColorsInstanse.Field329, Class6.ColorsInstanse.Field330);
      Class252.Method328(g, this.Field956 + var3, var2, var4, this.Field904, Class6.ColorsInstanse.Field331, Class6.ColorsInstanse.Field332);
      var4 = Math.min(Math.max(this.Field956 + var3 + var4 - Field899 / 2, this.Field956 + var3), this.Field956 + var3 + this.Field954 - Field899);
      var2 = var2 + this.Field904 / 2 - Field899 / 2;
      if (Field900 != null && Field901 != null && Field902 != null && Field903 != null) {
         boolean var6 = this.Field958 && this.Field959;
         g.drawImage(var6 ? Field902 : Field900, var4, var2, 0);
         Image img;
         int var5 = (img = var6 ? Field903 : Field901).getHeight();
         g.drawImage(img, var4, var2, 0);
         g.drawRegion(img, 0, 0, var5, var5, 5, var4 + var5, var2, 0);
         g.drawRegion(img, 0, 0, var5, var5, 3, var4 + var5, var2 + var5, 0);
         g.drawRegion(img, 0, 0, var5, var5, 6, var4, var2 + var5, 0);
      }

   }
}
