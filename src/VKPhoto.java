public class VKPhoto extends DataJson implements Class184 {
   public int id;
   private long owner_id;
   public String text;
   public Class280 ImageSizes;

   public final VKImageWithSize Method310(int var1, boolean var2) {
      Class280 var3= this.ImageSizes;
      return this.ImageSizes != null && var3.sizes != null && var3.sizes.length > 0 ? this.ImageSizes.GetAppropriateForScaleFactor(var1, true) : null;
   }

   public final String toString() {
      return "photo" + this.owner_id + "_" + this.id;
   }

   public final String GetUrl(int size) {
      if (this.ImageSizes == null)
      {
         return null;
      }
      else
      {
         VKImageWithSize var2 = this.ImageSizes.GetAppropriateForScaleFactor(size, false);
         return var2 == null ? null : var2.url;
      }
   }

   public final int GetWidth(int var1) {
      if (this.ImageSizes == null) {
         return var1;
      } else {
         VKImageWithSize var2;
         if ((var2 = this.ImageSizes.GetAppropriateForScaleFactor(var1, false)) == null) {
            return var1;
         } else {
            return var2.width > 0 ? var2.width : var1;
         }
      }
   }

   public final int GetHeight(int var1) {
      if (this.ImageSizes == null) {
         return var1;
      } else {
         VKImageWithSize var2;
         if ((var2 = this.ImageSizes.GetAppropriateForScaleFactor(var1, false)) == null) {
            return var1;
         } else {
            return var2.height > 0 ? var2.height : var1;
         }
      }
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optGetInt("id");
         json.optGetInt("album_id");
         this.owner_id = json.optLong("owner_id");
         json.optLong("user_id");
         json.optGetInt("date");
         this.text = json.optGetString("text");
         json.optGetString("access_key");
         this.ImageSizes = (Class280)(new Class280()).ProcessFields(json);
         return this;
      }
   }
}
