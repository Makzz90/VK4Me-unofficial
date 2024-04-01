public final class VKAudioAlbum extends DataJson {
   public Class71 Field969;

   public final boolean Method36() {
      return this.Field969 != null;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         var1.optGetInt("id");
         var1.optGetInt("owner_id");
         var1.optGetString("title");
         if ((var1 = var1.Method180("thumb")) != null) {
            this.Field969 = (Class71)(new Class71()).ProcessFields(var1);
         }

         return this;
      }
   }
}
