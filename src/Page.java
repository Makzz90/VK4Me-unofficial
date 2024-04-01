import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;


public class Page {
   public Page Field807;
   private Class336 Field808;
   public Hashtable Field809;
   private Vector _elements;
   public int ScrollableHeight;//либо это высота всех элементов
   public int VerticalScroll;
   public int Field813;
   public int Field814;
   private float Field815;
   private float Field816;
   private int Field817;
   protected boolean IsLoaded;//private
   public Class277 Field819;
   public Class277 Field820;
   public int Field821;
   public int Width;
   public int Height;
   public int Field824;
   public Class36 Field825;
   public String Title;

   public final Page Method360(String title)
   {
      if (this.Title == null && title != null || this.Title != null && title == null) {
         this.Field820 = null;
      }

      this.Title = title;
      return this;
   }

   public final Page Method361(Page page)
   {
      this.Field807 = page;
      if (page != null || Settings.Instance.GuiUseDrawer && Settings.Instance.GuiTouchHud && LoginForm.HomePage != null)
      {
         this.Field808 = new Class145(this, Localized.GetString("action.back"), true, page);
      }
      else
      {
         this.Field808 = null;
      }

      if (Class198.Instance.Field627 != null && Class198.Instance.Field627.equals(this)) {
         Class198.Instance.Method497(this.Field808);
      }

      return this;
   }

   public final void Method22() {
      Class198.Instance.NavigateBack(this.Field807);
   }

   public final void Method118() {
      Class198.Instance.Method497(this.Field808);
   }

   public final void Method119() {
      if (Class198.Instance.Field627 != null && Class198.Instance.Field627.hashCode() == this.hashCode()) {
         Class198.Instance.Repaint();
      }

   }

   public void Method362(Class328 var1) {
   }

   public Page(String title) {
      this.Field809 = new Hashtable();
      this._elements = new Vector(10, 20);
      this.Method287(title);
   }

   public Page ShowOutOfMemoryError() {
      this.Clear();
      Class198.Instance.ShowError(Localized.GetString("general.outOfMemory"));
      Class198.Instance.SetInLoadingState(false);
      return this;
   }

   public int GetWidth() {
      return Class198.Instance._width;
   }

   public final void Method364(int width, int var2) {
      this.Method83(width, -1, var2);
   }

   public final void Method365(int var1, int var2) {
      this.Method83(var1, var2, -1);
   }

   public final void Method366(int var1, int var2) {
      this.Method83(var1, var2, -1);
   }

   private void Method83(int width, int var2, int var3)
   {
      synchronized(this)
      {
         int var5 = Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
         int totalHeight = 0;
         int var7 = width - (Class198.Instance.CharSpaceWidth << 2);

         for(int i = 0; i < this._elements.size(); i++)
         {
            Class328 item= (Class328)this._elements.elementAt(i);
            if (item != null)
            {
               item._page = this;
               if (item instanceof Class187)
               {
                  item.Field954 = width;
                  item.Field956 = 0;
               }
               else
               {
                  item.Field954 = var7;
                  item.Field956 = var5;
               }

               item.VerticalPosition = totalHeight;
               if (i > this._elements.size() - var3 - 1 || i < var2)
               {
                  item.Method8();
               }

               totalHeight += item.Height + (item.BottomLine ? 1 : 0);
            }
         }

         if (var2 != -1 && this.Field814 >= var2)
         {
            this.VerticalScroll += totalHeight - this.ScrollableHeight;
            this.Field813 += totalHeight - this.ScrollableHeight;
         }

         this.ScrollableHeight = totalHeight;
      }
   }

   public void Method292(Graphics g, int var2) {
      this.Method61(g, var2, Class198.Instance.HeaderHeight, Class198.Instance.getWidth(), Class198.Instance.imgH, Class198.Instance.getHeight(), true);
   }

   public final void Method9(Graphics g, int var2, int var3) {
      this.Method61(g, var3, Class198.Instance.HeaderHeight, Class198.Instance.getWidth(), var2, Class198.Instance.getHeight(), true);
   }

