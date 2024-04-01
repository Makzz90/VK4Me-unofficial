import javax.microedition.lcdui.Graphics;

public final class PostFooterUC extends Class328 implements Class187, Class466 {
   VKNewsfeedPost _post;
   private boolean _isLiked;
   boolean _isReposted;
   private int Field1130 = 0;
   String _likesCount;
   String _repostsCount;
   private String _views;
   private String _commentsCount;
   private static int[] Field1135 = new int[9];

   public PostFooterUC(Page page, VKNewsfeedPost post) {
      this._page = page;
      this._post = post;
      this.Height = Class198.Instance._font.getHeight() << 1;
      if (this._post != null)
      {
         this._isLiked = this._post.likes == null ? false : this._post.likes.user_likes;
         this._likesCount = Class467.Method12(this._post.likes == null ? 0 : this._post.likes.count);
         this._isReposted = this._post.reposts == null ? false : this._post.reposts.user_reposted;
         this._views = Class467.Method12(this._post.views);
         this._repostsCount = Class467.Method12(this._post.reposts == null ? 0 : this._post.reposts.count);
         this._commentsCount = Class467.Method12(this._post.comments == null ? 0 : this._post.comments.count);
      }

   }

   public final Class328 Method159(int var1) {
      if (this.Field1130 == -1) {
         this.Field1130 = 0;
      } else if (this.Field1130 == -2) {
         return this;
      }

      switch(var1) {
      case 2:
         if (this.Field1130 > 0) {
            --this.Field1130;
         }
         break;
      case 5:
         if (this.Field1130 <= 1) {
            ++this.Field1130;
         }
      }

      return this;
   }

   public final Class328 Method161(int var1, int var2) {
      this.Method159(var1);
      return this;
   }

   public final Class328 Method162(int var1, int var2, int var3) {
      if (this.Field1130 == -2) {
         return this;
      } else {
         this.Field1130 = -1;
         super.Method162(var1, var2, var3);
         if (this.Field958) {
            var2 = this.Field956;
            var3 = this.Field956;
            var2 = var2 + Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight() + (this._likesCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._likesCount);
            if (var1 > var3 && var1 < var2) {
               this.Field1130 = 0;
            }

            var3 = var2;
            var2 = var2 + Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight() + (this._commentsCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._commentsCount);
            if (var1 > var3 && var1 < var2) {
               this.Field1130 = 1;
            }

            var3 = var2;
            var2 = var2 + Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight() + (this._repostsCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._repostsCount);
            if (var1 > var3 && var1 < var2) {
               this.Field1130 = 2;
            }
         }

         return this;
      }
   }

