import win32process



si = win32process.STARTUPINFO()
# Create a process specified by commandLine
# Returns the handle to the new process.
hProcess = win32process.CreateProcess(
                      None,     # AppName
                      "Notepad in1.txt",# Command line
                      None,     # Process Security
                      None,     # ThreadSecurity
                      0,        # Inherit Handles?
                      win32process.NORMAL_PRIORITY_CLASS,
                      None,     # New environment
                      None,     # Current directory
                      si)       # startup info.
print hProcess[0], hProcess[1]
