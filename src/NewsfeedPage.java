public final class NewsfeedPage extends Class446 implements Class11 {
   public NewsfeedPage()  {
      super(Localized.GetString("title.newsfeed"), true);
   }

   public final void LoadData()  {
      Class198.Instance.SetInLoadingState(true);
      //Class423 var2 = (new Class423()).AddCountParameter(5);
      String var1 = this.next_from == null ? null : this.next_from.toString();
      
      //var2.AddParameter("start_from", var1);
      
      
      Class224 var3 = new Class224("newsfeed.get");
      JSONObject temp = var3.GetResponse();
      //var3.ProcessFields(temp);
      //
      if (var3 != null && var3.items != null && var3.items.length > 0)
      {
         if (var3.items.length < 5 || var3.next_from == null || this.next_from != null && this.next_from.equals(var3.next_from)) {
            this.IsAllLoaded = true;
            Class198.Instance.SetInLoadingState(false);
            if (var3.next_from != null && this.next_from != null && this.next_from.equals(var3.next_from)) {
               return;
            }
         }

         this.next_from = var3.next_from;

         for(int i = 0; i < var3.items.length; i++)
         {
        	 VKNewsfeedPost post = var3.items[i];
        	 VKGroupOrUser owner = var3.GetOwnerById(post.GetOwnerId());
        	 
            ProcessPost(this, post, owner);
         }
      } else {
         this.IsAllLoaded = true;
         if (var3 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      Class198.Instance.SetInLoadingState(false);
   }

   public static void ProcessPost(Class11 page, VKNewsfeedPost post, VKGroupOrUser owner0)  {
      if (post != null)
      {
    	  VKGroupOrUser owner;
    	  if(owner0==null)
    		  owner = Class31.GetUser(post.owner_id);
    	  else
    		  owner = owner0;
         page.AddItem(LoginForm.GetHeaderElement(owner, false, true, true, true, (Page)page).SetSubtitle(Class467.GetDateForUI(post.date)));
         if (post.from_id != post.owner_id && post.from_id != 0L) {
            page.AddItem(LoginForm.GetHeaderElement(Class31.GetUser(post.from_id), true, true, false, true, (Page)page).SetSubtitle(Class467.GetDateForUI(post.date)));
         }

         //boolean var3;
         if (post.GetIsAds()) {
            TextBlock tbAds = new TextBlock(Localized.GetString("element.advertisement"));
            tbAds.IsBold = true;
            page.AddItem(tbAds);
         }

         if (post.IsTextExists()) {
            page.AddItem(new TextBlock(post.text));
         }

         if (post.attachments != null && post.attachments.length > 0) {
            for(int i = 0; i < post.attachments.length; i++) {
               VKAttachment attachment = post.attachments[i];
               if (attachment != null)
               {//TODO Attachments presenter
                  if (attachment instanceof Class184)
                  {
                     int size = Math.min(Class198.Instance._width, Class198.Instance._height) - (Class198.Instance.CharSpaceWidth << 2);
                     int var5 = ((Class184)attachment).GetWidth(size);
                     ImageElement imgElement = new ImageElement(attachment.photo!=null ? attachment.photo  : null, ((Class184)attachment).GetUrl(size), false, Math.min(size, var5), Math.min(size, var5) * ((Class184)attachment).GetHeight(size) / var5);
                     imgElement.Field1185 = 1;
                     page.AddItem(imgElement);
                  }
                  else if(attachment.photo!=null)
                  {
                	  int var4 = Math.min(Class198.Instance._width, Class198.Instance._height) - (Class198.Instance.CharSpaceWidth << 2);
                      int var5 = ((Class184)attachment.photo).GetWidth(var4);
                      ImageElement imgElement = new ImageElement(attachment.photo!=null ? attachment.photo  : null, ((Class184)attachment.photo).GetUrl(var4), false, Math.min(var4, var5), Math.min(var4, var5) * ((Class184)attachment.photo).GetHeight(var4) / var5);
                      imgElement.Field1185 = 1;
                      page.AddItem(imgElement);
                  }
                  else
                  {
                     page.AddItem(new AttachmentItemUC(attachment));
                  }
               }
            }
         }

         if (post.copy_history != null && post.copy_history.length > 0 && (post = post.copy_history[0]) != null)
         {
        	 VKAttachment a = new VKAttachment();
        	 a.type="wall";
        	 a.wall=post;
            page.AddItem(new AttachmentItemUC(a));
         }

         if (post.signer_id != 0L && post.signer_id != post.owner_id && post.signer_id != post.from_id)
         {
        	 
            page.AddItem(LoginForm.GetHeaderElement(Class31.GetUser(post.signer_id), true, true, false, true, (Page)page));
         }

         page.AddItem(new PostFooterUC((Page)page, post));
         page.AddItem(new OffsetElementUI());
      }
   }

   public final void AddItem(Class328 var1) {
      this.AddElement(var1);
   }
}
