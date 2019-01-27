from __future__ import print_function
import json
from os.path import join, dirname
from watson_developer_cloud import SpeechToTextV1
from watson_developer_cloud.websocket import RecognizeCallback, AudioSource
import threading

def setuptranscription():
    service = SpeechToTextV1(
         ## url is optional, and defaults to the URL below. Use the correct URL for your region.
        url='https://gateway-wdc.watsonplatform.net/speech-to-text/api',
        iam_apikey='aGUZ4JpGbf7WNYnmcIh4YiVqjFleXafwwDdbmCqqtAif')

def gettxt():
    with open(join(dirname(__file__), '/home/pi/Desktop/nwHacks/speech.wav'),
          'rb') as audio_file:
                result = json.dumps(service.recognize(audio=audio_file,content_type='audio/wav',timestamps=False,word_confidence=False).get_result(),indent=2)
                print("running turn to string")
                text_file = open("speechdata.txt", "w")
                text_file.write(str(result))
                text_file.close()
