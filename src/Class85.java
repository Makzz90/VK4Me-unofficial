public final class Class85 extends VKUsersAndGroups
{
	public VKMessage[] items;


   public Class85(long peerId, int count, int offset)
   {
      super("messages.getHistory");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
      this.AddLong("peer_id", peerId);
      this.AddIntiger("count", count);
      this.AddIntiger("offset", offset);
   }

   public Class85(long var1, int var3)
   {
      this(var1, 1, 0);
   }

   public final Class85 SetStartMessageId(int id)
   {
      this.AddIntiger("start_message_id", id);
      return this;
   }
   
   public final DataJson ProcessFields(JSONObject json)
   {
	      super.ProcessFields(json);
	      if (json == null) {
	         return this;
	      }
	      else
	      {
	         if ((json = json.Method180("response")) != null)
	         {
	            json.optGetInt("count");
	            JSONArray var4= json.optJSONArray("items");
	            if (var4 != null)
	            {
	               this.items = new VKMessage[var4.Count()];

	               for(int i = 0; i < this.items.length; i++)
	               {
	                  JSONObject var3= var4.Method508(i);
	                  if (var3 != null) {
	                     this.items[i] = (VKMessage)(new VKMessage()).ProcessFields(var3);
	                  }
	               }
	            }
	         }

	         return this;
	      }
	   }

   public final boolean GotSomeItems() {
	      return this.items != null && this.items.length > 0;
	   }
}
