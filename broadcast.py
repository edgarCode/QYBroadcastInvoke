#作用是通过广播的形式发送视频的id，然后用demo程序接收并再次发送广播调起客户端的播放或者详情页
import sys, os
# coding=utf-8
print "1 playVideo"
print "2 openAlbumDetail"
broadcastType = raw_input("Please choose the type (only number):")
vrsAlbumId = raw_input("vrsAlbumId:")
vrsTvId = raw_input("vrsTvId:")
command = ""
typeInd = int(broadcastType)
if(typeInd == 2) :	
	vrsChnId = raw_input("vrsChnId:")
	albumId = raw_input("albumId:")
	command = "adb shell am broadcast -a com.qiyi.video.myreiver --ei type %d --es vrsAlbumId %s --es vrsTvId %s --es vrsChnId %s --es albumId %s" % (typeInd, vrsAlbumId, vrsTvId, vrsChnId, albumId) 
elif(typeInd == 1) :
	command = "adb shell am broadcast -a com.qiyi.video.myreiver --ei type %d --es vrsAlbumId %s --es vrsTvId %s" % (typeInd, vrsAlbumId, vrsTvId) 
connetConfirm = raw_input("Are you sure connect to device ? (yes or no)")
if(connetConfirm == "yes"):	
	os.system("adb shell am start -n com.example.receiver/.MainActivity")
	os.system(command)


