public class Class224 extends VKUsersAndGroups {
	public Class224(String method) {
		super(method);
		this.AddIntiger("extended", 1);
		this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
		this.AddIntiger("return_banned", 0);
		this.AddIntiger("max_photos", 4);
		this.AddIntiger("count", 20);
		this.AddParameter("filters", "post");
	}

	public VKNewsfeedPost[] items;
	public String next_from;

	public final DataJson ProcessFields(JSONObject json) {
		super.ProcessFields(json);
		if (json == null) {
			return this;
		} else {
			if ((json = json.Method180("response")) != null) {
				this.next_from = json.optGetString("next_from");
				JSONArray var4 = json.optJSONArray("items");
				if (var4 != null) {
					this.items = new VKNewsfeedPost[var4.Count()];

					for (int i = 0; i < this.items.length; i++) {
						JSONObject var3 = var4.Method508(i);
						if (var3 != null) {
							// this.items[i] = (VKNewsfeedPost)(new
							// VKNewsfeedPost()).ProcessFields(var3);
							this.items[i] = new VKNewsfeedPost();
							this.items[i].ProcessFields(var3);
						}
					}
				}
			}

			return this;
		}
	}
}
