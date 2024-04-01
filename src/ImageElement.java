import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public final class ImageElement extends Class328 implements Class463 {
   private Image _img;
   private int width;
   private int height;
   private boolean Field1182;
   private String _url;
   public boolean Field1184;
   public byte Field1185 = 4;
   private int Field1186;
   private VKPhoto _photo;

   public final int Method5() {
      return this.Field1186;
   }

   public final void Method6()
   {
      if (this.Field1186 <= 5)
      {
         this.Field1186++;
      }
   }

   public ImageElement(VKPhoto photo, String url, boolean var3, int width, int height) {
      this.Field960 = Localized.GetString("action.reveal");
      this._photo = photo;
      this.width = width;
      this.height = height;
      this.Field1182 = var3;
      this._url = Settings.Instance.DoNotLoadImages ? null : url;
      super.SkipImage = Settings.Instance.DoNotLoadImages;
      Class198.Instance.Method495(this);
   }

   public final void CommandExecuted() {
      if (this._photo != null) {
         Class198.Instance.NavigateForward(Class75.Field206.Method60(this._photo, null, this).Method361(this._page));
      }

   }

   public final void Method8() {
      if (this._url == null) {
         this.Height = 0;
      } else {
         if (this._img != null) {
            this.height = Math.min(this.height, this._img.getHeight());
            this.width = Math.min(this.width, this._img.getWidth());
         }

         this.Height = this.height + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      }
   }

   public final void Method9(Graphics g, int var2, int var3) {
      this.Method8();
      if (this._url != null) {
         var2 += Class198.Instance.CharSpaceWidth;
         int var4 = this.Field1185 == 4 ? 0 : (this.Field1185 == 8 ? this.Field954 - this.width : (this.Field954 - this.width) / 2);
         if (this._img != null) {
            g.drawRegion(this._img, (this._img.getWidth() - this.width) / 2, (this._img.getHeight() - this.height) / 2, this.width, this.height, 0, this.Field956 + var3 + var4, this.VerticalPosition + var2, 20);
         } else {
            Class198.Instance.Method495(this);
            g.setColor(Class6.ColorsInstanse.Field328);
            g.fillRect(this.Field956 + var3 + var4, this.VerticalPosition + var2, this.width, this.height);
         }

         if (!this.Field1184 && MessageItemUC.Field1264 != null) {
            g.drawImage(MessageItemUC.Field1264, this.Field956 + var3 + var4, this.VerticalPosition + var2, 20);
            g.drawRegion(MessageItemUC.Field1264, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 5, this.Field956 + var3 + var4 + this.width - MessageItemUC.Field1270, this.VerticalPosition + var2, 0);
            g.drawRegion(MessageItemUC.Field1264, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 3, this.Field956 + var3 + var4 + this.width - MessageItemUC.Field1270, this.VerticalPosition + var2 + this.height - MessageItemUC.Field1270, 0);
            g.drawRegion(MessageItemUC.Field1264, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 6, this.Field956 + var3 + var4, this.VerticalPosition + var2 + this.height - MessageItemUC.Field1270, 0);
         }

         if (this.Field958 && this.Field959) {
            g.setColor(Class6.ColorsInstanse.Field309);
            g.drawRect(this.Field956 + var3 + var4, this.VerticalPosition + var2, this.width, this.height);
         }

      }
   }

   public final int Count() {
      return 1;
   }

   public final boolean Method11(int var1)
   {
      return this.Field1182;
   }

   public final String GetUrl(int index)
   {
      return this._img == null ? this._url : null;
   }

   public final void SetImage(int index, Image img) {
      if (img != null) {
         this._img = Class252.Method329(img, Math.min(this.height, this.width * img.getHeight() / Math.max(1, img.getWidth())));
         this.height = this._img.getHeight();
         this.width = this._img.getWidth();
      }
   }

   public final void Error(Throwable th)
   {
	   //todo Out of memory
	   String temp = "Image item: ";
	   if(th != null)
	   {
		   if(th instanceof OutOfMemoryError)
			   temp+="OutOfMemoryError";
		   else
			   temp+=th.getMessage();
	   }
	   else
	   {
		   temp+="Unknown error";
	   }
      Class198.Instance.ShowError(temp);
   }
}
