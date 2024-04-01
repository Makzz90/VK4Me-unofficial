import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public abstract class Class328 {
   public Page _page;
   public int Field954;
   public int Height;
   public int Field956;
   public int VerticalPosition;
   public boolean Field958;
   public boolean Field959 = true;
   public String Field960;
   boolean BottomLine;
   boolean SkipImage;
   private int Field963;
   private int Field964;
   private int Field965;

   public void Method23() {
   }

   public final Class328 Method157(boolean skipImg) {
      this.SkipImage = skipImg;
      return this;
   }

   public final Class328 TurnBottomLine(boolean value) {
      this.BottomLine = value;
      return this;
   }

   public Class328 Method159(int var1) {
      return this;
   }

   public Class328 KeyPressed(int code) throws Exception {
      if ((code == 8 || code == 1000011) && this.Field958 && this.Field959) {
         this.CommandExecuted();
      }

      return this;
   }

   public Class328 Method161(int var1, int var2) {
      return this;
   }

   public Class328 Method162(int var1, int var2, int var3) {
      this.Field958 = this.Field959 && var1 < this.Field956 + this.Field954 && var1 > this.Field956 && var2 < this.VerticalPosition + this.Height + Class198.Instance.HeaderHeight - var3 && var2 > this.VerticalPosition + Class198.Instance.HeaderHeight - var3;
      this.Field963 = var1;
      this.Field964 = var2 - var3;
      this.Field965 = 0;
      return this;
   }

   public Class328 Method163(int var1, int var2, int var3) {
      this.Field965 += (this.Field963 - var1) * (this.Field963 - var1) + (var2 - var3 - this.Field964) * (var2 - var3 - this.Field964);
      if ((double)this.Field965 > Class198.Instance.Field628) {
         this.Field958 = false;
      }

      this.Field963 = var1;
      this.Field964 = var2 - var3;
      return this;
   }

   public Class328 Method114(int var1, int var2, int var3) throws Exception {
      if (this.Field958 && this.Field959) {
         
			this.CommandExecuted();
		
      }

      this.Field958 = false;
      return this;
   }

   public abstract void Method8();

   public abstract void Method9(Graphics g, int var2, int var3);

   public static String Method164(String var0, int var1, boolean var2, Font var3) {
      if (var0 != null && var0.length() != 0) {
         StringBuffer sb = new StringBuffer();

         for(int i = 0; i < var0.length(); i++)
         {
            if (var0.charAt(i) == '\n') {
               sb.append(' ');
            } else {
               sb.append(var0.charAt(i));
            }

            if (var3.stringWidth(sb.toString().trim() + "...") > var1) {
               sb.setLength(sb.length() - 1);
               return sb.toString().trim() + "...";
            }
         }

         return sb.toString();
      } else {
         return var0;
      }
   }

   public static String Method165(String var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else {
         char[] var2;
         for(int var3 = (var2 = new char[var0.length()]).length - (var1 ? 2 : 1); var3 >= 0; var3--) {
            var2[var3] = '*';
         }

         if (var1 && var0.length() > 0) {
            var2[var2.length - 1] = var0.charAt(var2.length - 1);
         }

         return new String(var2);
      }
   }

   public void CommandExecuted() throws Exception {
   }
}
