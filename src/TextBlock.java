import javax.microedition.lcdui.Graphics;

public class TextBlock extends Class328 {
   private Class277 Field1195;
   private Class277[] Field1196;
   private Integer Field1197;
   public boolean IsBold;
   public int Field1199;

   public final void Method23() {
      this.Field1196 = null;
   }

   public final TextBlock Method55(int var1) {
      Integer var2 = new Integer(var1);
      this.Field1197 = var2;
      return this;
   }

   public TextBlock(String lable) {
      this.Method57(lable);
      boolean var2 = true;
      super.Field959 = var2;
   }

   public final TextBlock SetBold(boolean var1) {
      this.IsBold = true;
      return this;
   }

   public final TextBlock Method57(String var1) {
      this.Field1195 = var1 == null ? null : new Class277(var1);
      this.Field1196 = null;
      return this;
   }

   public final void Method9(Graphics g, int var2, int var3) {
      if (this.Field1199 != 1 && this.Field1199 != 8) {
         this.Field1199 = 4;
      }

      int var4 = var2;
      var2 += Class198.Instance._tbNormal.Height / 2;
      this.Method8();
      if (this.Field1196 != null) {
         g.setColor((this.Field1197 != null ? this.Field1197.intValue() : Class6.ColorsInstanse.Field292));
         int var8 = this.VerticalPosition + var4 - (!(this._page instanceof Class36) ? Class198.Instance.HeaderHeight : Class198.Instance.Method488()) + Class198.Instance._tbNormal.Height / 2;
         int h = 0;
         if (var8 < 0) {
            h = 0 + -var8 / Class198.Instance._tbNormal.Height;
         }

         int i = h;
         TextElement tb = this.IsBold ? Class198.Instance._tbBold : Class198.Instance._tbNormal;
         var2 += Math.min(h, this.Field1196.length) * tb.Height;
         var8 = this.VerticalPosition + var4 - (!(this._page instanceof Class36) ? Class198.Instance.HeaderHeight : Class198.Instance.Method488()) + this.Height - Class198.Instance._tbNormal.Height / 2 - (!(this._page instanceof Class36) ? Class198.Instance.Field646 : Class198.Instance.Method489());
         h = this.Field1196.length;
         if (var8 > 0) {
            h += -var8 / Class198.Instance._tbNormal.Height;
         }

         //var7 = var7;
         var4 = var2;

         for(; i < h; i++) {
            var8 = this.Field1199 == 1 ? this.Field954 / 2 : (this.Field1199 == 8 ? this.Field954 : 0);
            tb.Draw(g, this.Field1196[i], this.Field956 + var3 + var8, this.VerticalPosition + var2, 16 | this.Field1199);
            var2 += tb.Height;
         }
      }

      if (this.Field958 && this.Field959) {
         g.setColor(Class6.ColorsInstanse.Field309);
         g.drawRect(this.Field956 + var3 - 2, this.VerticalPosition + var4 - 2, this.Field954 + 4, this.Height - Class198.Instance._tbNormal.Height + 4);
      }

   }

   public final void Method8() {
      if (this.Field954 > 0 && this.Field1196 == null && this.Field1195 != null) {
         this.Field1196 = Class198.Instance._tbNormal.Method91(this.Field1195, this.Field954);
         this.Height = (1 + this.Field1196.length) * Class198.Instance._tbNormal.Height;
      }

   }
}
