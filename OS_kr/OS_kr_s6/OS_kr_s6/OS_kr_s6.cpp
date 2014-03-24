// OS_kr_s6.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include <Windows.h>
#include <iostream>
using namespace std;
int _tmain(int argc, _TCHAR* argv[])
{STARTUPINFO si;
    PROCESS_INFORMATION pi;

    ZeroMemory( &si, sizeof(si) );
    si.cb = sizeof(si);
    ZeroMemory( &pi, sizeof(pi) );

	LPTSTR szCmdline = _tcsdup(TEXT("C:\\Windows\\Notepad.exe")); //mutable string
    // Start the child process. 
    if( !CreateProcess( NULL,   // No module name (use command line)
        szCmdline,        // Command line
        NULL,           // Process handle not inheritable
        NULL,           // Thread handle not inheritable
        FALSE,          // Set handle inheritance to FALSE
        0,              // No creation flags
        NULL,           // Use parent's environment block
        NULL,           // Use parent's starting directory 
        &si,            // Pointer to STARTUPINFO structure
        &pi )           // Pointer to PROCESS_INFORMATION structure
    ) 
    {
        printf( "CreateProcess failed (%d).\n", GetLastError() );
		system("pause");
        return 0;
    }
	
    // Wait until child process exits.
    WaitForSingleObject( pi.hProcess, INFINITE );

    // Close process and thread handles. 
    CloseHandle( pi.hProcess );
    CloseHandle( pi.hThread );
	cout<<"DONE\n";
	system("pause");
}
/*
	cout<<"hi\n"<<GetLastError();
	system ("pause");
	return 0;
}*/

