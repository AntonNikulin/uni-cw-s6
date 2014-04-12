import threading
import sys
import win32file

class FetchFiles(threading.Thread):
    """
    Thread checking URLs.
    """

    def __init__(self, filenames, hOutput, lock):
        """
        Constructor.

        @param filenames list of files to check
        @param hOutput file handle to write output
        """
        threading.Thread.__init__(self)
        self.filenames = filenames
        self.hOutput = hOutput
        self.lock = lock

    def run(self):
        """
        Thread run method. Check Files one by one.
        """
        while self.filenames:
            fn = self.filenames.pop()
            try:
                d = open(fn)
                #Convert to decimal
                base, number = d.readline().split()
                intBase = int(base)
                dec = int(number, intBase)
            except:
                print "=====ERR===="
                print 'File %s failed: %s' % (fn, sys.exc_info()[0])
                print base, number, intBase
                print "=====   ====="
            self.lock.acquire()
            print '%s : lock acquired ' % self.name
            win32file.WriteFile(self.hOutput, str(dec)+"\n")
            print '%s : write done ' % self.name
            print '%s lock released ' % self.name
            self.lock.release()
            print 'FILE %s fetched by %s \n' % (fn, self.name)


