import javax.microedition.lcdui.Graphics;

public final class OffsetElementUI extends Class328 implements Class187 {
   public OffsetElementUI() {
      this.Height = Class198.Instance._font.getHeight() / 2 + 1;
      //boolean var2 = true;
      super.Field959 = true;
      //var2 = true;
      super.SkipImage = true;
   }

   public final void Method9(Graphics g, int var2, int var3) {
      g.setColor(Class6.ColorsInstanse.Field360);
      g.drawLine(this.Field956 + var3, this.VerticalPosition + var2, this.Field956 + var3 + this.Field954, this.VerticalPosition + var2);
      g.setColor(Class6.ColorsInstanse.Field327);
      g.fillRect(this.Field956 + var3, this.VerticalPosition + var2 + 1, this.Field954, this.Height - 1);
   }

   public final void Method8() {
   }
}
