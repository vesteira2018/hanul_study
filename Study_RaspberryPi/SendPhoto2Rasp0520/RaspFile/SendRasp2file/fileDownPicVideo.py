import datetime
import time
import requests   # to make GET request
import os
import json

def download():  # file download
    ntime = datetime.datetime.now()
    print(ntime)
    
    url = "http://192.168.0.105:8888/maker/hong123@naver.com/MyPicture.jpg"
    file_name = "/home/pi/Python/Pictures/" + str(ntime) + ".jpg"
    
    responseHead = requests.head(url)     # Is picture exist?
    print(responseHead.status_code)
    
    if responseHead.status_code == 200:       # if file is exist
        with open(file_name, "wb") as file:   # open in binary mode
            response = requests.get(url)      # get request
            file.write(response.content)      # write to file
            
            renamefile('PIC', file_name)      # deletefile
            return 1
    
    url2 = "http://192.168.0.105:8888/maker/raspDelFile"   
    dataJson = requests.post(url2).json()
    print(dataJson)
    
    for data in dataJson:
        fileName = data.get('fileName')
        if fileName is not None:
            removefile(fileName)
            
    return 0

            
def renamefile(value, file_name):   # delete file after download
    url = "http://192.168.0.105:8888/maker/raspRenameFile"
    r = requests.get(url, params = {'id' : value, 'fileName' : file_name})

'''def delfile():
    url = "http://192.168.0.138:8888/maker/hong123@naver.com/fileName"'''
    
    
def removefile(filename):
    file_name = "/home/pi/Python/Pictures/" + filename
    if os.path.isfile(file_name):
        os.remove(file_name)
        return 'true'
    else:
        return 'false'
    
    
    
    
    
