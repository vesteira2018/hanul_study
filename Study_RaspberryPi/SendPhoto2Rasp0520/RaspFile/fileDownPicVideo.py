import datetime
import time
import requests   # to make GET request

def download():  # file download
    ntime = datetime.datetime.now()
    print(ntime)
    
    url = "http://121.148.239.200:80/app/resources/MyPicture.jpg"
    url2 = "http://121.148.239.200:80/app/resources/MyVideo.mp4"
    
    file_name = "/home/pi/Python/Pictures/" + str(ntime) + ".jpg"
    file_name2 = "/home/pi/Python/Videos/" + str(ntime) + ".mp4"
    
    responseHead = requests.head(url)     # Is picture exist?
    print(responseHead.status_code)
    
    if responseHead.status_code == 200:       # if file is exist
        with open(file_name, "wb") as file:   # open in binary mode
            response = requests.get(url)      # get request
            file.write(response.content)      # write to file
            
            deletefile('PIC')                 # deletefile
            return 1
        
    responseHead2 = requests.head(url2)       # Is picture exist?
    print(responseHead2.status_code)
    
    if responseHead2.status_code == 200:       # if file is exist
        with open(file_name2, "wb") as file:   # open in binary mode
            response2 = requests.get(url2)     # get request
            file.write(response2.content)      # write to file
            
            deletefile('VIDEO')                # deletefile
            return 2
        
    return 0
            
def deletefile(value):   # delete file after download
    url = "http://121.148.239.200:80/app/raspDelFile"
    r = requests.get(url, params = {'id' : value})


    
    
    
    
    