   public void Method61(Graphics g, int x, int y, int width, int height, int var6, boolean var7)
   {
      synchronized(this)
      {
         this.Field824 = height;
         Class198.Instance.Field646 = this.Field824;
         int clipX = g.getClipX();
         int clipY = g.getClipY();
         int clipWidth = g.getClipWidth();
         int clipHeight = g.getClipHeight();
         g.setClip(x, y, width, height);
         
         if (var7)
         {
            g.setColor(Class6.ColorsInstanse.Field291);//Background
            g.fillRect(x, y, width, height);
         }

         var7 = false;
         if (this.Field815 != 0.0F)
         {
            this.Field815 *= Class198.Instance.Field635 ? 0.5F : 0.96F;
            if (!(this.Field815 > 1.0F) && !(this.Field815 < -1.0F)) {
               this.Field815 = 0.0F;
            } else {
               this.Field813 += (int)this.Field815;
               this.Method0();
               this.VerticalScroll = this.Field813;
            }

            var7 = true;
         }

         this.Method0();
         if (this.Field813 != this.VerticalScroll)
         {
            if (!Settings.Instance.GuiSmoothScroll)
            {
               this.VerticalScroll = this.Field813;
            } else if (Math.abs(this.Field813 - this.VerticalScroll) < 4) {
               this.VerticalScroll += this.Field813 > this.VerticalScroll ? 1 : -1;
            } else {
               this.VerticalScroll += (this.Field813 - this.VerticalScroll) / 4;
            }

            if (this.Field813 != this.VerticalScroll) {
               var7 = true;
            }
         }

         int var13 = Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
         int pos = 0;
         y -= this.VerticalScroll;
         int var15 = width - (Class198.Instance.CharSpaceWidth << 2);

         int i;
         for(i = 0; i < this._elements.size(); i++)
         {
            Class328 element= (Class328)this._elements.elementAt(i);
            if (element != null)
            {
               element._page = this;
               if (Class198.Instance.Field638) {
                  element.Field958 = i == this.Field814;
               }

               if (element instanceof Class187) {
                  element.Field954 = width;
                  element.Field956 = 0;
               } else {
                  element.Field954 = var15;
                  element.Field956 = var13;
               }

               element.VerticalPosition = pos;
               if (element.VerticalPosition + element.Height - this.VerticalScroll >= 0) {
                  if (element.VerticalPosition - this.VerticalScroll < height) {
                     this.Method362(element);
                     element.Method9(g, y, x);
                     if (element.BottomLine)
                     {
                    	 //g.setColor(0, 0, 255);
                    	 g.setColor(Class6.ColorsInstanse.Field326);
                        g.drawLine(x, pos + y + element.Height, width + x, pos + y + element.Height);
                     }
                  } else if (element.VerticalPosition - this.VerticalScroll <= var6) {
                     element.Method8();
                  }
               }

               pos += element.Height + (element.BottomLine ? 1 : 0);
            }
         }

         this.IsLoaded = this.Height != height && this.Width != width || this.ScrollableHeight < pos && this.ScrollableHeight <= this.Field824 || this.ScrollableHeight > pos && pos <= this.Field824;
         this.Width = width;
         this.Height = height;
         this.ScrollableHeight = pos;
         if (this.ScrollableHeight > this.Field824 && this.Field813 + this.Field824 > this.ScrollableHeight)
         {
            this.Field813 = this.ScrollableHeight - this.Field824;
         }
         else if (this.Field813 < 0)
         {
            this.Field813 = 0;
         }

         if (this.Field813 != this.VerticalScroll)
         {
            var7 = true;
         }

         g.setClip(clipX, clipY, clipWidth, clipHeight);
         if (!this.IsLoaded)
         {
            if (!this.IsLoaded && var7) {
               Class198.Instance.Repaint();
            }

         } else {
            for(i = 0; i < this._elements.size(); i++)
            {
               ((Class328)this._elements.elementAt(i)).Method23();
            }

            Class198.Instance.Repaint();
         }
      }
   }

   public void Method8() {
   }

   public void Method62(int var1, int var2)
   {
      for(int i = 0; i < this._elements.size(); i++)
      {
         Class328 var4= (Class328)this._elements.elementAt(i);
         if (var4 != null)
         {
            boolean var5 = var4.Field958;
            var4.Method162(var1, var2, this.Field813);
            if (!var5 && var4.Field958)
            {
               this.Field814 = i;
            }
         }
      }

   }

