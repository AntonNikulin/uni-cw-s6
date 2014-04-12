from custHelpFunc import *
import random
import threading
import uuid
import win32file
import threads
import win32event


files1 = ["1.txt", "2.txt"]
files2 = ["a.txt", "b.txt"]

#Fill data
for f in files1:
    hProcess = createFileOpenNotepad(f)
    win32event.WaitForSingleObject(hProcess[0], 10000)
for f in files2:
    hProcess = createFileOpenNotepad(f)
    win32event.WaitForSingleObject(hProcess[0], 10000)

#Result file
hOutput = win32file.CreateFile(
   "output.txt",               # The file name
   win32file.GENERIC_WRITE,     # we want write access.
   win32file.FILE_SHARE_READ,   # others can open for read
   None,                        # No special security requirements
   win32file.CREATE_ALWAYS,     # File to be created.
   win32file.FILE_ATTRIBUTE_NORMAL, # Normal attributes
   None )

#Threading
lock = threading.Lock()
t1 = threads.FetchFiles(files1, hOutput, lock)
t2 = threads.FetchFiles(files2, hOutput, lock)
t1.start()
t2.start()
t1.join()
t2.join()

win32file.CloseHandle(hOutput)


