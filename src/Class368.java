import javax.microedition.lcdui.Graphics;

public class Class368 extends Class328 {
   public long Field1073;
   public long Field1074;

   public final void Method0() {
      if (this.Field1073 < 0L) {
         this.Field1073 = 0L;
      } else {
         if (this.Field1073 > this.Field1074) {
            this.Field1073 = this.Field1074;
         }

      }
   }

   private Class368(int var1) {
      this(Class198.Instance._font.getHeight() / 4, 0);
   }

   private Class368(int var1, int var2) {
      this.Field959 = false;
      this.Height = var1 + (Class198.Instance.CharSpaceWidth << 1);
      long var4 = 100L;
      this.Field1074 = var4;
      this.Field1073 = (long)var2;
   }

   public Class368 Method247(long var1) {
      this.Field1073 = var1;
      return this;
   }

   public Class368() {
      this(0);
   }

   public void Method9(Graphics var1, int var2, int var3) {
      var2 += Class198.Instance.CharSpaceWidth << 1;
      int var4 = (int)((long)this.Field954 * Math.min(this.Field1073, this.Field1074) / this.Field1074);
      Class252.Method328(var1, this.Field956 + var3 + var4, this.VerticalPosition + var2, this.Field954 - var4, this.Height - (Class198.Instance.CharSpaceWidth << 1), Class6.ColorsInstanse.Field329, Class6.ColorsInstanse.Field330);
      Class252.Method328(var1, this.Field956 + var3, this.VerticalPosition + var2, var4, this.Height - (Class198.Instance.CharSpaceWidth << 1), Class6.ColorsInstanse.Field331, Class6.ColorsInstanse.Field332);
   }

   public final void Method8() {
   }
}
