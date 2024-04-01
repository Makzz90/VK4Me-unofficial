public final class Class72 extends VKResponse {
   

   public Class72(long var1, int var3) {
      super(/*Field205 == null ? (Field205 = Method4("pb")) : Field205,*/ "audio.add");
      this.AddLong("owner_id", var1);
      this.AddIntiger("audio_id", var3);
   }

   
   
   private int Field1169;

   public final boolean IsSucsess() {
      return /*super.IsSucsess() &&*/ this.Field1169 != 0;
   }

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         this.Field1169 = json.optGetInt("response");
         return this;
      }
   }
}
