#include <WinAPISysWin.au3>

Local $aList = _WinAPI_EnumWindowsTop ( )

For $i = 1 To $aList[0][0]
    If $aList[$i][1] = "MozillaWindowClass" Then
        WinActivate($aList[$i][0])
        Exit
    EndIf
Next