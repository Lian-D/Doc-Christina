from __future__ import print_function
from os.path import join, dirname
import subprocess
import time
import thread
import threading
import RPi.GPIO as GPIO
from watson_developer_cloud import SpeechToTextV1
from watson_developer_cloud.websocket import RecognizeCallback, AudioSource
import json

def setuptranscription():
    service = SpeechToTextV1(
         ## url is optional, and defaults to the URL below. Use the correct URL for your region.
        url='https://gateway-wdc.watsonplatform.net/speech-to-text/api',
        iam_apikey='aGUZ4JpGbf7WNYnmcIh4YiVqjFleXafwwDdbmCqqtAif')
    return service

def gettxt(service):
    with open(join(dirname(__file__), '/home/pi/Desktop/nwHacks/speech.wav'),
          'rb') as audio_file:
                result = json.dumps(service.recognize(audio=audio_file,content_type='audio/wav',timestamps=False,word_confidence=False).get_result(),indent=2)
                print("running turn to string")
                text_file = open("speechdata.txt", "w")
                text_file.write(str(result))
                text_file.close()

def sendtxt():
    subprocess.call('scp /home/pi/Desktop/nwHacks/speechdata.txt tonyx@10.19.132.116:/C:/Users/TonyX/Desktop' , shell = True)


GPIO.setmode(GPIO.BCM)

GPIO.setup(27, GPIO.IN, pull_up_down=GPIO.PUD_UP)

while True:
    input_state = GPIO.input(27)
    if input_state == False:
        subprocess.call('timeout 5 arecord -D dmic_sv -c2 -r 48000 -f S32_LE -t wav -V mono speech.wav', shell = True)
        gettxt(setuptranscription())
        sendtxt()




        




