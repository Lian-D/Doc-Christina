from __future__ import print_function
import json
from os.path import join, dirname
from watson_developer_cloud import SpeechToTextV1
from watson_developer_cloud.websocket import RecognizeCallback, AudioSource
import threading

# If service instance provides API key authentication
service = SpeechToTextV1(
     ## url is optional, and defaults to the URL below. Use the correct URL for your region.
    url='https://gateway-wdc.watsonplatform.net/speech-to-text/api',
    iam_apikey='aGUZ4JpGbf7WNYnmcIh4YiVqjFleXafwwDdbmCqqtAif')


#models = service.list_models().get_result()
#print(json.dumps(models, indent=2))

#model = service.get_model('en-US_BroadbandModel').get_result()
#print(json.dumps(model, indent=2))


with open(join(dirname(__file__), 'C:/Users/Fred/nwHacks2019-Project/resources/speech.wav'),
          'rb') as audio_file:
                result = json.dumps(service.recognize(audio=audio_file,content_type='audio/wav',timestamps=False,word_confidence=False).get_result(),indent=2)
                print("running turn to string")
                text_file = open("speechdata.txt", "w")
                text_file.write(str(result))
                text_file.close()


# EEVERYTHING UNDERNEATH HERE IS UNUSED
class MyRecognizeCallback(RecognizeCallback):
    def __init__(self):
        RecognizeCallback.__init__(self)

    def on_transcription(self, transcript):
        print('running on transcription')
        print(transcript)

    def on_connected(self):
        print('Connection was successful')

    def on_error(self, error):
        print('Error received: {}'.format(error))

    def on_inactivity_timeout(self, error):
        print('Inactivity timeout: {}'.format(error))

    def on_listening(self):
        print('Service is listening')

    def on_hypothesis(self, hypothesis):
        print("running on_hypothesis")
        print(hypothesis)

    def on_data(self, data):
        print("running on_data")
        print(data)
        print("running turn to string")
        text_file = open("speechdata.txt", "w")
        text_file.write(str(data))
        text_file.close()

    def turntostring(self, data):
        print("running turn to string")
        text_file = open("speechdata.txt", "w")
        text_file.write(str(data))
        text_file.close()
        
    

# Example using threads in a non-blocking way
mycallback = MyRecognizeCallback()
audio_file = open(join(dirname(__file__), 'C:/Users/Fred/nwHacks2019-Project/resources/speech.wav'), 'rb')
audio_source = AudioSource(audio_file)
recognize_thread = threading.Thread(
    target=service.recognize_using_websocket,
    args=(audio_source, "audio/l16; rate=44100", mycallback))
#recognize_thread.start()
#recognize_thread.join()
