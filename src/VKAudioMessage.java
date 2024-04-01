public class VKAudioMessage extends DataJson {
   private int id;
   private long owner_id;
   public int duration;
   public int[] waveform;
   public String url;
   private int Field715 = Integer.MAX_VALUE;
   private int Field716 = Integer.MIN_VALUE;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optGetInt("id");
         this.owner_id = json.optLong("owner_id");
         this.duration = json.optGetInt("duration");
//         jObject.optGetString("link_ogg");
         this.url = json.optGetString("link_mp3");
         JSONArray jArray = json.optJSONArray("waveform");
         if (jArray != null) {
            this.waveform = new int[jArray.Count()];

            for(int i = 0; i < this.waveform.length; i++) {
               this.waveform[i] = jArray.Method506(i, 0);
               this.Field715 = Math.min(this.Field715, this.waveform[i]);
               this.Field716 = Math.max(this.Field716, this.waveform[i]);
            }
         }

         return this;
      }
   }

   public final String toString() {
      return "audio_message" + this.owner_id + "_" + this.id;
   }
}
