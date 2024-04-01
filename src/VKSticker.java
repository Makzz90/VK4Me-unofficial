public class VKSticker extends DataJson implements Class184 {
   private int sticker_id;
   private VKImage[] _images;

   public final String GetUrl(int var1) {
      if (this._images == null) {
         return null;
      } else {
         VKImage var2;
         return (var2 = this.Method394(var1)) == null ? null : var2.url;
      }
   }

   public final int GetHeight(int var1) {
      if (this._images == null) {
         return var1;
      } else {
         VKImage var2;
         if ((var2 = this.Method394(var1)) == null) {
            return var1;
         } else {
            return var2.height > 0 ? var2.height : var1;
         }
      }
   }

   public final int GetWidth(int var1) {
      if (this._images == null) {
         return var1;
      } else {
         VKImage var2;
         if ((var2 = this.Method394(var1)) == null) {
            return var1;
         } else {
            return var2.width > 0 ? var2.width : var1;
         }
      }
   }

   private VKImage Method394(int var1) {
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;
      int var4 = -1;
      int var5 = Integer.MIN_VALUE;

      for(int i = 0; i < this._images.length; i++) {
         VKImage var7;
         if ((var7 = this._images[i]) != null) {
            if (var7.width == var1) {
               return var7;
            }

            if (var7.width > var1 && var7.width < var3) {
               var3 = var7.width;
               var2 = i;
            }

            if (var7.width > var5) {
               var5 = var7.width;
               var4 = i;
            }
         }
      }

      if (var2 != -1) {
         return this._images[var2];
      } else if (var4 != -1) {
         return this._images[var4];
      } else {
         return null;
      }
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         json.optGetInt("product_id");
         this.sticker_id = json.optGetInt("sticker_id");
         JSONArray var4;
         if ((var4 = json.optJSONArray("images")) != null) {
            this._images = new VKImage[var4.Count()];

            for(int i = 0; i < this._images.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this._images[i] = (VKImage)(new VKImage()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }

   public final String toString() {
      return this.sticker_id + "";
   }
}
