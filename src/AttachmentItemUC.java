import javax.microedition.lcdui.Graphics;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class AttachmentItemUC extends Button implements Class80 {
   private Class368 Field1297;
   VKAttachment _attach;
   private int[] Field1299;
   private int[] Field1300;
   private int Field1301;
   private int Field1302;
   private int Field1303;

   public AttachmentItemUC(VKAttachment attachment) {
      super(attachment.toString(), (byte)3);
      this.Field266 = true;
      this.Field267 = true;
      this.Field268 = true;
      this._attach = attachment;
      if (attachment != null) {
         this.Method109(true);
         if (attachment instanceof Class242) {
            String var3;
            Class242 var4;
            if (SomeStringUtils.IsStringEmpty(var3 = (var4 = (Class242)attachment).Field766)) {
               var3 = "";
            }

            this.SetSubtitle(var3);
            this.Method105();
            this.SetLable(var4.Field765);
         } else if (attachment.photo!=null) {
            String var6;
            if (SomeStringUtils.IsStringEmpty(var6 = attachment.photo.text)) {
               var6 = "";
            }

            this.SetSubtitle(var6);
            this.Method104(attachment.photo);
            this.SetLable(Localized.GetString("attachment.photo") + " #" + attachment.photo.id);
         } else if (attachment.sticker!=null) {
            this.SetSubtitle(attachment.toString());
            this.SetRleIcon("new/sticker-emoji.rle");
            this.SetLable(Localized.GetString("attachment.sticker"));
         } else if (attachment.audio!=null) {
            VKAudio var8 = attachment.audio;
            this.SetSubtitle(var8.artist);
            this.Method102(var8);
            this.SetLable(var8.title);
            this.SetContent(SomeStringUtils.Method430((long)var8.duration));
         } else if (attachment.graffiti!=null) {
            this.SetSubtitle(attachment.toString());
            this.SetRleIcon("new/spray.rle");
            this.SetLable(Localized.GetString("attachment.graffiti"));
         } else if (attachment.audio_message!=null) {
            VKAudioMessage var9 = attachment.audio_message;
            this.SetSubtitle("");
            this.SetContent(SomeStringUtils.Method430((long)var9.duration));
            this.SetRleIcon("new/voicemail.rle");
            this.SetLable("");
         } else if (attachment.doc!=null) {
            VKDocument var10 = attachment.doc;
            this.SetSubtitle(var10.title);
            int var5;
            this.SetContent((var5 = var10.size) >= 1073741824 ? (float)((int)((float)var5 / 1.07374182E9F * 10.0F)) / 10.0F + " GiB" : (var5 >= 1048576 ? (float)((int)((float)var5 / 1048576.0F * 10.0F)) / 10.0F + " MiB" : (var5 >= 1024 ? (float)((int)((float)var5 / 1024.0F * 10.0F)) / 10.0F + " KiB" : var5 + " B")));
            this.SetRleIcon("new/file.rle");
            this.SetLable(Localized.GetString("attachment.document"));
         } else if (attachment.audio_playlist!=null) {
            VKPlayList var11 = attachment.audio_playlist;
            this.Method103(var11);
         } else if (attachment.video!=null) {
            VKVideo var12 = attachment.video;
            this.SetSubtitle(SomeStringUtils.IsStringEmpty(var12.description) ? Localized.GetString("attachment.video") : var12.description);
            this.SetContent(SomeStringUtils.Method430((long)var12.duration));
            this.SetRleIcon("new/filmstrip.rle");
            this.SetLable(var12.title);
         } else if (attachment.link!=null) {
            VKLink var13 = attachment.link;
            this.SetSubtitle(var13.url);
            this.SetRleIcon("new/link.rle");
            this.SetLable(Localized.GetString(var13.title));
         } else if (attachment.wall!=null) {
            VKNewsfeedPost var14 = attachment.wall;
            this.SetSubtitle(var14.IsTextExists() ? var14.text : Localized.GetString("attachment.wall"));
            this.SetContent(SomeStringUtils.Method428(var14.date));
            this.SetRleIcon("new/newspaper-variant.rle");
            this.SetLable(Class31.GetUser(var14.owner_id).GetTitle("nom"));
         } else if (attachment.wall_reply!=null) {
            VKWallReply var15 = attachment.wall_reply;
            this.SetSubtitle(var15.IsStringExists() ? var15.text : Localized.GetString("attachment.wall_reply"));
            this.SetContent(SomeStringUtils.Method428(var15.date));
            this.SetRleIcon("new/message.rle");
            this.SetLable(Class31.GetUser(var15.from_id).GetTitle("nom"));
         } else {
            this.SetSubtitle(attachment.toString());
            this.SetRleIcon("new/paperclip.rle");
            this.SetLable(Localized.GetString("attachment.general"));
         }

         Class362 var7;
         if ((var7 = Class459.Method196(this.Method73())) != null) {
            var7.Method290(this);
         }
      }

   }

   public final void CommandExecuted() 
   {
      if (this._attach.wall!=null) {
         LoginForm.Method264(this._page, this._attach.wall, null);
      } else if (this._attach.wall_reply!=null) {
         VKWallReply var12 = this._attach.wall_reply;
         Class199 var15=new Class199(var12.owner_id, var12.post_id);
         var15.GetResponse();
         
         if (var15.Field567 != null)
         {
            LoginForm.Method264(this._page, var15.Field567, null);
         }

      } else {
         Class36 var2;
         if (this._attach.audio_message!=null) {
            if (Class459.Method199(this.Method73())) {
               return;
            }

            VKAudioMessage var1 = this._attach.audio_message;
            switch(Settings.Instance.DownloadMode) {
            case 0:
               (var2 = new Class36()).AddElement((new Class487(this, Localized.GetString("settings.downloadFile"), var1)).SetRleIcon("new/cloud-download.rle"));
               var2.AddElement((new Class9(this, Localized.GetString("settings.openBrowser"), var1)).SetRleIcon("new/web.rle"));
               Class198.Instance.Method481(var2);
               break;
            case 1:
            case 2:
               this.Method222(Settings.Instance.DownloadMode == 2, var1);
            default:
               return;
            }
         } else if (this._attach.doc!=null) {
            if (Class459.Method199(this.Method73())) {
               return;
            }

            VKDocument var5 = this._attach.doc;
            switch(Settings.Instance.DownloadMode) {
            case 0:
               (var2 = new Class36()).AddElement((new Class486(this, Localized.GetString("settings.downloadFile"), var5)).SetRleIcon("new/cloud-download.rle"));
               var2.AddElement((new Class485(this, Localized.GetString("settings.openBrowser"), var5)).SetRleIcon("new/web.rle"));
               Class198.Instance.Method481(var2);
               break;
            case 1:
            case 2:
               this.Method221(Settings.Instance.DownloadMode == 2, var5);
            default:
               return;
            }
         } else {
            if (this._attach instanceof Class242) {
               LoginForm.Method255(((Class242)this._attach).Field764, ((Class242)this._attach).Field763, this._page);
               return;
            }

            if (this._attach.photo!=null) {
               Class198.Instance.NavigateForward(Class75.Field206.Method60(this._attach.photo, this, null).Method361(this._page));
               return;
            }

            if (this._attach instanceof Class184) {
               if (Class459.Method199(this.Method73())) {
                  return;
               }

               Class184 var6;
               String var10 = (var6 = (Class184)this._attach).GetUrl(Integer.MAX_VALUE);
               if (var6 != null && var10 != null) {
                  switch(Settings.Instance.DownloadMode) {
                  case 0:
                     Class36 var4;
                     (var4 = new Class36()).AddElement((new Class484(this, Localized.GetString("settings.downloadFile"), var6, var10)).SetRleIcon("new/cloud-download.rle"));
                     var4.AddElement((new Class482(this, Localized.GetString("settings.openBrowser"), var6, var10)).SetRleIcon("new/web.rle"));
                     Class198.Instance.Method481(var4);
                     break;
                  case 1:
                  case 2:
                     this.Method71(Settings.Instance.DownloadMode == 2, var10);
                  default:
                     return;
                  }
               }
            } else {
               if (this._attach.audio_playlist!=null) {
                  VKPlayList var9 = this._attach.audio_playlist;
                  Page page = (new Page(var9.title)).Method361(this._page);
                  Class226 var11=new Class226(var9.owner_id, var9.id, var9.access_key);
                  var11.GetResponse();
                  if (var11  != null && var11.Items != null && var11.Items.length > 0) {
                     for(int i = 0; i < var11.Items.length; i++) {
                        if (var11.Items[i] != null)
                        {
                        	VKAttachment a = new VKAttachment();//todo
                        	a.type="audio";
                        	a.audio=var11.Items[i];
                           page.AddElement(new AttachmentItemUC(a));
                        }
                     }
                  }

                  Class198.Instance.NavigateForward(page);
                  return;
               }

               if (this._attach.audio!=null) {
                  if (Class459.Method199(this.Method73())) {
                     return;
                  }

                  VKAudio var7 = this._attach.audio;
                  switch(Settings.Instance.DownloadMode) {
                  case 0:
                     (var2 = new Class36()).AddElement((new Class490(this, Localized.GetString("settings.addToLibrary"), var7)).SetRleIcon("new/content-copy.rle"));
                     var2.AddElement((new Class493(this, Localized.GetString("settings.downloadFile"), var7)).SetRleIcon("new/cloud-download.rle"));
                     var2.AddElement((new Class492(this, Localized.GetString("settings.openBrowser"), var7)).SetRleIcon("new/web.rle"));
                     Class198.Instance.Method481(var2);
                     break;
                  case 1:
                  case 2:
                     this.Method220(Settings.Instance.DownloadMode == 2, var7);
                  default:
                     return;
                  }
               } else if (this._attach.video!=null) {
                  if (Class459.Method199(this.Method73())) {
                     return;
                  }

                  Class36 var8 = new Class36();
                  VKVideo var13= this._attach.video;
                  if (!VKVideo.IsStringEmpty(var13.platform)) {
                     if (var13.Field1114 != null && var13.Field1114.indexOf("youtube.com") != -1) {
                        var8.AddElement(new Class398(this, Localized.GetString("action.openJTube"), var13));
                        var8.AddElement(new Class401(this, Localized.GetString("action.webPlayer"), var13));
                     }
                  } else {
                     if (var13.Field1120 != null) {
                        var8.AddElement(new Class399(this, "144p", var13));
                     }

                     if (var13.Field1119 != null) {
                        var8.AddElement(new Class412(this, "240p", var13));
                     }

                     if (var13.Field1118 != null) {
                        var8.AddElement(new Class413(this, "360p", var13));
                     }

                     if (var13.Field1117 != null) {
                        var8.AddElement(new Class414(this, "480p", var13));
                     }

                     if (var13.Field1116 != null) {
                        var8.AddElement(new Class415(this, "720p", var13));
                     }

                     if (var13.Field1115 != null) {
                        var8.AddElement(new Class416(this, "1080p", var13));
                     }

                     if (var13.Field1114 != null) {
                        var8.AddElement(new Class417(this, Localized.GetString("action.webPlayer"), var13));
                     }
                  }

                  if (var8.Count() != 0) {
                     Class198.Instance.Method481(var8);
                     return;
                  }

                  Class198.Instance.ShowError(Localized.GetString("error.linksNotFound"));
               } else if (this._attach.link!=null) {
                  Midlet.Method445(this._attach.link.url);
               }
            }
         }

      }
   }

   public final void Method218(VKVideo var1, String var2, String var3) {
      if (var1 != null && var2 != null && var3 != null) {
         switch(Settings.Instance.DownloadMode) {
         case 0:
            Class36 var4;
            (var4 = new Class36()).AddElement((new Class488(this, Localized.GetString("settings.downloadFile"), var1, var2, var3)).SetRleIcon("new/cloud-download.rle"));
            var4.AddElement((new Class491(this, Localized.GetString("settings.openBrowser"), var1, var2, var3)).SetRleIcon("new/web.rle"));
            Class198.Instance.Method481(var4);
            return;
         case 1:
         case 2:
            this.Method219(Settings.Instance.DownloadMode == 2, var1, var2, var3);
         default:
         }
      }
   }

   public final void Method219(boolean var1, VKVideo var2, String var3, String var4) {
      if (var1) {
         Midlet.Method445(var3);
      } else {
         Class198.Instance.NavigateForward(new Class12(this, true, this._page, var2, var4, var3));
      }
   }

   public final void Method220(boolean var1, VKAudio var2) {
      if (var1) {
         Midlet.Method445(var2.url);
      } else {
         Class198.Instance.NavigateForward(new Class14(this, true, this._page, var2));
      }
   }

   public final void Method71(boolean var1, String var2) {
      if (var1) {
         Midlet.Method445(var2);
      } else {
         Class198.Instance.NavigateForward(new Class17(this, true, this._page, var2));
      }
   }

   public final void Method221(boolean var1, VKDocument var2) {
      if (var1) {
         Midlet.Method445(var2.url);
      } else {
         Class198.Instance.NavigateForward(new Class19(this, true, this._page, var2));
      }
   }

   public final void Method222(boolean var1, VKAudioMessage var2) {
      if (var1) {
         Midlet.Method445(var2.url);
      } else {
         Class198.Instance.NavigateForward(new Class21(this, true, this._page, var2));
      }
   }

   public final void Method9(Graphics var1, int var2, int var3) {
      super.Method9(var1, var2, var3);
      if (this.Field1297 != null) {
         this.Field1297.Field958 = this.Field958;
         this.Field1297.Field954 = this.Field954 - 2;
         this.Field1297.Method9(var1, this.VerticalPosition + var2 + this.Height - this.Field1297.Height, this.Field956 + var3 + 1);
      }

      int var4;
      if (this._attach.audio_message!=null && this.Field954 > 0 && this.Field1302 != this.Field954 && this.Field1303 != this.Height) {
         this.Field1302 = this.Field954;
         this.Field1303 = this.Height;
         var4 = this.Field954 - this.TextOffset - this.Field270;
         int[] var5 = this._attach.audio_message.waveform;
         int var6 = Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth / 2;
         int var7 = Math.max(1, Math.min(var5.length, var4 / Math.max(1, var6) - 1));
         int var8 = var5.length / var7;
         this.Field1299 = new int[var7];
         this.Field1300 = new int[var7];
         this.Field1301 = var4 / var7;
         var4 = 0;
         int var9 = Integer.MAX_VALUE;
         int var10 = Integer.MIN_VALUE;

         int var11;
         for(var11 = 0; var11 < var5.length; var11 += var8) {
            var9 = Math.min(var9, var5[var11]);
            var10 = Math.max(var10, var5[var11]);
         }

         var11 = (this.Height - var6) / Math.max(1, var10 - var9);

         for(var10 = 0; var10 < var5.length; var10 += var8) {
            this.Field1299[var4] = var6 + (var5[var10] - var9) * var11;
            this.Field1300[var4] = (this.Height - this.Field1299[var4]) / 2;
            ++var4;
            if (var4 >= var7) {
               break;
            }
         }
      }

      if (this.Field1299 != null && this.Field1300 != null) {
         var3 += Class198.Instance.CharSpaceWidth * 3 / 2;

         for(var4 = 0; var4 < this.Field1299.length; ++var4) {
            Class252.Method328(var1, this.Field956 + var3 + this.TextOffset, this.VerticalPosition + var2 + this.Field1300[var4], Class198.Instance.CharSpaceWidth, this.Field1299[var4], this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296);
            var3 += this.Field1301;
         }
      }

   }

   public final void Method1(long var1) {
      if (this.Field1297 == null) {
         Class368 var10001 = new Class368();
         boolean var4 = true;
         Class368 var3 = var10001;
         var10001.Field959 = var4;
         this.Field1297 = (Class368)var3;
      }

      if (this.Field1297 != null) {
         this.Field1297.Method247(var1);
      }

      if (this._page != null) {
         this._page.Method119();
      }

   }

   public final void Method27(String var1) {
      this.Field1297 = null;
      if (this._page != null) {
         this._page.Method119();
      }

      this.SetSubtitle(Localized.GetString("general.error") + ": Attachment view: " + var1);
      Class198.Instance.ShowError(var1);
   }

   public final void Method72() {
      this.Field1297 = null;
      if (this._page != null) {
         this._page.Method119();
      }

      this.SetSubtitle(Localized.GetString("general.downloadFinished"));
   }

   public final String Method73() {
      return this._attach == null ? null : this._attach.toString();
   }
}