   public void Method63(int var1, int var2) throws Exception
   {
      for(int i = 0; i < this._elements.size(); i++)
      {
         Class328 var4= (Class328)this._elements.elementAt(i);
         if (var4 != null) {
            var4.Method114(var1, var2, this.Field813);
         }
      }

      this.Field815 += this.Field816;
      this.Field816 = 0.0F;
   }

   public void Method64(int var1, int var2) {
      boolean var3 = false;

      int i;
      for(i = 0; i < this._elements.size(); i++) {
         Class328 var5= (Class328)this._elements.elementAt(i);
         if (var5 != null) {
            var5.Method163(var1, var2, this.Field813);
            //Class288 var6;
            if (var5 instanceof Class288 && ((Class288)var5).Field958) {
               var3 = true;
            }
         }
      }

      if (!var3)
      {
         i = Class198.Instance.Field634 - Class198.Instance.Field632;
         this.Field813 += i;
         this.Field816 = (float)i;
         this.Method0();
         this.VerticalScroll = this.Field813;
         this.Method8();
      }
   }

   private boolean Method11(int var1) {
      Class328 var2;
      int var3;
      switch(var1) {
      case 1:
         if (this._elements.size() > 1) {
            Class198.Instance.Method470();
            if ((var2 = this.Method367()) != null && var2.Height + (Class198.Instance.CharSpaceWidth << 1) > this.Field824 && this.Field817 != 0) {
               var3 = var2.VerticalPosition - Class198.Instance.CharSpaceWidth;
               this.Field813 -= this.Field824 / 5;
               if (this.Field813 <= var3) {
                  this.Field817 = 0;
                  this.Field813 = var3;
               } else {
                  this.Field817 -= this.Field824 / 5;
               }
            } else {
               --this.Field814;
               this.Method21();
               this.Method370();
               this.Method23();
               this.Method21();
               this.Method69();
               this.Method370();
               this.Method8();
            }

            return true;
         }
         break;
      case 6:
         if (this._elements.size() > 1) {
            Class198.Instance.Method470();
            if ((var2 = this.Method367()) != null && var2.Height + (Class198.Instance.CharSpaceWidth << 1) > this.Field824 && this.Field817 != var2.Height) {
               var3 = var2.VerticalPosition + var2.Height - this.Field824 + Class198.Instance.CharSpaceWidth;
               this.Field813 += this.Field824 / 5;
               if (this.Field813 >= var3) {
                  this.Field817 = var2.Height;
                  this.Field813 = var3;
               } else {
                  this.Field817 += this.Field824 / 5;
               }
            } else {
               this.Field814++;
               this.Method21();
               this.Method69();
               this.Method20();
               this.Method21();
               this.Method370();
               this.Method69();
               this.Method8();
            }

            return true;
         }
         break;
      case 50:
         if (this._elements.size() > 1) {
            this.Method305(true);
            return true;
         }
         break;
      case 56:
         if (this._elements.size() > 1) {
            this.Method305(false);
            return true;
         }
      }

      return false;
   }

   public void Method67(int var1) {
      boolean var10000;
      switch(var1) {
      case 1:
      case 6:
      case 50:
      case 56:
         var10000 = this.Method11(var1);
         break;
      default:
         var10000 = false;
      }

      if (!var10000) {
         Class328 var2= this.Method367();
         if (var2 != null) {
            var2.Method159(var1);
         }

      }
   }

   public void ButtonPressed(int var1) throws Exception {
      Class328 var2= this.Method367();
      if (var2 != null) {
         var2.KeyPressed(var1);
      }

   }

   public void Method65(int key) {
      if (!this.Method11(key)) {
         Class328 var2= this.Method367();
         if (var2 != null) {
            var2.Method161(key, this.Field813);
         }

      }
   }

