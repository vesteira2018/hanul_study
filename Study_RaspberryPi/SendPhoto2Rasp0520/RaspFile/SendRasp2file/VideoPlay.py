import cv2
import numpy as np
import os

#Image Folder Path
path_folder = "/home/pi/Python/Videos"
supported_formats = ('.mp4', '.avi', '.h264')

#Load video path of all images      
def load_video_path(pathFolder):
    #empty list
    _path_video_list = []
    #Loop for every file in folder path
    for filename in os.listdir(pathFolder):
        #Image Read Path
        _path_video_read = os.path.join(pathFolder, filename)
        #Check if file path has supported image format and then only append to list
        if _path_video_read.lower().endswith(supported_formats):
            _path_video_list.append(_path_video_read)
    #Return image path list
    return _path_video_list


def videoShow():    
    #Load video paths   
    video_path_list = load_video_path(path_folder)
    
    for video_path in video_path_list:
        #if image is none load image
        if video_path is not None:
            # Load video
            # Create a VideoCapture object and read from input file
            # If the input is the camera, pass 0 instead of the video file name
            cap = cv2.VideoCapture(video_path)
            
            #mine   
            #cap.set(3, 1024)
            #cap.set(4, 768)
            
            
            # Check if camera opened successfully
            if (cap.isOpened()== False): 
              print("Error opening video stream or file")
             
            # Read until video is completed
            while(cap.isOpened()):
              # Capture frame-by-frame
              ret, frame = cap.read()
              if ret == True: 
                # Display the resulting frame
                cv2.imshow('Frame',frame)
                
                #mine
                cv2.resizeWindow("Frame",1024, 768);
                #move Window
                cv2.moveWindow("Frame", 0, 0)
             
                # Press Q on keyboard to  exit
                if cv2.waitKey(25) & 0xFF == ord('q'):
                  break
             
              # Break the loop
              else: 
                break
            
            #continiue to for loop
            continue 

    if len(video_path_list) is not 0: 
        # When everything done, release the video capture object
        cap.release()
         
        # Closes all the frames
        cv2.destroyAllWindows()
