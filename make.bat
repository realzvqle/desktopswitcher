@echo off

cl src/*.c user32.lib /Fe:desktopswitch.exe
del *.obj
