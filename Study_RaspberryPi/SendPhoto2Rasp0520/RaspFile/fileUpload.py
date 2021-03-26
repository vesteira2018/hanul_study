import RPi.GPIO as GPIO
from picamera import PiCamera
import time
import requests
import json

trig = 11
echo = 13
servo_pin = 12

upload_check = 0

start_time = 0
remain_time = 5

GPIO.setmode(GPIO.BOARD)

# distance sensor
GPIO.setup(echo, GPIO.IN)
GPIO.setup(trig, GPIO.OUT)
GPIO.output(trig, GPIO.LOW)

# servo Motor
GPIO.setup(servo_pin, GPIO.OUT)
p = GPIO.PWM(servo_pin, 50)

p.start(0)

def distance_check():
    GPIO.output(trig, GPIO.HIGH)
    time.sleep(0.00001)
    GPIO.output(trig, GPIO.LOW)
    
    stop = 0
    start = 0
    
    while GPIO.input(echo) == GPIO.LOW:
        start = time.time()
    while GPIO.input(echo) == GPIO.HIGH:
        stop = time.time()
    duration = stop - start
    distance = (duration*340*100)/2
    
    return distance

try:
    while True:
        result_distance = distance_check()
        print("distance=%2f cm"%(result_distance))
        
        if upload_check == 0 and result_distance <= 15:
            # capture
            camera = PiCamera()

            camera.start_preview()
            time.sleep(2)
            camera.capture('/home/pi/Pictures/capture.jpg')
            camera.stop_preview()
            camera.close()
            
            # image upload to server
            url = 'http://192.168.0.200:8989/app/raspUploadfile'
            files = {'media': open('/home/pi/Pictures/capture.jpg', 'rb')}
            dataJson = requests.post(url, files=files).json()
            print(dataJson)
            
            if dataJson.get('returnValue') == 'true':
                # crossline up
                p.ChangeDutyCycle(7.5)
            
            start_time = time.time()
            upload_check = 1;
            
        elif upload_check == 1 and result_distance <= 15:
            start_time = time.time()
            
        elif upload_check == 1 and result_distance > 15:
            if ((start_time + remain_time) - time.time()) <= 0:
                # crossline down after 3 seconds
                p.ChangeDutyCycle(0)
                upload_check = 0;
            
        time.sleep(1);
except KeyboardInterrupt:
    GPIO.cleanup()