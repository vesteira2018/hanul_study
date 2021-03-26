import datetime
import time
import picamera 
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BOARD)
GPIO.setup(11, GPIO.IN, GPIO.PUD_UP)

try:
    while True:
        with picamera.PiCamera() as camera:    
            camera.start_preview()
            GPIO.wait_for_edge(11, GPIO.FALLING)
            ntime = datetime.datetime.now()
            print(ntime)
            camera.start_recording('/home/pi/Videos/' + str(ntime) + '.h264')
            time.sleep(1)
            GPIO.wait_for_edge(11, GPIO.FALLING)
            camera.stop_recording()
            camera.stop_preview()
            camera.close()
except KeyboardInterrupt:
    GPIO.cleanup()




