import javax.microedition.lcdui.Graphics;

public final class PasswordBox extends TextBox2 {
   Class277 Field967;
   int Field968 = 0;

   public PasswordBox(String var1) {
      super(var1, null);
   }

   public PasswordBox() {
      super(null);
   }

   public final void Method139(String var1) {
      this.Field477 = var1 == null ? null : new Class277(var1);
      this.Field480 = null;
      this.Field967 = null;
   }

   public final void Method9(Graphics var1, int var2, int var3) {
      var2 += Class198.Instance.CharSpaceWidth;
      Class252.DrawBorder(var1, this.Field956 + var3, this.VerticalPosition + var2, this.Field954, this.Height - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth, this.Field958 && this.Field959, this._page instanceof Class36);
      if (this.Field954 > 0) {
         if (this.Field477 != null && this.Field967 == null) {
            this.Field967 = Class198.Instance._tbNormal.Method92(TextElement.Method93(this.Field477, this.Field968 > 0), this.Field954 - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth, false);
         }

         if (this.Field478 != null && this.Field479 == null) {
            this.Field479 = Class198.Instance._tbNormal.Method92(this.Field478, this.Field954 - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth, true);
         }
      }

      if (this.Field967 != null && this.Field967.Field876 > 0) {
         var1.setFont(Class198.Instance._font);
         var1.setColor(Class6.ColorsInstanse.Field292);
         Class198.Instance._tbNormal.Draw(var1, this.Field967, this.Field956 + var3 + Class198.Instance.CharSpaceWidth, this.VerticalPosition + var2 + (this.Height - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth - Class198.Instance._font.getHeight()) / 2, 20);
      } else {
         if (this.Field479 != null) {
            var1.setFont(Class198.Instance._font);
            var1.setColor(Class6.ColorsInstanse.Field294);
            Class198.Instance._tbNormal.Draw(var1, this.Field479, this.Field956 + var3 + Class198.Instance.CharSpaceWidth, this.VerticalPosition + var2 + (this.Height - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth - Class198.Instance._font.getHeight()) / 2, 20);
         }

      }
   }
}
