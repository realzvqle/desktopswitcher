#include <Windows.h>
#include <wchar.h>
#include <winuser.h>


VOID ShowFailureResponse(DWORD errorCode)
{
    LPVOID lpMsgBuf;

    FormatMessageW(
        FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
        NULL,
        errorCode,
        MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
        (LPWSTR)&lpMsgBuf,
        0, NULL);

    wprintf(L"%s\n", (LPWSTR)lpMsgBuf);

    LocalFree(lpMsgBuf);
}

int wmain(int argc, WCHAR* argv[]){
    if(argc < 2){
        wprintf(L"usage: desktopswitch [desktopname]\n");
        return 1;
    }
    HANDLE hDesktop = CreateDesktopW(argv[1], NULL, NULL, 0, DESKTOP_CREATEWINDOW | DESKTOP_SWITCHDESKTOP, NULL);
    if(hDesktop == NULL){
        ShowFailureResponse(GetLastError());
        return -1;
    }
    if(!SetThreadDesktop(hDesktop)){
        ShowFailureResponse(GetLastError());
        return -1;
    }
    if(!SwitchDesktop(hDesktop)){
        ShowFailureResponse(GetLastError());
        return -1;
    }   
}
