public class VKLink extends DataJson {
   public String url;
   public String title;

   public final String toString() {
      return "link";
   }

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return null;
      } else {
         this.url = var1.optGetString("url");
         this.title = var1.optGetString("title");
         var1.optGetString("caption");
         var1.optGetString("description");
         if ((var1 = var1.Method180("photo")) != null) {
            (new VKPhoto()).ProcessFields(var1);
         }

         return this;
      }
   }
}
