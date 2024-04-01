import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class TextBox2 extends Class328 implements Class466 {
   public Class277 Field477;
   public Class277 Field478;
   public Class277 Field479;
   public Class277 Field480;
   public static int Field481;
   public static Image Field482;
   public static Image Field483;

   public final void Method287(String var1) {
      this.Field478 = var1 == null ? null : new Class277(var1);
      this.Field479 = null;
   }

   public void Method288(Class277 var1) {
      this.Field477 = var1;
      this.Field480 = null;
   }

   public void Method139(String var1) {
      this.Field477 = var1 == null ? null : new Class277(var1);
      this.Field480 = null;
   }

   public TextBox2(String var1, String var2) {
      this.Field960 = Localized.GetString("general.holdField");
      this.Method287(var1);
      this.Method139(var2);
      this.Height = Class198.Instance._font.getHeight() + (Class198.Instance.CharSpaceWidth << 2);
   }

   public TextBox2(String lable) {
      this(lable, null);
   }

   public TextBox2() {
      this(null);
   }

   public final void CommandExecuted() {
      Class198.Instance.Method471(this);
   }

   public void Method9(Graphics g, int var2, int var3) {
      var2 += Class198.Instance.CharSpaceWidth;
      Class252.DrawBorder(g, this.Field956 + var3, this.VerticalPosition + var2, this.Field954, this.Height - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth, this.Field958 && this.Field959, this._page instanceof Class36);
      if (this.Field954 > 0) {
         if (this.Field477 != null && this.Field480 == null) {
            this.Field480 = Class198.Instance._tbNormal.Method92(this.Field477, this.Field954 - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth, true);
         }

         if (this.Field478 != null && this.Field479 == null) {
            this.Field479 = Class198.Instance._tbNormal.Method92(this.Field478, this.Field954 - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth, true);
         }
      }

      if (this.Field480 != null && this.Field480.Field876 > 0) {
         g.setFont(Class198.Instance._font);
         g.setColor(Class6.ColorsInstanse.Field292);
         Class198.Instance._tbNormal.Draw(g, this.Field480, this.Field956 + var3 + Class198.Instance.CharSpaceWidth, this.VerticalPosition + var2 + (this.Height - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth - Class198.Instance._font.getHeight()) / 2, 20);
      } else {
         if (this.Field479 != null) {
            g.setFont(Class198.Instance._font);
            g.setColor(Class6.ColorsInstanse.Field294);
            Class198.Instance._tbNormal.Draw(g, this.Field479, this.Field956 + var3 + Class198.Instance.CharSpaceWidth, this.VerticalPosition + var2 + (this.Height - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth - Class198.Instance._font.getHeight()) / 2, 20);
         }

      }
   }

   public final String GetContent() {
      return this.Field477 == null ? null : this.Field477.toString();
   }

   public void Method8() {
   }
}
