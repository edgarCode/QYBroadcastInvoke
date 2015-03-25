import sys, os
print "1 playVideo"
print "2 openAlbumDetail"
print "3 openAlbumList"

reload(sys)
sys.setdefaultencoding('utf-8')

broadcastType = raw_input("Please choose the type (only number):")
packageName = raw_input("Please input the packageName of the app (default com.qiyi.video):")
command = ""
typeId = int(broadcastType)
if(typeId == 3) :
        listType = raw_input("listType(you can type like vip,7new, history, favorite, if not in these you can empty):")
        if(listType.strip()=='') :
                chnId = raw_input("chnId:")
                command = "adb shell am broadcast -a com.qiyi.video.myreiver --ei type %d --es package %s --es chnId %s" % (typeId, packageName, chnId)
        else:
                command = "adb shell am broadcast -a com.qiyi.video.myreiver --ei type %d --es listType %r --es package %s" % (typeId, listType, packageName)
        print "command = %s" %command
elif(typeId == 2) :
        vrsAlbumId = raw_input("vrsAlbumId:")
        vrsTvId = raw_input("vrsTvId:")
        vrsChnId = raw_input("vrsChnId:")
        albumId = raw_input("albumId:")
        command = "adb shell am broadcast -a com.qiyi.video.myreiver --ei type %d --es package --es vrsAlbumId %s --es vrsTvId %s --es vrsChnId %s --es albumId %s" % (typeId, packageName, vrsAlbumId, vrsTvId, vrsChnId, albumId) 
elif(typeId == 1) :
        vrsAlbumId = raw_input("vrsAlbumId:")
        vrsTvId = raw_input("vrsTvId:")
        command = "adb shell am broadcast -a com.qiyi.video.myreiver --ei type %d --es package --es vrsAlbumId %s --es vrsTvId %s" % (typeId,packageName, vrsAlbumId, vrsTvId) 
connetConfirm = raw_input("Are you sure connect to device ? (yes or no)")
if(connetConfirm == "yes"):	
        os.system("adb shell am start -n com.edgarcode.qytoolbox/.MainActivity")
        os.system(command)



