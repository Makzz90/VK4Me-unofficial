import java.util.Vector;

public final class Class289 extends VKUsersAndGroups {
   private Vector Field906 = new Vector();
   private VKMessage[] Field1285;

   public Class289() {
      super("messages.getById");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   public final Class289 Method387(int var1) {
      if (var1 < 0) {
         var1 = -var1;
      }

      if (this.Field906.indexOf(new Integer(var1)) != -1) {
         return this;
      } else {
         this.Field906.addElement(new Integer(var1));
         if (this.Field906 != null && this.Field906.size() > 0) {
            this.AddParameter("message_ids", Method432(",", this.Field906));
         } else {
            this.AddParameter("message_ids", null);
         }

         return this;
      }
   }
   
   public final VKMessage Method194() {
	      return this.Field1285 != null && this.Field1285.length > 0 ? this.Field1285[0] : null;
	   }

	   public final boolean Method36() {
	      return this.Method194() != null;
	   }

	   public final DataJson ProcessFields(JSONObject json) {
	      super.ProcessFields(json);
	      if (json == null) {
	         return this;
	      } else {
	         if ((json = json.Method180("response")) != null) {
	            json.optGetInt("count");
	            JSONArray var4;
	            if ((var4 = json.optJSONArray("items")) != null) {
	               this.Field1285 = new VKMessage[var4.Count()];

	               for(int i = 0; i < this.Field1285.length; i++) {
	                  JSONObject var3;
	                  if ((var3 = var4.Method508(i)) != null) {
	                     this.Field1285[i] = (VKMessage)(new VKMessage()).ProcessFields(var3);
	                  }
	               }
	            }
	         }

	         return this;
	      }
	   }

}