   private void Method305(boolean var1) {
      Class198.Instance.Method470();
      this.Field813 += (this.Field824 - Class198.Instance._font.getHeight()) * (var1 ? -1 : 1);
      this.Method0();
      Page var7 = this;
      Class328 var2;
      if ((var2 = this.Method367()) != null) {
         int var8 = var2.VerticalPosition + var2.Height / 2;
         byte var3 = 1;
         if (this.Field813 < var8) {
            var3 = -1;
         }

         var8 = Integer.MAX_VALUE;
         int var4 = -1;

         for(int var5 = this.Field814; var5 >= 0 && var5 < var7._elements.size(); var5 += var3) {
            Class328 var6;
            if (!(var6 = (Class328)var7._elements.elementAt(var5)).SkipImage) {
               if (var6.VerticalPosition < var7.Field813 + var7.Field824 / 2 && var6.VerticalPosition + var6.Height - var7.Field813 > var7.Field813 + var7.Field824 / 2) {
                  var7.Field814 = var5;
                  break;
               }

               int var9;
               if ((var9 = Math.abs(var7.Field813 + var7.Field824 / 2 - (var6.VerticalPosition + var6.Height / 2)) - var6.Height / 2) >= var8) {
                  var7.Field814 = var5 - var3;
                  break;
               }

               var8 = var9;
               var4 = var5;
            }
         }

         if (var4 != -1) {
            var7.Field814 = var4;
         }
      }

      this.Method8();
   }

   public final Class328 Method367() {
      return this.Field814 >= 0 && this.Field814 < this._elements.size() ? (Class328)this._elements.elementAt(this.Field814) : null;
   }

   public final TextBox2 Method368() {
      Class328 var1;
      return (var1 = this.Method367()) != null && var1 instanceof TextBox2 ? (TextBox2)var1 : null;
   }

   final boolean Method117() {
      return this.Method368() != null;
   }

   public final void Method287(String title) {
      this.Field819 = title == null ? null : new Class277(title);
      this.Field820 = null;
      if (Class198.Instance.Field627 != null && Class198.Instance.Field627.equals(this)) {
         Class198.Instance.setTitle(title == null ? "VK" : title);//VK4ME
      }

   }

   public String Method29() {
      return this.Field825 == null ? null : this.Field825.Field819.toString();
   }

   public void Method7() {
      if (Class198.Instance.Method492()) {
         Class198.Instance.Method487();
      } else {
         if (this.Field825 != null) {
            Class198.Instance.Method482(this.Field825);
         }

      }
   }

   public final void Method369(int var1) {
      this.Field814 = var1;
      this.Method21();
      if (this.Method367() != null) {
         this.Method370();
         this.Method69();
         this.Method23();
         this.Method21();
         Class198.Instance.Repaint();
      }
   }

   private void Method0() {
      if (this.Field824 < this.ScrollableHeight) {
         if (this.Field813 < 0) {
            this.Field813 = 0;
         }

         int var1 = this.ScrollableHeight - this.Field824;
         if (this.Field813 > var1) {
            this.Field813 = var1;
         }

      } else {
         this.Field813 = 0;
      }
   }

   private void Method20() {
      int var1 = this.Field814 - 1;
      boolean var2 = false;

      while(this.Field814 != var1) {
         Class328 var3= this.Method367();
         if (var3 != null && !var3.SkipImage) {
            return;
         }

         this.Field814++;
         if (this.Field814 >= this._elements.size())
         {
            this.Field814 = 0;
            if (var2)
            {
               break;
            }

            var2 = true;
         }
      }

   }

   private void Method23() {
      int var1 = this.Field814 + 1;
      boolean var2 = false;

      while(this.Field814 != var1) {
         Class328 var3;
         if ((var3 = this.Method367()) != null && !var3.SkipImage) {
            return;
         }

         --this.Field814;
         if (this.Field814 < 0) {
            this.Field814 = this._elements.isEmpty() ? 0 : this.Count() - 1;
            if (var2) {
               break;
            }

            var2 = true;
         }
      }

   }

   private void Method21() {
      if (this.Field814 > this._elements.size() - 1) {
         this.Field814 = !(this instanceof Class446) && !(this instanceof Class118) ? 0 : this._elements.size() - 1;
         this.Method20();
      }

      if (this.Field814 < 0) {
         this.Field814 = !(this instanceof Class446) && !(this instanceof Class118) && !this._elements.isEmpty() ? this._elements.size() - 1 : 0;
         this.Method23();
      }

   }