   public final void CommandExecuted() {
      try {
		this.Method305(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   public final Class328 KeyPressed(int code) throws Exception {
      if ((code == 8 || code == 1000011) && this.Field958 && this.Field959) {
         this.Method305(false);
      }

      return this;
   }

   private void Method305(boolean action) throws Exception {
      switch(this.Field1130) {
      case 0:
         if (this._isLiked) {
            this._isLiked = false;
            Class196 var3 = (Class196)(new Class133(this._post)).DoDispatch();
            this._isLiked = var3 == null || var3.likes == -1;
            if (var3 != null) {
               this._likesCount = Class467.Method12(var3.likes);
            }
         } else {
            this._isLiked = true;
            Class60 var4 = (Class60)(new Class104(this._post)).DoDispatch();
            this._isLiked = var4 != null && var4.likes != -1;
            if (var4 != null) {
               this._likesCount = Class467.Method12(var4.likes);
            }
         }
         break;
      case 1:
         if (!(Class198.Instance.Field627 instanceof Class240)) {
            LoginForm.Method264(this._page, this._post, (VKWallReply)null);
         }
         break;
      case 2:
         Class36 var2;
         (var2 = new Class36()).AddElement((new Class301(this, Localized.GetString("action.repostToWall"))).SetRleIcon("new/account.rle"));
         var2.AddElement((new Class302(this, Localized.GetString("action.repostToChat"))).SetRleIcon("new/share.rle"));
         Class198.Instance.Method481(var2);
      }

      if (action) {
         this.Field1130 = 0;
      }

   }

   public final void Method9(Graphics g, int var2, int var3) {
      if (this._post != null) {
         int var4 = this.Field956 + var3;
         int var5 = this.VerticalPosition + var2 + Class198.Instance._font.getHeight() / 2;
         int var6 = Class198.Instance._font.getHeight() + Class198.Instance._font.getHeight() - 1;
         boolean var7 = this.Field958 && this.Field1130 == 0;
         int color8;
         int var9;
         int var10;
         if (!this._isLiked) {
            color8 = var7 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295;
            var9 = var7 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296;
            var10 = var7 ? Class6.ColorsInstanse.Field306 : Class6.ColorsInstanse.Field294;
         } else {
            color8 = var7 ? Class6.ColorsInstanse.Field356 : Class6.ColorsInstanse.Field353;
            var9 = var7 ? Class6.ColorsInstanse.Field357 : Class6.ColorsInstanse.Field354;
            var10 = var7 ? Class6.ColorsInstanse.Field358 : Class6.ColorsInstanse.Field355;
         }

         if (var7) {
            Class252.Method328(g, var4, this.VerticalPosition + var2, (Class198.Instance._font.getHeight() / 2 << 1) + Class198.Instance._font.getHeight() + (this._likesCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._likesCount), var6, Class6.ColorsInstanse.Field302, Class6.ColorsInstanse.Field303);
         }

         var4 += Class198.Instance._font.getHeight() / 2;
         //сердце
         Field1135[this.Field958 && this.Field1130 == 0 ? 1 : (this._isLiked ? 2 : 0)] = Class6.ColorsInstanse.Method140(g, var4, var5, Field1135[this.Field958 && this.Field1130 == 0 ? 1 : (this._isLiked ? 2 : 0)], "new/heart.rle", color8, var9, Class198.Instance._font.getHeight(), 20);
         g.setColor(var10);
         var4 += Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight();
         if (this._isLiked) {
            g.setFont(Class198.Instance._fontBold);
            g.drawString(this._likesCount, var4, var5, 20);
         } else {
            g.setFont(Class198.Instance._font);
            g.drawString(this._likesCount, var4, var5, 20);
         }

         var4 += (this._likesCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._likesCount);
         if (this.Field958 && this.Field1130 == 1) {
            Class252.Method328(g, var4, this.VerticalPosition + var2, (Class198.Instance._font.getHeight() / 2 << 1) + Class198.Instance._font.getHeight() + (this._commentsCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._commentsCount), var6, Class6.ColorsInstanse.Field302, Class6.ColorsInstanse.Field303);
         }

         var4 += Class198.Instance._font.getHeight() / 2;
         //комментарий
         Field1135[this.Field958 && this.Field1130 == 1 ? 4 : 3] = Class6.ColorsInstanse.Method140(g, var4, var5, Field1135[this.Field958 && this.Field1130 == 1 ? 4 : 3], "new/comment.rle", this.Field958 && this.Field1130 == 1 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field958 && this.Field1130 == 1 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296, Class198.Instance._font.getHeight(), 20);
         g.setColor(this.Field958 && this.Field1130 == 1 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field294);
         var4 += Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight();
         g.setFont(Class198.Instance._font);
         g.drawString(this._commentsCount, var4, var5, 20);
         var4 += (this._commentsCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._commentsCount);
         if (this.Field958 && this.Field1130 == 2) {
            Class252.Method328(g, var4, this.VerticalPosition + var2, (Class198.Instance._font.getHeight() / 2 << 1) + Class198.Instance._font.getHeight() + (this._repostsCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._repostsCount), var6, Class6.ColorsInstanse.Field302, Class6.ColorsInstanse.Field303);
         }

         var4 += Class198.Instance._font.getHeight() / 2;
         //поделится
         Field1135[this.Field958 && this.Field1130 == 2 ? 6 : (this._isReposted ? 7 : 5)] = Class6.ColorsInstanse.Method140(g, var4, var5, Field1135[this.Field958 && this.Field1130 == 2 ? 6 : (this._isReposted ? 7 : 5)], "new/share.rle", this.Field958 && this.Field1130 == 2 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field958 && this.Field1130 == 2 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296, Class198.Instance._font.getHeight(), 20);
         g.setColor(this.Field958 && this.Field1130 == 2 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field294);
         var4 += Class198.Instance._font.getHeight() / 2 + Class198.Instance._font.getHeight();
         if (this._isReposted) {
            g.setFont(Class198.Instance._fontBold);
            g.drawString(this._repostsCount, var4, var5, 20);
         } else {
            g.setFont(Class198.Instance._font);
            g.drawString(this._repostsCount, var4, var5, 20);
         }

         if (var4 + (this._repostsCount.length() > 0 ? Class198.Instance._font.getHeight() / 2 : 0) + Class198.Instance._font.stringWidth(this._repostsCount) <= this.Field956 + var3 + this.Field954 - Class198.Instance._font.getHeight() / 2 && this._views.length() > 0) {
            g.setColor(Class6.ColorsInstanse.Field294);
            g.setFont(Class198.Instance._font);
            g.drawString(this._views, this.Field956 + var3 + this.Field954 - Class198.Instance._font.getHeight() / 2, var5, 24);
            Field1135[8] = Class6.ColorsInstanse.Method140(g, this.Field956 + var3 + this.Field954 - (Class198.Instance._font.getHeight() / 2 << 1) - Class198.Instance._font.stringWidth(this._views), var5, Field1135[8], "new/eye.rle", Class6.ColorsInstanse.Field295, Class6.ColorsInstanse.Field296, Class198.Instance._tbNormal.Height, 24);
         }
      }
   }

   public final void Method8() {
   }
}
