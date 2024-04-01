public final class Class44 extends DataJson {
   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         JSONObject var2;
         if ((var2 = var1.Method180("photo")) != null) {
            (new Class280()).ProcessFields(var2);
         }

         if ((var2 = var1.Method180("graffiti")) != null) {
            (new VKGraffiti()).ProcessFields(var2);
         }

         return this;
      }
   }
}
