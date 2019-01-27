# nwHacks2019-Project
A functional system with a python backend and java front end built to assist hospital workers 

It is set to only work on a local PC, would require large changes to all file paths to run elsewhere.

Raspberry Pi3 B+ detects keyword "Christina" and records a 10 second .wav file and transcribes it to txt: <br />
    Raspberry Pi is connected with Adafruit i2s mems microphone. <br />
    Used Picovoice Porcupine for voice detection and IBM Watson for audio transcription. <br />
    
Ssh used to connect to local PC: <br />
    *requires enabling ssh on personal device which is a severe security hazard* <br />
    A temporary solution for cloud/server <br />
    
Java program parses and displays transcription to display on GUI and automatically updates when new transcription arrives. <br />
