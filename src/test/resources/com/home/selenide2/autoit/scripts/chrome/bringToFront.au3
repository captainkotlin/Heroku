#include <WinAPISysWin.au3>
Local $aList = _WinAPI_EnumWindowsTop ( )

For $i = 1 To $aList[0][0]
    If $aList[$i][1] = "Chrome_WidgetWin_1" Then
		WinActivate($aList[$i][0])
		Local $sText = WinGetTitle("[ACTIVE]")
		If (StringInStr($sText, "Google Chrome")) Then 
			ExitLoop
		EndIf
    EndIf
Next