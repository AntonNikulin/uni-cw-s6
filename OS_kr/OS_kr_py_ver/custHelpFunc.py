import win32process
import win32file
import win32event

def createFileOpenNotepad(filename):
    """
    Creates file
    @param filename <string> name of the to be created
    """
    h1 = win32file.CreateFile(
       filename,               # The file name \
       win32file.GENERIC_WRITE,     # we want write access. \
       win32file.FILE_SHARE_READ,   # others can open for read \
       None,                        # No special security requirements \
       win32file.CREATE_ALWAYS,     # File to be created. \
       win32file.FILE_ATTRIBUTE_NORMAL, # Normal attributes \
       None )                       # No template file.
    win32file.CloseHandle(h1)

    #opens file in notepad in new process
    si = win32process.STARTUPINFO()
    # Create a process specified by commandLine
    #The result is a tuple of (hProcess, hThread, dwProcessId, dwThreadId)
    hProcess = win32process.CreateProcess(
                          None,     # AppName
                          "Notepad "+filename,# Command line
                          None,     # Process Security
                          None,     # ThreadSecurity
                          0,        # Inherit Handles?
                          win32process.NORMAL_PRIORITY_CLASS,
                          None,     # New environment
                          None,     # Current directory
                          si)       # startup info.

    return hProcess
