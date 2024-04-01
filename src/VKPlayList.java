public class VKPlayList extends DataJson {
   public int id;
   public long owner_id;
   public String title;
   private Class393[] Field774;
   public Class71 Field775;
   private Class505[] Field776;
   public String access_key;

   public final String toString() {
      return "audio_playlist" + this.owner_id + "_" + this.id;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optGetInt("id");
         this.owner_id = json.optLong("owner_id");
         json.optGetInt("type");
         this.title = json.optGetString("title");
         this.access_key = json.optGetString("access_key");
         JSONObject var2;
         if ((var2 = json.Method180("photo")) != null) {
            this.Field775 = (Class71)(new Class71()).ProcessFields(var2);
         }

         int i;
         JSONObject var4;
         JSONArray var5;
         if ((var5 = json.optJSONArray("main_artists")) != null) {
            this.Field776 = new Class505[var5.Count()];

            for(i = 0; i < var5.Count(); i++) {
               if ((var4 = var5.Method508(i)) != null) {
                  this.Field776[i] = (Class505)(new Class505()).ProcessFields(var4);
               }
            }
         }

         if ((var5 = json.optJSONArray("genres")) != null) {
            this.Field774 = new Class393[var5.Count()];

            for(i = 0; i < var5.Count(); i++) {
               if ((var4 = var5.Method508(i)) != null) {
                  this.Field774[i] = (Class393)(new Class393()).ProcessFields(var4);
               }
            }
         }

         return this;
      }
   }

   public final String Method58() {
      if (this.Field776 == null || this.Field776.length <= 0) {
         return null;
      } else {
         StringBuffer var1 = new StringBuffer();

         for(int i = 0; i < this.Field776.length; ++i) {
            Class505 var3;
            if ((var3 = this.Field776[i]) != null && var3.Field1355 != null) {
               var1.append(var3.Field1355);
               if (i != this.Field776.length - 1) {
                  var1.append(", ");
               }
            }
         }

         return var1.toString();
      }
   }
}
