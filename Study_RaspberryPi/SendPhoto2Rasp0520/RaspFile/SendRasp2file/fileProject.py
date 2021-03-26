import fileDownPicVideo
import imageShow
import time

start_time = time.time()
remain_time = 10
rtnValue = 0

# find all file in Pictures fold
'''for root, dirs, files in os.walk('/home/pi/Python/Pictures'):
    for file in files:
        # if file.endswith('png'):
        print(os.path.join(root, file))
'''        

try:    
    while True:  
        imageShow.imgShow()
        
#        rtnValue = fileDownPicVideo.download()
        
        if ((start_time + remain_time) - time.time()) <= 0:
            fileDownPicVideo.download()
            start_time = time.time()
            print(start_time)


except KeyboardInterrupt:
    pass

GPIO.cleanup()