   private void Method69() {
      Class328 var1;
      if ((var1 = this.Method367()) != null) {
         if (var1.Height + (Class198.Instance.CharSpaceWidth << 1) <= this.Field824) {
            if (var1.VerticalPosition - this.Field813 + var1.Height + Class198.Instance.CharSpaceWidth >= this.Field824) {
               this.Field813 = var1.VerticalPosition + var1.Height - this.Field824 + Class198.Instance.CharSpaceWidth;
               this.Field817 = var1.Height;
            }
         } else if (var1.VerticalPosition + var1.Height - this.Field813 >= this.Field824) {
            this.Field813 = var1.VerticalPosition - Class198.Instance.CharSpaceWidth;
            this.Field817 = this.Field824 - Class198.Instance.CharSpaceWidth;
         }

         Class198.Instance.Repaint();
      }
   }

   private void Method370() {
      Class328 var1= this.Method367();
      if (var1 != null) {
         if (var1.Height + (Class198.Instance.CharSpaceWidth << 1) <= this.Field824) {
            if (var1.VerticalPosition - this.Field813 - Class198.Instance.CharSpaceWidth <= 0) {
               this.Field813 = var1.VerticalPosition - Class198.Instance.CharSpaceWidth;
               this.Field817 = 0;
            }
         } else if (var1.VerticalPosition + var1.Height - this.Field824 - this.Field813 <= 0) {
            this.Field813 = var1.VerticalPosition + var1.Height - this.Field824 + Class198.Instance.CharSpaceWidth;
            this.Field817 = var1.Height - this.Field824 + Class198.Instance.CharSpaceWidth;
         }

         Class198.Instance.Repaint();
      }
   }

   public Page RemoveElementAtPosition(int index) {
      if (index >= 0 && index < this.Count()) {
         this._elements.removeElementAt(index);
         return this;
      } else {
         return this;
      }
   }

   public Page Method293(Class328 element, int index) {
      if (element == null) {
         return this;
      } else {
         element._page = this;
         if (element instanceof Class463) {
            Class198.Instance.Method495((Class463)element);
         }

         this._elements.insertElementAt(element, index);
         return this;
      }
   }

   public Page Method294(Class328 var1) {
      return this.RemoveElementAtPosition(this.GetElementIndex(var1));
   }

   public final int GetElementIndex(Class328 element) {
      return this._elements.indexOf(element);
   }

   public final boolean Method372(Class328 var1) {
      return this.GetElementIndex(var1) != -1;
   }

   public Page AddElement(Class328 element) {
      if (element == null) {
         return this;
      } else {
         element._page = this;
         if (element instanceof Class463) {
            Class198.Instance.Method495((Class463)element);
         }

         this._elements.addElement(element);
         return this;
      }
   }

   public final Class328 ElementAt(int index) {
      return (Class328)this._elements.elementAt(index);
   }

   public int Count() {
      return this._elements.size();
   }

   public final boolean IsEmpty() {
      return this._elements.isEmpty();
   }

   public Page Clear() {
      this._elements.removeAllElements();
      System.gc();
      return this;
   }

   public Page() {
   }

   public static String Method374(String var0) {
      if (var0 == null) {
         return null;
      } else {
         StringBuffer sb = new StringBuffer();
         char[] var4 = var0.toCharArray();

         for(int i = 0; i < var4.length; i++) {
            char ch = var4[i];
            if ('A' <= ch && ch <= 'Z') {
               sb.append((char)ch);
            } else if ('a' <= ch && ch <= 'z') {
               sb.append((char)ch);
            } else if ('0' <= ch && ch <= '9') {
               sb.append((char)ch);
            } else if (ch == ' ') {
               sb.append("%20");
            } else if (ch != '-' && ch != '_' && ch != '.' && ch != '!' && ch != '~' && ch != '*' && ch != '\'' && ch != '(' && ch != ')') {
               if (ch <= 127) {
                  sb.append(IntToHex(ch));
               } else if (ch <= 2047) {
                  sb.append(IntToHex(192 | ch >> 6));
                  sb.append(IntToHex(128 | ch & 63));
               } else {
                  sb.append(IntToHex(224 | ch >> 12));
                  sb.append(IntToHex(128 | ch >> 6 & 63));
                  sb.append(IntToHex(128 | ch & 63));
               }
            } else {
               sb.append((char)ch);
            }
         }

         return sb.toString();
      }
   }

   private static String IntToHex(int var0) {//TODO дубликат
      String var1 = Integer.toHexString(var0);
      return "%" + (var1.length() < 2 ? "0" : "") + var1;
   }
}
