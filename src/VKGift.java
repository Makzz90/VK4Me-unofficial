public class VKGift extends DataJson implements Class184 {
   private int id;
   private String thumb_48;
   private String Field1156;
   private String Field1157;

   public final String GetUrl(int var1) {
      if (var1 <= 48) {
         return this.thumb_48;
      } else {
         return var1 <= 96 ? this.Field1156 : this.Field1157;
      }
   }

   public final int GetWidth(int var1) {
      if (var1 <= 48) {
         return 48;
      } else {
         return var1 <= 96 ? 96 : 256;
      }
   }

   public final int GetHeight(int var1) {
      if (var1 <= 48) {
         return 48;
      } else {
         return var1 <= 96 ? 96 : 256;
      }
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.thumb_48 = json.optGetString("thumb_48");
         this.Field1156 = json.optGetString("thumb_96");
         this.Field1157 = json.optGetString("thumb_256");
         this.id = json.optGetInt("id");
         return this;
      }
   }

   public final String toString() {
      return "gift" + this.id;
   }
}
