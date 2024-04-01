public final class Class483 extends VKUsersAndGroups {
   

	//
	public VKConversationWithLastMessage[] Items;
//	   public int UnreadCount;
	   //
	
   public Class483() {
      super("messages.getConversations");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   public final Class483 SetCount(int count) {
      this.AddIntiger("count", count);
      return this;
   }

   
   public final boolean GotSomeItems()
   {
	      return this.Items != null && this.Items.length > 0;
	   }
   
   public final DataJson ProcessFields(JSONObject json) {
	      super.ProcessFields(json);
	      if (json == null)
	      {
	         return this;
	      }
	      else
	      {
	    	  json = json.Method180("response");
	         if (json != null)
	         {
	            json.optGetInt("count");
	            JSONArray var2= json.optJSONArray("items");
	            if (var2 != null)
	            {
	               this.Items = new VKConversationWithLastMessage[var2.Count()];

	               for(int i = 0; i < this.Items.length; i++)
	               {
	                  JSONObject var4= var2.Method508(i);
	                  if (var4 != null)
	                  {
	                     this.Items[i] = (VKConversationWithLastMessage)(new VKConversationWithLastMessage()).ProcessFields(var4);
	                  }
	               }
	            }

//	            this.UnreadCount = json.optGetInt("unread_count");
	         }

	         return this;
	      }
   }
}
