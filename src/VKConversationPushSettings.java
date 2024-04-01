public final class VKConversationPushSettings extends DataJson {
   public boolean Field525;

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         var1.optGetInt("disabled_until");
         var1.optGetBoolean("disabled_forever");
         this.Field525 = var1.optGetBoolean("no_sound");
         return this;
      }
   }
}
