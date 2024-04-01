public final class Class467 extends Class446 implements Class11 {
   VKGroupOrUser Field1289;
   private int Field1290 = 0;

   public Class467(long var1)  {
      super(Localized.GetString("title.pageInformation"), false);
      this.IsAllLoaded = true;
      Class31.Method515(var1, "can_message,ban_info,can_write_private_message,can_see_audio,followers,friend_status,common_count,blacklisted,blacklisted_by_me,fixed_post,ban_info,members_count,counters,photo_50,photo_100,text,views,reposts,likes,status,sex,online,online_app,online_mobile,last_seen,first_name_nom,first_name_gen,first_name_dat,first_name_acc,first_name_ins,first_name_abl,last_name_nom,last_name_gen,last_name_dat,last_name_acc,last_name_ins,last_name_abl,screen_name,image_status,emoji_status,crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name,occupation,description,activity,age_limits,bdate,education,contacts,home_town,country,city,interests,books,activities,about,connections,relation,movies,music,games,tv,quotes,personal,site");
      this.Field1289 = Class31.GetUser(var1);
      this.Field825.AddElement((new Class519(this, Localized.GetString("action.showAvatar"))).SetRleIcon("new/account.rle"));
      this.Method287("@" + this.Field1289.Method349());
      this.Field1227 = true;
      Class198.Instance.SetInLoadingState(true);
      TextBlock var10001;
      boolean var4;
      TextBlock var5;
      String var7;
      if (this.Field1289 != null && this.Field1289.is_group) {
         VKGroup var6;
         if (!SomeStringUtils.IsStringEmpty((var6 = this.Field1289.GetGroup()).deactivated)) {
            if (var6.deactivated.equals("deleted")) {
               this.Method191(new TextBlock(Localized.GetString("element.pageDeleted")));
            } else {
               this.Method191(new TextBlock(Localized.GetString("element.pageBanned")));
            }
         } else {
            this.Method191(LoginForm.GetHeaderElement(var6, false, true, true, true, this).SetSubtitle(Localized.GetString("element.community")));
            if (!Class291.IsNullOrEmpty(var6.status)) {
               var10001 = new TextBlock(var6.status);
               var4 = false;
               var5 = var10001;
               var10001.Field959 = var4;
               this.Method191(var5.Method157(true));
            }

            if (var6.Field856) {
               this.Method191(new TextBlock(Localized.GetString("element.groupBlacklisted")));
            } else {
               if (!var6.Field857 && var6.is_closed != 0) {
                  if (var6.is_closed == 1) {
                     this.Method191(new TextBlock(Localized.GetString("element.groupClosed")));
                  } else {
                     this.Method191(new TextBlock(Localized.GetString("element.groupPrivate")));
                  }
               }

               if (var6.Field857 || var6.is_closed != 2) {
                  var7 = var6.Field857 ? Localized.GetString("action.leaveGroup") : (var6.is_closed == 0 ? Localized.GetString("action.joinGroup") : (var6.invited_by != 0 ? Localized.GetString("action.acceptInvitation") : Localized.GetString("action.sendRequest")));
                  this.Method191((new Class518(this, var7, var6)).Method109(true));
               }

               if (var6.Field857 || var6.is_closed == 0) {
                  if (var6.Field858) {
                     this.Method191((new Class472(this, Localized.GetString("action.writeMessage"))).Method109(true));
                  }

                  this.Method191((new Class474(this, Localized.GetString("action.additionalInfo"))).SetRleIcon("new/information.rle"));
                  if (var6.albums > 0) {
                     this.Method191((new Class475(this, Localized.GetString("title.albums"), (byte)3)).SetRleIcon("new/image.rle").SetContent(Method12(var6.albums)).Method96(true));
                  }

                  if (var6.audios > 0) {
                     this.Method191((new Class476(this, Localized.GetString("elements.audios"), (byte)3)).SetRleIcon("new/music-note.rle").SetContent(Method12(var6.audios)).Method96(true));
                  }

                  this.Method191(new OffsetElementUI());
                  this.IsAllLoaded = false;
               }
            }
         }
      } else {
         VKUser var3;
         if (!SomeStringUtils.IsStringEmpty((var3 = this.Field1289.GetUser()).deactivated)) {
            if (var3.deactivated.equals("deleted")) {
               this.Method191(new TextBlock(Localized.GetString("element.pageDeleted")));
            } else {
               this.Method191(new TextBlock(Localized.GetString("element.pageBanned")));
            }
         } else {
            this.Method191(LoginForm.GetHeaderElement(var3, false, true, true, true, this));
            if (!Class291.IsNullOrEmpty(var3.status)) {
               var10001 = new TextBlock(var3.status);
               var4 = false;
               var5 = var10001;
               var10001.Field959 = var4;
               this.Method191(var5.Method157(true));
            }

            if (var3.blacklisted) {
               this.Method191(new TextBlock(Localized.GetString("element.userBlacklisted")));
            } else {
               switch(var3.friend_status) {
               case 1:
                  var7 = Localized.GetString("action.cancelFriendsRequest");
                  break;
               case 2:
                  var7 = Localized.GetString("action.acceptFriendsRequest");
                  break;
               case 3:
                  var7 = Localized.GetString("action.removeFromFriends");
                  break;
               default:
                  var7 = Localized.GetString("action.addToFriends");
               }

               if (var3.GetId() != Settings.Instance.UserId) {
                  this.Method191((new Class477(this, var7, var3)).Method109(true));
               }

               if (var3.can_write_private_message && var3.GetId() != Settings.Instance.UserId) {
                  this.Method191((new Class478(this, Localized.GetString("action.writeMessage"))).Method109(true));
               }

               this.Method191((new Class480(this, Localized.GetString("action.additionalInfo"))).SetRleIcon("new/information.rle"));
               if (var3.friends > 0) {
                  this.Method191((new Class209(this, Localized.GetString("elements.friends"), (byte)3)).SetRleIcon("new/account.rle").SetContent((var3.online_friends > 0 ? Method12(var3.online_friends) + " / " : "") + Method12(var3.friends)).Method96(true));
               }

               if (var3.groups > 0) {
                  this.Method191((new Class208(this, Localized.GetString("elements.groups"), (byte)3)).SetRleIcon("new/account-supervisor.rle").SetContent(Method12(var3.groups)).Method96(true));
               }

               if (var3.albums > 0) {
                  this.Method191((new Class207(this, Localized.GetString("title.albums"), (byte)3)).SetRleIcon("new/image.rle").SetContent(Method12(var3.albums)).Method96(true));
               }

               if (var3.audios > 0) {
                  this.Method191((new Class204(this, Localized.GetString("elements.audios"), (byte)3)).SetRleIcon("new/music-note.rle").SetContent(Method12(var3.audios)).Method96(true));
               }

               this.Method191(new OffsetElementUI());
               this.IsAllLoaded = false;
            }
         }
      }

      this.Field1227 = false;
      Class198.Instance.SetInLoadingState(false);
      this.Method20();
   }

   public final Page Clear() {
      int var1 = this.Field1290;

      while(var1 < this.Count()) {
         this.RemoveElementAtPosition(var1);
      }

      System.gc();
      return this;
   }

   private void Method191(Class328 var1) {
      this.AddElement(var1);
      ++this.Field1290;
   }

   public final void LoadData() {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null) {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      Class61 var1=new Class61(this.Field1289.GetId(), 20, ((Integer)this.next_from).intValue() * 20);
      var1.GetResponse();
      
      //
      if (var1 != null && var1.Field691 != null && var1.Field691.length > 0) {
         if (var1.Field691.length < 20) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var1.Field691.length; i++)
         {
            NewsfeedPage.ProcessPost(this, var1.Field691[i],null);
         }
      } else {
         this.IsAllLoaded = true;
         if (var1 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      Class198.Instance.SetInLoadingState(false);
   }

   public static String Method12(int var0) {
      int var10000 = var0;
      //boolean var1 = false;
      var0 = var10000;
      if (var10000 == 0) {
         return "";
      } else if (var0 < 10000) {
         return var0 + "";
      } else {
         return var0 < 1000000 ? var0 / 1000 + "K" : var0 / 1000000 + "M";
      }
   }

   public static String GetDateForUI(int date) {
      long var1;
      if ((var1 = System.currentTimeMillis() / 1000L / 86400L - (long)(date / 86400)) > 1L) {
         return Localized.Method398("general.dateAt", SomeStringUtils.Method428(date), SomeStringUtils.Method427(date));
      } else {
         String var10000 = var1 == 1L ? "general.yesterdayAt" : "general.todayAt";
         String var3 = SomeStringUtils.Method427(date);
         return Localized.Method398(var10000, var3, null);
      }
   }

   public final void AddItem(Class328 element) {
      this.AddElement(element);
   }
}
