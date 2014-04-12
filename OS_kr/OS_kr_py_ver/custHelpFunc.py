import win32process
import win32file

def createNotepadOpen(filename):
    """
    opens file in notepad in new process
    @param filename <string> file to open with notepad in new process
    Returns the handle to the new process.
    The result handle is a tuple of (hProcess, hThread, dwProcessId, dwThreadId)
    """
    si = win32process.STARTUPINFO()
    # Create a process specified by commandLine
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

def createWin32File(filename):
    """
    Creates file
    @param filename <string> name of the to be created
    """
    h1 = win32file.CreateFileW(
       filename,               # The file name \
       win32file.GENERIC_WRITE,     # we want write access. \
       win32file.FILE_SHARE_READ,   # others can open for read \
       None,                        # No special security requirements \
       win32file.CREATE_ALWAYS,     # File to be created. \
       win32file.FILE_ATTRIBUTE_NORMAL, # Normal attributes \
       None )                       # No template file.
    return h1

def getDecimalIntFromFile(filename):
    """
    Converts number from file to decimal
    reads first value as base, second as number to convert
    @param filename = <string> contains name of file with number to convert
    return <int>
    """
    with open(filename) as f1:
        base, number = f1.readline().split()
    intBase = int(base)
    return int(number, intBase)

